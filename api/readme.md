## API
### Description
This application is a user management system.
### Development
- Java 17
- Spring Boot Framework version 3.2.5
- IDE IntelliJ IDEA IDE.
- GitHub repository https://github.com/anapi76/katas_sopra.git/api
- Postman for testing
### Configuration
- The application is configured to use an in-memory H2 database.   
  http://localhost:8080/h2-console/
- Spring Data JPA
- Spring Security
- PasswordEncrypted
- The application starts on port 8080.
- API documentation with Swagger. http://localhost:8080/swagger-ui/index.html
- Testing with JUnit and Mockito
- Securing Endpoints with JWT
- UserRole (GET)
- AdminRole (GET,POST,PUT,PATCH,DELETE)
### Functionalities
- Get all products with token
  http://localhost:8080/product
- Get a product by id with token
  http://localhost:8080/product/{id}
- Create a product with token
  http://localhost:8080/create
- Update a product with token
  http://localhost:8080/update/{id}
- Delete a product with token
  http://localhost:8080/delete/{id}
- User login return a token
  http://localhost:8080/auth/login
