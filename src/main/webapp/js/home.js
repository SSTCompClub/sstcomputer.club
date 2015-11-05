getNews(0);

document.getElementById("Carousel").style.height = ((document.body.clientHeight / 2) + "px");
window.onresize = function(event) {
    document.getElementById("Carousel").style.height = ((document.body.clientHeight / 2) + "px");
};

$('.carousel').carousel({
    interval: 10000 //10 seconds
});

function getNews(page) {
    var json = {};//TODO: Update this for new server side code
    json.request = "get";
    json.page = page;

    var content = JSON.stringify(json);

    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            document.getElementById('newsFeed').innerHTML = xmlhttp.responseText;
            console.log(xmlhttp.responseText);
        }

        if (xmlhttp.status === 500) {
            document.getElementById('newsFeed').innerHTML = "<p>Error 500. An internal server error has occured. Can't handle request.</p>";
        }
    };

    xmlhttp.open("POST", "/", true);
    xmlhttp.send(content);
}

function nextPage() {
    alert("function \"nextPage\" hasn't been implemented client side nor server side.");
}

function previousPage() {
    alert("function \"previousPage\" hasn't been implemented client side nor server side.");
}