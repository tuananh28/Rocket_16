// Tính tổng các số trong mảng
// Khai báo ra mảng chưa các giá trị như bên dưới
var numArray = [10, 20, 30];
// Sử dụng vòng for để tính các giá trị trong mảng
var total = 0;
numArray.forEach(function (element) {
    total = total + element;
});
console.log("---------CÁCH 1: Tổng các số trong mảng numArray là: ", total);
// Sử dụng reduce để tính tổng
// Viết hàm tính tổng, hàm này là hàm callback, thực hiện xem giá trị mỗi khi lặp qua 1 phần tử
function callback(accumulator, currentValue, currentIndex) {
    console.log("--------------Lần lặp ", currentIndex + 1, "------------");
    console.log("accumulator hiện tại: ", accumulator);
    console.log("currentValue hiện tại: ", currentValue);
    console.log("currentIndex hiện tại: ", currentIndex);
    accumulator = accumulator + currentValue;
    return accumulator;
}
// sử dụng hàm reduce với hàm callback là sum vừa viết.
console.log("Cách 2: Sử dụng Reduce");
var total_reduce = numArray.reduce(callback, 0);
console.log("---------CÁCH 2: Tổng các số sử dụng reduce: ", total_reduce);
// có thể sử dụng cách viết ngắn gọn hơn sử dụng arror function và bỏ param currentIndex do không cần dùng tới.
var total_reduce_other = numArray.reduce(function (accumulator, currentValue) { return accumulator + currentValue; }, 0);
console.log("----------CÁCH 3: Tối ưu cách viết, tổng các phần tử mảng là: ", total_reduce_other);
// Thực hiện thay đổi giá trị initialValue  = 20
var total_reduce_other_1 = numArray.reduce(function (accumulator, currentValue) { return accumulator + currentValue; }, 20);
console.log("----------CÁCH 4: Thay đổi initialValue =20, tổng các phần tử mảng là: ", total_reduce_other_1);
// Không sử dụng initialValue.
var total_reduce_other_2 = numArray.reduce(function (accumulator, currentValue) { return accumulator + currentValue; });
console.log("----------CÁCH 5: không sử dụng initialValue, tổng các phần tử mảng là: ", total_reduce_other_2);
