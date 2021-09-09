function login() {
  var username = document.getElementsByName("username").value;
  var password = document.getElementsByName("password").value;

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
      storage.setLocal(document.getElementsByName("remember-me").checked);
      //save data to cookie
      storage.setItem("ID", data.id);
      storage.setItem("EMAIL", data.email);
      storage.setItem("USERNAME", username);
      storage.setItem("FULLNAME", data.fullname);
      storage.setItem("ROLE", data.role);

      //redirect to Home page
      window.location.href = "http://127.0.0.1:5501/Source/html/index.html";
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
$(function () {
  var isRememberMe = storage.getRememberMe();
  document.getElementById("remember-me").checked = storage.isLocal();
});
