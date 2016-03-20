$(document).ready(function () {



    var resetList = function () {
        $("#table tbody").empty();
        $("#table thead").empty();
        $("#tableHeader").text("");
        $("#update").empty();
        $("#new").empty();
        $("#tableHeaderSmall").text("");
        hobbyIndex = 1;
    };

    var editPerson = function (personId) {
        resetList();

        var person;

        $.getJSON("http://localhost:8080/CA2/api/person/id/" + personId, {"content-type": "application/json"}, function (data) {
            person = (data);
            console.log(person);
        });



        $("#tableHeader").text("Edit Person");
        $("#tableHeaderSmall").text("ID: " + personId);



        var d1 = document.createElement("div");
        var d2 = document.createElement("div");
        var d3 = document.createElement("div");
        var d4 = document.createElement("div");
        var d5 = document.createElement("div");
        var d6 = document.createElement("div");
        var d7 = document.createElement("div");

        $(d1).attr("class", "form-group");
        $(d2).attr("class", "form-group");
        $(d3).attr("class", "form-group");
        $(d4).attr("class", "form-group");
        $(d5).attr("class", "form-group");
        $(d6).attr("class", "form-group");
        $(d7).attr("class", "form-group");


        var in1 = document.createElement("input");
        var in2 = document.createElement("input");
        var in3 = document.createElement("input");
        var in4 = document.createElement("input");
        var in5 = document.createElement("input");
        var in6 = document.createElement("input");
        var in7 = document.createElement("input");

        $(in1).attr("type", "text");
        $(in2).attr("type", "text");
        $(in3).attr("type", "text");
        $(in4).attr("type", "text");
        $(in5).attr("type", "text");
        $(in6).attr("type", "text");
        $(in7).attr("type", "text");

        $(in1).attr("class", "form-control");
        $(in2).attr("class", "form-control");
        $(in3).attr("class", "form-control");
        $(in4).attr("class", "form-control");
        $(in5).attr("class", "form-control");
        $(in6).attr("class", "form-control");
        $(in7).attr("class", "form-control");

        $(in1).attr("placeholder", "First Name");
        $(in2).attr("placeholder", "Last Name");
        $(in3).attr("placeholder", "Email (ex: mail@mail.com)");
        $(in4).attr("placeholder", "Street (ex: Esrumgade 12)");
        $(in5).attr("placeholder", "City (ex: København NV)");
        $(in6).attr("placeholder", "Zip Code (ex: 2400)");
        $(in7).attr("placeholder", "idk bout this one");

        $(in1).attr("aria-describedby", "sp1");
        $(in2).attr("aria-describedby", "sp1");
        $(in3).attr("aria-describedby", "sp1");
        $(in4).attr("aria-describedby", "sp1");
        $(in5).attr("aria-describedby", "sp1");
        $(in6).attr("aria-describedby", "sp1");
        $(in7).attr("aria-describedby", "sp1");

        $(d1).append(in1);
        $(d2).append(in2);
        $(d3).append(in3);
        $(d4).append(in4);
        $(d5).append(in5);
        $(d6).append(in6);
        $(d7).append(in7);

        $("#update").append(d1, d2, d3, d4, d5, d6, d7);
    };



    var editCompany = function () {




    };

    var newPerson = function () {
        resetList();

        $("#tableHeader").text("New Person");
        $("#tableHeaderSmall").text("");

        var divs = [];
        var inputs = [];
        var spans = [];
        var placeholders = ["First Name", "Last Name", "Email", "Street (w/ #)", "City", "Zip Code",
            "Hobby #1 Name", "Hobby #1 Description", "Hobby #2 Name", "Hobby #2 Description",
            "Hobby #3 Name", "Hobby #3 Description", "Phone Number #1", "Phone Number #2", "Phone Number #3"];

        for (var i = 0, max = placeholders.length; i < max; i++) {
            (function (i) {
                var div = document.createElement("div");
                var input = document.createElement("input");
                var span = document.createElement("span");
                var spanId = "span" + i;
                $(div).attr("class", "input-group");
                $(input).attr("type", "text");
                $(input).attr("class", "form-control");
                $(input).attr("aria-describedby", spanId);
                $(input).attr("placeholder", placeholders[i]);
                $(span).attr("class", "input-group-addon");
                $(span).attr("id", spanId);


                $(div).append(input);
                $(div).append(span);

                divs[i] = div;
                inputs[i] = input;
                spans[i] = span;

                $("#new").append(div, input);
            })(i);
        }

        var submit = document.createElement("button");
        var reset = document.createElement("button");

        $(submit).attr("type", "submit");
        $(submit).attr("class", "btn btn-success");
        $(submit).text("Submit Person");

        $(reset).attr("class", "btn btn-danger");
        $(reset).text("Reset Form");

        $("#new").append(document.createElement("br"));
        $("#new").append(submit, reset);

        $("#newForm").submit(function () {
            var person = {};

            var hobbies = [];
            var phones = [];


            var h1 = {};
            h1.name = $("input:nth-of-type(7)").val();
            h1.description = $("input:nth-of-type(8)").val();
            var h2 = {};
            h2.name = $("input:nth-of-type(9)").val();
            h2.description = $("input:nth-of-type(10)").val();
            var h3 = {};
            h3.name = $("input:nth-of-type(11)").val();
            h3.description = $("input:nth-of-type(12)").val();

            if(h1.name !== "") hobbies.push(h1);
            if(h2.name !== "") hobbies.push(h2);
            if(h3.name !== "") hobbies.push(h3);

            var p1 = {};
            p1.number = $("input:nth-of-type(13)").val();
            var p2 = {};
            p1.number = $("input:nth-of-type(14)").val();
            var p3 = {};
            p1.number = $("input:nth-of-type(15)").val();

            if(p1.number !== "") phones.push(p1);
            if(p2.number !== "") phones.push(p2);
            if(p3.number !== "") phones.push(p3);


            person.firstName = $("input:first-of-type").val();
            person.lastName = $("input:nth-of-type(2)").val();
            person.email = $("input:nth-of-type(3)").val();
            person.street = $("input:nth-of-type(4)").val();
            person.city = $("input:nth-of-type(5)").val();
            person.zipCode = $("input:nth-of-type(6)").val();
            person.hobbies = hobbies;
            person.phones = phones;

            console.log(JSON.stringify(person));

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/CA2/api/person",
                contentType: "application/json",
                data: JSON.stringify(person),
                
                succes: function(){
                    console.log("yay");
                },
                complete: function(){
                    resetList();
                }
                
            });

            return false;
        });
    };

    var popPeople = function () {

        resetList();

        $("#tableHeader").text("Persons");
        $("#tableHeaderSmall").text("Click A Row for more Details");

        // HEADERS
        var thr = document.createElement("tr");
        var th1 = document.createElement("th");
        var th2 = document.createElement("th");
        var th3 = document.createElement("th");
        var th4 = document.createElement("th");
        var th5 = document.createElement("th");



        $(th1).text("First Name");
        $(th2).text("Last Name");
        $(th3).text("Email");
        $(th4).text("Street");
        $(th5).text("City");




        $("#thead").append(thr);
        $(thr).append(th1, th2, th3, th4, th5);


        // DATA ROWS
        $.getJSON("http://localhost:8080/CA2/api/person", function (list) {

            var index = 1;

            $(list).each(function () {


                var tr = document.createElement("tr");
                var td1 = document.createElement("td");
                var td2 = document.createElement("td");
                var td3 = document.createElement("td");
                var td4 = document.createElement("td");
                var td5 = document.createElement("td");


                // BUTTONS

                var tdEdit = document.createElement("td");
                var tdDel = document.createElement("td");

                var edit = document.createElement("button");
                var del = document.createElement("button");

                $(edit).attr("id", this.id);
                $(del).attr("id", this.id);

                $(edit).click(function () {
                    editPerson(this.id);
                });

                $(edit).text("Edit");
                $(del).text("Delete");

                $(tdEdit).append(edit);
                $(tdDel).append(del);

                // BUTTONS END

                $(td1).text(this.firstName);
                $(td2).text(this.lastName);
                $(td3).text(this.email);
                $(td4).text(this.street);
                $(td5).text(this.city);


                //COLLAPSE
                var dt = "target" + index;
                $(tr).attr("data-toggle", "collapse");
                $(tr).attr("data-target", "#" + dt);
                $(tr).attr("class", "accordion-toggle");




                $("#tbody").append(tr);
                $(tr).append(td1, td2, td3, td4, td5, tdEdit, tdDel);

                //HIDDEN ROW
                var trHidden = document.createElement("tr");
                var tdHidden = document.createElement("td");
                var divHidden = document.createElement("div");
                var tableHidden = document.createElement("table");


                $(tdHidden).attr("colspan", "8");
                $(tdHidden).attr("class", "hiddenRow");
                $(divHidden).attr("class", "accordion-body collapse");
                $(divHidden).attr("id", dt);
                $(tableHidden).attr("class", "table");

                var phoneIndex = 1;
                $(this.phones).each(function () {
                    var phoneRow = document.createElement("tr");
                    var phoneName = document.createElement("td");
                    var phoneNumber = document.createElement("td");
                    var phoneDescription = document.createElement("td");

                    $(phoneDescription).attr("class", "text-muted");
                    $(phoneName).text("Phone #" + phoneIndex + ":");
                    $(phoneNumber).text(this.number);
                    $(phoneDescription).text(this.description);

                    $(phoneRow).append(phoneName, phoneNumber, phoneDescription);
                    $(tableHidden).append(phoneRow);
                    phoneIndex++;
                });

                phoneIndex = 1;

                $(tableHidden).append(document.createElement("br"));

                $(this.hobbies).each(function () {
                    var hobbieRow = document.createElement("tr");
                    var hobbieNumber = document.createElement("td");
                    var hobbieName = document.createElement("td");
                    var hobbieDescription = document.createElement("td");

                    $(hobbieDescription).attr("class", "text-muted");
                    $(hobbieNumber).text("Hobbie #" + phoneIndex + ":");
                    $(hobbieName).text(this.name);
                    $(hobbieDescription).text(this.description);


                    $(hobbieRow).append(hobbieNumber, hobbieName, hobbieDescription);
                    $(tableHidden).append(hobbieRow);
                    phoneIndex++;
                });


                $(divHidden).append(tableHidden);
                $(tdHidden).append(divHidden);
                $(trHidden).append(tdHidden);

                $("#tbody").append(trHidden);
                index++;
            });

        });

    };
    var popCompanies = function () {

        resetList();

        $("#tableHeader").text("Copmanies");
        $("#tableHeaderSmall").text("Click A Row for more Details");

        var thr = document.createElement("tr");
        var th1 = document.createElement("th");
        var th2 = document.createElement("th");
        var th3 = document.createElement("th");
        var th4 = document.createElement("th");
        var th5 = document.createElement("th");
        var th6 = document.createElement("th");

        $(th1).text("Name");
        $(th2).text("Description");
        $(th3).text("CVR");
        $(th4).text("# of Employees");
        $(th5).text("Market Value");
        $(th6).text("Email");

        $("#thead").append(thr);
        $(thr).append(th1, th2, th3, th4, th5, th6);

        $.getJSON("http://localhost:8080/CA2/api/company", function (list) {

            $(list).each(function () {



                console.log(this);

                var tr = document.createElement("tr");
                var td1 = document.createElement("td");
                var td2 = document.createElement("td");
                var td3 = document.createElement("td");
                var td4 = document.createElement("td");
                var td5 = document.createElement("td");
                var td6 = document.createElement("td");
                var td7 = document.createElement("td");
                var td8 = document.createElement("td");
                var edit = document.createElement("button");
                var del = document.createElement("button");

                $(edit).attr("id", this.id);
                $(del).attr("id", this.id);

                $(edit).text("Edit");
                $(del).text("Delete");

                $(td1).text(this.name);
                $(td2).text(this.description);
                $(td3).text(this.cvr);
                $(td4).text(this.numEmployees);
                $(td5).text(this.marketValue);
                $(td6).text(this.email);

                $("#tbody").append(tr);
                $(td7).append(edit);
                $(td8).append(del);
                $(tr).append(td1, td2, td3, td4, td5, td6, td7, td8);
            });
        });
    };

    var popAddresses = function () {
        $("#table").empty();
    };

    var popHobbies = function () {
        $("#table").empty();
    };

    var popCities = function () {
        $("#table").empty();
    };

    //popPeople();

    $("#findPersons").click(function () {
        popPeople();
    });

    $("#findCompanies").click(function () {
        popCompanies();
    });

    $("#addPerson").click(function () {
        newPerson();
    });



});


