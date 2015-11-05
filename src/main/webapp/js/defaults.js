var navList = 
'<li id="nav-storage"><a href="javascript:storagePage()">File Storage</a></li>' +
'<li id="nav-lan"><a href="javascript:lanPage()">LAN Parties</a></li>' +
'<li id="nav-login"><a href="javascript:loginPage()">Login</a></li>' +
'<li id="nav-about"><a href="javascript:aboutPage()">About</a></li>';

var navHTML =   
'<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">\n' +
'    <div class="container">\n' +
'        <!-- Brand and toggle get grouped for better mobile display -->\n' +
'        <div class="navbar-header">\n' +
'            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">\n' +
'                <span class="sr-only">Toggle navigation</span>\n' +
'                <span class="icon-bar"></span>\n' +
'                <span class="icon-bar"></span>\n' +
'                <span class="icon-bar"></span>\n' +
'            </button>\n' +
'            <div id="nav-home">\n' +
'               <img class="navbar-brand" src="img/CC.png" style="padding: 0px; padding-right: 5px;">\n' +
'               <a class="navbar-brand" href="javascript:homePage()"><b>SST Computer Club</b></a>\n' +
'            </div>\n' +
'        </div>\n' +
'        <!-- Collect the nav links, forms, and other content for toggling -->\n' +
'        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">\n' +
'            <ul id="navList" class="nav navbar-nav navbar-right">\n' +
                navList +
'            </ul>\n' +
'        </div>\n' +
'        <!-- /.navbar-collapse -->\n' +
'    </div>\n' +
'    <!-- /.container -->\n' +
'</nav>';

function initDefaults() {
    document.getElementById('navigation-bar').innerHTML = navHTML;
    
    grabPage();
}

function setActive(selectedPage) {
    document.getElementById('navList').innerHTML = navList;
    
    var doc = document.getElementById(selectedPage);
    doc.className = "active";
}

function homePage() {
    setActive("nav-home");
    window.history.pushState(null, null, "df?page=home");
    grabPage();
}

function storagePage() {
    setActive("nav-storage");
    window.history.pushState(null, null, "df?page=storage");
    grabPage();
}

function lanPage() {
    setActive("nav-lan");
    window.history.pushState(null, null, "df?page=lan");
    grabPage();
}

function loginPage() {
    setActive("nav-login");
    window.history.pushState(null, null, "df?page=login");
    grabPage();
}

function aboutPage() {
    setActive("nav-about");
    window.history.pushState(null, null, "df?page=about");
    grabPage();
}

function contactPage() {
    window.history.pushState(null, null, "df?page=contact");
    grabPage();
}

function grabPage() {
    var json = {};
    json.type = "page";
    json.page = document.location.href;
    
    var content = JSON.stringify(json);
            
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200 && !(document.location.pathname === "/500")) {
            var response = xmlhttp.responseText.split("<!-- /.end -->");
            var pageMeta = JSON.parse(response[0]);
            
            document.title = pageMeta.title;
            //Remove & inject scripts
            
            document.getElementById('page-content').innerHTML = response[1];
        }

        if (xmlhttp.status === 404) {
            window.history.pushState(null, null, "df?page=404");
            grabPage();
        }
        
        if (xmlhttp.status === 500) {
            window.location.assign("500");
        }
    };

    xmlhttp.open("POST", "/", true);
    xmlhttp.send(content);
}