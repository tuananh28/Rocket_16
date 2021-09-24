"use strict";
exports.__esModule = true;
exports.CanBo = void 0;
var CanBo = /** @class */ (function () {
    function CanBo(name, age, gender, address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
    CanBo.prototype.getname = function () {
        return this.name;
    };
    CanBo.prototype.setname = function (value) {
        this.name = value;
    };
    CanBo.prototype.getage = function () {
        return this.age;
    };
    CanBo.prototype.setage = function (value) {
        this.age = value;
    };
    CanBo.prototype.getgender = function () {
        return this.gender;
    };
    CanBo.prototype.setgender = function (value) {
        this.gender = value;
    };
    CanBo.prototype.getaddress = function () {
        return this.address;
    };
    CanBo.prototype.setaddress = function (value) {
        this.address = value;
    };
    CanBo.prototype.printInforCanBo = function () {
        console.log("Name : " + this.name
            + " Age : " + this.age
            + " Gender : " + this.gender
            + " Address : " + this.address);
    };
    return CanBo;
}());
exports.CanBo = CanBo;
