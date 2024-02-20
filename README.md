# Shopping Cart App 
## SPRING DATA JPA USING HYBERNATE


## Description
This is a Java, MySQL, ORM, JPA and Hybernate exercise that allows to interact with a database with 4 tables: 
### Users 
* Insert User to database
* Update user's email and area of interest.
* Delete a user. 
### Products
* Insert New Products
* Update an Existing Product
* Delete a product 
### Order History
* An order is generated when a user "buys" some products. The inventory of the purchased products is also afected by this transaction. 
### Wishlist 
* A user can add and remove products from their wishlist or delete the list entirely. 


## Table of Contents
* [Important Links](#important-links)
* [Usage Information](#usage-information)
* [Test Instructions](#tests-instructions)


## Important Links
* [Github Repository](https://github.com/XimenaFernandezdelCCu/ShoppingCart_JPAEx)

## Usage Information
Test the funcionality of this code using Postman (or other web API testing application). The following tables show the endpoints, their type and functionality by Entity. 
<br/>Root Endpoint: localhost:8080/shoppingcart
### User
| Endpoint | Type    | Functionality | BODY |
| -------- | ------- |  ------- |------- |
| /user/all  | GET    | Returns All Users | NA |
| /user/{name of a user} | GET     | Returns a List of all users with that first name.  |NA |
| /user/{email of a user} | GET     | Returns the user with that email.  |NA |
| /user/save | POST     | Saves a new user to the DB  | Must contain details of the new user. | 
| /user/edit/{user id} | PUT | Update email and Area of Interest of a User | Must contain the information to be updated. |
| /user/delete/{user id}| DELETE | Deletes a User by ID  | NA |

### Product
| Endpoint | Type    | Functionality | BODY |
| -------- | ------- |  ------- |------- |
| /product/all  | GET    | Returns All Products | NA |
| /product/{name of a product} | GET     | Returns a List of all products with that name.  | NA |
| /product/{price of a product} | GET     | Returns a List of all products with that price.  | NA |
| /product/save | POST     | Saves a new product to the DB or increments the inventory of an existing product by one.  | Must contain new product details |
| /product/edit/{id} | PUT | Update price, image, description and total_products_inventory of a Product. | Must contain the information to be updated.|
| /product/delete/{id} | PUT | Sets the Status collumn of a product to false. |NA|

### Order
| Endpoint | Type    | Functionality | BODY |
| -------- | ------- |  ------- |------- |
| /orderHistory/all | GET | Returns a list of all Orders in the DB. | NA |
| /orderHistory/{user id} | GET | Returns a list of all Orders associated with a specific user. | NA |
| /orderHistory/{order id}/product | GET | Returns a list of the products from a specific Order. | NA |
| /orderHistory//buy/{user id} | POST | Creates an order and fixes the inventory of the products being bought. | Must contain a JSON object with a field "products" that contains an array with the id of the desired product and its quantity. |


### Wishlist
| Endpoint | Type    | Functionality | BODY |
| -------- | ------- |  ------- |------- |
| /wishlist/{user id} | GET | Returns a list of all the wished products from a specific user. | NA |
| /wishlist/save/{user id} | POST | Creates a wishlist instance in the DB with the user Id from the argument {user id} and the products to be added in the body. | Must contain an array with the Id's from the products to be added to the wishlist. |
| /wishlist/{user id}/remove | DELETE | Removes products from a specific user's wishlist | Must contain an array with the Id's of the products to be removed. | Must contain an array with the Id's from the products to be removed from the wishlist. |
| /wishlist/delete/{user id} | DELETE | Deletes all wishlist entities associated with a user from the DB. | NA |


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

#### POST: orderHistory/buy/{user id}
    {
        "products": [
            {
                "productId": 2940, 
                "quantity": 1
            },
            {
                "productId": 9531, 
                "quantity": 3
            }
        ]
    }
#### POST: /wishlist/save/{arg}
    {
        "products": [2940, 255, 8031, 9531]
    }
#### DELETE: /wishlist/{user id}/remove
    {
        "products": [2940]
    }

## Tests Instructions
Tests for some of the funcionalities of the application are provided and must be run as JUNIT tests. 

## Author
Ximena Fernández del Castillo 
