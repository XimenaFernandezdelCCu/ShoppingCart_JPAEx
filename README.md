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
| /user/edit/{id} | PUT | Update email and Area of Interest of a User |
| /user/delete/{id}| DELETE | Deletes a User by ID  |
| /product/all  | GET    | Returns All Products |
| /product/{name of a product} | GET     | Returns a List of all products with that name.  |
| /product/{price of a product} | GET     | Returns a List of all users with that email.  |
| /product/save | POST     | Saves a new product to the DB or increments the inventory of an existing product by one.  |
| /product/edit/{id} | PUT | Update price, image, description and total_products_inventory of a Product. |
| /product/delete/{id} | PUT | Sets the Status collumn of a product to false. |
| /wishlist/save/{arg} | POST | Creates a wishlist instance in the DB with the user Id from the argument {arg} and the Id from the products to be added in the body. |


### Request Body Format Examples
#### POST: /user/save 
    {
        "name": "Karla",
        "lastName": "Cu",
        "bio": "Bio",
        "email": "karla@mail.com",
        "areaOfInterest": "money"
    }
    
#### Put: user/edit/{id}
    {
        "email": "lucas@mail.com",
        "areaOfInterest": "food"
    }
#### POST: /product/save
    {
        "name": "glassess",
        "price": 1000.0,
        "image": null,
        "description": "Rayban",
        "totalProductsInventory": 5,
        "status": true
    }
#### Put: product/edit/{id}
    {
        "price": 1000.0,
        "image": null,
        "description": "Rayban",
        "totalProductsInventory": 5
    }
#### POST: /wishlist/save/{arg}
{
    "products": [2940, 255, 8031, 9531]
}


## Tests Instructions
Tests for some of the funcionalities of the application are provided and must be run as JUNIT tests. 

## Author
Ximena Fernández del Castillo 
