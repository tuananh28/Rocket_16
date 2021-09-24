"use strict";
exports.__esModule = true;
var CanBo_1 = require("./../../Lab 1/Lab 1.3_Inheritance/CanBo");
// Sử dụng reduce tính tuổi trung bình của các nhân viên.
// Tạo ra các đối tượng
var staff1 = new CanBo_1.CanBo("staff1", 20, "Male", "HN");
var staff2 = new CanBo_1.CanBo("staff2", 22, "FeMale", "NĐ");
var staff3 = new CanBo_1.CanBo("staff3", 24, "Male", "HN");
// Tạo mảng để lưu các đối tượng.
var staffArray;
staffArray = [staff1, staff2, staff3];
// Sử dụng reduce để tính tổng tuổi của các phần tử trong mảng.
var totalAge = staffArray.reduce(function (total_Age, itemCurrent) { return total_Age + itemCurrent.getage(); }, 0);
// In ra tuổi trung bình.
console.log("Tuổi trung bình của nhân viên là: ", totalAge / staffArray.length);
