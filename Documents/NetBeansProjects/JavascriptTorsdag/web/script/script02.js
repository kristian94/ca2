$(document).ready(function () {
    var Person = function (name, age, isMale, occupation) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.occupation = occupation;

    };

    var table = document.createElement("table");
    $("body").append(table);

    $("form").submit(function(){
        

        var name;
        var age;
        var isMale = true;
        var occupation;
        
        if($("#name").val()) name = $("#name").val();
        else return false;
        if($("#age").val()) age = $("#age").val();
        else return false;
        if($("#male").is(":checked")) isMale = true;
        else if ($("#female").is(":checked")) isMale = false;
        else return false;
        if($("#occupation").val()) occupation = $("#occupation").val();
        else return false;
        
        var p = new Person(name, age, isMale, occupation);
        
        var json = JSON.stringify(p);
        
        console.log(json);
        $.post("Servlet2", {json : json}, function(){
            console.log("json posted");
        });
        
        return true;
    });

    $("#btn").click(function () {

        $.getJSON("Servlet2", "application/json", function (result) {
            console.log(result);
            var p = result;

            var tr = document.createElement("tr");

            var td1 = document.createElement("td");
            var td2 = document.createElement("td");
            var td3 = document.createElement("td");
            var td4 = document.createElement("td");

            $(td1).text(p.name);
            $(td2).text(p.age);
            if (p.isMale)
                $(td3).text("Male");
            else
                $(td3).text("Female");
            $(td4).text(p.occupation);

            $(tr).append(td1, td2, td3, td4);
            $(table).append(tr);
        });
    });
});