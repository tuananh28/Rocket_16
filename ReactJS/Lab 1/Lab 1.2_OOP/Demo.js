"use strict";
exports.__esModule = true;
var Department_1 = require("./Department");
var Position_1 = require("./Position");
var Account_1 = require("./Account");
// Khai báo các phòng ban trên hệ thống
var dep1 = new Department_1.Department(1, "Sale"); // Tạo mới 1 đối tượng Department.
var dep2 = new Department_1.Department(2, "Kỹ thuật");
var dep3 = new Department_1.Department(3, "Phó giám đốc");
var dep4 = new Department_1.Department(4, "Tài chính");
var dep5 = new Department_1.Department(5, "Bảo vệ");
console.log('--- Thông tin phòng ban trên hệ thống: ---');
(0, Department_1.printInforDepartment)(dep1); // Thực hiện in thông tin của đối tượng vừa tạo.
(0, Department_1.printInforDepartment)(dep2);
(0, Department_1.printInforDepartment)(dep3);
(0, Department_1.printInforDepartment)(dep4);
(0, Department_1.printInforDepartment)(dep5);
// Khai báo các Position trên hệ Thống
var pos1 = new Position_1.Possition(1, "Dev");
var pos2 = new Position_1.Possition(2, "Test");
var pos3 = new Position_1.Possition(3, "Scrum_Master");
var pos4 = new Position_1.Possition(4, "PM");
console.log('--- Thông tin Position trên hệ thống: ---');
(0, Position_1.printInforPosition)(pos1); // Thực hiện in thông tin của đối tượng vừa tạo.
(0, Position_1.printInforPosition)(pos2);
(0, Position_1.printInforPosition)(pos3);
(0, Position_1.printInforPosition)(pos4);
// Khai báo các Account trên hệ thống
var date = new Date("2021-07-01"); // khai báo đổi tượng kiểu date để sử dụng
var acc1 = new Account_1.Account(1, "tuananh@gmail.com", "tuananh", "Bùi Tuấn Anh", dep3, pos1, date);
var acc2 = new Account_1.Account(2, "hoamai@gmail.com", "hoamai", "Bùi Thị Hoa Mai", dep1, pos3, date);
var acc3 = new Account_1.Account(3, "daoluc@gmail.com", "daonguyen", "Nguyễn Đào Lực ", dep2, pos2, date);
var acc4 = new Account_1.Account(4, "hoanglinh@gmail.com", "hoanglinh", "Trần Hoàng Linh", dep4, pos4, date);
// Gọi hàm in thông tin Account để sử dụng.
(0, Account_1.printInforAccount)(acc1);
(0, Account_1.printInforAccount)(acc2);
(0, Account_1.printInforAccount)(acc3);
(0, Account_1.printInforAccount)(acc4);
// function printInforPosition(pos1: any) {
//     throw new Error("Function not implemented.");
// }
// function printInforAccount(acc1: any) {
//     throw new Error("Function not implemented.");
// }
