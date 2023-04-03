$(function () {
    hideMessageErrorValidate();
    document.getElementById("rememberMe").checked = storage.isLocal();
});


function login() {
    // get username & password
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    // call api
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
            storage.setLocal(document.getElementById("rememberMe").checked);
            // save data to cookie
            storage.setItem("ID", data.id);
            storage.setItem("EMAIL", data.email);
            storage.setItem("FIRSTNAME", data.firstName);
            storage.setItem("LASTNAME", data.lastName);
            storage.setItem("FULLNAME", data.fullName);
            storage.setItem("ROLE", data.role);
            storage.setItem("USERNAME", username);
            storage.setItem("PASSWORD", password);
            hideMessageErrorValidate();
            // redirect to Home
            window.location.href = "http://localhost:5501/html/program.html";
        },
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 401) {
                showMessageErrorValidate("Wrong Account or Password!");
            } else {
                console.log();
                console.log(textStatus);
                console.log(errorThrown);
            }
        }
    });

}

function showMessageErrorValidate(message) {
    document.getElementById("error-message").style.display = "block";
    document.getElementById("error-message").innerHTML = message;
}

function hideMessageErrorValidate() {
    document.getElementById("error-message").style.display = "none";
}

