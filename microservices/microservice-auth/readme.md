## MICROSERVICES
### Description
Authorized Microservices
### Development
- Java 17
- Spring Boot Framework version 3.2.5
- IDE IntelliJ IDEA IDE.
- GitHub repository https://github.com/anapi76/katas_sopra.git/microservices/microservice-auth
- Postman for testing
### Configuration
- Spring Data JPA
- Spring Security
- PasswordEncrypted
- The application starts on port 8081.
- API documentation with Swagger. http://localhost:8081/swagger-ui/index.html
- Testing with JUnit and Mockito
- Securing Endpoints with JWT
- UserRole (GET)
- AdminRole (GET,POST,PUT,PATCH,DELETE)
### Functionalities
- Register a user
  http://localhost:8081/auth/register
- Checks the user and returns a jwt token
  http://localhost:8081/auht/login
- Validate the token
  http://localhost:8081/auth/validate

