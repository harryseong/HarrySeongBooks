$(document).ready(function(){
    $("button").click(function(){
        $.post("demo_test_post.asp",
            {
                isbn13: "Donald Duck",
                readStatus: "Duckburg"
            },
            function(data,status){
                alert("Data: " + data + "\nStatus: " + status);
            });
    });
});