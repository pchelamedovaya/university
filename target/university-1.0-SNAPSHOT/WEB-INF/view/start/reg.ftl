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
    <@macros.navbar autentificated/>
    <div class="container">
        <div class="container-wrapper">
            <h2 class="text-center">Please sign up</h2>
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
    <script src="/../university_war_exploded/js/reg.js"></script>
</body>
</html>
