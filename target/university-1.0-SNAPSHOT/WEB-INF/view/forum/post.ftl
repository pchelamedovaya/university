<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Forum</title>
    <link rel="stylesheet" href="/university_war_exploded/styles/post.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<@macros.navbar autentificated/>
<div class="container-my container-help">
    <form class="formpost" method="POST">
        <div class="form-group">
            <input type="text" class="form-control" id="author" name="author" placeholder="Your name">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="title" name="title" placeholder="Title">
        </div>
        <div class="form-group">
            <textarea class="form-control" id="text" name="text" placeholder="Your message"></textarea>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="hashtags" name="hashtags" placeholder="Your hashtags">
        </div>
        <button type="submit" class="btn btn-primary">Publish</button>
    </form>
</div>
<#list postList as post>
    <div class="container-my container-advt">
        <div id="forum-posts">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">
                        <a class="card-title-link" href="/university_war_exploded/forum/detail?id=${post.id}">${post.title}</a>
                    </h5>
                    <p class="card-text-author">Author: ${post.author}</p>
                    <p class="card-text-message">${post.text}</p>
                    <p class="card-text-socialNet">${post.hashtags}</p>
                </div>
            </div>
        </div>
    </div>
</#list>
</body>
</html>