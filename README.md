# Hotel Management System

This project implements a simple hotel management system using Java for backend logic and MySQL for data storage.

## Features

- Manage rooms: Add, view, update, and delete room information.
- Manage guests: Add, view, update, and delete guest information.
- Manage reservations: Make, view, update, and cancel reservations.
- Data persistence: Uses MySQL database for storing room, guest, and reservation information.

## Setup

### Requirements

- Java Development Kit (JDK)
- MySQL Server
- JDBC Driver for MySQL (included in Maven `pom.xml`)

### Database Setup

1. Create a MySQL database named `hotel_db`.
2. Import the database schema using `hotel_db_schema.sql`.

### Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/hotel-management-system.git
   cd hotel-management-system
Update DB_URL, DB_USER, and DB_PASSWORD in HotelManagementSystemApp.java to match your MySQL configuration.

Compile and run the application:

bash
