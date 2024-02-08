# Shopping Cart App 
## SPRING DATA JPA USING HYBERNATE


## Description
This is a Java, MySQL, ORM, JPA and Hybernate exercise that allows to interact with a database with 3 tables: 
### Users 
* Insert User to database
* Update user's email and area of interest.
* Delete a user. 
### Products
* Insert New Products
* Update an Existing Product
* Delete a product 
### Order History
* Future development



## Table of Contents
* [Important Links](#important-links)
* [Usage Information](#usage-information)
* [Test Instructions](#tests-instructions)


## Important Links
* [Github Repository](https://github.com/XimenaFernandezdelCCu/ShoppingCart_JPAEx)

## Usage Information
Test the funcionality of this code using Postman (or other web API testing application). the following table shows the endpoints, their type and functionality. 
<br/>Root Endpoint: localhost:8080/shoppingcart
| Endpoint | Type    | Functionality | 
| -------- | ------- |  ------- |
| /user/all  | GET    | Returns All Users |
| /user/{name of a user} | GET     | Returns a List of all users with that first name.  |
| /user/{email of a user} | GET     | Returns a List of all users with that email.  |
| /user/save | POST     | Saves a new user to the DB  |

## Tests Instructions
Tests for some of the funcionalities of the application are provided and must be run as JUNIT tests. 

## Author
Ximena Fernández del Castillo 
