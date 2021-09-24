"use strict";
exports.__esModule = true;
exports.Product = void 0;
var Product = /** @class */ (function () {
    function Product(name, price) {
        this.name = name;
        this.price = price;
    }
    // Nhóm hàm getter và Setter
    Product.prototype.setname = function (v) {
        this.name = v;
    };
    Product.prototype.getname = function () {
        return this.name;
    };
    Product.prototype.setprice = function (v) {
        this.price = v;
    };
    Product.prototype.getprice = function () {
        return this.price;
    };
    return Product;
}());
exports.Product = Product;
