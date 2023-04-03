$(function () {
    if (!isLogin()) {
        window.location.replace("http://127.0.0.1:5500/html/login.html");
    }

    $(".header").load("header.html", function () {
        document.getElementById("fullname").innerHTML = storage.getItem("FULL_NAME");
        if (storage.getItem("ROLE") == "User") {
            document.getElementById("viewListDepartments").style.display = "none";
        }
    });
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function isLogin() {
    if (storage.getItem("ID")) {
        return true;
    }
    return false;
}

function logout() {
    storage.removeItem("ID");
    storage.removeItem("FULL_NAME");
    storage.removeItem("USERNAME");
    storage.removeItem("PASSWORD");

    // redirect to login page
    window.location.replace("http://127.0.0.1:5500/html/login.html");

}

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListDepartments() {
    $(".main").load("viewlistdepartments.html", function () {
        buildTable();
    });
}

var departments = [];
var currentPage = 1;
var size = 3;
var sortField = "modifiedDate";
var isAsc = false;

var minCreateDate = "";
var maxCreateDate = "";

function getListDepartments() {

    var url = "http://localhost:8080/api/v1/departments";

    url += "?page=" + currentPage + "&size=" + size;

    url += "&sort=" + sortField + "," + (isAsc ? "asc" : "desc");

    var search = document.getElementById("input-search-department").value;
    if (search) {
        url += "&search=" + search;
    }

    if (minCreateDate) {
        url += "&minDate=" + minCreateDate;
    }

    if (maxCreateDate) {
        url += "&maxDate=" + maxCreateDate;
    }

    // call API from server
    $.ajax({
        url: url,
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (data, textStatus, xhr) {
            // reset list employees
            departments = [];
            departments = data.content;
            fillDepartmentToTable();
            resetDeleteCheckbox();
            pagingTable(data.totalPages);
            renderSortUI();
        },
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 403) {
                window.location.href = "http://127.0.0.1:5500/html/forbidden.html";
            }
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function pagingTable(pageAmount) {

    var pagingStr = "";

    if (pageAmount > 1 && currentPage > 1) {
        pagingStr +=
            '<li class="page-item">' +
            '<a class="page-link" onClick="prevPaging()">Previous</a>' +
            '</li>';
    }

    for (i = 0; i < pageAmount; i++) {
        pagingStr +=
            '<li class="page-item ' + (currentPage == i + 1 ? "active" : "") + '">' +
            '<a class="page-link" onClick="changePage(' + (i + 1) + ')">' + (i + 1) + '</a>' +
            '</li>';
    }

    if (pageAmount > 1 && currentPage < pageAmount) {
        pagingStr +=
            '<li class="page-item">' +
            '<a class="page-link" onClick="nextPaging()">Next</a>' +
            '</li>';
    }

    $('#pagination').empty();
    $('#pagination').append(pagingStr);

}

function resetPaging() {
    currentPage = 1;
    size = 3;
}

function prevPaging() {
    changePage(currentPage - 1);
}

function nextPaging() {
    changePage(currentPage + 1);
}

function changePage(page) {
    if (page == currentPage) {
        return;
    }
    currentPage = page;
    buildTable();
}

function renderSortUI() {
    var sortTypeClazz = isAsc ? "fa-sort-asc" : "fa-sort-desc";

    switch (sortField) {
        case 'name':
            changeIconSort("heading-name", sortTypeClazz);
            changeIconSort("heading-author", "fa-sort");
            changeIconSort("heading-createDate", "fa-sort");
            break;
        case 'author.fullName':
            changeIconSort("heading-author", sortTypeClazz);
            changeIconSort("heading-name", "fa-sort");
            changeIconSort("heading-createDate", "fa-sort");
            break;
        case 'createDate':
            changeIconSort("heading-createDate", sortTypeClazz);
            changeIconSort("heading-name", "fa-sort");
            changeIconSort("heading-author", "fa-sort");
            break;
        default:
            changeIconSort("heading-name", "fa-sort");
            changeIconSort("heading-author", "fa-sort");
            changeIconSort("heading-createDate", "fa-sort");
            break;
    }
}

function changeIconSort(id, sortTypeClazz) {
    document.getElementById(id).classList.remove("fa-sort", "fa-sort-asc", "fa-sort-desc");
    document.getElementById(id).classList.add(sortTypeClazz);
}

function changeSort(field) {
    if (field == sortField) {
        isAsc = !isAsc;
    } else {
        sortField = field;
        isAsc = true;
    }
    buildTable();
}

function resetSort() {
    sortField = 'modifiedDate';
    isAsc = false;
}

function resetDeleteCheckbox() {
    // reset delete all checkbox
    document.getElementById("checkbox-all").checked = false;

    // reset checkbox item
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            checkboxItem.checked = false;
            i++;
        } else {
            break;
        }
    }
}

function resetTable() {
    resetPaging();
    resetSort();
    resetSearch();
    resetFilter();
    resetDeleteCheckbox();
}

function resetSearch() {
    document.getElementById("input-search-department").value = "";
}

// https://www.w3schools.com/howto/howto_js_trigger_button_enter.asp
function handKeyUpEventForSearching(event) {
    // Number 13 is the "Enter" key on the keyboard
    if (event.keyCode === 13) {
        event.preventDefault();
        handleSearch();
    }
}

function handleSearch() {
    resetPaging();
    resetSort();
    resetDeleteCheckbox();
    buildTable();
}

function changeMinCreateDate(e) {
    minCreateDate = e.target.value;
    resetPaging();
    resetSort();
    resetDeleteCheckbox();
    buildTable();
}

function changeMaxCreateDate(e) {
    maxCreateDate = e.target.value;
    resetPaging();
    resetSort();
    resetDeleteCheckbox();
    buildTable();
}

function resetFilter() {
    minCreateDate = "";
    maxCreateDate = "";
    document.getElementById("minCreateDate").value = "";
    document.getElementById("maxCreateDate").value = "";
}

function refreshTable() {
    resetTable();
    buildTable();
}

function fillDepartmentToTable() {
    departments.forEach(function (item, index) {
        $('tbody').append(
            '<tr>' +
            '<td><input id="checkbox-' + index + '" type="checkbox" onClick="onChangeCheckboxItem()"></td>' +
            '<td>' + item.name + '</td>' +
            '<td>' + item.author.fullName + '</td>' +
            '<td>' + item.createDate + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });
}

function buildTable() {
    $('tbody').empty();
    getListDepartments();
}

function openAddModal() {
    openModal();
    resetFormAdd();
}

function resetFormAdd() {
    document.getElementById("titleModal").innerHTML = "Add Department";
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("authorLabel").style.display = "none";
    document.getElementById("author").style.display = "none";
    document.getElementById("createdDateLabel").style.display = "none";
    document.getElementById("createdDate").style.display = "none";
    hideNameErrorMessage();
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function showNameErrorMessage(message) {
    document.getElementById("nameErrorMessage").style.display = "block";
    document.getElementById("nameErrorMessage").innerHTML = message;
}

function hideNameErrorMessage() {
    document.getElementById("nameErrorMessage").style.display = "none";
}

function addDepartment() {

    // get data
    var name = document.getElementById("name").value;

    // validate name 6 -> 30 characters
    if (!name || name.length < 6 || name.length > 30) {
        // show error message
        showNameErrorMessage("Department name must be from 6 to 30 characters!");
        return;
    }

    // validate unique name
    $.ajax({
        url: "http://localhost:8080/api/v1/departments/name/" + name + "/exists",
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (data, textStatus, xhr) {
            if (data) {
                // show error message
                showNameErrorMessage("Department name is exists!");
            } else {
                // call api create department
                var department = {
                    name: name,
                    authorId: storage.getItem("ID")
                };

                $.ajax({
                    url: 'http://localhost:8080/api/v1/departments',
                    type: 'POST',
                    data: JSON.stringify(department), // body
                    contentType: "application/json", // type of body (json, xml, text)
                    // dataType: 'json', // datatype return
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
                    },
                    success: function (data, textStatus, xhr) {
                        console.log(data);
                        // success
                        hideModal();
                        showSuccessAlert();
                        resetTable();
                        buildTable();
                    },
                    error(jqXHR, textStatus, errorThrown) {
                        alert("Error when loading data");
                        console.log(jqXHR);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
            }
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function resetFormUpdate() {
    document.getElementById("titleModal").innerHTML = "Update Department";
    document.getElementById("authorLabel").style.display = "block";
    document.getElementById("author").style.display = "block";
    document.getElementById("createdDateLabel").style.display = "block";
    document.getElementById("createdDate").style.display = "block";
    hideNameErrorMessage();
}

var oldName;

function openUpdateModal(id) {

    // call API from server
    $.ajax({
        url: "http://localhost:8080/api/v1/departments/" + id,
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (data, textStatus, xhr) {
            // success
            openModal();
            resetFormUpdate();

            oldName = data.name;

            // fill data
            document.getElementById("id").value = data.id;
            document.getElementById("name").value = data.name;
            document.getElementById("author").value = data.author.fullName;
            document.getElementById("createdDate").value = data.createDate;
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addDepartment();
    } else {
        updateDepartment();
    }
}

function updateDepartment() {
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;

    // validate name 6 -> 30 characters
    if (!name || name.length < 6 || name.length > 30) {
        // show error message
        showNameErrorMessage("Department name must be from 6 to 30 characters!");
        return;
    }

    // validate unique name
    if (oldName == name) {
        // success
        hideModal();
        showSuccessAlert();
        resetTable();
        buildTable();
        return;
    }

    // validate unique name
    $.ajax({
        url: "http://localhost:8080/api/v1/departments/name/" + name + "/exists",
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (data, textStatus, xhr) {
            if (data) {
                // show error message
                showNameErrorMessage("Department name is exists!");
            } else {
                // call api create department
                var department = {
                    name: name
                };

                $.ajax({
                    url: 'http://localhost:8080/api/v1/departments/' + id,
                    type: 'PUT',
                    data: JSON.stringify(department), // body
                    contentType: "application/json", // type of body (json, xml, text)
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
                    },
                    // dataType: 'json', // datatype return
                    success: function (data, textStatus, xhr) {
                        console.log(data);
                        // success
                        hideModal();
                        showSuccessAlert();
                        resetTable();
                        buildTable();
                    },
                    error(jqXHR, textStatus, errorThrown) {
                        console.log(jqXHR);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
            }
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function openConfirmDelete(id) {
    // get index from employee's id
    var index = departments.findIndex(x => x.id == id);
    var name = departments[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteDepartment(id);
    }
}

function deleteDepartment(id) {
    // TODO validate

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'DELETE',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            showSuccessAlert();
            resetTable();
            buildTable();
        }
    });
}

function onChangeCheckboxItem() {
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            if (!checkboxItem.checked) {
                document.getElementById("checkbox-all").checked = false;
                return;
            }
            i++;
        } else {
            break;
        }
    }
    document.getElementById("checkbox-all").checked = true;

}

function onChangeCheckboxAll() {
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            checkboxItem.checked = document.getElementById("checkbox-all").checked
            // if (document.getElementById("checkbox-all").checked) {
            //     checkboxItem.checked = true;
            // } else {
            //     checkboxItem.checked = false;
            // }
            i++;
        } else {
            break;
        }
    }
}

function deleteAllDepartment() {
    // get checked
    var ids = [];
    var names = [];
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            if (checkboxItem.checked) {
                ids.push(departments[i].id);
                names.push(departments[i].name);
            }
            i++;
        } else {
            break;
        }
    }

    // open confirm ==> bạn có muốn xóa bản ghi ...

    var result = confirm("Want to delete " + names + "?");
    if (result) {
        // call API
        $.ajax({
            url: 'http://localhost:8080/api/v1/departments?ids=' + ids,
            type: 'DELETE',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
            },
            success: function (result) {
                // error
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }

                // success
                showSuccessAlert();
                resetTable();
                buildTable();
            }
        });
    }

}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
        $("#success-alert").slideUp(500);
    });
}