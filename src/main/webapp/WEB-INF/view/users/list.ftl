<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link rel="stylesheet" href="/university_war_exploded/styles/userslist.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<@macros.navbar autentificated/>
<div class="container mt-4">
    <div class="mb-3">
        <#include '../search.ftl'>
    </div>
    <#list usersList as user>
        <div class="row" id="usersList">
            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-body">
                        <p class="card-title">${user.username}</p>
                        <p class="card-text">Name: ${user.name}</p>
                        <p class="card-text">Lastname: ${user.lastname}</p>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</div>
</body>
</html>
