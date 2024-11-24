# Teacher Management System

This project is a part of Teacher Management System implemented in Java. It provides basic CRUD operations to manage teacher records in a database.

## Features

- **Add Teacher**: Add new teachers to the database.
- **Update Teacher**: Update existing teacher information.
- **Delete Teacher**: Remove a teacher from the database.
- **Get Teacher**: Retrieve teacher information by ID or last name.
- **List All Teachers**: List all teachers stored in the database.

## Technologies Used

- **Java**: Programming language used for the implementation.
- **JUnit**: Framework used for unit testing.
- **JDBC**: Java Database Connectivity for database access.
- **MySQL**: Database used for storing teacher records.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**
- **MySQL Database**
- **Maven** (for dependency management)

### Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/nikouliciousp/TestApp.git
    cd TestApp
    ```

2. **Configure the database:**

    Create a MySQL database named `studentsdbcj` and configure the connection settings in the `DBUtil` class.

3. **Build the project:**

    ```bash
    mvn clean install
    ```

4. **Run the tests:**

    ```bash
    mvn test
    ```

## Usage

To use the system, you can execute the main classes to interact with the database. The tests provided in the `TeacherDAOImplTest` class demonstrate how to use the DAO methods.

## Project Structure

- **src/main/java**: Contains the main source code.
- **src/test/java**: Contains the test classes.
- **src/main/resources**: Contains the resources needed for the project (e.g., configuration files).
