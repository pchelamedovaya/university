<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NewsDetail</title>
    <link rel="stylesheet" href="/university_war_exploded/styles/newsdetail.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<@macros.navbar autentificated/>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <img src="${url}" alt="image" class="img-fluid">
            </div>
            <div class="col-md-4">
                <h2 class="title">${title}</h2>
                <h5>Category: ${category}</h5>
                <p>${shortdescription}</p>
                <p>${date}</p>
            </div>
        </div>
        <div class="row row-second">
            <div class="col-md-12">
                <h5 style="line-height: 33px">${content}</h5>
            </div>
        </div>
    </div>
</body>
</html>
