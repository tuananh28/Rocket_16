"use strict";
exports.__esModule = true;
exports.print_account_Arror_function = exports.print_Account = exports.printInforStaff = exports.Account = void 0;
var Account = /** @class */ (function () {
    // Hàm tạo full tham số cho Account
    function Account(name, age, gender, address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
    // Nhóm hàm getter và Setter
    Account.prototype.setname = function (v) {
        this.name = v;
    };
    Account.prototype.getname = function () {
        return this.name;
    };
    Account.prototype.setage = function (v) {
        this.age = v;
    };
    Account.prototype.getage = function () {
        return this.age;
    };
    Account.prototype.setgender = function (v) {
        this.gender = v;
    };
    Account.prototype.getgender = function () {
        return this.gender;
    };
    Account.prototype.setaddress = function (v) {
        this.address = v;
    };
    Account.prototype.getaddress = function () {
        return this.address;
    };
    return Account;
}());
exports.Account = Account;
// Viết hàm để in thông tin nhân viên:
// Cách 1: Normal
function printInforStaff(account) {
    console.log("Name: " + account.getname() + " Age: " + account.getage() + " Gender: " + account.getgender() + " Address: " + account.getaddress());
}
exports.printInforStaff = printInforStaff;
// Cách 2:
var print_Account = function printInforStaff_Other(account) {
    console.log("Name: " + account.getname() + " Age: " + account.getage() + " Gender: " + account.getgender() + " Address: " + account.getaddress());
};
exports.print_Account = print_Account;
// Cách 3: arrow Function
var print_account_Arror_function = function (account) {
    console.log("Name: " + account.getname() + " Age: " + account.getage() + " Gender: " + account.getgender() + " Address: " + account.getaddress());
};
exports.print_account_Arror_function = print_account_Arror_function;
// Cách 4: Viêt Arrow dưới dạng ngắn gọn hơn, bỏ ngoặc () trong khai báo biến đầu vào, bỏ {} trong đoạn return
var print_account_Arror_function_1 = function (account) { return console.log("Name: " + account.getname() + " Age: " + account.getage() + " Gender: " + account.getgender() + " Address: " + account.getaddress()); };
