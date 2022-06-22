
# LIbrary Management System 

A library management system implement using concepts of OOP in JAVA, GUI desgined using Java Swing on Netbeans and MS SQL as database run on Xampp.

System Users/Actors

Librarian

Functionalities

-Librarian

- can view loan history of borrowers
- can add borrower
- can update personal information of borrower
- can checkout an item
- can checkin an item
- can check for defaulters 
- can increase quantity of book
- can decrease quantity of book
- can add new book
- can delete a book
- can update book info
## Features

- Pie Chart to show most issued book
- Reports generations
- Defaulters List


## Run this project

Run this project

-For running this project , you must have installed JDK and NetBeans.

-Create a new project using netbeans and include these files in source code folder.

-Then include all JAR files in the library

-Install Xampp to host database and integrate with app

-Run these SQL statements to make the database

-Change the connection string in dbConnectivity.java according to your system.

```bash
  create database library_ms;

  create table users(id int PRIMARY key not null AUTO_INCREMENT, 
  name varchar(50), password varchar(50), email varchar(100), contact varchar(20));

  create table student_details(student_id int primary key AUTO_INCREMENT not null, 
  name varchar(100), department varchar(100));

  create table book_details(book_id int PRIMARY KEY AUTO_INCREMENT NOT null, 
  book_name varchar(250), author varchar(200), department varchar(100), quantity int);

  create table issue_book_details(id int PRIMARY KEY not null AUTO_INCREMENT,
  book_id int,book_name varchar(150),student_id int,student_name varchar(50),
  issue_date_date,due date date,status varchar(20));
```

-Click on run file.


    
## Contributors

- [@Dev](https://www.github.com/vorad1)
- [@Rudra](https://www.github.com/rudramodh)


