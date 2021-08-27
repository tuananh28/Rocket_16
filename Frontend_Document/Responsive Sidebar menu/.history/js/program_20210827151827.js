
function clickNavViewListUsers(){
    $(".home-section").load("ViewList.html");
    buildTable();
}
var users = [];

function User(id, email,username,fullname, department,position,createDate) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.fullname = fullname;
    this.department = department
    this.position = position;
    this.createDate = createDate;
}

function getListusers() {
    // call API from server
    $.get("https://6127ea33c2e8920017bc0f20.mockapi.io/api/accounts", function(data, status) {

        // reset list users
        users = [];

        // error
        if (status == "error") {
            // TODO
            alert("Error when loading data");
            return;
        }

        // success
        parseData(data);
        fillUserToTable();
    });
}

function parseData(data) {
    // users = data;

    data.forEach(function(item) {
        users.push(new User(item.id, item.email,item.username,item.fullname, item.department, item.position, item.createDate));
    });
}

function fillUserToTable() {
    users.forEach(function(item) {
        $('tbody').append(
            '<tr>' +
            '<td>' + item.id + '</td>' +
            '<td>' + item.email + '</td>' +
            '<td>' + item.username + '</td>' +
            '<td>' + item.fullname + '</td>' +
            '<td>' + item.department + '</td>' +
            '<td>' + item.position + '</td>' +
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
    getListusers();
}

function openAddModal() {   
    openModal();
    resetForm();
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("email").value= "";
    document.getElementById("username").value = "";
    document.getElementById("fullname").value = "";
    document.getElementById("department").value = "";
    document.getElementById("position").value = "";
}

function openModal() {
    $("#myModal").modal("show");
}

function hideModal() {
    $("#myModal").modal("hide");
}

function addUser() {

    // get data
    var email = document.getElementById("email").value;
    var username = document.getElementById("username").value;
    var fullname = document.getElementById("fullname").value;
    var department = document.getElementById("department").value;
    var position = document.getElementById("position").value;
    var createDate = document.getElementById("createDate").value;

    // TODO validate
    // then fail validate ==> return;

    var User = {
        email: email,
        username: username,
        fullname: fullname,
        department: department,
        position: position,
        createDate: createDate
    };

    $.post("https://6127ea33c2e8920017bc0f20.mockapi.io/api/accounts", User,
        function(data, status) {
            // error
            if (status == "error") {
                alert("Error when loading data");
                return;
            }

            // success
            hideModal();
            showSuccessAlert();
            buildTable();
        });
}


function openUpdateModal(id) {

    // get index from User's id
    var index = users.findIndex(x => x.id == id);

    // fill data
    document.getElementById("id").value = users[index].id;
    document.getElementById("email").value = users[index].email;
    document.getElementById("username").value = users[index].username;
    document.getElementById("fullname").value = users[index].fullname;
    document.getElementById("department").value = users[index].department;
    document.getElementById("position").value = users[index].position;
    document.getElementById("createDate").value = users[index].createDate;
    
    openModal();
}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addUser();
    } else {
        updateUser();
    }
}

function updateUser() {

    var id = document.getElementById("id").value;
    var email = document.getElementById("email").value;
    var username = document.getElementById("username").value;
    var fullname = document.getElementById("fullname").value;
    var department = document.getElementById("department").value;
    var position = document.getElementById("position").value;
    var createDate = document.getElementById("createDate").value;

    // TODO validate
    // then fail validate ==> return;

    var User = {
        email: email,
        username: username,
        fullname: fullname,
        department: department,
        position: position,
        createDate: createDate
    };

    $.ajax({
        url: 'https://6127ea33c2e8920017bc0f20.mockapi.io/api/accounts/' + id,
        type: 'PUT',
        data: User,
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            hideModal();
            showSuccessAlert();
            buildTable();
        }
    });
}


function openConfirmDelete(id) {
    // get index from User's id
    var index = users.findIndex(x => x.id == id);
    var username = users[index].username;

    var result = confirm("Bạn có chắc muốn xóa " + username + " không ?");
    if (result) {
        deleteUser(id);
    }
}

function deleteUser(id) {
    // TODO validate

    $.ajax({
        url: 'https://6127ea33c2e8920017bc0f20.mockapi.io/api/accounts/' + id,
        type: 'DELETE',
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            showSuccessAlert();
            buildTable();
        }
    });
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}