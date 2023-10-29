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
        messageName.textContent = "Please pay attention to the case of letters.";
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
        messageLastname.textContent = "Please pay attention to the case of letters.";
    }
})