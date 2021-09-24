import { NhanVien } from './../../Lab 1/Lab 1.3_Inheritance/NhanVien';
import { KySu } from './../../Lab 1/Lab 1.3_Inheritance/KySu';
import { CongNhan } from './../../Lab 1/Lab 1.3_Inheritance/CongNhan';
import { CanBo } from '../../Lab 1/Lab 1.3_Inheritance/CanBo';


// Tạo ra các đối tượng
let worker1 = new CongNhan("Worker1", 20, "Male", "HN", 10);
let worker2 = new CongNhan("Worker2", 22, "FeMale", "NĐ", 7);
let worker3 = new CongNhan("Worker3", 24, "Male", "HN", 8);

let Engineer1 = new KySu("Engineer1", 20, "Male", "HN", "DEV");
let Engineer2 = new KySu("Engineer2", 22, "FeMale", "NĐ", "TEST");
let Engineer3 = new KySu("Engineer3", 24, "Male", "HN", "DEV");

let Employee1 = new NhanVien("Employee1", 20, "Male", "HN", "Task1"); // Tạo mới 1 đối tượng Worker.
let Employee2 = new NhanVien("Employee2", 22, "FeMale", "NĐ", "Task2");
let Employee3 = new NhanVien("Employee3", 24, "Male", "HN", "Task3");

// Khai báo 1 mảng các staff, chứa các đối tượng phía trên vừa khai báo
let staffArray: CanBo[];
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
function printWorkerInfo(staffArray: CanBo[]) {
  staffArray.forEach((element) => {
    if (element instanceof CongNhan) {
      element.printInforCongNhan();
    }
    // console.log(element instanceof Worker);
  });
}
// Viết hàm để in ra thông tin Engineer
function printEngineerInfo(staffArray: CanBo[]) {
  staffArray.forEach((element) => {
    if (element instanceof KySu) {
      element.printInforKysu();
    }
    // console.log(element instanceof Worker);
  });
}

console.log("Thong tin Worker: ", printWorkerInfo(staffArray));
console.log("Thong tin Engineer: ", printEngineerInfo(staffArray));

// CÁCH 2: Sử dụng HOF, tham số đầu vào là 1 hàm, đầu ra trả ra 1 hàm.
console.log("------ Demo sử dụng HOF Cách 2: ------------");

function printStaff(staffArray: CanBo[], function_print) {
  return function_print(staffArray);
}
console.log("Sử dụng HOF để tin thông tin");
// In thông tin worker
printStaff(staffArray, printWorkerInfo);
// In thông tin Engineer
printStaff(staffArray, printEngineerInfo);

// CÁCH 3: Viết hàm giá trị truyền vào là 1 object
console.log("----------In thông tin theo Cách 3-----------");
function printStaffArray(staffArray: CanBo[], params) {
  staffArray.forEach((element) => {	
    if (element instanceof params) {
      console.log("Thông tin:", element);
    }
  });
}

printStaffArray(staffArray, CongNhan);
printStaffArray(staffArray, KySu);


