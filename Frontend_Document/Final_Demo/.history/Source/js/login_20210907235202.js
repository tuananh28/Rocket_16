function login(){
  var username = document.getElementsByName("username").value;
  var password = document.getElementsByName("password").value;

  $.ajax({
    url: 'http://localhost:8080/api/v1/login',
    type: 'GET',
    contentType: "application/json",
    dataType: 'json',
    beforeSend: function (xhr) {
        xhr.setRequestHeader("Authorization", "Basic " + btoa(username + ":" + password));
    },
    success: function (data, textStatus, xhr) {
      console.log(data);
      storage.setLocal(document.getElementsByName("remember-me").checked);
      //save data to cookie
      storage.setItem("ID", data.id);
      storage.setItem("EM")

}