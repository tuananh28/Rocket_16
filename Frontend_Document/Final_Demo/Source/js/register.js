var listAccount = [];
$("#signupForm").submit(function(){
  // Lấy các giá trị người dùng nhập vào
  // var v_ID_ID = $("#ID_ID").val();
  var v_Email_ID = $("#Email_ID").val();
  var v_Username_ID = $("#Username_ID").val();
  var v_Fullname_ID = $("#Fullname_ID").val();
  var v_Password_ID = $("#Password_ID").val();
  var v_RePassword_ID = $("#RePassword_ID").val();
  var V_Department_ID = "10";
  var v_Position_ID = "1";

  var registration = {
    email: v_Email_ID,
    username: v_Username_ID,
    fullname: v_Fullname_ID,
    password: v_Password_ID,
    departmentId: V_Department_ID,
    positionId: v_Position_ID,

  };

  if (v_RePassword_ID != v_Password_ID) {
    document.getElementById("error-repassword").innerHTML =
      " Password not match ! ";
    return false;
  }
  document.getElementById("error-repassword").style.display = "none";
  $.ajax({
    url: "http://localhost:8080/api/v1/registration",
    type: "POST",
    data: JSON.stringify(registration), // body
    contentType: "application/json", // type of body (json, xml, text)
    // dataType: 'json', // datatype return
    success: function (data, textStatus, xhr) {
      console.log(data);
      // success
      swal ( "Success", "We have sent an email. Please check email to active account!" , "success" );
      resetForm();
    },
    error(jqXHR, textStatus, errorThrown) {
      swal ( "Error!", "Error when loading data" , "error" );
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
  return false;
});

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
  $("#send_token_form").modal("show");
}
function Send_Token() {
  // get data
  var v_Email_ID = $("#email_token").val();
  // validate
  if (!v_Email_ID || v_Email_ID.length < 6 || v_Email_ID.length > 50) {
    // show error message
    document.getElementById("error-email-token").innerHTML =
      "Email không đúng định dạng!";
    return false;
  }
  //
  $.ajax({
    url: "http://localhost:8080/api/v1/accounts/email/" + v_Email_ID,
    type: "GET",
    contentType: "application/json",
    dataType: "json", // datatype return
    success: function (data, textStatus, xhr) {
      if (!data) {
        document.getElementById("error-email-token").innerHTML =
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
            resetForm();
            HideModal();
            Swal({
              title: 'We have sent an email. Please check email to active account!',
              showClass: {
                popup: 'animate__animated animate__fadeInDown'
              },
              hideClass: {
                popup: 'animate__animated animate__fadeOutUp'
              }
            })
          },
          error(jqXHR, textStatus, errorThrown) {
            swal ( "Error!", "Error when loading data" , "error" );
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
          },
        });
      }
      document.getElementById("error-email-token").style.display = "none";
    },
    error(jqXHR, textStatus, errorThrown) {
      swal ( "Error!", "Error when loading data" , "error" );
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
  return false;
}
function HideModal() {
  $("#send_token_form").modal("hide");
}