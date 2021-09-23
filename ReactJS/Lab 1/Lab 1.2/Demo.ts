import { Department, printInforDepartment } from "./Department";
import { Possition, printInforPosition } from "./Position";
import { Account, printInforAccount } from "./Account";

// Khai báo các phòng ban trên hệ thống
let dep1 = new Department(1, "Sale");  // Tạo mới 1 đối tượng Department.
let dep2 = new Department(2, "Kỹ thuật");
let dep3 = new Department(3, "Phó giám đốc");
let dep4 = new Department(4, "Tài chính");
let dep5 = new Department(5, "Bảo vệ");
console.log('--- Thông tin phòng ban trên hệ thống: ---')
printInforDepartment(dep1); // Thực hiện in thông tin của đối tượng vừa tạo.
printInforDepartment(dep2);
printInforDepartment(dep3);
printInforDepartment(dep4);
printInforDepartment(dep5);

// Khai báo các Position trên hệ Thống

let pos1 =  new Possition(1,"Dev");
let pos2 =  new Possition(2,"Test");
let pos3 =  new Possition(3,"Scrum_Master");
let pos4 =  new Possition(4,"PM");
console.log('--- Thông tin Position trên hệ thống: ---')
printInforPosition(pos1); // Thực hiện in thông tin của đối tượng vừa tạo.
printInforPosition(pos2);
printInforPosition(pos3);
printInforPosition(pos4);

// Khai báo các Account trên hệ thống
let date: Date = new Date("2021-07-01"); // khai báo đổi tượng kiểu date để sử dụng
let acc1 = new Account(1, "tuananh@gmail.com", "tuananh", "Bùi Tuấn Anh", dep3, pos1, date);
let acc2 = new Account(2, "hoamai@gmail.com", "hoamai", "Bùi Thị Hoa Mai", dep1, pos3, date);
let acc3 = new Account(3, "daoluc@gmail.com", "daonguyen", "Nguyễn Đào Lực ", dep2, pos2, date);
let acc4 = new Account(4, "hoanglinh@gmail.com", "hoanglinh", "Trần Hoàng Linh", dep4, pos4, date);
// Gọi hàm in thông tin Account để sử dụng.
printInforAccount(acc1);
printInforAccount(acc2);
printInforAccount(acc3);
printInforAccount(acc4);

// function printInforPosition(pos1: any) {
//     throw new Error("Function not implemented.");
// }
// function printInforAccount(acc1: any) {
//     throw new Error("Function not implemented.");
// }

