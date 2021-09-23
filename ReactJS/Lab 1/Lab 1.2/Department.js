"use strict";
exports.__esModule = true;
exports.printInforDepartment = exports.Department = void 0;
var Department = /** @class */ (function () {
    // Hàm tạo 2 tham số.
    function Department(id, name) {
        this.id = id;
        this.name = name;
    }
    // Nhóm hàm getter, setter
    Department.prototype.getname = function () {
        return this.name;
    };
    Department.prototype.setname = function (v) {
        this.name = v;
    };
    Department.prototype.getid = function () {
        return this.id;
    };
    Department.prototype.setid = function (v) {
        this.id = v;
    };
    return Department;
}());
exports.Department = Department;
// Khai báo 1 function để in thông tin các phòng ban.
function printInforDepartment(department) {
    console.log("ID: " + department.getid() + " Department Name: " + department.getname());
}
exports.printInforDepartment = printInforDepartment;
