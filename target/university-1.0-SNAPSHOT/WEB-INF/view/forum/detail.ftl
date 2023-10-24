<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Comments</title>
    <link rel="stylesheet" href="/university_war_exploded/styles/postdetails.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<@macros.navbar autentificated/>
<div class="container-my container-help">
    <div class="container-my">
        <div class="card-body">
            <h5 class="card-title">${title}</h5>
            <p class="card-text-author">Author: ${author}</p>
            <p class="card-text-message">${text}</p>
            <p class="card-text-socialNet">${hashtags}</p>
        </div>
    </div>
    <form class="commentpost" method="POST">
        <input type="hidden" name="postId" value="${postId}">
        <div class="form-group">
            <input type="text" class="form-control" id="author" name="author" placeholder="Your name">
        </div>
        <div class="form-group">
            <textarea class="form-control" id="text" name="text" placeholder="Your message"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Publish</button>
    </form>
</div>
<#list commentList as comment>
<div class="container-my container-advt">
    <div id="forum-comment">
        <div class="card-my">
            <div class="card-body">
                <p class="card-text-author">Author: ${comment.author}</p>
                <p class="card-text-message">${comment.text}</p>
            </div>
        </div>
    </div>
</div>
</#list>
</body>
</html>