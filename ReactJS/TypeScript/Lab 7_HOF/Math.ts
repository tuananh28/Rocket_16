// Định nghĩa ra 1 số hàm trong toán học.
function sum(a: number, b: number) {
    return a + b;
  }
  function minus(a: number, b: number) {
    return a - b;
  }
  function multiply(a: number, b: number) {
    return a * b;
  }
  console.log("------------ Demo cách gọi hàm như bình thường --------------");
  
  // Thực hiện sử dụng như cách bình thường
  // Phép cộng
  let sum_a_b = sum(20, 10);
  console.log("Kết quả phép cộng 2 số là: ", sum_a_b);
  
  // Phép trừ
  let minus_a_b = minus(20, 10);
  console.log("Kết quả phép cộng 2 số là: ", minus_a_b);
  
  // Phép nhân
  let multiply_a_b = multiply(20, 10);
  console.log("Kết quả phép cộng 2 số là: ", multiply_a_b);
  
  console.log("------------- Demo sử dụng HOF -----------------");
  
  // Khai báo HOF để tối ưu lại cách viết.
  function caculate(a: number, b: number, operation) {
    let result = operation(a, b);
    console.log("Kết quả phép tính ", operation, " là: ", result);
  }
  
  // Sử dụng HOF với sum
  caculate(20, 10, sum);
  // Sử dụng HOF với Minus
  caculate(20, 10, minus);
  // Sử dụng HOF với multiply
  caculate(20, 10, multiply);
  