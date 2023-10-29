$(document).ready(function () {
    function f(query) {
        $.ajax({
            url: "/university_war_exploded/user/dosearch",
            type: "GET",
            dataType: "json",
            data: {"query": query},
            success: function (data) {
                let results = data.objects;
                let container = $("#result");
                container.empty();
                if (results.length >= 1) {
                    for (let i = 0; i < results.length; i++) {
                        let resultHtml =
                            `<div class="row" id="usersList">
                                <div class="col-md-4">
                                    <div class="card mb-4">
                                        <div class="card-body">
                                            <h5 class="card-title">${results[i].username}</h5>
                                            <p class="card-text-name">Name: ${results[i].name}</p>
                                            <p class="card-text-lastname">Lastname: ${results[i].lastname}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>`
                        container.append(resultHtml);
                    }
                } else {
                    container.append("Not found..")
                }
            }
        });
    }

    $("#searchButton").click(function () {
        f($("#query").val());
    })

    $("#query").on("input", function () {
        f($("#query").val());
    })

});
