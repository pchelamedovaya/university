<#macro navbar autentificated>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <#if autentificated>
                    <li class="nav-item">
                        <a class="nav-link" href="/university_war_exploded/office">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/university_war_exploded/news/list">News</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/university_war_exploded/help">Help</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/university_war_exploded/user/search">For student</a>
                    </li>
                <#else>
                    <li class="nav-item">
                        <a class="nav-link" href="/university_war_exploded/about">About</a>
                    </li>
                </#if>
            </ul>
        </div>
    </nav>
</#macro>