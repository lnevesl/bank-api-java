# 🏦 Bank API - Spring Boot

## 📌 About the Project

This project is a **RESTful API for a digital banking system**, developed using **Java + Spring Boot**.

It allows basic banking operations such as:

* ✅ Account creation
* 💰 Deposit
* 💸 Withdrawal
* 🔄 Transfer between accounts
* 🔍 Account lookup by UUID

---

## 🚀 Technologies Used

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* Lombok
* H2 / MySQL (configurable)

---

## 🧱 Architecture

The project follows a layered architecture:

```
controller → service → repository → entity
```

* **Controller**: Handles HTTP requests
* **Service**: Business logic
* **Repository**: Database access
* **DTOs**: Data transfer between layers

---

## 📂 Project Structure

```
Bank
├── controller
├── dto
├── service
│   ├── impl
├── persistence
│   ├── entities
│   ├── repositories
```

---

## 📮 API Endpoints

### ➕ Create Account

```
POST /conta
```

### 💰 Deposit

```
POST /depositar/{id}
```

### 💸 Withdraw

```
POST /{id}/sacar
```

### 🔄 Transfer

```
POST /trasferencia
```

### 🔍 Get Account by UUID

```
GET /{uuid}
```

---

## ⚠️ Improvements to be Made

* Add exception handling (GlobalExceptionHandler)
* Add unit tests (JUnit + Mockito)
* Improve validations (Bean Validation)
* Implement authentication (Spring Security)
* Fix endpoint consistency (REST patterns)

---

## 🧠 Business Rules

* Cannot withdraw if balance is insufficient
* Cannot transfer without balance
* CPF must be unique
* Account starts with zero balance

---

## ▶️ How to Run

1. Clone the repository:

```
git clone https://github.com/your-username/bank-api-springboot.git
```

2. Run the project:

```
./mvnw spring-boot:run
```

3. Access:

```
http://localhost:8080
```

---

## 👨‍💻 Author

Developed by **Neves**
Java Backend Developer 🚀
