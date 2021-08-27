var user = [];

function User(id, email, username, fullName, department, position, createDate) {
  this.id = id;
  this.email = email;
  this.username = username;
  this.fullName = fullName;
  this.department = department;
  this.position = position;
  this.createDate = createDate;
}

function getListEmployees() {
  // call API from server
  $.get(
    "https://61266ad33ab4100017a68f40.mockapi.io/api/v1/user/users/",
    function (data, status) {
      // reset list employees
      employees = [];

      // error
      if (status == "error") {
        // TODO
        alert("Error when loading data");
        return;
      }

      // success
      parseData(data);
      fillEmployeeToTable();
    }
  );
}

function parseData(data) {
  // employees = data;

  data.forEach(function (item) {
    employees.push(
      new Employee(item.id, item.name, item.department, item.phone)
    );
  });
}

function fillEmployeeToTable() {
  employees.forEach(function (item) {
    $("tbody").append(
      "<tr>" +
        "<td>" +
        item.name +
        "</td>" +
        "<td>" +
        item.department +
        "</td>" +
        "<td>" +
        item.phone +
        "</td>" +
        "<td>" +
        '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' +
        item.id +
        ')"><i class="material-icons">&#xE254;</i></a>' +
        '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' +
        item.id +
        ')"><i class="material-icons">&#xE872;</i></a>' +
        "</td>" +
        "</tr>"
    );
  });
}

function buildTable() {
  $("tbody").empty();
  getListEmployees();
}

function openAddModal() {
  resetForm();
  openModal();
}

function resetForm() {
  document.getElementById("id").value = "";
  document.getElementById("name").value = "";
  document.getElementById("department").value = "";
  document.getElementById("phone").value = "";
}

function openModal() {
  $("#myModal").modal("show");
}

function hideModal() {
  $("#myModal").modal("hide");
}

function addEmployee() {
  // get data
  var name = document.getElementById("name").value;
  var department = document.getElementById("department").value;
  var phone = document.getElementById("phone").value;

  // TODO validate
  // then fail validate ==> return;

  var employee = {
    name: name,
    department: department,
    phone: phone,
  };

  $.post(
    "https://61266ad33ab4100017a68f40.mockapi.io/api/v1/user/users/",
    employee,
    function (data, status) {
      // error
      if (status == "error") {
        alert("Error when loading data");
        return;
      }

      // success
      hideModal();
      showSuccessAlert();
      buildTable();
    }
  );
}

function openUpdateModal(id) {
  // get index from employee's id
  var index = employees.findIndex((x) => x.id == id);

  // fill data
  document.getElementById("id").value = employees[index].id;
  document.getElementById("name").value = employees[index].name;
  document.getElementById("department").value = employees[index].department;
  document.getElementById("phone").value = employees[index].phone;

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
  var department = document.getElementById("department").value;
  var phone = document.getElementById("phone").value;

  // TODO validate
  // then fail validate ==> return;

  var employee = {
    name: name,
    department: department,
    phone: phone,
  };

  $.ajax({
    url: "https://61266ad33ab4100017a68f40.mockapi.io/api/v1/user/users/" + id,
    type: "PUT",
    data: employee,
    success: function (result) {
      // error
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }

      // success
      hideModal();
      showSuccessAlert();
      buildTable();
    },
  });
}

function openConfirmDelete(id) {
  // get index from employee's id
  var index = employees.findIndex((x) => x.id == id);
  var name = employees[index].name;

  var result = confirm("Want to delete " + name + "?");
  if (result) {
    deleteEmployee(id);
  }
}

function deleteEmployee(id) {
  // TODO validate

  $.ajax({
    url: "https://61266ad33ab4100017a68f40.mockapi.io/api/v1/user/users/" + id,
    type: "DELETE",
    success: function (result) {
      // error
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }

      // success
      showSuccessAlert();
      buildTable();
    },
  });
}

function showSuccessAlert() {
  $("#success-alert")
    .fadeTo(2000, 500)
    .slideUp(500, function () {
      $("#success-alert").slideUp(500);
    });
}
