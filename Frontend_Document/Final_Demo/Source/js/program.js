// Khai báo 1 array để lưu thông tin tất cả các Account trên hệ thống.
var listAccount = [];
var listDepartment = [];
var listPosition = [];
//Pagable
var currentPage = 1;
var size = 5;
var search = "";
// Sorting
var sortField = "id";
var isAsc = true;

function isLogin() {
  var username = storage.getItem("USERNAME");
  return username ? true : false;
}
$(function () {
  if (!isLogin()) {
    window.location.replace("login.html");
  }
  document.getElementById("fullName").innerHTML = storage.getItem("FULLNAME");
  // if (storage.getItem("ROLE") == "User") {
  //   window.location.replace("403.html");
  // }
});

function logout() {
  window.location.href = "login.html";
  // remove storage
  storage.removeItem("ID");
  storage.removeItem("EMAIL");
  storage.removeItem("FULLNAME");
  storage.removeItem("ROLE");
  storage.removeItem("USERNAME");
  storage.removeItem("PASSWORD");
}

// Hàm thực thi khi load đầy đủ các thành phần html
$(function () {
  showAvatar();
  $("#btn_changeAvatar").hide();
  // Gọi hàm load dữ liệu cho bảng Account từ Server API khi load trang
  getListEmployees();
  // Gọi hàm load dữ liệu cho bảng Department từ Server API khi load trang, sẽ đổ dữ liệu vào thẻ Select id="Department_ID" để chọn phòng ban
  getListDepartment();
  // Gọi hàm load dữ liệu cho bảng Possition từ Server API khi load trang, sẽ đổ dữ liệu vào thẻ  <select class="form-control" id="Position_ID"> để chọn Possition cho Account
  getListPosition();

  // Disable các trường CreateDate khi nhấn vào nút Save do trường này không cần nhập vào, sẽ lấy là Now Date khi Insert DB
  $("#Cretate_Date_ID").attr("disabled", "disabled");
  $("#ID_ID").attr("disabled", "disabled");

  // Xử lý sự kiện cho nút reset, Sử dụng JQuery để lấy các giá trị các trường theo ID, sau đó Set về rỗng
  $("#reset_btn").click(function () {
    $("#ID_ID").val("");
    $("#Email_ID").val("");
    $("#Username_ID").val("");
    $("#Fullname_ID").val("");
    $("#Department_ID").val("");
    $("#Position_ID").val("");
    $("#Cretate_Date_ID").val("");
  });

  // Xử lý sự kiện khi nhấn nút Save
  // Xử lý sự kiện khi nhấn nút Submit của Form(Save), ở đây phải sử dụng Return False ở cuối sự kiện này để không redirect sang trang mới.
  $("#Main_Form_ID").submit(function () {
    // Lấy các giá trị người dùng nhập vào
    // var v_ID_ID = $("#ID_ID").val();
    var v_Email_ID = $("#Email_ID").val();
    var v_Username_ID = $("#Username_ID").val();
    var v_Fullname_ID = $("#Fullname_ID").val();
    var v_Department_ID = $("#Department_ID").val();
    var v_Position_ID = $("#Position_ID").val();

    //Validate Email
    if (!v_Email_ID || v_Email_ID.length < 6 || v_Email_ID.length > 50) {
      // show error message
      document.getElementById("error-email").innerHTML =
        "Email name must be from 6 to 50 characters!";
      return false;
    }
    document.getElementById("error-email").style.display = "none";

    //Validate Username
    if (
      !v_Username_ID ||
      v_Username_ID.length < 6 ||
      v_Username_ID.length > 50
    ) {
      // show error message
      document.getElementById("error-username").innerHTML =
        "Username name must be from 6 to 50 characters!";
      return false;
    }
    document.getElementById("error-username").style.display = "none";
    //Validate Fullname
    if (
      !v_Fullname_ID | (v_Fullname_ID.length < 6) ||
      v_Fullname_ID.length > 50
    ) {
      // show error message
      document.getElementById("error-fullname").innerHTML =
        "Fullname name must be from 6 to 50 characters!";
      return false;
    }
    document.getElementById("error-fullname").style.display = "none";
    //Validate Department
    if (!v_Department_ID || v_Department_ID == "--Select a Department--") {
      // show error message
      document.getElementById("error-department").innerHTML =
        "Pls choose Department!";
      return false;
    }
    document.getElementById("error-department").style.display = "none";
    //Validate Position
    if (!v_Position_ID || v_Position_ID == "--Select a Position--") {
      // show error message
      document.getElementById("error-position").innerHTML =
        "Pls choose Possition!";
      return false;
    }
    document.getElementById("error-position").style.display = "none";

    // Lấy ra ID của Department khi người dùng lựa chọn phòng ban
    for (let index = 0; index < listDepartment.length; index++) {
      if (listDepartment[index].name == v_Department_ID) {
        var depID = listDepartment[index].id;
      }
    }
    // Lấy ra ID của Possition khi người dùng lựa chọn Possition
    for (let index = 0; index < listPosition.length; index++) {
      if (listPosition[index].name == v_Position_ID) {
        var posID = listPosition[index].id;
      }
    }
    // Tạo 1 đối tượng account để lưu giữ thông tin nhận được, ở đây khi tạo đối tượng không cần lấy ID do khi tạo dữ liệu trên server ID sẽ được tự động Gen
    var account = {
      email: v_Email_ID,
      username: v_Username_ID,
      fullname: v_Fullname_ID,
      departmentId: depID,
      positionId: posID,
      password: null,
    };

    // Add account tới MOCK API
    // Check Username đã có trên hệ thống hay chưa?
    $.ajax({
      url: "http://localhost:8080/api/v1/accounts/username/" + v_Username_ID,
      type: "GET",
      contentType: "application/json",
      dataType: "json", // datatype return
      beforeSend: function (xhr) {
        xhr.setRequestHeader(
          "Authorization",
          "Basic " +
          btoa(
            storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")
          )
        );
      },
      success: function (data, textStatus, xhr) {
        if (data) {
          alert("Username đã tồn tại trên hệ thống");
          return false;
        } else {
          // Add account tới MOCK API
          $.ajax({
            url: "http://localhost:8080/api/v1/accounts/",
            type: "POST",
            data: JSON.stringify(account), // body
            contentType: "application/json", // type of body (json, xml, text)
            // dataType: 'json', // datatype return
            beforeSend: function (xhr) {
              xhr.setRequestHeader(
                "Authorization",
                "Basic " +
                btoa(
                  storage.getItem("USERNAME") +
                  ":" +
                  storage.getItem("PASSWORD")
                )
              );
            },
            success: function (data, textStatus, xhr) {
              console.log(data);
              swal("Success", "Create Successful !!", "success");
              currentPage = data.totalPages;
              getListEmployees();
            },
            error(jqXHR, textStatus, errorThrown) {
              swal("Error!", "Error when loading data", "error");
              console.log(jqXHR);
              console.log(textStatus);
              console.log(errorThrown);
            },
          });
        }
      },
      error(jqXHR, textStatus, errorThrown) {
        swal("Error!", "Error when loading data", "error");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
      },
    });
    return false;
  });
});
// Đoạn bên trên khi load hoàn chỉnh trang web sẽ kết thúc ở đây, đoạn dưới sẽ viết các hàm bổ trợ khác

function getListDepartment() {
  $.ajax({
    url: "http://localhost:8080/api/v1/departments/",
    type: "GET",
    contentType: "application/json", // type of body (json, xml, text)
    dataType: "json", // datatype return
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " +
        btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD"))
      );
    },
    success: function (data, textStatus, xhr) {
      data.forEach(function (item) {
        var department = {
          id: item.id,
          name: item.name,
        };
        listDepartment.push(department);
      });
      for (let index = 0; index < listDepartment.length; index++) {
        $("#Department_ID").append(`
        <option>${listDepartment[index].name}</option>
          `);
      }
    },
    error(jqXHR, textStatus, errorThrown) {
      swal("Error!", "Error when loading data", "error");
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
}

function getListPosition() {
  // call API from server
  $.ajax({
    url: "http://localhost:8080/api/v1/positions/",
    type: "GET",
    contentType: "application/json", // type of body (json, xml, text)
    dataType: "json", // datatype return
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " +
        btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD"))
      );
    },
    success: function (data, textStatus, xhr) {
      data.forEach(function (item) {
        var position = {
          id: item.id,
          name: item.name,
        };
        listPosition.push(position);
      });
      for (let index = 0; index < listPosition.length; index++) {
        $("#Position_ID").append(`
        <option>${listPosition[index].name}</option>
          `);
      }
    },
    error(jqXHR, textStatus, errorThrown) {
      swal("Error!", "Error when loading data", "error");
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
  // success thì sẽ đổ dữ liệu vào listPossition và lấy dữ liệu trong List này fill vào phần thẻ Selecr để chọn Possition, chú ý phần này phải để trong nội dung xử lý của Ajax
}

// Viết hàm showAccount()
function showAccount() {
  $("#Email_ID").removeAttr("disabled");
  $("#Username_ID").removeAttr("disabled");
  // Xóa hết kết quả đang hiển thị ở bảng kết quả
  $("#Result_TB").empty();
  // Lặp trong listAccount để in thông tin từng phần tử
  // Hiển thị thêm 2 nút để sửa và xóa các Account
  for (var index = 0; index < listAccount.length; index++) {
    if (storage.getItem("ROLE") != "User") {
      $("#Result_TB").append(`
        <tr>
          <td><input id="checkbox-"+ type="checkbox" onClick="CheckboxItem(${index})"></td>
          <td>${listAccount[index].AccountID}</td>
          <td>${listAccount[index].Email}</td>
          <td>${listAccount[index].Username}</td>
          <td>${listAccount[index].FullName}</td>
          <td>${listAccount[index].Department}</td>
          <td>${listAccount[index].Position}</td>   
          <td>${listAccount[index].CreateDate}</td>
          <td><button class="btn btn-warning" onclick="editAccount(${index})">Edit</button></td>
          <td><button class="btn btn-warning" onclick="deleteAccount(${index})">Delete</button></td>
        </tr>
      `);
    }
  }
}

// Viết hàm xóa account
function deleteAccount(Index) {
  var v_del_ID = listAccount[Index].AccountID;
  // Hiển thị 1 Confim Popup, chọn Có = True
  // var confirm_del = confirm("Bạn có chắc chắn muốn xóa Account này không");
  swal({
    title: "Are you sure?",
    text: "Bạn có chắc chắn muốn xóa Account này không ",
    type: "warning",
    confirmButtonText: "Yes, Delete!",
    showCancelButton: true,
  }).then((result) => {
    if (result.value) {
      $.ajax({
        url: "http://localhost:8080/api/v1/accounts/" + v_del_ID,
        type: "DELETE",
        beforeSend: function (xhr) {
          xhr.setRequestHeader(
            "Authorization",
            "Basic " +
            btoa(
              storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")
            )
          );
        },
        success: function (result) {
          // error
          if (result == undefined || result == null) {
            swal("Error!", "Error when loading data", "error");
            return;
          }
          // success
          getListEmployees();
        },
      });
    } else {
      return;
    }
  });
}

function DeleteAll() {
  // get id cua nhung o duoc tich
  var ids = [];
  for (let index = 0; index < size; index++) {
    var checkboxInput = document.getElementById("checkbox-" + index);
    if (checkboxInput != null && checkboxInput != undefined) {
      if (checkboxInput.checked) {
        ids.push(checkboxInput.value);
      }
    } else {
      break;
    }
  }

  if (ids.length == 0) {
    alert("Bạn phải chọn ít nhất 1 bản ghi mới xóa được...");
  }

  // goi api
  $.ajax({
    url: "http://localhost:8080/api/v1/accounts?ids=" + ids.toString(),
    type: "DELETE",
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " +
        btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD"))
      );
    },
    success: function (result) {
      // success
      getListEmployees();
    },
    error(jqXHR, textStatus, errorThrown) {
      if (jqXHR.status == 403) {
        window.location.href = "403.html";
      } else {
        swal.fire("Error!", "Error when loading data", "error");
        console.log();
        console.log(textStatus);
        console.log(errorThrown);
      }
    },
  });
}

function CheckboxAll() {
  var checkboxTotal = document.getElementById("checkbox-all");

  for (let index = 0; index < size; index++) {
    var checkboxInput = document.getElementById("checkbox-" + index);
    if (checkboxInput != null && checkboxInput != undefined) {
      checkboxInput.checked = checkboxTotal.checked;
    } else {
      break;
    }
  }
}
// Viết hàm để Edit các account
function editAccount(Index) {
  // Lấy giá trị các trường ID, Fullname, Department, Possition Fill vào Form
  $("#ID_ID").val(listAccount[Index].AccountID);
  $("#Fullname_ID").val(listAccount[Index].FullName);
  $("#Department_ID").val(listAccount[Index].Department);
  $("#Position_ID").val(listAccount[Index].Position);
  // Disable các trường Email, Username, CreateDate khi nhấn vào nút Edit do không cho cập nhật các trường này
  $("#Email_ID").attr("disabled", "disabled");
  $("#Username_ID").attr("disabled", "disabled");
  $("#Cretate_Date_ID").attr("disabled", "disabled");
  //  Xử lý sự kiện khi click vào nút Update
  $("#update_btn").click(function () {
    var v_ID_ID = $("#ID_ID").val();
    var v_Fullname_ID = $("#Fullname_ID").val();
    var v_Department_ID = $("#Department_ID").val();
    var v_Position_ID = $("#Position_ID").val();
    //Validate Fullname
    if (
      !v_Fullname_ID | (v_Fullname_ID.length < 6) ||
      v_Fullname_ID.length > 50
    ) {
      // show error message
      document.getElementById("error-fullname").innerHTML =
        "Fullname name must be from 6 to 50 characters!";
      return false;
    }
    document.getElementById("error-fullname").style.display = "none";
    //Validate Department
    if (!v_Department_ID || v_Department_ID == "--Select a Department--") {
      // show error message
      document.getElementById("error-department").innerHTML =
        "Pls choose Department!";
      return false;
    }
    document.getElementById("error-department").style.display = "none";
    //Validate Position
    if (!v_Position_ID || v_Position_ID == "--Select a Position--") {
      // show error message
      document.getElementById("error-position").innerHTML =
        "Pls choose Possition!";
      return false;
    }
    document.getElementById("error-position").style.display = "none";

    // Lấy ra ID của Department khi người dùng lựa chọn phòng ban
    for (let index = 0; index < listDepartment.length; index++) {
      if (listDepartment[index].name == v_Department_ID) {
        var depID = listDepartment[index].id;
      }
    }
    // Lấy ra ID của Possition khi người dùng lựa chọn Possition
    for (let index = 0; index < listPosition.length; index++) {
      if (listPosition[index].name == v_Position_ID) {
        var posID = listPosition[index].id;
      }
    }
    // Ở đây chỉ cho người dùng update các trường, fullname, Department, Possition, các trường Username, Email trên thực tế sẽ để cố định.
    var account = {
      fullname: v_Fullname_ID,
      departmentId: depID,
      positionId: posID,
    };
    $.ajax({
      url: "http://localhost:8080/api/v1/accounts/" + v_ID_ID,
      type: "PUT",
      data: JSON.stringify(account), // body
      contentType: "application/json", // type of body (json, xml, text)
      beforeSend: function (xhr) {
        xhr.setRequestHeader(
          "Authorization",
          "Basic " +
          btoa(
            storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")
          )
        );
      },
      // dataType: 'json', // datatype return
      success: function (data, textStatus, xhr) {
        console.log(data);
        // success
        swal("Success", "Update Successful !", "success");
        getListEmployees();
      },
      error(jqXHR, textStatus, errorThrown) {
        if (jqXHR.status == 403) {
          window.location.href = "403.html";
        }
        swal("Error!", "Error when loading data", "error");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
      },
    });
  });
}

/// Viết hàm gọi dữ liệu server API bằng Ajax khi load trang Web
function getListEmployees() {
  // call API from server
  var url = "http://localhost:8080/api/v1/accounts/";

  url += "?page=" + currentPage + "&size=" + size;

  url += "&sort=" + sortField + "," + (isAsc ? "asc" : "desc");

  var search = document.getElementById("search").value;

  if (search) {
    url += "&search=" + search;
    document.getElementById("search").value = "";
  }
  $.ajax({
    url: url,
    type: "GET",
    contentType: "application/json", // type of body (json, xml, text)
    dataType: "json", // datatype return
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " +
        btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD"))
      );
    },
    success: function (data, textStatus, xhr) {
      // reset list employees
      listAccount = [];
      // success
      parseData(data.content);
      showAccount();
      pagingTable(data.totalPages);
    },
    error(jqXHR, textStatus, errorThrown) {
      if (jqXHR.status == 403) {
        window.location.href = "403.html";
      }
      swal("Error!", "Error when loading data", "error");
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
}

// hàm chuyển dữ liệu API nhận được bằng Ajax chuyển về dạng List để sử dụng trong chương trình
function parseData(data) {
  // employees = data;
  data.forEach(function (item) {
    var account = {
      AccountID: item.id,
      Email: item.email,
      Username: item.username,
      FullName: item.fullname,
      Department: item.department,
      Position: item.position,
      CreateDate: item.createDate,
    };
    listAccount.push(account);
  });
}

function pagingTable(pageAmount) {
  var pagingStr = "";
  if (pageAmount > 1 && currentPage > 1) {
    pagingStr +=
      '<li class="page-item"><a class="page-link" onClick="prevPaging()">Previous</a></li>';
  }
  for (i = 0; i < pageAmount; i++) {
    pagingStr +=
      '<li class="page-item' +
      (currentPage == i + 1 ? " active" : "") +
      '">' +
      '<a class="page-link" onClick="changePage(' +
      (i + 1) +
      ')">' +
      (i + 1) +
      "</a>" +
      "</li>";
  }
  if (pageAmount > 1 && currentPage < pageAmount) {
    pagingStr +=
      '<li class="page-item"><a class="page-link" onClick="nextPaging()">Next</a></li>';
  }
  $(".pagination").empty();
  $(".pagination").append(pagingStr);
}

function prevPaging() {
  changePage(currentPage - 1);
}

function nextPaging() {
  changePage(currentPage + 1);
}

function changePage(page) {
  if (page == currentPage) {
    return;
  }
  currentPage = page;
  getListEmployees();
}

function resetPaging() {
  currentPage = 1;
  size = 5;
}

function Search() {
  resetPaging;
  getListEmployees();
}

function KeyUpForSearch(event) {
  if (event.keyCode === 13) {
    event.preventDefault();
    Search();
  }
}

function Sort(field) {
  if (field == sortField) {
    isAsc = !isAsc;
  } else {
    sortField = field;
    isAsc = true;
  }
  getListEmployees();
}

function resetSort() {
  sortField = "id";
  isAsc = true;
}

function showAvatar() {
  // Get ImgName
  var url = "http://localhost:8080/api/v1/files/image/";
  url += storage.getItem("ID"); // Gửi kèm id của User đăng nhập cho Backend
  $.ajax({
    url: url,
    type: "GET",
    // Kiểu dữ liệu trả về là String nên khi chuyển sang bên Frontend sẽ gọi là text.html
    contentType: "text/html", // Đổi kiểu dữ liệu text cho phù hợp với kiểu trả về là tên ảnh trong Backend
    dataType: "html", // datatype return
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " +
        btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD"))
      );
    },
    success: function (data, textStatus, xhr) {
      // Đoạn lệnh này copy từ phần gọi Ajax theo cách không xác thực commemt bên trên xuống.
      // Show Avatar, thêm thể img vào thẻ div tương ứng trong html
      $(".imgAvatar").append(`
          <img src="/Source/img/${data}"  id="photo">`);
    },
    error(jqXHR, textStatus, errorThrown) {
      swal("Error!", "Error when loading data", "error");
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
}

//Nhóm hàm Upload ảnh
$("#btn_changeAvatar").click(function () {
  // Test sự kiện onclick
  console.log("btn_changeAvatar clicked!");
  // Tạo đối tượng Form Data để lưu thông tin gửi đi
  var myform = $("#form_avatar");
  var fomrData = new FormData(myform[0]);
  // Set file input vào Form data trước khi gửi đi
  fomrData.append("image", $("#file")[0].files[0]);
  // Set id của User đăng nhập vào Form data trước khi gửi đi
  var id = storage.getItem("ID");
  fomrData.append("id", id);

  // fomrData.append('id', '4');

  $.ajax({
    url: "http://localhost:8080/api/v1/files/image",
    type: "POST",
    data: fomrData, // body
    processData: false,
    contentType: false, // Không để kiểu Content do đang gửi dữ liệu Formdata
    // dataType: 'json', // datatype return
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " +
        btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD"))
      );
    },
    success: function (data, textStatus, xhr) {
      showAvatar(); // Sau khi thay đổi avatar thành công gọi lại hàm này để show lại ảnh.
    },
    error(jqXHR, textStatus, errorThrown) {
      swal("Error!", "Error when loading data", "error");
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
});

$("#uploadBtn").click(function () {
  $("#btn_changeAvatar").show();
});

var imgDiv = document.querySelector(".profile-pic-div");
var img = document.querySelector("#photo");
var file = document.querySelector("#file");
var uploadBtn = document.querySelector("#uploadBtn");

//if user hover on img div

imgDiv.addEventListener("mouseenter", function () {
  uploadBtn.style.display = "block";
});

//if we hover out from img div

imgDiv.addEventListener("mouseleave", function () {
  uploadBtn.style.display = "none";
});

function ChangePassword() {
  $("#change_password_form").modal("show");
}

$("#ChangePassword").submit(function () {
  var oldPassword = document.getElementById("old_password").value;
  var newPassword = document.getElementById("new_password").value;
  var comfirmPassword = document.getElementById("comfirm_password").value;
  if (oldPassword != storage.getItem("PASSWORD")) {
    document.getElementById("error-old-password").innerHTML = "Wrong Password!";
    return false;
  }
  if (comfirmPassword != newPassword) {
    document.getElementById("error-comfirm-password").innerHTML =
      " Password not match ! ";
    return false;
  }
  document.getElementById("error-comfirm-password").style.display = "none";
  var url = "http://localhost:8080/api/v1/Password/changePassword";
  url += "?username=" + storage.getItem("USERNAME");
  // if (newPassword) {
  // url += "&newPassword=" + newPassword;
  // }
  var account = {
    newPassword:newPassword,
  }
  $.ajax({
    url: url + "&newPassword=" + newPassword,
    type: "PUT",
    data: JSON.stringify(account),
    contentType: "application/json", // type of body (json, xml, text)
    // dataType: "json", // datatype return
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " +
        btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD"))
      );
    },
    success: function (data, textStatus, xhr) {
      console.log(data);
      logout();
    },
    error(jqXHR, textStatus, errorThrown) {
      swal("Error!", "Error when loading data", "error");
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
});