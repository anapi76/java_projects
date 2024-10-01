## MICROSERVICES
### Description
Microservices application
### Development
- Java 17
- Spring Boot Framework version 3.2.5
- IDE IntelliJ IDEA IDE.
- GitHub repository https://github.com/anapi76/katas_sopra.git/microservices
- Postman for testing
- Spring Cloud Netflix Eureka
- Spring Cloud Config
- Spring Cloud Gateway
### Microservices
### 1. [Eureka Microservice](microservice-eureka)
- **Description**: This microservice acts as a discovery server, allowing other microservices to register and find each other.
- **URL**: `http://localhost:8761`
- **Technologies**: Spring Cloud Netflix Eureka

### 2. [Config Server Microservice](microservice-config)
- **Description**: Provides centralized configuration for all microservices. It allows storing configurations in a Git repository.
- **URL**: `http://localhost:8888`
- **Technologies**: Spring Cloud Config

### 3. [Auth Microservice](microservice-auth)
- **Description**: Handles business logic related to authenticated a user.
- **Routes**:
  - `POST /auth/login`: check credentials and return a token.
  - `POST /auth/Validate`: Validate the token.
  - `POST /auth/register`: Create a user.

### 4. [User Microservice](microservice-user)
- **Description**: Handles business logic related to users.
- **Routes** (with token):
  - `GET /user`: Get all users.
  - `GET /user/{id}`: Get a user by id.
  - `POST /user/`: Create a user.
  - `PUT /user/{id}`: Update a user.
  - `DELETE /user/{id}`: Delete a user.
  
### 5. [Product Microservice ](microservice-product)
- **Description**: Handles business logic related to products and product types.
- **Routes** (with token):
  - `GET /product`: Get all products.
  - `GET /product/{id}`: Get a product by id.
  - `POST /product/`: Create a product.
  - `PUT /product/{id}`: Update a product.
  - `DELETE /product/{id}`: Delete a product.
  - `GET /typeProduct/`: Retrieves all product types.

### 5. [API Gateway](microservice-gateway)
- **Description**: Acts as an entry point for client requests and redirects requests to the appropriate microservices.
- **Routes**:
  - `GET /product/**`: Redirects to the endpoints of the Product microservice.
  - `GET /typeProduct/**`: Redirects to the endpoints of the Product microservice.
- **Technologies**: Spring Cloud Gateway

## How to Run the Microservices

1. **Eureka**: Run the Eureka microservice at `http://localhost:8761`.
2. **Config Server**: Run the Config Server at `http://localhost:8888`.
3. **Auth Microservice**: Run the Auth microservice.
4. **User Microservice**: Run the User microservice.
5. **Product Microservice**: Run the Product microservice.
6. **API Gateway**: Run the API Gateway at `http://localhost:8083`

## Steps in Postman
1. User Registration (username, password)
   Endpoint: http://localhost:8083/auth/register
2. User Login - Log in with your credentials to obtain an authentication token.
   Endpoint: http://localhost:8083/auth/login
3. Accessing Protected Resources (Include the token in the Authorization header of your requests) - 
   Once you have the token, you can use it to access protected routes for the product, user, or typeProduct services.
   

