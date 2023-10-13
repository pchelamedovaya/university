<#import "../macros.ftl" as macros/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>News</title>
    <link rel="stylesheet" href="../styles/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            padding: 0 35px;
        }
        .container {
            margin-bottom: 70px;
            margin-top: 50px;
        }
        .row-second {
            margin-top: 20px;
        }
        .img-fluid {
            width: 95%;
        }
        .title {
            margin-bottom: 45px;
        }
    </style>
</head>
<body>
<@macros.navbar/>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <img src="${url}" alt="image" class="img-fluid">
            </div>
            <div class="col-md-4">
                <h2 class="title">${title}</h2>
                <p>Category: ${category}</p>
                <p>${shortdescription}</p>
                <p>${date}</p>
            </div>
        </div>
        <div class="row row-second">
            <div class="col-md-12">
                <p>${content}</p>
            </div>
        </div>
    </div>
</body>
</html>
