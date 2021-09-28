"use strict";
exports.__esModule = true;
var Product_1 = require("./Product");
// Tạo ra các đối tượng
var product1 = new Product_1.Product("Product1", 200);
var product2 = new Product_1.Product("Product2", 250);
var product3 = new Product_1.Product("Product3", 400);
// Tạo mảng để lưu các đối tượng.
var productArray;
productArray = [product1, product2, product3];
// Viết hàm dưới dạng currying để tính discount giá sản phẩm
var discount = function (discount) { return function (price) { return price - price * discount; }; };
// Tạo hàm để giảm giá 10% cho sản phẩm
var tenPercentDiscount = discount(0.1);
// In ra thông tin sản phẩm sau giảm giá 10 %
console.log("----------Thông tin sản phẩm giảm giá 10%-----------");
productArray.forEach(function (element) {
    console.log("Name: ", element.getname(), "Price: ", tenPercentDiscount(element.getprice()));
});
// Tạo hàm để giảm giá 20% cho sản phẩm
var twentyPercentDiscount = discount(0.2);
// In ra thông tin sản phẩm sau giảm giá 10 %
console.log("----------Thông tin sản phẩm giảm giá 20%-----------");
productArray.forEach(function (element) {
    console.log("Name: ", element.getname(), "Price: ", twentyPercentDiscount(element.getprice()));
});
