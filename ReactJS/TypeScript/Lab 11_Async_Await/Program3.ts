// -	Giả sử bài toán đặt ra, cần tạo ra 1 số phòng ban mới, và tạo thêm người quản lý cho phòng ban mới tạo, người quản lý này có position.
// -	Cần phải tạo theo thứ tự như bên dưới. trong trường hợp xảy ra lỗi ở bất kỳ bước nào thì sẽ dừng thực thi ở các bước phía sau. Sử dụng promise để xử lý bài toán này.
// -	Step1: Tạo mới 1 Department
// -	Step2: Tạo mới 1 Position
// -	Step3: Tạo mới 1 Account


//hàm tạo Department
async function callAPICreateDepartment() {
  console.log("Step1: call API Create Department!");
  return "Create Department successfully!";
}
//hàm tạo Position
async function callAPICreatePosition() {
  console.log("Step2: call API Create Position!");
  return "Create Position successfully!";
}
//hàm tạo Account
async function callAPICreateAccount() {
  console.log("Step3: call API Create Account!");
  return "Create Account successfully!";
}
// Viết hàm tổng hợp đẻ tạo mới 3 đối tượng.
// 1. Tạo Department
// 2. Tạo Position
// 3. Tạo Account.
// Bất cứ bước nào gặp lỗi sẽ dừng chương trình.
async function create_NewObject() {
  //call API Department
  let resultCreateDepartment = await callAPICreateDepartment();
  console.log(resultCreateDepartment);

  //Call API Position
  let resultCreatePosition = await callAPICreatePosition();
  console.log(resultCreatePosition);

  //call API Account
  let resultCreateAccount = await callAPICreateAccount();
  console.log(resultCreateAccount);
}

create_NewObject();
