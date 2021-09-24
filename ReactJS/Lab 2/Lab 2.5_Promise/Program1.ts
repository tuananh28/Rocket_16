// Demo cách sử dụng promise
// Khai báo 1 Promise có đầu vào là 2 hàm dạng HOF là resolve và reject
let promise = new Promise(function (resolve, reject) {
    resolve("Call API Success!"); 
     reject("error when load API!! Check Again!!");
  });
  
  promise.then(
    // Trong quá trình thực thi Promise nếu resolve được trả về thì sẽ thực hiện đoạn lệnh này
    function (success) {
      console.log("Chạy đoạn lệnh Success: ", success);
    },
    // Trong quá trình thực thi Promise nếu reject được trả về thì sẽ thực hiện đoạn lệnh này
    function (error) {
      console.log("Chạy đoạn lệnh error: ", error);
    }
  );  