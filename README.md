# Employee Management System

A secure REST API built using Spring Boot.

## Features

- Employee CRUD
- JWT Authentication
- Spring Security
- BCrypt Password Encryption
- MySQL Database
- Spring Data JPA
- Swagger UI
- Pagination
- Sorting
- Search
- Global Exception Handling

## Tech Stack

- Java 11
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger

## APIs

### Authentication

POST /auth/register

POST /auth/login

### Employees

GET /employees

GET /employees/{id}

POST /employees

PUT /employees/{id}

DELETE /employees/{id}

## Swagger

```
http://localhost:8080/swagger-ui/index.html
```

## Run

```bash
mvn spring-boot:run
```

## Author

Ram Krishna
