## MICROSERVICE-PRODUCT
### Description
Product Microservices
### Development
- Java 17
- Spring Boot Framework version 3.2.5
- IDE IntelliJ IDEA IDE.
- GitHub repository https://github.com/anapi76/katas_sopra.git/microservices/micorservice-product
- Postman for testing
### Configuration
- Spring Data JPA
- Spring Security
- PasswordEncrypted
- The application starts on port 9090.
- API documentation with Swagger. http://localhost:9090/swagger-ui/index.html
- Testing with JUnit and Mockito
- Securing Endpoints with JWT
- UserRole (GET)
- AdminRole (GET,POST,PUT,PATCH,DELETE)
### Functionalities
- Get all products with token
  http://localhost:9090/product
- Get a product by id with token
  http://localhost:9090/product/{id}
- Create a product with token
  http://localhost:9090/create
- Update a product with token
  http://localhost:9090/update/{id}
- Delete a product with token
  http://localhost:9090/delete/{id}
- Get all typeproducts with token
  http://localhost:9090/typeProduct
- Get a typeproduct by id with token
  http://localhost:9090/typeProduct/{id}

