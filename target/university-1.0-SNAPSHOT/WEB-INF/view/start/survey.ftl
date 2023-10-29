<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Survey</title>
    <link rel="stylesheet" href="/university_war_exploded/styles/survey.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="title">Please take the survey before viewing the news on this site</h1>
    <form action="" method="POST">
        <div class="form-group">
            <span class="question">Have you had problems logging into the website?</span>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="logging-issues" id="logging-issues-yes" value="yes">
                <label class="form-check-label" for="logging-issues-yes">Yes</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="logging-issues" id="logging-issues-no" value="no">
                <label class="form-check-label" for="logging-issues-no">No</label>
            </div>
        </div>
        <div class="form-group">
            <label class="question" for="institute">Which institute are you studying at?</label>
            <select class="form-control" id="institute" name="institute">
                <option hidden disabled selected></option>
                <option value="ITIS">Institute of Information Technologies and Intelligent Systems</option>
                <option value="IFMIB">Institute of Fundamental Medicine and Biology</option>
                <option value="LAW">Faculty of Law</option>
                <option value="IEIP">Institute of Ecology and Nature Management</option>
                <option value="IGINT">Institute of Geology and Oil and Gas Technologies</option>
                <option value="IEIF">Institute of Management, Economics and Finance</option>
                <option value="IMO">Institute of International Relations</option>
            </select>
        </div>
        <div class="form-group">
            <span class="question">Which section of the site do you use the most?</span>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="news" name="recommendation[]" value="news">
                <label class="form-check-label" for="news">News</label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="notes" name="recommendation[]" value="notes">
                <label class="form-check-label" for="notes">Notes</label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="communication" name="recommendation[]" value="communication">
                <label class="form-check-label" for="communication">Communication</label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="search" name="recommendation[]" value="search">
                <label class="form-check-label" for="search">Search by student</label>
            </div>
        </div>
        <div class="form-group">
            <span class="question">Have you had problems finding information about students on the website?</span>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="about-students-issues" id="about-students-issues-yes" value="yes">
                <label class="form-check-label" for="about-students-issues-yes">Yes</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="about-students-issues" id="about-students-issues-no" value="no">
                <label class="form-check-label" for="about-students-issues-no">No</label>
            </div>
        </div>
        <div class="form-group">
            <label class="question" for="site-recommend">Would you recommend this site to your friends?</label>
            <select class="form-control" id="site-recommend" name="site-recommend">
                <option hidden disabled selected></option>
                <option value="necessarily">Necessarily</option>
                <option value="never">Never in my life</option>
                <option value="yes">I think yes</option>
                <option value="no">I think no</option>
                <option value="interesting-functions">I'll recommend it if you add interesting features</option>
            </select>
        </div>
        <div class="form-group">
            <label class="question" for="comments">Here you can leave feedback and suggestions</label>
            <textarea rows="3" class="form-control" id="comments"></textarea>
            <span><span id="commentsCount">0</span>/440</span>
        </div>

        <div class="button-my">
            <button type="button" class="btn btn-primary btn-my"
                    data-bs-toggle="modal" data-bs-target="#staticBackdrop">OK</button>
        </div>

        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
             data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Thanks for your answers and your time!</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
                    </div>
                    <div class="modal-body">
                        <p>if you are confident in the accuracy of your answers, click the "Submit" button</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" value="Vote">Submit</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <script src="/../university_war_exploded/js/survey.js"></script>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
