import { CanBo } from './../../Lab 1/Lab 1.3_Inheritance/CanBo';
// Sử dụng reduce tính tuổi trung bình của các nhân viên.
// Tạo ra các đối tượng
let staff1 = new CanBo("staff1", 20, "Male", "HN");
let staff2 = new CanBo("staff2", 22, "FeMale", "NĐ");
let staff3 = new CanBo("staff3", 24, "Male", "HN");
// Tạo mảng để lưu các đối tượng.
let staffArray: CanBo[];
staffArray = [staff1, staff2, staff3];
// Sử dụng reduce để tính tổng tuổi của các phần tử trong mảng.
let totalAge = staffArray.reduce(
  (total_Age, itemCurrent) => total_Age + itemCurrent.getage(),
  0
);
// In ra tuổi trung bình.
console.log("Tuổi trung bình của nhân viên là: ", totalAge / staffArray.length);


