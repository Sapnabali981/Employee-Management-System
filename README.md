# 👨‍💼 Employee Management System (EMS)

## 📌 Project Overview

Employee Management System is a **Spring Boot REST API** application that allows organizations to manage employee records efficiently.
It supports operations like employee creation, update, retrieval, soft deletion, and restoration of employee data.

This project demonstrates strong backend development concepts including **REST API development, layered architecture, database integration, global exception handling, and cloud deployment.**

---

## 🚀 Live Project Links

* 🌐 **Live API:** https://github.com/Sapnabali981/Employee-Management-System
* 💻 **GitHub Repository:** https://ems-backend-cqtf.onrender.com/

---

## 🛠️ Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

### Database

* PostgreSQL / MySQL (whichever you used)

### Deployment

* Render Cloud Platform
* Docker

---

## ✨ Features

### ✅ Employee Management

* Add Employee
* Update Employee
* Fetch Employee by ID
* Fetch All Employees
* Soft Delete Employee
* Restore Deleted Employee

---

### ✅ Soft Delete Implementation

Instead of permanently deleting employee records:

* `isDeleted` flag is used
* Deleted employees can be restored later
* Ensures data safety

---

### ✅ Exception Handling

* Global Exception Handler implemented
* Custom exceptions:

  * Employee Not Found
  * Employee Already Deleted
  * Employee Already Active

---

### ✅ Layered Architecture

Project follows clean separation:

```
Controller → Service → Repository → Database
```

---

## 📂 API Endpoints

| Method | Endpoint                         | Description              |
| ------ | -------------------------------- | ------------------------ |
| POST   | `/employees/addEmployee`          | Create new employee      |
| GET    | `/employees/fetchAllEmployees`      | Fetch all employees      |
| GET    | `/employees/fetchById/{id}`       | Fetch employee by ID     |
| PUT    | `/employees/updateEmployeeById/{id}`  | Update employee          |
| DELETE | `/employees/deleteEmployeeById/{id}`  | Soft delete employee     |
| PUT    | `/employees/restoreEmployee/{id}` | Restore deleted employee |

---

## 🗄️ Database Design

Employee entity contains:

* Employee ID
* Name
* Email
* Department
* Salary
* Created Timestamp
* Soft Delete Flag

---

## 🔐 Environment Configuration

Sensitive credentials are stored using environment variables.

```
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
PORT
```

---

## ▶️ How to Run Locally

### Step 1 – Clone Repository

```
git clone (Add your EMS GitHub link)
```

---

### Step 2 – Configure Database

Update `application.properties` with database credentials.

---

### Step 3 – Build Project

```
mvn clean install
```

---

### Step 4 – Run Application

```
mvn spring-boot:run
```

---

## 📊 Project Highlights

* REST API Development using Spring Boot
* Soft Delete Mechanism
* DTO based data handling
* Global Exception Handling
* Clean Layered Architecture
* Cloud Deployment using Render & Docker
* Database Integration using JPA & Hibernate

---

## 👩‍💻 Author

**Sapna Bali**
Java Backend Developer
📧 [sapnabali45@gmail.com](mailto:sapnabali45@gmail.com)
🔗 GitHub: [https://github.com/Sapnabali981](https://github.com/Sapnabali981)

---
