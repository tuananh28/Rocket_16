async function callAPI() {
    console.log("Thực hiện call API từ server");
    return "Call API Success";
}

async function callAPICreateAccount(){
    console.log("STEP1: Thực hiện đoạn lệnh trước khi gọi API!");
    //Thực hiện call API, thêm await để xử lý bất đồng bộ.  
    let result = await callAPI();
    console.log("STEP2: Thực hiện Call API và trả về kết quả: ", result);

    // Đoạn lệnh phía dưới sẽ thực thi sau khi hoàn thành chạy API.

    console.log("STEP3: Thực hiện đoạn lệnh sau khi gọi API!");
}

// Demo Kết quả
callAPICreateAccount();
