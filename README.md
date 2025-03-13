# User Management System

A simple **Spring Boot** application that demonstrates basic CRUD (Create, Read, Update, Delete) operations using an `ArrayList` as an in-memory data store. This project is designed to showcase core concepts like RESTful APIs, input validation, exception handling, and clean code practices.

---

## Features

- Add a new user.
- Retrieve all users.
- Retrieve a user by ID.
- Update an existing user.
- Delete a user.
- Input validation using `jakarta.validation`.
- Global exception handling for better error reporting.

---

## Technologies Used

- **Spring Boot 3.x**
- **Java 17** (or higher)
- **Maven** for build and dependency management
- **REST APIs** for communication
- **Jakarta Bean Validation** for input validation
- **Spring Boot Exception Handling** for robust error reporting

---

## Endpoints

### 1. **Create User**
- **URL:** `POST /users`
- **Description:** Add a new user to the system.
- **Request Body Example:**
  ```json
  {
      "name": "Vinay",
      "email": "vinay24@gmail.com",
      "age": "25"
  }
  ```
- **Response Example:**
  ```json
  {
      "statusCode": 201,
      "message": "User created successfully",
      "data": {
          "id": 1,
          "name": "Vinay",
          "email": "vinay24@gmail.com"
      }
  }
  ```

### 2. **Retrieve All Users**
- **URL:** `GET /users`
- **Description:** Get a list of all users in the system.
- **Response Example:**
  ```json
  {
      "statusCode": 200,
      "message": "Users found successfully",
      "data": [
          {
              "id": 1,
              "name": "Vinay",
              "email": "vinay24@gmail.com"
          },
          {
            "uId": 2,
            "name": "H.Hari Raj",
            "email": "hhariraj579@gmail.com",
            "age": 23
        },
        {
            "uId": 3,
            "name": "Ranjith",
            "email": "ranjith5@gmail.com",
            "age": 25
        },
        {
            "uId": 4,
            "name": "Sahana",
            "email": "sahana7@gmail.com",
            "age": 22
        },
        {
            "uId": 5,
            "name": "shreyas",
            "email": "shreyas3@gmail.com",
            "age": 23
        }
      ]
  }
  ```

### 3. **Retrieve User by ID**
- **URL:** `GET /users/{id}`
- **Description:** Get details of a user by their unique ID.
- **Response Example:**
  ```json
  {
      "statusCode": 200,
      "message": "User found successfully",
      "data": {
          "id": 1,
          "name": "Vinay",
          "email": "vinay24@gmail.com"
      }
  }
  ```

### 4. **Update User**
- **URL:** `PUT /users/{id}`
- **Description:** Update an existing user's details.
- **Request Body Example:**
  ```json
  {
      "name": "Sahana",
      "email": "sahana7@outlook.com"
  }
  ```
- **Response Example:**
  ```json
  {
      "statusCode": 200,
      "message": "User updated successfully",
      "data": {
          "id": 4,
          "name": "Sahana",
          "email": "sahana7@outlook.com"
      }
  }
  ```

### 5. **Delete User**
- **URL:** `DELETE /users/{id}`
- **Description:** Delete a user from the system by their unique ID.
- **Response Example:**
  ```json
  {
      "statusCode": 200,
      "message": "User deleted successfully",
      "data": {
          "id": 5,
          "name": "shreyas",
          "email": "shreyas3@gmail.com"
      }
  }
  ```

---

## How to Run the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/HARIRAJ579/user-management-system.git
   cd user-management-system
2. Build the project using Maven:
   ```bash
   mvn clean install

3. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run

4. Access the application:
   ```bash
   1) Use tools like Postman or cURL to test the REST APIs.
   2) The application runs by default at http://localhost:8081

5. Improvements:
   ```bash
   1) Add persistent storage with a database like MySQL or PostgreSQL.
   2) Implement user authentication and authorization.
   3) Include pagination and sorting for retrieving users.
   4) Add unit and integration tests.
