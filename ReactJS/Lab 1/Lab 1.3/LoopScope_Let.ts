// var i = 5;
// console.log("Giá trị i TRƯỚC vòng lặp: "+ i);
// for (var i = 0; i < 10; i++) {
//   console.log("Chạy vòng lặp làm thay đổi giá trị của i");

// }
// console.log("Giá trị i SAU vòng lặp bị thay đổi theo: "+ i);

// Khi sử dụng với let, thì giá trị biến i không thay đổi
let i = 5;
console.log("Giá trị i TRƯỚC vòng lặp: ", i);
for (let i = 0; i < 10; i++) {
  console.log("Chạy vòng lặp không thay đổi giá trị của i");
}
console.log("Giá trị i SAU vòng lặp không thay đổi: ", i);
