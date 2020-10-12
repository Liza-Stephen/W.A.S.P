# W.A.S.P

**Bug Tracking System** refers to an application that keeps track of reported software bugs in software development projects. It may be regarded as a type of issue tracking system.

Many bug tracking systems, such as those used by most open-source software projects, allow end-users to enter bug reports directly. Other systems are used only internally in a company or organization doing software development. Typically bug tracking systems are integrated with other project management software.



# Prerequisite to get started:

jre 1.8.0_261

Apache Tomcat 9.0

Apache Derby db-derby-10.14.2.0


# Steps to get started:

## Establishing a Database Connection:

 * Run the git clone command **git clone --branch FinalBranch https://github.com/Liza-Stephen/W.A.S.P.git**
 
 * Go to **'W.A.S.P/Bug Tracking System/src/com/wasp/database/DatabaseConnect.java'**

 * Change the path of database in the variable "**con**" to the path of the database folder as 'jdbc:derby:.../W.A.S.P/Database/bugstrack' where ... should be changed with the absolute path of the project .
 

## Run the application:

* Establish a tomcat server to host the backend servlet.

* In the project directory, go to **'W.A.S.P/Bug Tracking System/WebContent/WEB-INF/homepage.html'**

## Contributors
* Liza Bini Stephen (Team Lead)
* Vineet Kishore
* Megha Garg
* Pankaj Malik
* Miral Thakkar
* Pulkit Bansal
* Aditya Samota

## This Project is part of the **CODEFURY** Competition hosted by HSBC Software Development (India) Pvt. Ltd.
