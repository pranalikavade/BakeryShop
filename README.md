# 🍰 Online Bakery Shop – Java Console Project


A Java-based console application that simulates a real-world **bakery inventory and order management system**.
Users can register, view bakery products, place orders, and view their order history. Admin users can add and manage bakery items.
This project is built using **Core Java**, **JDBC**, **PostgreSQL**, and **Maven** in a clean multi-package architecture.

---

## ✨ Features

- 👤 Customer Registration & Management
- 
- 🍩 View Available Bakery Products
- 
- 🛒 Place New Orders
- 
- 📜 View Order History
- 
- 🧾 Admin Options – Add New Products, Manage Stock
- 
- 📋 Menu-Driven Console Interface
- 
- 🔐 Role-Based Access (Admin/User)
- 
- ✅ Stock Quantity Check Before Order
- 
- 💬 Confirmation & Error Messages

---

## 💻 Technologies Used

| Technology      | Purpose                          |
|-----------------|----------------------------------|
| ☕ Core Java     | OOP Concepts, Multithreading     |
| 🔌 JDBC          | Java Database Connectivity       |
| 🗄️ PostgreSQL    | Relational Database              |
| 📦 Maven         | Build & Dependency Management   |
| 🧠 Eclipse IDE   | Development Environment          |

---
✅ Functionalities

👤 User & Admin Actions

Register new customer

View bakery product catalog

Place order (with quantity & stock validation)

View past orders by customer

Admin can add new products

Admin can manage inventory

___________________________________________
⚙️ Prerequisites

Java JDK 17+

Apache Maven

PostgreSQL 14+

Eclipse / IntelliJ IDE

____________________________________________


## 📦 Maven Dependencies

```
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.1</version>
</dependency>

_____________________________________________________________________________________

Schema
______________________________________________________________________________________

CREATE TABLE customers (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  phone VARCHAR(20)
);

CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  price NUMERIC(10, 2) NOT NULL,
  stock INT NOT NULL
);

CREATE TABLE orders (
  id SERIAL PRIMARY KEY,
  customer_id INT REFERENCES customers(id),
  product_id INT REFERENCES products(id),
  quantity INT,
  order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

 Sample data
INSERT INTO customers(name, phone) VALUES ('Ravi Kumar', '9876543210');
INSERT INTO products(name, price, stock) VALUES ('Chocolate Cake', 450.0, 10);

____________________________________________________________________________________
```
📸 Sample Console Output
_____________________________________________________________________
==== Welcome to Online Bakery Shop ====

📋 Main Menu:
1. View Products
2. Add Product
3. View Customers
4. Add Customer
5. Place Order
6. View All Orders
7. Exit
Select option:
____________________________________________________________________

