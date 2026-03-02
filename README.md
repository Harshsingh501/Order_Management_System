# 🛒 Order Management System

A simplified backend **Order Management System** built using **Spring Boot**.

This project simulates a basic trading / e-commerce backend that:

- Accepts orders via REST APIs
- Processes orders concurrently
- Stores orders in memory
- Logs order activity to file
- Provides analytics using Java Streams
- Uses proper Spring IoC and Dependency Injection
- Handles failures with custom exceptions

---

## 🚀 Tech Stack

- Java 21
- Spring Boot 3.2.5
- Spring MVC
- Maven
- Java Collections & Generics
- Multithreading (ExecutorService)
- Java Streams API
- Java File I/O
- ConcurrentHashMap (Thread Safety)

---

## 📂 Project Structure

```
com.oms.Order_Management_System
│
├── controller        # REST Controllers
├── service           # Business Logic
├── repository        # In-memory storage
├── model             # Order entities & enums
├── util              # File logging utility
├── exception         # Custom exceptions & handlers
└── OrderManagementSystemApplication.java
```

---

## 📌 Features Implemented

### 1️⃣ Accept Orders via REST API

- `POST /orders`
- `GET /orders`

---

### 2️⃣ In-Memory Storage

- Uses `ConcurrentHashMap`
- Thread-safe storage using concurrent collections

---

### 3️⃣ Concurrent Order Processing

- Uses `ExecutorService`
- Orders processed asynchronously
- Simulates background processing

---

### 4️⃣ File Logging

All processed orders are logged into:

```
order-logs.txt
```

---

### 5️⃣ Analytics (Using Java Streams)

The system provides the following analytical endpoints:

- **Total Order Amount**  
  `GET /orders/analytics/total`

- **Total BUY vs SELL Count**  
  `GET /orders/analytics/buy-sell`

- **Top Customer by Volume**  
  `GET /orders/analytics/top-customer`

- **Group Orders by Status**  
  `GET /orders/analytics/group-status`

---

### 6️⃣ Custom Exception Handling

- `InvalidOrderException`
- Global exception handling using `@RestControllerAdvice`

---

## 🧪 API Testing Example

### Create Order

**POST**
```
http://localhost:8080/orders
```

### Sample Request Body

```json
{
  "id": 1,
  "customerName": "Harsh",
  "type": "BUY",
  "price": 100,
  "quantity": 5
}
```

---

## ▶️ How To Run The Project

1. Clone the repository
2. Open in IntelliJ IDEA
3. Ensure Java 21 is configured as Project SDK
4. Run:

```
OrderManagementSystemApplication.java
```

Application starts at:

```
http://localhost:8080
```

---

## 🧠 Concepts Demonstrated

- Spring Boot Auto Configuration
- REST API Development
- Dependency Injection (IoC)
- Thread Safety
- Concurrent Programming
- Java Streams for Data Aggregation
- File Handling
- Layered Architecture Design

