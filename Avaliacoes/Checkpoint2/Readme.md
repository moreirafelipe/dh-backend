# Spring Boot OdontoClinic Rest Api Service



This is a simple Java / Maven / Spring Boot (version 2.5.6) application that provides appointments services between dentists and patients through Spring Boot JPA CRUD Rest Api operations with JSON entities validation  through Spring-Boot-Starter dependency and  **global \*@ExceptionHandler\* with the \*@ControllerAdvice\* annotation** . You can use Postman to test the service.



I hope this document helps you.



## ▶️ How to Run

- Clone this repository

- Make sure you are using:

  - Java SE 17 (or higher)

  - JDK 17 (or higher)

  - Maven 3.x

    

- Spring Boot (v. 2.5.6) dependencies:

  - Spring web

  - Spring boot dev tools

  -  Lombok

  - SQL Spring Data JPA

  - SQL H2 Database

    

- For while, to start the application, just run its main method

- The **Postman JSON Collection file (v2.1)** can be found at: `src\main\resources` 



### 🔧 Installing the Java SE and JDK 17

You can download and install one of the packages bellow according to your operational system:

[**Oracle Java SE 17**](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

[**Oracle JDK 17**](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

[**OpenJDK 17**](https://jdk.java.net/17/)



### 🔧 Installing the Apache Maven

- Access the [**download and installation**](https://maven.apache.org/download.cgi) guide and follow its steps according your operating system.
- After Maven installation, check the environment variable value e.g.

```
echo %JAVA_HOME% C:\Program Files\Java\jdk1.7.0_51
```



### 🌐 About the Api Rest Service

This project intends to provide CRUD operations through Rest API service for a fictional odontology clinic. Basically, it counts on:

- Patients module and dentists module;

- Business classes;
- Data access classes using ORM;
- Classes of service;
- Controller classes;
- MVC layers;
- Use of good practices:

   ○ Logging of exceptions with Log4J;




### 😎 Clean code observed

- Used MAVEN to manage dependencies on libraries and frameworks;
- Implemented a layered enterprise application architecture and dependency injection;
- Used the MVC pattern provided by the Spring Framework;
- Used an ORM for data access and persistence;
- Kept the application log record with Log4J to facilitate troubleshooting (troubleshooting) in case of errors;