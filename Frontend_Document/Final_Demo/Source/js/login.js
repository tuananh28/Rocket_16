$(function () {
  hideMessageErrorValidate();
  document.getElementById("check").unchecked = storage.isLocal();
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
      } else {
        console.log();
        console.log(textStatus);
        console.log(errorThrown);
      }
    },
  });
}

function showMessageErrorValidate(message) {
  document.getElementById("error-message").style.display = "block";
  document.getElementById("error-message").innerHTML = message;
}

function hideMessageErrorValidate() {
  document.getElementById("error-message").style.display = "none";
}

$("#RegisterForm").submit(function () {
  // Lấy các giá trị người dùng nhập vào
  // var v_ID_ID = $("#ID_ID").val();
  var v_Email_ID = $("#Email_ID").val();
  var v_Username_ID = $("#Username_ID").val();
  var v_Fullname_ID = $("#Fullname_ID").val();
  var v_Password_ID = $("#Password_ID").val();

  var registration = {
    email: v_Email_ID,
    username: v_Username_ID,
    fullname: v_Fullname_ID,
    password: v_Password_ID,
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
      alert("Create Successful");
    },
    error(jqXHR, textStatus, errorThrown) {
      alert("Error when loading data");
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
  return false;
});