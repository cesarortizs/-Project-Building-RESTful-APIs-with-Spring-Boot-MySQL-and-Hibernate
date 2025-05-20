**How to set up the project**
<br><br>
We will need to create an user called "prueba" with the password "12345" on our MySQL instance and grant it permissions to read, create, update and delete registries using the commands found below, alternatively we can modify the "application.properties" file to configure our own username and password combo:
<br><br><br>
*CREATE USER 'prueba'@'localhost' IDENTIFIED BY '12345';*
<br><br>
*GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES, RELOAD on \*.\* TO 'prueba'@'localhost' WITH GRANT OPTION;*
<br><br><br>
A database named "library_management" is also required, we can create it using the following command:
<br><br><br>
*CREATE DATABASE library_management;*
<br><br><br>
We also need a table called "books" that can be created using the following command:
<br><br><br>
*CREATE TABLE books*
*(id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,*
*title VARCHAR(200) NOT NULL,*
*author VARCHAR(100) NOT NULL,*
*isbn INT NOT NULL,*
*published_date DATE NOT NULL);*
<br><br><br>
**How to run the application**
<br><br>
The application runs on port 8080, it will not ask for authentication as its a very basic spring boot project, it comes configured with the previous database specifications but it will not automatically create any table, therefore the need to create our "books" table on MySQL directly.
<br><br>
The application handles exceptions if we make a request with an incorrect HTTP method to an existing endpoint, if we send an incorrect body to an specific endpoint (incomplete or with wrong types) and if we request a non existing resource from an endpoint.
<br><br><br>
**API endpoints and sample requests for testing**
<br><br>
The application has five endpoints:
<br><br><br>
*GET /books*
<br><br>
This will return a list with all the books registered in the "books" table
<br><br><br>
*GET /books/{id}*
<br><br>
We can replace {id} with the number of the id of an specific book in the "books" table, it will return us the object that represents it
<br><br><br>
*POST /books*
<br><br>
We can send a request body with the properties of a book object to create and insert it in the "books" table as presented below:
<br><br>
*{*
*"title": "the shining",*
*"author": "stephen king",*
*"isbn": 307743659,*
*"publishedDate": "1977-01-28"*
*}*
<br><br><br>
*PUT /books/{id}*
<br><br>
We can replace {id} with the number of the id of an specific book in the "books" table and send a request body with the properties of a book object to update that specific book details, as presented below:
<br><br>
*{*
*"title": "pet sematary",*
*"author": "stephen king",*
*"isbn": 307743659,*
*"publishedDate": "1983-11-04"*
*}*
<br><br><br>
*DELETE /books/{id}*
<br><br>
We can replace {id} with the number of the id of an specific book in the "books" table, it will delete its registry
