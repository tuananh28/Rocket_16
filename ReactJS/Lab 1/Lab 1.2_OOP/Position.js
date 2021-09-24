"use strict";
exports.__esModule = true;
exports.printInforPosition = exports.Possition = void 0;
var Possition = /** @class */ (function () {
    // Hàm contructor
    function Possition(id, name) {
        this.id = id;
        this.name = name;
    }
    // Nhóm hàm getter setter
    Possition.prototype.getname = function () {
        return this.name;
    };
    Possition.prototype.setname = function (v) {
        this.name = v;
    };
    Possition.prototype.getid = function () {
        return this.id;
    };
    Possition.prototype.setid = function (v) {
        this.id = v;
    };
    return Possition;
}());
exports.Possition = Possition;
// Hàm in thông tin Position, viết bên ngoài class
function printInforPosition(position) {
    console.log("ID: " + position.getid() + " Position Name: " + position.getname());
}
exports.printInforPosition = printInforPosition;
