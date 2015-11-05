function contact() {
    var json = {};
    json.type = "validation";
    json.name = document.getElementById('name').value;
    json.email = document.getElementById('email').value;
    json.message = document.getElementById('message').value;
    json.response = grecaptcha.getResponse();

    var content = JSON.stringify(json);

    if (!(json.response === "")) {
        document.getElementById('error').innerHTML = "";

        var xmlhttp = new XMLHttpRequest();

        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {  
                var responseJSON = JSON.parse(xmlhttp.responseText);
                if (responseJSON['success'] === true) {
                    document.getElementById('name').value = "";
                    document.getElementById('email').value = "";
                    document.getElementById('message').value = "";
                    document.getElementById('error').innerHTML = "Your message has been sent.";
                } else if (responseJSON['success'] === false) {
                    document.getElementById('error').innerHTML = "Oh no! We think you're a robot ... are you?";
                }
            }

            if (xmlhttp.status === 500) {
                document.getElementById('error').innerHTML = "Error 500. An internal server error has occured. Can't handle request.";
            }
        };

        xmlhttp.open("POST", "/contact", true);
        xmlhttp.send(content);
    } else {
        document.getElementById('error').innerHTML = "Please verify that you're not a robot.";
    }
}