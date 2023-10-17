<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link type="text/css" rel="stylesheet" href="/university_war_exploded/styles/start.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<#--    <@macros.navbar/>-->
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <h2 class="text-center">Registration</h2>
                <form method="POST" novalidate>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" id="username" name="username" required oninput="count(this, 32)">
                        <small class="form-text text-danger" id="messageUsername"></small>
                    </div>
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name" required oninput="count(this, 20)">
                        <small class="form-text text-danger" id="messageName"></small>
                    </div>
                    <div class="form-group">
                        <label for="lastname">Lastname</label>
                        <input type="text" class="form-control" id="lastname" name="lastname" required oninput="count(this, 20)">
                        <small class="form-text text-danger" id="messageLastname"></small>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" required oninput="count(this, 12)">
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Register</button>
                </form>
            </div>
        </div>
    </div>
    <script>
        count = function(input, max) {
            if (input.value.length > max) {
                input.value = input.value.substring(0, max);
            }
        }
        const passwordInput = document.getElementById("password");
        passwordInput.addEventListener("input", function () {
            if (count.length > 0) {
                passwordInput.classList.remove("is-invalid");
                passwordInput.classList.add("is-valid");
            } else {
                passwordInput.classList.remove("is-valid");
                passwordInput.classList.add("is-invalid");
            }
        })

        const usernameInput = document.getElementById("username");
        const usernameREG = /^[a-zA-Z0-9_]+$/;
        const messageUsername = document.getElementById("messageUsername");
        const nameInput = document.getElementById("name");
        const nameREG = /^[A-Z][a-z]*(?:-[A-Z][a-z]*)*$/;
        const messageName = document.getElementById("messageName");
        const lastnameInput = document.getElementById("lastname");
        const lastnameREG = /^[A-Z][a-z]*(?:-[A-Z][a-z]*)*$/;
        const messageLastname = document.getElementById("messageLastname");

        usernameInput.addEventListener("input", function () {
            if (usernameREG.test(usernameInput.value)) {
                usernameInput.classList.remove("is-invalid");
                usernameInput.classList.add("is-valid");
                messageUsername.textContent = "";
            } else {
                usernameInput.classList.remove("is-valid");
                usernameInput.classList.add("is-invalid");
                messageUsername.textContent = "Error. You are using invalid characters.";
            }
        })
        nameInput.addEventListener("input", function () {
            if (nameREG.test(nameInput.value)) {
                nameInput.classList.remove("is-invalid");
                nameInput.classList.add("is-valid");
                messageName.textContent = "";
            } else {
                nameInput.classList.remove("is-valid");
                nameInput.classList.add("is-invalid");
                messageName.textContent = "The field is filled in incorrectly, please pay attention to the case of letters.";
            }
        })
        lastnameInput.addEventListener("input", function () {
            if (lastnameREG.test(lastnameInput.value)) {
                lastnameInput.classList.remove("is-invalid");
                lastnameInput.classList.add("is-valid");
                messageLastname.textContent = "";
            } else {
                lastnameInput.classList.remove("is-valid");
                lastnameInput.classList.add("is-invalid");
                messageLastname.textContent = "The field is filled in incorrectly, please pay attention to the case of letters.";
            }
        })
    </script>
</body>
</html>
