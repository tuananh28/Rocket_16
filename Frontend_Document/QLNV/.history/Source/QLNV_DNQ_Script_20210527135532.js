// Trong bài tập này sẽ xử dụng Jquery và JavaScript, JavaScript để thực hiện chức năng quản lý nhân viên, tương ứng với bảng Account trong DB TestingSystem, Các chức năng: Thêm, Sửa, Xóa. Dữ liệu này sẽ tương tác với server Backend API.
// Khai báo 1 array để lưu thông tin tất cả các Account trên hệ thống.
var listAccount = []
$(function () {
    // Gọi hàm load dữ liệu từ Server API khi load trang
    getListEmployees();

    // Hàm thực thi khi load đầy đủ các thành phần html
    $('#reset_btn').click(function () {
        // Xử lý sự kiện cho nút reset, Sử dụng JQuery để lấy các giá trị các trường theo ID, sau đó Set về rỗng
        $('#ID_ID').val("")
        $('#Email_ID').val("")
        $('#Username_ID').val("")
        $('#Fullname_ID').val("")
        $('#Department_ID').val("")
        $('#Position_ID').val("")
        $('#Cretate_Date_ID').val("")
    })

    // Xử lý sự kiện khi nhấn nút Save
    $('#Main_Form_ID').submit(function () {
        // Xử lý sự kiện khi nhấn nút Submit của Form(Save), ở đây phải sử dụng Return False ở cuối sự kiện này để không redirect sang trang mới.
        // Lấy các giá trị người dùng nhập vào
        var v_ID_ID = $('#ID_ID').val()
        var v_Email_ID = $('#Email_ID').val()
        var v_Username_ID = $('#Username_ID').val()
        var v_Fullname_ID = $('#Fullname_ID').val()
        var v_Department_ID = $('#Department_ID').val()
        var v_Position_ID = $('#Position_ID').val()
        var v_Cretate_Date_ID = $('#Cretate_Date_ID').val()

        // Tạo 1 đối tượng account để lưu giữ thông tin nhận được
        var account = {
            'Email': v_Email_ID,
            'Username': v_Username_ID,
            'FullName': v_Fullname_ID,
            'Department': v_Department_ID,
            'Position': v_Position_ID,
            'CreateDate': v_Cretate_Date_ID
        }
        // Add account tới MOCK API
        $.post("https://60aef8dc5b8c300017deb66b.mockapi.io/accounts/Accounts", account,
            function (data, status) {
                // error
                if (status == "error") {
                    alert("Error when loading data");
                    return;
                }
                // success
                // Hàm này để hiển thị thông tin account ở table      
                getListEmployees();
            });
        return false;
        // Sử dụng return false để không redirect tới 1 trang khác.
    })
})
// Đoạn bên trên khi load hoàn chỉnh trang web sẽ kết thúc ở đây, đoạn dưới sẽ viết các hàm bổ trợ khác
// Viết hàm showAccount()
function showAccount() {
    // Xóa hết kết quả đang hiển thị ở bảng kết quả
    $('#Result_TB').empty()
    // Lặp trong listAccount để in thông tin từng phần tử
    // Hiển thị thêm 2 nút để sửa và xóa các Account
    for (var index = 0; index < listAccount.length; index++) {
        $('#Result_TB').append(`
              <tr>
              <th>${listAccount[index].AccountID}</th>
              <th>${listAccount[index].Email}</th>
              <th>${listAccount[index].Username}</th>
              <th>${listAccount[index].FullName}</th>
              <th>${listAccount[index].Department}</th>
              <th>${listAccount[index].Position}</th>   
              <th>${listAccount[index].CreateDate}</th>
              <th><button class="btn btn-warning" onclick="editAccount(${index})">Edit</button></th>
              <th><button class="btn btn-warning" onclick="deleteAccount(${index})">Delete</button></th>
              </tr>
              `)
    }
}
// Viết hàm xóa account
function deleteAccount(Index) {
    var v_del_ID = listAccount[Index].AccountID;
    // Hiển thị 1 Confim Popup, chọn Có = True
    var confirm_del = confirm('Bạn có chắc chắn muốn xóa Account này không')
    if (confirm_del) {
        $.ajax({
            url: 'https://60aef8dc5b8c300017deb66b.mockapi.io/accounts/Accounts/' + v_del_ID,
            type: 'DELETE',
            success: function (result) {
                // error
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }

                // success
                getListEmployees();
            }
        });
    } else {
        return
    }
}
// Viết hàm để Edit các account
function editAccount(Index) {
    $('#ID_ID').val(listAccount[Index].AccountID)
    $('#Email_ID').val(listAccount[Index].Email)
    $('#Username_ID').val(listAccount[Index].Username)
    $('#Fullname_ID').val(listAccount[Index].FullName)
    $('#Department_ID').val(listAccount[Index].Department)
    $('#Position_ID').val(listAccount[Index].Position)
    $('#Cretate_Date_ID').val(listAccount[Index].CreateDate)

    //  Xử lý sự kiện khi click vào nút Update 
    $('#update_btn').click(function () {
        var v_ID_ID = $('#ID_ID').val()
        var v_Email_ID = $('#Email_ID').val()
        var v_Username_ID = $('#Username_ID').val()
        var v_Fullname_ID = $('#Fullname_ID').val()
        var v_Department_ID = $('#Department_ID').val()
        var v_Position_ID = $('#Position_ID').val()
        var v_Cretate_Date_ID = $('#Cretate_Date_ID').val()

        var account = {
            'AccountID': v_ID_ID,
            'Email': v_Email_ID,
            'Username': v_Username_ID,
            'FullName': v_Fullname_ID,
            'Department': v_Department_ID,
            'Position': v_Position_ID,
            'CreateDate': v_Cretate_Date_ID,
        }
        $.ajax({
            url: 'https://60aef8dc5b8c300017deb66b.mockapi.io/accounts/Accounts/' + v_ID_ID,
            type: 'PUT',
            data: account,
            success: function (result) {
                // error
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }
                getListEmployees();
            }
        });
    })
}


// Viết hàm gọi dữ liệu server API bằng Ajax khi load trang Web
function getListEmployees() {
    // call API from server
    $.get("https://60aef8dc5b8c300017deb66b.mockapi.io/accounts/Accounts", function (data, status) {
        // reset list employees
        listAccount = [];
        // error
        if (status == "error") {
            // TODO
            alert("Error when loading data");
            return;
        }
        // success
        parseData(data);
        showAccount();
    });
}
// hàm chuyển dữ liệu API nhận được bằng Ajax chuyển về dạng List để sử dụng trong chương trình
function parseData(data) {
    // employees = data;
    data.forEach(function (item) {
        var account = {
            'AccountID': item.AccountID,
            'Email': item.Email,
            'Username': item.Username,
            'FullName': item.FullName,
            'Department': item.Department,
            'Position': item.Position,
            'CreateDate': item.CreateDate,
        }
        listAccount.push(account)
    });
}

















