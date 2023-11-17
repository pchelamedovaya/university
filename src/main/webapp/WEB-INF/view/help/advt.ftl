<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Help</title>
    <link rel="stylesheet" href="/university_war_exploded/styles/advts.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
</head>
<body>
<@macros.navbar autentificated/>
<div class="container-my container-help">
    <form action="" id="formhelp" class="formhelp" method="POST">
        <div class="form-group">
            <input type="text" class="form-control" id="title" name="title" placeholder="Title">
        </div>
        <div class="form-group user-name">
            <input value="${user.name}" type="text" class="form-control" id="nameAuthor" name="nameAuthor" placeholder="Your name">
        </div>
        <div class="form-group user-lastname">
            <input value="${user.lastname}" type="text" class="form-control" id="lastnameAuthor" name="lastnameAuthor" placeholder="Your lastname">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="time" name="time" placeholder="Suitable days of the week, time for you">
        </div>
        <div class="form-group">
            <select class="form-control" id="format" name="format" required>
                <option value="" disabled selected>Suggested format</option>
                <option value="Distantly">Distantly</option>
                <option value="Face-to-face">Face-to-face</option>
                <option value="Any format">Any format</option>
            </select>
        </div>
        <div class="form-group">
            <textarea class="form-control" id="message" name="message" placeholder="Your message"></textarea>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="url" name="url" placeholder="Your social network">
        </div>
        <button id="submitButton" type="submit" class="btn btn-primary">Publish</button>
    </form>
</div>

<div id="resultadvt">
<#list advtList as advt>
<div class="container-my container-advt">
    <div id="forum-posts">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${advt.title}</h5>
                <p class="card-text-author">Author: ${advt.nameAuthor} ${advt.lastnameAuthor}</p>
                <p class="card-text-time">Time: ${advt.time}</p>
                <p class="card-text-format">Format: ${advt.format}</p>
                <p class="card-text-message">${advt.message}</p>
                <p class="card-text-socialNet">TG: ${advt.url}</p>
            </div>
        </div>
    </div>
</div>
</#list>
</div>
<script src="/../university_war_exploded/js/advt.js"></script>
</body>
</html>
