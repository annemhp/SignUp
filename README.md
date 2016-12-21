# SignUp

This is a simple web application developed using SpringMVC.

The web application is hosted on Apache Tomcat8 on Amazonaws Unix server.

Below is the link to access the web application.

http://ec2-35-166-164-141.us-west-2.compute.amazonaws.com:8080/SignUp/welcome.html?

Firebase Database is used to save user data.

Registered user information from the database can be accessed using the below link.

https://gfsignup-e1d3f.firebaseio.com/users.json?print=pretty

Spring RestTeamplate is used to make Restful requests to access firebase Database.



The following acceptance criteria are to be met for users to register sucessfully:

● The username field accepts alpha numeric values only

● The username length is no less than 5 characters

● The username is not already registered

● The password has a minimum length of 8 characters and contains at least 1 number,

1 uppercase, and 1 lowercase character

● The user gets feedback when the username or the password doesn't meet the

criteria

● Upon submission of a valid username and password, they are persisted to a

database

● The user gets feedback that he/she has been registered
