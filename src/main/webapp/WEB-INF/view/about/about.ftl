<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>About</title>
    <link rel="stylesheet" href="/university_war_exploded/styles/about.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-my">
    <h1 class="about">About University</h1>
    <div class="wrapper">
        <section class="marg-b">
            <h2>History of our University</h2>
            <h5>Our University is an innovative educational institution where students acquire the knowledge and skills necessary for a successful career. Our university strives to inspire and develop the leaders of tomorrow by providing high-quality education and access to advanced technologies.</h5>
            <h5>The University was founded in 1950 and has been a center of education and innovation ever since. Over the decades of the university's existence, we have raised generations of leaders who have made a significant contribution to various spheres of society. Our university has always strived to find new knowledge and to develop modern approaches to education.</h5>
        </section>
        <section>
            <h2>The main missions of the University</h2>
            <h5>The mission of the university is to provide students with the opportunity to develop their potential and achieve outstanding results in their lives and careers. We strive to:</h5>
            <div class="variant">
                <h5>1. To provide high-quality education based on advanced knowledge and innovation.</h5>
                <h5>2. Support research and development by promoting scientific discoveries and innovations.</h5>
                <h5>3. Promote the values of global cooperation, cultural diversity and social responsibility.</h5>
            </div>
        </section>
    </div>
    <div class="wrapper-my">
        <section>
            <div class="marg-b">
                <h2>Members of the administration</h2>
            </div>
            <ul>
                <#list adminMemberList as member>
                    <div class="card my-card">
                        <div class="container-card">
                            <div class="my-img">
                                <img src="${member.url}" alt="image">
                            </div>
                            <div class="info">
                                <h3>${member.name}</h3>
                                <h3>${member.lastname}</h3>
                                <p>${member.jobTitle}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <h5>${member.bio}</h5>
                            </div>
                        </div>
                    </div>
                </#list>
            </ul>
        </section>
        <section>
            <div class="marg-b">
                <h2>Faculties and specialties of our University</h2>
            </div>
            <ul class="ul-faculty">
                <#list facultyList as faculty>
                    <li>
                        <div class="facultyName marg-b">
                            <h3>${faculty.nameFaculty} — ${faculty.abbreviation}</h3>
                            <h5>(Code: ${faculty.code})</h5>
                        </div>
                        <ul class="speciality">
                            <#list faculty.specialityList as specialization>
                                <div class="card my-card">
                                    <li>
                                        <h3 class="name-spec">${specialization.specialityName} Code: ${specialization.specialityCode}</h3>
                                        <ul>
                                            <li class="code">Curriculum code: ${specialization.curriculumCode}</li>
                                            <li><h5>Description: ${specialization.description}</h5></li>
                                            <li class="marg-b">Curriculum link: <a class="link_cur" href="${specialization.curriculumLink}">Click to view the curriculum</a></li>
                                            <li>Address: ${faculty.address}</li>
                                            <li>Phone number: ${faculty.phoneNumber}</li>
                                            <li>Email: ${faculty.email}</li>
                                        </ul>
                                    </li>
                                </div>
                            </#list>
                        </ul>
                    </li>
                </#list>
            </ul>
        </section>
    </div>
    <section class="contact">
        <h5>Contact information:</h5>
        <div class="contact-inf">
            <p>Address: Eidswalls, 35</p>
            <p>Email: university@mail.ru</p>
            <p>Phone number: +79797970000</p>
        </div>
    </section>
</div>
</body>
</html>
