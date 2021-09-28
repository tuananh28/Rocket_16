// Sử dụng hàm setTimeout để delay quá trình trả dữ liệu về từ server, khi này sẽ xảy ra bất đồng bộ ở step 2 và step 3
function callAPI() {
    setTimeout(() => {
        console.log("Thực hiện đoạn lệnh gọi API từ Server ..");
        return "Call API Successfully";
    }, 1000);
}
function callAPICreateAccount() {
    console.log("STEP1: Thực hiện đoạn lệnh trước khi gọi API!");
    //Thực hiện call API.
    let result = callAPI();
    console.log("STEP2: Thực hiện Call API và trả về kết quả: ", result);
    // Đoạn lệnh phía dưới sẽ thực thi ngay sau khi quá trình gọi API chạy, do hàm setTimeout delay nên STEP 3 sẽ chạy trước khi STEP2 chạy xong
    console.log("STEP3: Thực hiện đoạn lệnh sau khi gọi API!");
}
callAPICreateAccount();
