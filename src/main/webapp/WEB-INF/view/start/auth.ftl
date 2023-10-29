<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Authentication</title>
    <link type="text/css" rel="stylesheet" href="/university_war_exploded/styles/start.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <@macros.navbar autentificated/>
    <div class="container">
        <div class="container-wrapper">
            <h2 class="text-center">Please sign in</h2>
            <form method="POST" novalidate>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" required oninput="count(this, 32)">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required oninput="count(this, 12)">
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="rememberme" name="rememberme">
                    <label class="form-check-label" for="rememberme">Remember me</label>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Sign in</button>
            </form>
        </div>
    </div>
    <script src="/../university_war_exploded/js/auth.js"></script>
</body>
</html>
