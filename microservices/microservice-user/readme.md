## MICROSERVICES
### Description
User Microservices
### Development
- Java 17
- Spring Boot Framework version 3.2.5
- IDE IntelliJ IDEA IDE.
- GitHub repository https://github.com/anapi76/katas_sopra.git/microservices/micorservice-user
- Postman for testing
### Configuration
- Spring Data JPA
- Spring Security
- PasswordEncrypted
- The application starts on port 8082.
- API documentation with Swagger. http://localhost:8082/swagger-ui/index.html
- Testing with JUnit and Mockito
- Securing Endpoints with JWT
- UserRole (GET)
- AdminRole (GET,POST,PUT,PATCH,DELETE)
### Functionalities
- Get all users with token
  http://localhost:8082/user
- Get a user by id with token
  http://localhost:8082/user/{id}
- Create a user with token
  http://localhost:8082/create
- Update a user with token
  http://localhost:8082/update/{id}
- Delete a user with token
  http://localhost:8082/delete/{id}

