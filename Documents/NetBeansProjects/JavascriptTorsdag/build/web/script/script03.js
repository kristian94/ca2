$(document).ready(function () {



    var update = function () {
        $.get("Servlet3", function(result){
            $("#clock").text(result);
            setTimeout(update(), 1000);
        });
        
        
    };
    
    update();
});




