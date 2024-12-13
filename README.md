# Quiz App Setup

Prerequisites
Before you begin, ensure you have the following installed:

*     JDK 17 or later
*     Maven 3.x
*     MySQL
*     

######  after running the project , if it doesn't create Database automatically then try this*

*     start with Database conection*:

1. run this command in your terminal :```mysql -u root -p```
2. then create Database  using this :```CREATE DATABASE questiondb```

### * update Your application.properties
#### * Replace userName & yourPassword with your actual MySQL userName & password respectively.
1. spring.datasource.username= `` root``
2. spring.datasource.password=```yourPassword ```