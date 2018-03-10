![Logo](./img/ATS.jpg "Automatic Testing System of olympiad/school/university
 programs in different programming languages")

## About ATS

ATS(Automatic Testing System) - it's cross-platform system for conducting olympiads, tests, 
control works and individual solutions of tasks on programming. Work with the system takes
place in the web browser. At the moment system is supporting only C and C++ language, but another 
languages will be added soon. Compiler installation directories are taken from the registry 
(windows-version) or from the path variable (linux-version) Also *ATS* supports 
administrator room, in which administrator can:
- change basic information about system(title, description and much more); 
- add, remove and change tasks;
- change programming language for passing olympiad or test;
- change time for the that is given for the passage olympiad or test;
- add, remove and change groups or classes for grouping participants;
- remove participants;
- observe for the results of all participants.

The appearance of the system you can see 
[here](https://github.com/VladimirBalun/ATS/tree/master/img).

## What you need to build ATS
For build *ATS* on your computer, you will need to have the following
applications:
- Git
- JDK/JRE
- TomCat
- Maven
- MySQL

For Windows, you have to download and install [Git](https://git-scm.com/download), 
[JDK/JRE](http://www.oracle.com/technetwork/java/index-jsp-138363.html), 
[TomCat](https://tomcat.apache.org/download-80), 
[Maven](http://maven.apache.org/download.cgi) and
[MySQL](https://dev.mysql.com/downloads/installer/). After installation you
need to add system variables for JDK/JRE and Maven. 

OS X users should install Homebrew. Once Homebrew is installed, run:
    
    brew install git
    brew install java
    brew install tomcat
    brew install maven
    brew install mysql

Linux/BSD users should use their appropriate package managers to install:

    apt-get install git
    apt-get install default-jre
    apt-get install default-jdk
    apt-get install tomcat8
    apt-get install maven
    apt-get install mysql-server
    apt-get install mysql-client

Don't forget to use administrative rights, where you need it! After 
installation on all OS, run:

    java -version
    mvn --version

If installed, you'll need to see the versions JDK/JRE and Maven.

## How to build ATS
Clone a copy of the main ATS git repo by running:

    git clone https://github.com/VladimirBalun/ATS.git

Enter the ATS directory and run the build script on Windows:

    build.bat

Enter the ATS directory and run the build script on OS X or Linux/BSD:

    ./build

Everything will build in directory:

    ../src/target/

## Version
The system is in constant development(current beta-version 1.2). Watch out for changes!. 
____
Documentation will be supplemented over time, but if you have any questions, please 
contact: vladimirbalun@yandex.ru

