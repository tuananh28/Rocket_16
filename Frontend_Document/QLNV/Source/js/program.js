// Khai báo 1 array để lưu thông tin tất cả các Account trên hệ thống.
var listAccount = [];
$(function () {
  // Gọi hàm load dữ liệu từ Server API khi load trang
  getListEmployees();

  // Hàm thực thi khi load đầy đủ các thành phần html
  $("#reset_btn").click(function () {
    // Xử lý sự kiện cho nút reset, Sử dụng JQuery để lấy các giá trị các trường theo ID, sau đó Set về rỗng
    $("#ID_ID").val("");
    $("#Email_ID").val("");
    $("#Username_ID").val("");
    $("#Fullname_ID").val("");
    $("#Department_ID").val("");
    $("#Position_ID").val("");
    $("#Cretate_Date_ID").val("");
  });

  // Xử lý sự kiện khi nhấn nút Save
  $("#Main_Form_ID").submit(function () {
    // Xử lý sự kiện khi nhấn nút Submit của Form(Save), ở đây phải sử dụng Return False ở cuối sự kiện này để không redirect sang trang mới.
    // Lấy các giá trị người dùng nhập vào
    var v_ID_ID = $("#ID_ID").val();
    var v_Email_ID = $("#Email_ID").val();
    var v_Username_ID = $("#Username_ID").val();
    var v_Fullname_ID = $("#Fullname_ID").val();
    var v_Department_ID = $("#Department_ID").val();
    var v_Position_ID = $("#Position_ID").val();
    var v_Cretate_Date_ID = $("#Cretate_Date_ID").val();

    // Tạo 1 đối tượng account để lưu giữ thông tin nhận được
    var account = {
      email: v_Email_ID,
      username: v_Username_ID,
      fullname: v_Fullname_ID,
      departmentId: v_Department_ID,
      positionId: v_Position_ID,
      createDate: v_Cretate_Date_ID,
    };
    $.ajax({
      url: "http://localhost:8080/api/v1/accounts",
      type: "POST",
      data: JSON.stringify(account), // body
      contentType: "application/json", // type of body (json, xml, text)
      // dataType: 'json', // datatype return
      success: function (data, textStatus, xhr) {
        console.log(data);
        // success
        getListEmployees();
      },
      error(jqXHR, textStatus, errorThrown) {
        alert("Error when loading data");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
      },
    });
    return false;
    // Add account tới MOCK API
    // $.post("http://localhost:8080/api/v1/accounts", account,
    //     function (data, status) {
    //         // error
    //         if (status == "error") {
    //             alert("Error when loading data");
    //             return;
    //         }
    //         // success
    //         // Hàm này để hiển thị thông tin account ở table
    //         getListEmployees();
    //     });
    // return false;
    // Sử dụng return false để không redirect tới 1 trang khác.
  });
});
// Đoạn bên trên khi load hoàn chỉnh trang web sẽ kết thúc ở đây, đoạn dưới sẽ viết các hàm bổ trợ khác
// Viết hàm showAccount()
function showAccount() {
  // Xóa hết kết quả đang hiển thị ở bảng kết quả
  $("#Result_TB").empty();
  // Lặp trong listAccount để in thông tin từng phần tử
  // Hiển thị thêm 2 nút để sửa và xóa các Account
  for (var index = 0; index < listAccount.length; index++) {
    $("#Result_TB").append(`
              <tr>
              <th>${listAccount[index].id}</th>
              <th>${listAccount[index].email}</th>
              <th>${listAccount[index].username}</th>
              <th>${listAccount[index].fullname}</th>
              <th>${listAccount[index].department}</th>
              <th>${listAccount[index].position}</th>   
              <th>${listAccount[index].createDate}</th>
              <th><button class="btn btn-warning" onclick="openUpdateModal(${index})">Edit</button></th>
              <th><button class="btn btn-warning" onclick="deleteAccount(${index})">Delete</button></th>
              </tr>
              `);
  }
}
// Viết hàm xóa account
function deleteAccount(index) {
  var v_del_ID = listAccount[index].id;
  var username = listAccount[index].username;
  // Hiển thị 1 Confim Popup, chọn Có = True
  var confirm_del = confirm(
    "Bạn có chắc chắn muốn xóa Account " + username + " này không"
  );
  if (confirm_del) {
    $.ajax({
      url: "http://localhost:8080/api/v1/accounts/" + v_del_ID,
      type: "DELETE",
      success: function (result) {
        // error
        if (result == undefined || result == null) {
          alert("Error when loading data");
          return;
        }
        // success
        console.log(result);
        getListEmployees();
      },
    });
  } else {
    return;
  }
}
// Viết hàm để Edit các account
function editAccount(Index) {
  $("#ID_ID").val(listAccount[Index].id);
  $("#Email_ID").val(listAccount[Index].email);
  $("#Username_ID").val(listAccount[Index].username);
  $("#Fullname_ID").val(listAccount[Index].fullname);
  $("#Department_ID").val(listAccount[Index].department);
  $("#Position_ID").val(listAccount[Index].position);
  $("#Cretate_Date_ID").val(listAccount[Index].createDate);

  //  Xử lý sự kiện khi click vào nút Update
  $("#update_btn").click(function () {
    var v_ID_ID = $("#ID_ID").val();
    var v_Email_ID = $("#Email_ID").val();
    var v_Username_ID = $("#Username_ID").val();
    var v_Fullname_ID = $("#Fullname_ID").val();
    var v_Department_ID = $("#Department_ID").val();
    var v_Position_ID = $("#Position_ID").val();
    var v_Cretate_Date_ID = $("#Cretate_Date_ID").val();

    var account = {
      id: v_ID_ID,
      email: v_Email_ID,
      username: v_Username_ID,
      fullname: v_Fullname_ID,
      departmentId: v_Department_ID,
      positionId: v_Position_ID,
      createDate: v_Cretate_Date_ID,
    };
    $.ajax({
      url: "'http://localhost:8080/api/v1/accounts/" + v_ID_ID,
      type: "PUT",
      data: JSON.stringify(account), // body
      contentType: "application/json", // type of body (json, xml, text)
      // dataType: 'json', // datatype return
      success: function (data, textStatus, xhr) {
        console.log(data);
        // success
        getListEmployees();
      },
      error(jqXHR, textStatus, errorThrown) {
        alert("Error when loading data");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
      },
    });
  });
}

// Viết hàm gọi dữ liệu server API bằng Ajax khi load trang Web
function getListEmployees() {
  // call API from server
  $.get("http://localhost:8080/api/v1/accounts", function (data, status) {
    // reset list employees
    listAccount = [];
    // error
    if (status == "error") {
      // TODO
      alert("Error when loading data");
      return;
    }
    // success
    listAccount = data;
    // parseData(data);
    showAccount();
  });
}
// hàm chuyển dữ liệu API nhận được bằng Ajax chuyển về dạng List để sử dụng trong chương trình
// function parseData(data) {
//     // employees = data;
//     data.forEach(function (item) {
//         var account = {
//             'AccountID': item.id,
//             'Email': item.email,
//             'Username': item.ussername,
//             'FullName': item.fullName,
//             'Department': item.department,
//             'Position': item.position,
//             'CreateDate': item.createDate,
//         }
//         listAccount.push(account)
//     });
// }
