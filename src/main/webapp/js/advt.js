$(document).ready(function () {
    $("#submitButton").click(function () {
        console.log("BUTTON CLICKED")
        let title = $("#title").val();
        let format = $("#format").val();
        let time = $("#time").val();
        let url = $("#url").val();
        let nameAuthor = $("#nameAuthor").val();
        let lastnameAuthor = $("#lastnameAuthor").val();
        let message = $("#message").val();
        $.ajax({
            url: "/university_war_exploded/help",
            type: "POST",
            data: {
                title: title,
                format: format,
                time: time,
                url: url,
                nameAuthor: nameAuthor,
                lastnameAuthor: lastnameAuthor,
                message: message
            },
            success: function (response) {
                let container = $("#resultadvt");
                if (response.success) {
                    $("#message").val("");
                    $("#title").val("");
                    $("#time").val("");
                    $("#url").val("");
                    $("#format").val("");
                    container.append(`
                        <div class="container-my container-advt">
                            <div id="forum-posts">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">${title}</h5>
                                        <p class="card-text-author">Author: ${nameAuthor} ${lastnameAuthor}</p>
                                        <p class="card-text-time">Time: ${time}</p>
                                        <p class="card-text-format">Format: ${format}</p>
                                        <p class="card-text-message">${message}</p>
                                        <p class="card-text-socialNet">TG: ${url}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    `);
                }
            },
            error: function (xhr, status, error) {
                console.log("XHR STATUS:" + status);
                console.log("HTTP STATUS:" + xhr.status);
                console.log("MESSAGE:" + error);
            }
        });
    });
});