function validatePasswordsAndSubmit() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;

    if (username === '' || password === '' || confirmPassword === '') {
        // Show an error message if any of the fields are empty
        var errorMessage = document.getElementById("emptyFieldError");
        errorMessage.style.display = "block";
        return;
      }


    if (password !== confirmPassword) {
        // Show the error message if passwords do not match
        var errorMessage = document.getElementById("passwordMatchError");
        errorMessage.style.display = "block";
        return;
    }

    // If passwords match, submit the form
    document.getElementById("signupForm").submit();
}
