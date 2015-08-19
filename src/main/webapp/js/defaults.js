var navList = 
'<li id="storage"><a href="/storage.html">File Storage</a></li>' +
'<li id="about"><a href="/about.html">About</a></li>' +
'<li><a href="/login">Login</a></li>';

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
'            <img class="navbar-brand" src="img/CC.png" style="padding: 0px; padding-right: 5px;">\n' +
'            <a class="navbar-brand" href="/" onclick="nav()"><b>SST Computer Club</b></a>\n' +
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
        
var footerHTML = 
'<a href="/contact.html" style="padding: 5px 14px; background-color: #eee; border: 1px solid #ddd; border-radius: 15px; margin-right: 5px; margin-left: 5px;">Contact Us</a>\
 <p> Not <b>Copyright &copy; SST Computer Club 2015</b>. All rights reserved. This website is to be worked on by SST Computer Club as a whole.</p>';

function initDefaults() {
    document.getElementById('navigation-bar').innerHTML = navHTML;
    document.getElementsByTagName('footer')[0].innerHTML = footerHTML;
}

function setActive(selectedPage) {
    document.getElementById('navList').innerHTML = navList;
    
    var d = document.getElementById(selectedPage);
    d.className = "active";
}