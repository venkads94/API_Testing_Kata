# API Automation Framework (Cucumber + Rest Assured)

This project is an API automation framework built using **Cucumber (v7.0.0)** and **Rest Assured (v5.4.0)**.  
It is developed in **Eclipse IDE** and targets the APIs hosted at:

**Base URI:** `https://automationintesting.online/api`

---

## 📌 Features
- BDD-style test scenarios using **Cucumber**.
- API testing with **Rest Assured**.
- Supports multiple HTTP methods: `GET`, `POST`, `PUT`.
- Easily extendable for additional endpoints.
- Generates Cucumber HTML reports.

---

## 🔧 Dependencies
- Java 11+
- Maven
- Cucumber 7.0.0
- Rest Assured 5.4.0
- JUnit/TestNG (depending on runner configuration)

---

## 🚀 Endpoints Covered
- **Health Check**
  - `GET /booking/actuator/health`
- **Authentication**
  - `POST /auth/login`
- **Create Booking** 
  - `POST /booking`
- **Get Booking by ID**
  - `GET /booking/{bookingId}`
- **Update Booking**
  - `PUT /booking/{bookingId}`

---

## ▶️ How to Run Tests
1. Clone the repository:
   ```bash
   git clone <repo-url>
2. Navigate to project directory:
   cd api-automation-framework
3. Run test using Maven:
   mvn clean test
4. View reports:
   - Reports are generated under target/cucumber-reports.
   
## ✅ Test Execution Results
- **Total Tests Run:** 15  
- **Passes:** 15  
- **Failures:** 0  
- **Skips:** 0  

All tests executed successfully 🎉




