<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>News</title>
    <link rel="stylesheet" href="/university_war_exploded/styles/newslist.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<@macros.navbar autentificated/>
<div class="container-newsList">
    <#list newsList as news>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <img src="${news.url}" alt="image" class="img-fluid">
                </div>
                <div class="col-md-8">
                    <p class="news-date">${news.date?string("dd-MM-YYYY")}</p>
                    <h2 class="news-title">
                        <a class="news-title-link" href="/university_war_exploded/news/detail?id=${news.id}">${news.title}</a>
                    </h2>
                    <h5 class="news-category">Category: ${news.category}</h5>
                    <div class="block" style="height: 18px"></div>
                    <div class="news-content">${news.shortdescription}</div>
                </div>
            </div>
        </div>
    </#list>
</div>
</body>
</html>