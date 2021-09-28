// -	Thực hiện Demo sử dụng kế thừa, Array, Foreach, ForOf trong TypeScript.
// -	Làm lại bài Question 1, trong TestingSystem4, Java Core trước đây.
// -	Tạo Class: Staff.ts, là class cha, có các thuộc tính: name, age, gender, address.
// -	Các Class: Worker.ts, Employee.ts, Engineer.ts kế thừa từ class Staff và có thêm các thuộc tính khác.

import { CongNhan } from "./CongNhan";
import { KySu } from "./KySu";
import { NhanVien } from "./NhanVien";

// -	Cho các đối tượng của Worker, Employee, Engineer vào trong Array, Set. Sử dụng Foreach, ForOf lặp qua các phần tử để in kết quả.
let congnhan1 = new CongNhan("Hà Thị Bưởi", 25, "Nữ", "Nam Định", 5);
let congnhan2 = new CongNhan("Lê Thị Na", 31, "Nữ", "Thanh Hóa", 5);
let congnhan3 = new CongNhan("Hồ Công Toàn", 21, "Nam", "Hải Dương", 10);
// In thông tin của Worker:
congnhan1.printInforCongNhan();
console.log("------------------Demo Array Worker ------------------");
// Tạo 1 mảng Array lưu thông tin worker1,2,3 để demo Array.
let congnhanArray: CongNhan[];  // Khai báo 1 mảng
congnhanArray = [congnhan1, congnhan2, congnhan3];  // Add các phần tử vào trong mảng.
// Sử dụng foreach để in thông tin
congnhanArray.forEach(element => {
    element.printInforCongNhan();
});
console.log("------------------Finish Demo Array ------------------");

// Khai báo các Kỹ sư trên hệ thống
let KySu1 = new KySu("Bùi Tuấn Anh ", 21, "Nam", "Hà Nội", "DEV");
let KySu2 = new KySu("Bùi Thị Hoa Mai ", 22, "Nữ", "Hà Nội", "TEST");
let KySu3 = new KySu("Bùi Hải Linh ", 20, "Nữ", "Hà Nội", "TEST");

// In thông tin Kỹ sư
KySu1.printInforKysu();
// Tạo 1 mảng Set lưu thông tin Engineer1,2,3 để demo set.
console.log("------------------Demo Set Engineer ------------------");
let KySuSET = new Set(); // Khai báo 1 set
KySuSET.add(KySu1);
KySuSET.add(KySu2);
KySuSET.add(KySu3);
// Lấy ra tổng số phần tử trong Set
console.log("Tổng số phần tử trong Set: " + KySuSET.size);
console.log("Xóa 1 phần tử trong Set: " + KySuSET.delete(KySu3));
// In thông tin các phần tử trong set
KySuSET.forEach(element => {
    console.log(element);
});

//Khai báo các Nhân viên trên hệ Thống

let NhanVien1 = new NhanVien("Lê Anh Tuấn", 21, "Nam", "Thường Tín", "Task1");
let NhanVien2 = new NhanVien("Nguyễn Hà Anh", 22, "Nữ", "Bình Định", "Task2");
let NhanVien3 = new NhanVien("Lê Thị Thu", 21, "Nữ", "Bắc Ninh", "Task3");

NhanVien1.printInforNhanVien();
let NhanVienArray: NhanVien[] = [NhanVien1, NhanVien2, NhanVien3];
// FOR IN
for (const item in NhanVienArray) {
    console.log(NhanVienArray[item]);
    }

// FOR OF
for (const element of NhanVienArray) {
    element.printInforNhanVien();
}


