var SIZE = 3;
var currentPage = 1;
var isAsc = false;
var currentFieldName = "id";
var oldName;

function isLogin() {
    var username = storage.getItem("USERNAME");
    return username ? true : false;
}

$(function () {
    if (!isLogin()) {
        window.location.href = "http://localhost:5501/html/login.html";
    }
    $(".header").load("header.html", function () {
        document.getElementById("fullName").innerHTML = storage.getItem("FULLNAME");
    });
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListEmployees() {
    $(".main").load("viewlistemployees.html", function () {
        buildTable();
    });
}

var employees = [];

function Employee(id, name) {
    this.id = id;
    this.name = name;
}

function getListEmployees() {
    // call API from server
    var url = "http://localhost:8080/api/v1/departments";
    var search = document.getElementById("searchInput").value;

    url += "?page=" + currentPage + "&size=" + SIZE;

    url += "&sort=" + currentFieldName + "," + (isAsc ? 'ASC' : 'DESC');

    if (search != null && search != undefined && search.length != 0) {
        url += "&search=" + search;
    }

    $.ajax({
        url: url,
        type: 'GET',
        contentType: "application/json", // type of body (json, xml, text)
        dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(
                storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (data, textStatus, xhr) {
            // reset list employees
            employees = [];

            // error
            if (status == "error") {
                // TODO
                alert("Error when loading data");
                return;
            }

            // success
            employees = data.content;
            fillEmployeeToTable();
            renderPaging(data.totalPages);
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function renderPaging(totalPages) {
    $('#pagination').empty();
    for (let index = 1; index <= totalPages; index++) {
        $('#pagination').append(
            '<li class="page-item">' +
            '<a class="page-link" onClick="onClickPage(' + index + ')">' + index + '</a>' +
            '</li>'
        );
    }
}

function onClickPage(page) {
    if (currentPage == page) {
        return;
    }
    currentPage = page;
    buildTable();
}

function fillEmployeeToTable() {

    // add delete button
    if (storage.getItem("ROLE") != "Employee") { 
       document.getElementById("addButton").style.display = "block";
       document.getElementById("deleteButton").style.display = "block";
    }else{
        document.getElementById("addButton").style.display = "none";
        document.getElementById("deleteButton").style.display = "none";
    }
    
    // heading
    $('#table-heading').empty();
    var strHeading = "";

    if (storage.getItem("ROLE") != "Employee") {
        strHeading += '<th><input id="checkbox-total" type="checkbox" onclick="changeCheckboxTotal()"/></th>';
    }

    strHeading += "<th onclick='onSort(\"id\")'>Id</th>";
    strHeading += "<th onclick='onSort(\"name\")'>Name</th>";
    
    if (storage.getItem("ROLE") != "Employee") {
        strHeading += "<th>Actions</th>";
    }

    $('#table-heading').append(strHeading);

    // body
    employees.forEach(function (item, index) {
        var str = "";
        str += '<tr>';


        if (storage.getItem("ROLE") != "Employee") {
            str += '<td><input id="checkbox-' + index + '" value="' + item.id + '" type="checkbox" /></td>';
        }

        str += 
            '<td>' + item.id + '</td>' +
            '<td>' + item.name + '</td>';

        if (storage.getItem("ROLE") != "Employee") {
            str += 
                '<td>' +
                '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
                '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
                '</td>';
        }
        str += '</tr>';
        $('tbody').append(str);
    });
}

function buildTable() {
    $('tbody').empty();
    getListEmployees();
}

function onClickSearchButton() {
    resetPaging();
    resetSorting();
    // get list
    buildTable();
}

function resetSearch() {
    document.getElementById("searchInput").value = "";
}

function resetPaging() {
    currentPage = 1;
}

function resetFilter() {
}
function resetSorting() {
    isAsc = false;
    currentFieldName = "id";
}

function onSort(fieldName) {
    if (currentFieldName != fieldName) {
        isAsc = true;
        currentFieldName = fieldName;
    } else {
        isAsc = !isAsc;
    }

    buildTable();
}

function openAddModal() {
    resetForm();
    openModal();
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("error-message").style.display = "none";
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function showMessageErrorValidate(message) {
    document.getElementById("error-message").style.display = "block";
    document.getElementById("error-message").innerHTML = message;
}

function addEmployee() {

    // get data
    var name = document.getElementById("name").value;
    // validate

    if (name.length < 6) {
        showMessageErrorValidate("Tên phải lớn hơn 6 kí tự");
        return;
    }

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/name?name=' + name,
        type: 'GET',
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(
                storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (data, textStatus, xhr) {
            if (!data) {
                var employee = {
                    name: name
                };
                $.ajax({
                    url: 'http://localhost:8080/api/v1/departments',
                    type: 'POST',
                    data: JSON.stringify(employee), // body
                    contentType: "application/json", // type of body (json, xml, text)
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader("Authorization", "Basic " + btoa(
                            storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
                    },
                    // dataType: 'json', // datatype return
                    success: function (data, textStatus, xhr) {
                        hideModal();
                        showSuccessAlert();
                        resetSearch();
                        resetPaging();
                        resetSorting();
                        resetFilter();
                        buildTable();
                    },
                    error(jqXHR, textStatus, errorThrown) {
                        console.log(jqXHR);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
            } else {
                showMessageErrorValidate("Tên không được trùng");
            }
        },
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 403) {
                window.location.href = "http://localhost:5501/html/forbidden.html";
            } else {
                console.log();
                console.log(textStatus);
                console.log(errorThrown);
            }
        }
    });
}


function openUpdateModal(id) {
    resetForm();

    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);

    // fill data
    document.getElementById("id").value = employees[index].id;
    document.getElementById("name").value = employees[index].name;
    oldName = employees[index].name;
    openModal();
}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addEmployee();
    } else {
        updateEmployee();
    }
}

function updateEmployee() {
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;

    if (name == oldName) {
        // success
        hideModal();
        showSuccessAlert();
        resetSearch();
        resetPaging();
        resetSorting();
        resetFilter();
        buildTable();
    } else {
        // validate
        if (name.length < 6) {
            showMessageErrorValidate("Tên phải lớn hơn 6 kí tự");
            return;
        }
        $.ajax({
            url: 'http://localhost:8080/api/v1/departments/name?name=' + name,
            type: 'GET',
            contentType: "application/json", // type of body (json, xml, text)
            // dataType: 'json', // datatype return
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(
                    storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
            },
            success: function (data, textStatus, xhr) {
                if (!data) {
                    var employee = {
                        name: name
                    };

                    $.ajax({
                        url: 'http://localhost:8080/api/v1/departments/' + id,
                        type: 'PUT',
                        data: JSON.stringify(employee),
                        contentType: "application/json",
                        beforeSend: function (xhr) {
                            xhr.setRequestHeader("Authorization", "Basic " + btoa(
                                storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
                        },
                        success: function (result) {
                            // success
                            hideModal();
                            showSuccessAlert();
                            resetSearch();
                            resetPaging();
                            resetSorting();
                            resetFilter();
                            buildTable();
                        },
                        error(jqXHR, textStatus, errorThrown) {
                            if (jqXHR.status == 403) {
                                window.location.href = "http://localhost:5501/html/forbidden.html";
                            } else {
                                console.log();
                                console.log(textStatus);
                                console.log(errorThrown);
                            }
                        }
                    });
                } else {
                    showMessageErrorValidate("Tên không được trùng");
                }
            },
            error(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });
    }


}


function openConfirmDelete(id) {
    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);
    var name = employees[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteEmployee(id);
    }
}

function deleteEmployee(id) {
    // TODO validate
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'DELETE',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(
                storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (result) {
            // success
            showSuccessAlert();
            resetSearch();
            resetPaging();
            resetSorting();
            resetFilter();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 403) {
                window.location.href = "http://localhost:5501/html/forbidden.html";
            } else {
                console.log();
                console.log(textStatus);
                console.log(errorThrown);
            }
        }
    });
}

function deleteMultipleDepartment() {
    // get id cua nhung o duoc tich
    var ids = [];
    for (let index = 0; index < SIZE; index++) {
        var checkboxInput = document.getElementById("checkbox-" + index);
        if (checkboxInput != null && checkboxInput != undefined) {
            if (checkboxInput.checked) {
                ids.push(checkboxInput.value);
            }
        } else {
            break;
        }
    }

    if (ids.length == 0) {
        alert("Bạn phải chọn ít nhất 1 bản ghi mới xóa được...");
    }

    // goi api
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments?ids=' + ids.toString(),
        type: 'DELETE',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(
                storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (result) {
            // success
            showSuccessAlert();
            resetSearch();
            resetPaging();
            resetSorting();
            resetFilter();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 403) {
                window.location.href = "http://localhost:5501/html/forbidden.html";
            } else {
                console.log();
                console.log(textStatus);
                console.log(errorThrown);
            }
        }
    });
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
        $("#success-alert").slideUp(500);
    });
}

function changeCheckboxTotal() {
    var checkboxTotal = document.getElementById("checkbox-total");

    for (let index = 0; index < SIZE; index++) {
        var checkboxInput = document.getElementById("checkbox-" + index);
        if (checkboxInput != null && checkboxInput != undefined) {
            checkboxInput.checked = checkboxTotal.checked;
        } else {
            break;
        }

    }
}

function logout() {
    window.location.href = "http://localhost:5501/html/login.html";
    // remove storage
    storage.removeItem("ID");
    storage.removeItem("EMAIL");
    storage.removeItem("FIRSTNAME");
    storage.removeItem("LASTNAME");
    storage.removeItem("FULLNAME");
    storage.removeItem("ROLE");
    storage.removeItem("USERNAME");
    storage.removeItem("PASSWORD");
}
