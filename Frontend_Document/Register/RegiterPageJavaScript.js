// Reset Form Register
function resetForm() {
    document.getElementById('Full_Name_ID').value = ''
    document.getElementById('Email_ID').value = ''
    document.getElementById('Password_ID').value = ''
    document.getElementById('Re_Password_ID').value = ''
    document.getElementById('Birthday_ID').value = ''
}

function createNewUser() {
    var v_Full_Name = document.getElementById('Full_Name_ID').value
    var v_Email = document.getElementById('Email_ID').value
    var v_Password = document.getElementById('Password_ID').value
    var v_Re_Password = document.getElementById('Re_Password_ID').value
    var v_Birthday = document.getElementById('Birthday_ID').value

    if (v_Password != v_Re_Password) {
        alert("Mat khau khong trung khop")
    }

    var user = {
        Full_Name: v_Full_Name,
        Email: v_Email,
        Password: v_Password,
        Birthday: v_Birthday,
    }

    window.open('login.html', '_self')

    var json = JSON.stringify(user)  // Chuyển đối tượng sang dạng Json String, Convert a JavaScript object into a string with JSON.stringify(). https://www.w3schools.com/js/js_json_stringify.asp
    localStorage.setItem('user', json) // The Storage object of the Web Storage API provides access to the session storage or local storage for a particular domain. This allows you to read, add, modify, and delete stored data items.

}

function loginSuccess() {
    var v_Email_Login_id = document.getElementById('Email_Login_id').value
    var v_Password_Login_id = document.getElementById('Password_Login_id').value
    var user = JSON.parse(localStorage.getItem('user')) // Get the value of the specified local storage item:

    if ((user.Email == v_Email_Login_id) && (user.Password == v_Password_Login_id)) {
        alert('Đăng nhập thành công')
        window.open('Home.html', '_self')
    }
    else {
        alert('Kiểm tra lại thông tin!!!')
    }
}

function returnPageRegister() {
    window.open('RegisterPage.html', '_self')
}
