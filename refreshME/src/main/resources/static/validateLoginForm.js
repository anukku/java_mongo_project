function validateLoginForm() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var loginError = document.getElementById("loginError");

    if (username.trim() === "" || password.trim() === "") {
      loginError.style.display = "block";
      return;
    }

    // If the form is valid, submit it
    document.getElementById("loginForm").submit();
  }