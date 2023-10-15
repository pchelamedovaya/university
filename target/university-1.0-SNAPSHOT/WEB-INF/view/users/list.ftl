<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link rel="stylesheet" href="../styles/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            padding: 0 35px;
        }
        .container {
            margin-bottom: 70px;
            margin-top: 50px !important;
        }
        .col-md-4 {
            width: 100%;
        }
        .mb-3 {
            display: flex;
            gap: 25px;
        }
        .card-title {
            margin-bottom: 20px;
        }
        p {
            margin: 0;
        }
    </style>
</head>
<body>
<@macros.navbar/>
<div class="container mt-4">
    <div class="mb-3">
        <#include '../search.ftl'>
    </div>
    <#list usersList as user>
        <div class="row" id="userCards">
            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title">${user.username}</h5>
                        <p class="card-text">Name: ${user.name}</p>
                        <p class="card-text">Lastname: ${user.lastname}</p>
<#--                        <p class="card-text">Group: ${user.group}</p>-->
<#--                        <p class="card-text">Institute: ${user.institute}</p>-->
                    </div>
                </div>
            </div>
        </div>
    </#list>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
