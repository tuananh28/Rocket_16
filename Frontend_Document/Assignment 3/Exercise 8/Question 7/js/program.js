$(function () {
    $(".header").load("header.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function ClickNavHome() {
    $(".main").load("home.html");
}

function ViewList() {
    $(".main").load("ViewList.html");
    initTable();
}

var employee = [];
var counter = 0;

function Employee(name, department, phone) {
    this.id = ++counter;
    this.name = name;
    this.department = department;
    this.phone = phone;
}

function initEmployee() {
    if (employee == null || employee.length == 0) {
        employee.push(new Employee("Bùi Tuấn Anh", "IT Product", "(+84)868 102 848"));
        employee.push(new Employee("Bùi Thị Hoa Mai", "Sale", "(+84)389 760 202"));
        employee.push(new Employee("Phạm Ngọc Diễn", "Marketing ", "(+84)974 673 264"));
    }
}

function initTable() {
    setTimeout(function name(params) {
        $("tbody").empty();
        initEmployee();
        employee.forEach(function (item) {
            $("tbody").append(
                "<tr>" +
                    "<td>" + item.name + "</td>" +
                    "<td>" + item.department +"</td>" +
                    "<td>" + item.phone + "</td>" +
                    "<td>" +
                        '<a class="edit" title="Edit" data-toggle="tooltip" onclick="EditModal('+ item.id +')"><i class="material-icons">&#xE254;</i></a>' +
                        '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
                    "</td>" +
                "</tr>"
            );
        });
    }, 500);
}
function openAdd(){
    showModal();
    resetForm();
}
function resetForm(){
    document.getElementById("id").value  = "";
    document.getElementById("name").value  = "";
    document.getElementById("department").value = "";
    document.getElementById("phone").value = "";
}
function showModal(){
    $('#myModal').modal('show');
}
function HideModal(){
    $('#myModal').modal('hide');
}
function addEmployee(){
    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    employee.push(new Employee(name, department, phone));
    HideModal();
    showSuccessAlert();
    initTable();

}
function EditModal(id){
    // get index from employee's id
    var index = employee.findIndex(x => x.id == id);
    
    document.getElementById("id").value  = employee[index].id;
    document.getElementById("name").value  = employee[index].name;
    document.getElementById("department").value = employee[index].department;
    document.getElementById("phone").value = employee[index].phone;
    
    showModal();

}
function save(){
    var id = document.getElementById("id").value;
    if(id == null || id == ""){
        addEmployee()
    }else{
        updateEmployee();
    }
}
function updateEmployee(){
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    var index = employee.findIndex(x => x.id == id);
    //update Employee
    employee[index].name = name;
    employee[index].department = department;
    employee[index].phone = phone;

    HideModal();
    showSuccessAlert();
    initTable();
}
function openConfirmDelete(id) {
    // get index from employee's id
    var index = employee.findIndex(x => x.id == id);
    var name = employee[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteEmployee(id);
    }
}
function deleteEmployee(id){
    var index =  employee.findIndex(x => x.id === id);
    employee.splice(index, 1);

    showSuccessAlert();
    initTable();
}
function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}