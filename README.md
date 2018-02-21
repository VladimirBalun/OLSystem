# Testing system of programs
This application is a system of testing Olympiad tasks for programming
and some semblance of testing the knowledge of pupils/students on 
programming. At the moment *Testing System* checks programs on C language,
but it can checks programs in almost any programming language, for it
you will need to add compiler this language and change to bit of code
in the program. System has administrator room for change all the system 
without knowledge of programming. It's very useful for those, who want to
add/change/delete tasks, check results of tests, change basic data about
application without without working with code and DBMS. *Testing System* 
was written on **Java(Spring and Hibernate)** and with use **MySQL**, but you
will can be use any DBMS thanks to Hibernate.

## Appearance of the Testing System
This is a main page of application. Here shows basic information
about application. All the information(title, description, address, 
number, description of college/school/institute, icon and website) can be 
change in administrator room.

![Main page](http://my-files.ru/Get/hlse6z/%D0%91%D0%B5%D0%B7%D1%8B%D0%BC%D1%8F%D0%BD%D0%BD%D1%8B%D0%B9.png?justuploaded=true)

Page of tasks. Here shows all the tasks fo user, his statistic and how much 
time is left until the end of the Olympics.

![Main page](http://my-files.ru/Get/alsd3n/%D0%91%D0%B5%D0%B7%D1%8B%D0%BC%D1%8F%D0%BD%D0%BD%D1%8B%D0%B9.png)

Page is sending of task for checking. After the use has solved task, he can send
task to the *Testing system*. *Testing system* will check task and after will send
answer to the user. Answer will write in logs on the left side of the screen.

![Main page](http://my-files.ru/Get/qq8n1k/%D0%91%D0%B5%D0%B7%D1%8B%D0%BC%D1%8F%D0%BD%D0%BD%D1%8B%D0%B9.png)

This is a administrator room. Here you will can do whatever you want with
*Testing System*. I mean, yo will can change basic data, add/delete/change
tasks, delete users, watch results of users, add/delete/change groups for
users, change time the of passage Olympiad and much more.

![Administartor room](http://my-files.ru/Get/gsrakg/%D0%91%D0%B5%D0%B7%D1%8B%D0%BC%D1%8F%D0%BD%D0%BD%D1%8B%D0%B9.png?justuploaded=true)

Also *Testing System* has and another pages, but I won't put its, because pages don't 
bear useful information about application.

## Installation
For installation *Testing System* on your server, you will need to have the following
applications:
- JDK/JRE
- TomCat

## Description of implementation
#### DBMS
Application uses MySQL, but you will can be use any DBMS thanks to Hibernate. In
the database uses the following tables:
+ **basic_data**
    + Table *basic_data* stores information about *Testing System*(title, description, ...).
+ **users**
    + Table *users* stores information about users(description, login and password to log in 
    system, best result of Olympiad and group of user).
+ **groups**
    + Table *groups* stores information about groups of users.
+ **questions**
    + Table *questions* stores information about questions(tasks) for passing of
    Olympics(title and description of question).
+ **test_data_for_questions**
    + Table *test_data_for_questions* stores olympiad data for questions(input and output
    data, which will be passed to the compiler for verification).
+ **results_test**
    + Table *results_test* stores information about all the passing of Olympics(date 
    and time, user who passed the Olympiad and information about his results).
+ **logs_running_test**
    + Table *logs_running_test* stores information about passing of Olympiad by user.
    After Olympiad information for current user wil be deleted.
The scheme of the database:

![Scheme of the database](http://my-files.ru/Get/ivbe0l/%D1%81%D1%85%D0%B5%D0%BC%D0%B0%D0%91%D0%94.png?justuploaded=true)    

#### Architecture
Application uses architecture MVC. Detailed information about architecture will add later.
#### Code
Information about code will add later.
#### Checking task
Information about checking task will add later.

## Version
The development of the program is still ongoing. Current version of program 1.0.
____
Documentation will be supplemented over time, but if you have any questions, please contact: vladimirbalun@yandex.ru

