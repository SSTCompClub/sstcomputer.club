Greetings members of SST Computer Club.

The purpose of this website is for user of CC to expand their knowledge and to create a beneficial medium for any who uses it. So far the main things that will be covered are News, File Management, and history about CC.

If you haven't setup your workspace yet, then here are the instructions:

### Environment requirements:
* [Java Development Kit 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) (cause GAE uses 7 server side)
* Git ([**Windows**](http://git-scm.com/download/win), **GNU/Linux**: Open a terminal and run: _sudo apt-get install git_ or the equivalent for your distribution, [**Mac OS X**](http://git-scm.com/download/mac))
* This IDE ([Eclipse (Java EE)](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunasr2)
* A [GitHub account](https://github.com/join), and a [Google account](https://accounts.google.com/SignUp)

### Eclipse:
1. Follow instructions from [here](https://developers.google.com/eclipse/docs/install-eclipse-4.4)
2. Open Eclipse
3. Get EGit by opening **Help > Eclipse Marketplace**
4. Type in _EGit_ and hit enter
5. Install EGit
6. Restart Eclipse
7. Go to the arrow next to Google icon in your toolbar and find _New Web Application Project_
  * In the _Project Name_ type: SST-Computer-Club
  * In the _Package Name_ type: club.sstcomputer.web
  * Deselect GWT (Google Web Toolkit)
8. Right-click the project in the _Project Explorer_ and click _Properties_
9. Go to **Google > App Engine**
10. Type in _sst-computer-club_ for Application ID
11. Read all of [this](http://wiki.eclipse.org/EGit/User_Guide)
12. Fetch the files from this repository

##### Notice:
Netbeans is not to be supported for one reason, which is the difference in structure. Google made GAE for Eclipse, and does make it easier for all users to use, unlike Netbeans which is not officially supported and requires you to already have a background with GAE. Now when it comes to Intellij IDEA, well that's pay to use for the whole package, so no Java EE and any of that giz.

If you have permission issues or need to be added to anything, then send an e-mail to: _sstcompclub@gmail.com_
All there really is needed for developers is viewing access to appspot to be able to debug servlet issues, and access to the Git repository