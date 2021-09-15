$(function () {
  hideMessageErrorValidate();
  document.getElementById("check").unchecked = storage.isLocal();
});
$("#password").on("keypress", function (e) {
  if (e.which == 13) {
    login();
  }
});
function login() {
  // get username & password
  var username = document.getElementById("username").value;
  var password = document.getElementById("password").value;

  // call api
  $.ajax({
    url: "http://localhost:8080/api/v1/login",
    type: "GET",
    contentType: "application/json",
    dataType: "json",
    beforeSend: function (xhr) {
      xhr.setRequestHeader(
        "Authorization",
        "Basic " + btoa(username + ":" + password)
      );
    },
    success: function (data, textStatus, xhr) {
      console.log(data);
      storage.setLocal(document.getElementById("check").checked);
      // save data to cookie
      storage.setItem("ID", data.id);
      storage.setItem("EMAIL", data.email);
      storage.setItem("FULLNAME", data.fullname);
      storage.setItem("ROLE", data.role);
      storage.setItem("USERNAME", username);
      storage.setItem("PASSWORD", password);
      hideMessageErrorValidate();
      // redirect to Home
      window.location.replace("index.html");
    },
    error(jqXHR, textStatus, errorThrown) {
      if (jqXHR.status == 401) {
        showMessageErrorValidate("Wrong Account or Password!");
      }
      resetForm();
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
}
function showMessageErrorValidate(message) {
  document.getElementById("error-message").style.display = "block";
  document.getElementById("error-message").innerHTML = message;
}

function hideMessageErrorValidate() {
  document.getElementById("error-message").style.display = "none";
  document.getElementById("error-repassword").style.display = "none";
  document.getElementById("error-email").style.display = "none";
}

function SignUp() {
  // Lấy các giá trị người dùng nhập vào
  // var v_ID_ID = $("#ID_ID").val();
  var v_Email_ID = $("#Email_ID").val();
  var v_Username_ID = $("#Username_ID").val();
  var v_Fullname_ID = $("#Fullname_ID").val();
  var v_Password_ID = $("#Password_ID").val();
  var v_RePassword_ID = $("#RePassword_ID").val();

  var registration = {
    email: v_Email_ID,
    username: v_Username_ID,
    fullname: v_Fullname_ID,
    password: v_Password_ID,
  };
  if (v_RePassword_ID != v_Password_ID) {
    document.getElementById("error-repassword").innerHTML= "Password not match !";
    return;
  }
  $.ajax({
    url: "http://localhost:8080/api/v1/registration",
    type: "POST",
    data: JSON.stringify(registration), // body
    contentType: "application/json", // type of body (json, xml, text)
    // dataType: 'json', // datatype return
    success: function (data, textStatus, xhr) {
      console.log(data);
      // success
      ShowSuccessAlert();
      hideMessageErrorValidate();
      resetForm();
    },
    error(jqXHR, textStatus, errorThrown) {
      alert("Error when loading data");
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
  return false;
}

function resetForm() {
  $("#Email_ID").val("");
  $("#Username_ID").val("");
  $("#Fullname_ID").val("");
  $("#Password_ID").val("");
  $("#RePassword_ID").val("");
  $("#email_token").val("");
  $("#username").val("");
  $("#password").val("");
}
function ResendToken() {
  $("#email_token").val("");
  $("#resend_form").modal("show");
}
function Resend() {
  // get data
  var v_Email_ID = $("#email_token").val();
  // validate
  if (!v_Email_ID || v_Email_ID.length < 6 || v_Email_ID.length > 50) {
    // show error message
    document.getElementById("error-email").innerHTML =
      "Email không đúng định dạng!";
    return false;
  }

  $.ajax({
    url: "http://localhost:8080/api/v1/accounts/email/" + v_Email_ID,
    type: "GET",
    contentType: "application/json",
    dataType: "json", // datatype return
    success: function (data, textStatus, xhr) {
      if (!data) {
        document.getElementById("error-email").innerHTML =
          "Email không tồn tại !!";
        return false;
      } else {
        $.ajax({
          url:
            "http://localhost:8080/api/v1/registration/userRegistrationConfirmRequest?email=" +
            v_Email_ID,
          type: "GET",
          // data: JSON.stringify(account), // body
          // contentType: "application/json",
          // dataType: "json", // type of body (json, xml, text)
          // datatype return
          success: function (data, textStatus, xhr) {
            console.log(data);
            hideMessageErrorValidate();
            resetForm();
            HideModal();
            ShowSuccessAlert();
          },
          error(jqXHR, textStatus, errorThrown) {
            alert("Error when loading data");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
          },
        });
      }
    },
    error(jqXHR, textStatus, errorThrown) {
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
  return false;
}
function ShowSuccessAlert() {
  $("#myModal").modal("show");
}

function HideModal() {
  $("#resend_form").modal("hide");
}
