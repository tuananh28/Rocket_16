"use strict";
exports.__esModule = true;
var NhanVien_1 = require("./../../Lab 1/Lab 1.3_Inheritance/NhanVien");
var KySu_1 = require("./../../Lab 1/Lab 1.3_Inheritance/KySu");
var CongNhan_1 = require("./../../Lab 1/Lab 1.3_Inheritance/CongNhan");
// Tạo ra các đối tượng
var worker1 = new CongNhan_1.CongNhan("Worker1", 20, "Male", "HN", 10);
var worker2 = new CongNhan_1.CongNhan("Worker2", 22, "FeMale", "NĐ", 7);
var worker3 = new CongNhan_1.CongNhan("Worker3", 24, "Male", "HN", 8);
var Engineer1 = new KySu_1.KySu("Engineer1", 20, "Male", "HN", "DEV");
var Engineer2 = new KySu_1.KySu("Engineer2", 22, "FeMale", "NĐ", "TEST");
var Engineer3 = new KySu_1.KySu("Engineer3", 24, "Male", "HN", "DEV");
var Employee1 = new NhanVien_1.NhanVien("Employee1", 20, "Male", "HN", "Task1"); // Tạo mới 1 đối tượng Worker.
var Employee2 = new NhanVien_1.NhanVien("Employee2", 22, "FeMale", "NĐ", "Task2");
var Employee3 = new NhanVien_1.NhanVien("Employee3", 24, "Male", "HN", "Task3");
// Khai báo 1 mảng các staff, chứa các đối tượng phía trên vừa khai báo
var staffArray;
staffArray = [
    worker1,
    worker2,
    worker3,
    Engineer1,
    Engineer2,
    Engineer3,
    Employee1,
    Employee2,
    Employee3,
];
// CÁCH 1: Thực hiện gọi hàm bình thường.
console.log("---- Demo bằng cách gọi hàm bình thường, Cách 1 ----------");
// Viết hàm để in ra thông tin worker
function printWorkerInfo(staffArray) {
    staffArray.forEach(function (element) {
        if (element instanceof CongNhan_1.CongNhan) {
            element.printInforCongNhan();
        }
        // console.log(element instanceof Worker);
    });
}
// Viết hàm để in ra thông tin Engineer
function printEngineerInfo(staffArray) {
    staffArray.forEach(function (element) {
        if (element instanceof KySu_1.KySu) {
            element.printInforKysu();
        }
        // console.log(element instanceof Worker);
    });
}
console.log("Thong tin Worker: ", printWorkerInfo(staffArray));
console.log("Thong tin Engineer: ", printEngineerInfo(staffArray));
// CÁCH 2: Sử dụng HOF, tham số đầu vào là 1 hàm, đầu ra trả ra 1 hàm.
console.log("------ Demo sử dụng HOF Cách 2: ------------");
function printStaff(staffArray, function_print) {
    return function_print(staffArray);
}
console.log("Sử dụng HOF để tin thông tin");
// In thông tin worker
printStaff(staffArray, printWorkerInfo);
// In thông tin Engineer
printStaff(staffArray, printEngineerInfo);
// CÁCH 3: Viết hàm giá trị truyền vào là 1 object
console.log("----------In thông tin theo Cách 3-----------");
function printStaffArray(staffArray, params) {
    staffArray.forEach(function (element) {
        if (element instanceof params) {
            console.log("Thông tin:", element);
        }
    });
}
printStaffArray(staffArray, CongNhan_1.CongNhan);
printStaffArray(staffArray, KySu_1.KySu);
