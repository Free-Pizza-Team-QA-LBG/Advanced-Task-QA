# Internal Management System (IMS) Project

## Objective
Build an Internal Management System (IMS) using **Java** and **SQL**, implementing **Object-Oriented Programming (OOP)** principles. The system should manage users and employee records with database interaction and thorough testing.

---

## Requirements

### 1. Database Setup (SQL)
- Create an SQL database named `ims_db`.
- Define a table `employees` with the following fields:
    - `id` (INT, Primary Key, Auto-Increment)
    - `first_name` (VARCHAR)
    - `last_name` (VARCHAR)
    - `email` (VARCHAR, unique)
    - `department` (VARCHAR)
    - `salary` (DECIMAL)

---

### 2. Java Project Structure
Use **Maven** to structure the project and manage dependencies. Implement the **Model-View-Service-DAO** pattern.

```bash
com.ims/
├── dao/         # Data Access Object (DB Interactions)
├── model/       # Employee Model class
├── service/     # Business Logic
├── ui/          # User Interface (Command Line Interface)
└── test/        # Unit tests using JUnit
```
# Tasks to Implement

## 1. Database Connectivity
Implement a `DBConnection` class in the `dao` package:
- Establish a connection to the SQL database.
- Ensure safe connection closure using try-with-resources or manual cleanup.

## 2. Employee Model
Implement the `Employee` class in the `model` package with:
- Fields matching the database structure: `id`, `first_name`, `last_name`, `email`, `department`, `salary`.
- Getters and Setters for all fields.
- A constructor to initialize the `Employee` object.
- A `toString()` method for printing employee details.

## 3. DAO Layer (CRUD Operations)
In the `dao` package, create an interface `EmployeeDAO` that defines the following methods:
- `createEmployee(Employee employee)`
- `readEmployee(int id)`
- `updateEmployee(Employee employee)`
- `deleteEmployee(int id)`
- `getAllEmployees()`

Implement `EmployeeDAOImpl` to connect to the database and perform the above operations.

## 4. Service Layer
In the `service` package, create `EmployeeService` that:
- Interacts with `EmployeeDAO` for CRUD operations.
- Contains business logic such as validations and input sanitization.

## 5. User Interface (CLI)
In the `ui` package, implement a simple CLI-based interface to interact with the system. It should allow the user to:
- Add an employee.
- View employee details by ID.
- Update employee details.
- Delete an employee by ID.
- List all employees.

Use `Scanner` for reading input from the user.

## 6. Unit Testing
Implement unit tests for:
- `Employee` model (testing setters, getters, and constructors).
- `EmployeeDAO` (mock database operations using JUnit and Mockito).

Ensure edge cases are covered:
- Non-existent employees.
- Duplicate email entries.
- Invalid data formats for fields like salary.


# Additional Considerations

## Error Handling
- Implement graceful error handling for SQL exceptions, invalid user inputs, and failed transactions.

## Logging
- Implement basic logging for key events (using `java.util.logging` or similar libraries):
    - Log database connection success/failure, CRUD operation attempts, etc.

# Deliverables
A working Java project with:
- Full CRUD operations on the `Employee` table.
- A CLI interface for user interaction.
- JUnit tests covering core functionality.
- A Maven POM file with all dependencies (JDBC, JUnit, Mockito).

# Technologies Used
- Java
- SQL
- Maven
- JUnit
- Mockito
- JDBC

# Unit Testing
- JUnit and Mockito will be used for testing the `Employee` model and `DAO` layer.
- Ensure tests for:
  - Valid and invalid inputs.
  - Non-existent employees.
  - Duplicate email entries.

# Logging
- Implement basic logging to track:
  - Database connection attempts (success and failure).
  - CRUD operations and errors.

# Error Handling
- Gracefully handle exceptions, including:
  - SQL errors.
  - Invalid user input.
  - Failed transactions.
