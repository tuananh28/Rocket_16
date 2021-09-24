// Thực hiện demo cách sử dụng currying function
// Viết hàm tính phép nhân của 3 số
// Viêt theo cách bình thường, sẽ truyền vào 3 tham số a, b, c
// function multiply(a, b, c) {
//     return a * b * c;
// }
// const result = multiply(1, 2, 3);
// console.log(result);

// Viết dưới dạng currying function, với cách viết này, có thể cố định 1 số giá trị đầu vào để tái sử dụng hàm.
function multiply(a) {
    return (b) => {
      return (c) => {
        return a * b * c;
      };
    };
  }
  
  // let result = multiply(1)(2)(3);
  // console.log(result); // 6
  
  const multiply_1 = multiply(1);
  const multiply_2 = multiply_1(2);
  console.log("--------- Sử dụng Currying function normal----------");
  console.log("Kết quả phép nhân với 3: ", multiply_2(3));
  // Trong trường hợp muốn cố dịnh giá trị a, b trong tham số đầu vào chỉ cần gọi lại hàm multiply_2() với tham số c thay đổi, tăng tính tái sử dụng của code
  // Trong trường hợp này giả sử viết theo cách bình thường sẽ như sau:
  // multiply(1,2,4)
  // multiply(1,2,5)
  console.log("Kết quả phép nhân với 4: ", multiply_2(4));
  console.log("Kết quả phép nhân với 5: ", multiply_2(5));
  
  // bài toán này viết dưới dạng Arrow function sẽ như sau
  // Khai báo ra hàm arrow
  const multiply_arrow = (a) => (b) => (c) => a * b * c;
  // Sử dụng hàm vừa khai báo
  console.log("--------- Sử dụng Currying function arrow ----------");
  
  const multiply_arrow_1 = multiply_arrow(1);
  const multiply_arrow_2 = multiply_arrow_1(2);
  
  console.log("Kết quả phép nhân với 3: ", multiply_arrow_2(3));
  console.log("Kết quả phép nhân với 4: ", multiply_arrow_2(4));
  console.log("Kết quả phép nhân với 5: ", multiply_arrow_2(5));
  