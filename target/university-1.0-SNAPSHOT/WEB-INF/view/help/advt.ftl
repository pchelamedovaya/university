<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Help</title>
    <link rel="stylesheet" href="/university_war_exploded/styles/advt.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <@macros.navbar/>
    <div class="title-text">
        <h1>Help for students</h1>
    </div>
    <div class="container container-one">
        <form class="formhelp" method="POST">
            <div class="form-group">
                <input type="text" class="form-control" id="title" name="title" placeholder="Title">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="nameAuthor" name="nameAuthor" placeholder="Your name">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="lastnameAuthor" name="lastnameAuthor" placeholder="Your lastname">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="time" name="time" placeholder="Suitable days of the week, time for you">
            </div>
<#--            <div class="form-group">-->
<#--                <input type="text" class="form-control" id="format" name="format" placeholder="Suggested format">-->
<#--            </div>-->
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
            <button type="submit" class="btn btn-primary">Publish</button>
        </form>
    </div>
    <#list advtList as advt>
        <div class="container">
            <div id="forum-posts">
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">${advt.title}</h5>
                        <p class="card-text">Author: ${advt.nameAuthor} ${advt.lastnameAuthor}</p>
                        <p class="card-text">Time: ${advt.time}</p>
                        <p class="card-text">Format: ${advt.format}</p>
                        <p class="card-text">${advt.message}</p>
                        <p class="card-text">TG: ${advt.url}</p>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</body>
</html>
