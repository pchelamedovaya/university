<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link rel="stylesheet" href="/university_war_exploded/styles/userlist.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
</head>
<body>
<@macros.navbar autentificated/>
<div class="container-my">
    <div class="container-wrapper">
        <div class="container-search">
            <#include '../search.ftl'>
            <div class="form-control filter">
                <select id="searchField">
                    <option value="username" selected>Username</option>
                    <option value="name">Name</option>
                    <option value="lastname">Lastname</option>
                </select>
                <svg width="20" height="20" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <g id="Icon/chevron-down">
                        <path id="Vector" d="M4.70435 6.75L9.20435 11.25L13.7043 6.75" stroke="#282828"
                              stroke-width="1.125" stroke-linecap="round" stroke-linejoin="round"/>
                    </g>
                </svg>
            </div>
        </div>
        <div id="result">
            <#list usersList as user>
                <div class="row" id="usersList">
                    <div class="col-md-4">
                        <div class="card mb-4">
                            <div class="card-body">
                                <h5 class="card-title">${user.username}</h5>
                                <p class="card-text-name">Name: ${user.name}</p>
                                <p class="card-text-lastname">Lastname: ${user.lastname}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</div>
<script src="/../university_war_exploded/js/search.js"></script>
</body>
</html>
