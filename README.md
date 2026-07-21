# 👨‍💼 Employee Management System with JWT Authentication

A secure backend REST API application developed using **Spring Boot**, **JWT Authentication**, **Spring Security**, **Hibernate**, and **MySQL**.

---

# 🚀 Features

- Employee CRUD Operations
- JWT Authentication
- Spring Security
- BCrypt Password Encryption
- Pagination
- Sorting
- Search Employees
- DTO Pattern
- Global Exception Handling
- Swagger API Documentation
- MySQL Database Integration

---

# 🛠️ Tech Stack

- Java 11
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger

---

# 📂 Project Structure

```
Controller
Service
Repository
Model
DTO
Security
Exception
Configuration
```

---

# 🔐 Authentication APIs

## Register User

```
POST /auth/register
```

## Login User

```
POST /auth/login
```

Returns JWT Token.

---

# 👨‍💼 Employee APIs

| Method | Endpoint |
|--------|----------|
| GET | /employees |
| GET | /employees/{id} |
| POST | /employees |
| PUT | /employees/{id} |
| DELETE | /employees/{id} |

All Employee APIs require **Bearer Token Authentication**.

---

# 📖 Swagger Documentation

```
http://localhost:8080/swagger-ui/index.html
```

---

# ⚙️ Run Project

Clone repository

```bash
git clone https://github.com/ramkrishna38/employee-management-system.git
```

Move into project

```bash
cd employee-management-system
```

Run

```bash
mvn spring-boot:run
```

---

# 💾 Database

Database : MySQL

Update your database configuration in

```
application.properties
```

---

# 📌 Highlights

- Secure REST APIs using JWT Authentication
- Layered Architecture (Controller-Service-Repository)
- Password Encryption using BCrypt
- Production-ready Exception Handling
- Clean DTO-based response model
- API Documentation with Swagger

---

# 👨‍💻 Author

**Ram Krishna**

GitHub

```
https://github.com/ramkrishna38/employee-management-system
```
