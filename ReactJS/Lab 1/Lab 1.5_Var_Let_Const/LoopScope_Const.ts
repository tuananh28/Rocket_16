const PI = 3.14;
console.log("\nGía trị của PI là : " + PI);
// Bây giờ sẽ thay đổi giá trị số PI
//PI = 3; không thể gán lai giá trị, sẽ báo lỗi.
// khi thực hiện khai báo với const chú ý cần gán giá trị ngay khi khai báo nếu không sẽ báo lỗi
//const Create_date;
//Create_date = " ";
console.log('\n Const với đối tượng: ')
// Có thể thay đổi thuộc tính của đối tượng, nhưng không gán lại toàn bộ đối tượng được.
const account = {
    name: "tuananh",
    age: 21,
    gender: "Nam",
    address: "Hà Nội",
}
console.log("\nThông tin Account: " , account);
// Thực hiện thay đổi thuộc tính của Account.
account.name ="tuananhbui";
account.age=22;
console.log('\nThông tin Account sau khi thay đổi: ',account)
// Bây giờ gán lại giá trị mới cho đối tượng account
// Không thể gán lại được, sẽ báo lỗi trong chương trình.
// account = {
//     name: "tuananh",
//     age: 21,
//     gender: "Nam",
//     address: "Hà Nội",
// }

