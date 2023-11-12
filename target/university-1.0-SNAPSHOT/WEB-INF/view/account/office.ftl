<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html>
<head>
    <title>Account</title>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="/university_war_exploded/styles/office.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<@macros.navbar autentificated/>
<div class="container">
    <div class="wrapper-account-card">
        <div class="img">
            <img src="/university_war_exploded/images/newsImage.jpg" alt="image">
        </div>
        <div class="account-card-info">
            <h3 class="name-info">${user.name}</h3>
            <h3 class="lastname-info">${user.lastname}</h3>
            <span class="bio">${user.bio!"Tell about yourself"}</span>
        </div>
        <div class="account-card-button">
            <button type="button" class="btn btn-primary button-my" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Edit</button>
        </div>
    </div>
    <div class="wrapper-account-info">
        <div class="username">
            <div class="placeholder-my">
                <h5>Username:</h5>
            </div>
            <div class="username-output-container">
                <h5 class="username-output">${user.username!"Username"}</h5>
            </div>
        </div>
        <div class="name">
            <div class="placeholder-my">
                <h5>Name:</h5>
            </div>
            <div class="name-output-container">
                <h5 class="name-output">${user.name}</h5>
            </div>
        </div>
        <div class="lastname">
            <div class="placeholder-my">
                <h5>Lastname:</h5>
            </div>
            <div class="lastname-output-container">
                <h5 class="lastname-output">${user.lastname}</h5>
            </div>
        </div>
        <div class="gender">
            <div class="placeholder-my">
                <h5>Gender:</h5>
            </div>
            <div class="gender-output-container">
                <h5 class="gender-output">${user.gender!""}</h5>
            </div>
        </div>
        <div class="institute">
            <div class="placeholder-my">
                <h5>Institute:</h5>
            </div>
            <div class="institute-output-container">
                <h5 class="institute-output">${user.institute!""}</h5>
            </div>
        </div>
        <div class="group">
            <div class="placeholder-my">
                <h5>Group:</h5>
            </div>
            <div class="group-output-container">
                <h5 class="group-output">${user.group!""}</h5>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
     data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <form action="" method="POST">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Please enter information about yourself</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="wrapper-account-info-modal">
                        <div class="username">
                            <div class="username-output-container-m">
                                <input type="text" name="username" placeholder="Username">
                            </div>
                        </div>
                        <div class="name">
                            <div class="name-output-container-m">
                                <input type="text" name="name" placeholder="Name">
                            </div>
                        </div>
                        <div class="lastname">
                            <div class="lastname-output-container-m">
                                <input type="text" name="lastname" placeholder="Lastname">
                            </div>
                        </div>
                        <div class="gender form-group">
                            <select name="gender" class="form-control" required>
                                <option value="" disabled selected>Gender</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                            </select>
                        </div>
                        <div class="institute">
                            <div class="institute-output-container-m">
                                <input type="text" name="institute" placeholder="Institute">
                            </div>
                        </div>
                        <div class="group">
                            <div class="group-output-container-m">
                                <input type="text" name="curGroup" placeholder="Group">
                            </div>
                        </div>
                        <div class="bio">
                            <div class="bio-output-container-m">
                                <input type="text" name="bio" placeholder="About me">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary button-my" value="OK">OK</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>