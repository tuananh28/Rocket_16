// Khai báo ra 1 đối tượng account
let account = {
    name: "tuananh",
    age: 20,
    gender: "Nam",
    address: "Hà Nội",
}
// Định nghĩa ra các biến để lưu trữ cho từng thuộc tính của dối tượng Account
let { name: name_let, age: age_let, gender: gender_let, address: address_let } = account;
console.log("\nThông tin các biến sau khi gán giá trị:");
console.log("Giá trị biến name_let: ", name_let);
console.log("Giá trị biến age_let: ", age_let);
console.log("Giá trị biến gender_let: ", gender_let);
console.log("Giá trị biến address_let: ", address_let);

// Tạo đối tượng Worker có các thuộc tính như account và thêm vào bậc nữa rank;
// Đây là cách khai báo bình thường
// let worker = {
//     name: "daonq",
//     age: 20,
//     gender: "Nam",
//     address: "HN",
//     rank: 10,
// }
// Sử dụng toán tử ...
let worker = {
    ...account,
    rank: 10,
}
console.log("\nThông tin worker: ", worker);

// Thực hiện demo với Array, khai báo 1 mảng bao gồm tên các bạn trong lớp.
let name_Array: String[] = ["Name1", "Name2", "Name3"];
let [Student1, Student2, Student3] = name_Array;
console.log("\nThông tin tên các sinh viên sau khi destructuring: ")
console.log("Student1: ", Student1);
console.log("Student2: ", Student2);
console.log("Student3: ", Student3);

// Thực hiện tạo thêm 1 mảng mới và thêm 1 số sinh viên nữa:
let name_Array_NEW: String[] = [...name_Array, "Name4", "Name5", "Name6"];
console.log("\nThông tin sinh viên trong mảng name_Array_NEW: ");

for (let index = 0; index < name_Array_NEW.length; index++) {
    console.log("Sinh viên ", index+ 1, name_Array_NEW[index]);

}


