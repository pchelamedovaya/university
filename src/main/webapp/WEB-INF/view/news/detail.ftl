<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NewsDetail</title>
    <link rel="stylesheet" href="/university_war_exploded/styles/newsdetails.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<@macros.navbar autentificated/>
<div class="container-my">
    <div class="wrapper">
        <div class="image">
            <img src="${url}" alt="image" class="img-fluid">
        </div>
        <div class="card-content">
            <h2 class="title">${title}</h2>
            <h5 class="category">Category: ${category}</h5>
            <p class="description">${shortdescription}</p>
            <p>${date?string("dd-MM-YYYY")}</p>
        </div>
    </div>
    <div class="row row-second">
        <div class="col-md-12">
            <h5 class="content">${content}</h5>
        </div>
    </div>
</div>
</body>
</html>
