# 🏥 Healthcare Patient Monitoring Dashboard

## 📊 My Contribution – Database Module (JDBC & MySQL)
Name - Kavyansh Vats
Reg no. - 23BCE10301
---

## 📌 Project Overview (Group no. 2)

The **Healthcare Patient Monitoring Dashboard** is a software application developed to monitor and manage patient health data efficiently. The system is designed to store, process, and analyze vital health parameters such as heart rate, blood pressure, and body temperature.

This project uses **Java (JDBC)** and **MySQL** to create a reliable backend system that supports real-time data handling. The application enables healthcare professionals to track patient conditions and identify abnormal health situations through an automated alert mechanism.

The database module plays a crucial role in ensuring structured data storage, fast retrieval, and seamless integration with the application. It also supports the generation of alerts when patient health parameters exceed normal thresholds, thereby assisting in timely medical intervention.

Overall, the project demonstrates the use of Advanced Java concepts and database management techniques to build a practical healthcare monitoring system.

---

## 👤 Team Member Role

**Database Developer**

---

## 🎯 Objective

The objective of this module is to design and implement a robust database system for storing and managing patient health data. It ensures efficient data storage, retrieval, and alert generation using MySQL and JDBC.

---

## 🗄️ Database Design

### 📌 Database Name:

`healthcare_dashboard`

### 📋 Tables Created:

1. **patients**

   * Stores patient basic details
   * Fields: patient_id, name, age, gender, contact

2. **health_data**

   * Stores patient health readings
   * Fields: record_id, patient_id, heart_rate, blood_pressure, temperature, recorded_at

3. **alerts**

   * Stores abnormal health alerts
   * Fields: alert_id, patient_id, alert_message, alert_time

---

## ⚙️ Technologies Used

* Java (Core + Advanced)
* JDBC (Java Database Connectivity)
* MySQL
* SQL (DDL & DML)

---

## 🔗 JDBC Integration

The database is connected to Java using JDBC. A connection class (`DBConnection.java`) is used to establish communication between the application and MySQL database.

---

## 🔁 Functionalities Implemented

### ✅ 1. Database Connectivity

* Successfully connected Java application to MySQL database using JDBC

### ✅ 2. Data Insertion

* Inserted patient details using Java
* Inserted health data dynamically

### ✅ 3. Data Retrieval

* Retrieved patient records using SQL queries in Java
* Displayed data in console output

### ✅ 4. Alert System 🚨

* Implemented logic to detect abnormal conditions:

  * Heart Rate > 120 or < 60
  * Temperature > 38°C
* Automatically stores alerts in database

---

## 🧪 Sample Output

* Successful connection message
* Inserted patient records
* Retrieved patient data
* Generated alerts for abnormal conditions

---

## 📂 Project Structure

```
Healthcare-Dashboard/
│
├── src/
│   ├── DBConnection.java
│   ├── TestConnection.java
│   ├── InsertPatient.java
│   ├── InsertHealthData.java
│   ├── FetchPatients.java
│   ├── FetchAlerts.java
│
├── lib/
│   └── mysql-connector-j-9.6.0.jar
```

---

## 🚀 How to Run

1. Compile all files:

```
javac -cp ".;lib/mysql-connector-j-9.6.0.jar" src/*.java
```

2. Run:

```
java -cp ".;lib/mysql-connector-j-9.6.0.jar;src" TestConnection
```

---

## 🧠 Concepts Used

* JDBC Connectivity
* SQL Queries (CREATE, INSERT, SELECT)
* Exception Handling
* OOP Concepts (Classes & Methods)
* Conditional Logic (Alert Generation)

---

## 🎯 Outcome

* Developed a functional database system for healthcare monitoring
* Achieved real-time data handling using Java and MySQL
* Implemented an alert system for abnormal health conditions

---

## ✅ Conclusion

The database module successfully manages patient data and ensures real-time monitoring through alert generation. This module forms the backbone of the Healthcare Patient Monitoring Dashboard.

---

## 🔥 Contribution Summary

✔ Designed database schema
✔ Created and managed MySQL database
✔ Implemented JDBC connection
✔ Developed data insertion and retrieval system
✔ Implemented alert generation logic

---
