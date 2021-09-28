"use strict";
exports.__esModule = true;
var Account_1 = require("./Account");
// Khai báo các Account trên hệ thống
var account1 = new Account_1.Account("account1", 20, "Male", "HN"); // Tạo mới 1 đối tượng Worker.
var account2 = new Account_1.Account("account2", 22, "FeMale", "NĐ");
var account3 = new Account_1.Account("account3", 24, "Male", "HN");
// In thông tin của Account:
// In thông tin theo cách 1 Normal
console.log("--- In thông tin theo cách 1: ");
(0, Account_1.printInforStaff)(account1);
// In thông tin theo cách 2:
console.log("--- In thông tin theo cách 2: ");
(0, Account_1.print_Account)(account2);
// In thông tin sử dụng arrow function cách 3:
console.log("--- In thông tin sử dụng arrow function: ");
(0, Account_1.print_account_Arror_function)(account3);
// In thông tin sử dụng arrow function cách 4:
console.log("--- In thông tin sử dụng arrow function_Cách 4: ");
(0, Account_1.print_account_Arror_function)(account3);
// Demo sử dụng map để lấy các giá trị trong mảng.
var account_Array;
account_Array = [account1, account2, account3];
// Sử dụng map để lặp. map sử dụng callback function, trả về value và key
// In thông tin account sử dụng map.
console.log("-------Thông tin Account sử dụng Map");
account_Array.map(function (account, key) {
    console.log("STT: ", key);
    (0, Account_1.printInforStaff)(account);
});
