# ReimbursmentApp

ReimbursmentApp is an application written in Java 11, utilizing Tomcat, Maven, and JUnit.

This Expense Reimbursement System allows an user to submit money reimbursement requests for different purposes (food, traveling, lodging, or other). 
Application has a Main Page with links to User Page and Admin Page.

## Features

User Page:
- add some basic data of business trip
- add expenses related to receipts
- add expenses related to car usage

After all costs are added, application count all the costs and show trip summary with sum of the costs.

Admin Page:
- add and change settings used for calculation
- add new type of receipts
- add limits for costs

## Future development possibilities
- add user management
- add role management related to users
- add limits checking 
- tickets related to users
- tickets approving by managers
- etc.

## Requirements

- Java 11
- Apache Tomcat
- Apache Maven
- Windows Operating System
- Git

## How to Set Up the Environment on a Windows System

1. **Install Java 11**:
    - Download and install [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
    - Set the `JAVA_HOME` environment variable to point to the JDK directory

2. **Install Apache Tomcat**:
    - Download and install [Tomcat](https://tomcat.apache.org/download-90.cgi)
    - Configure Tomcat as per the instructions provided on the site

3. **Install Apache Maven**:
    - Download and install [Maven](https://maven.apache.org/download.cgi)
    - Add Maven's binary directory to the `PATH` environment variable

## How to Build the Application

1. Open the command prompt and navigate to the project's root directory
2. Execute the command: mvn clean install

## How to Run the Tests

1. Make sure you are in the project's root directory
2. Execute the command: mvn clean test


The tests will run using JUnit, and the results will be displayed in the console.

## Further Assistance

If you encounter any difficulties with configuration, building, or testing the application, please consult the documentation:
- [Java 11](https://docs.oracle.com/en/java/javase/11/)
- [Apache Tomcat](https://tomcat.apache.org/tomcat-9.0-doc/index.html)
- [Apache Maven](https://maven.apache.org/guides/index.html)
- [JUnit](https://junit.org/junit5/docs/current/user-guide/)

