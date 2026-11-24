-- This is also created automatically on first application run.
CREATE DATABASE IF NOT EXISTS hotel_booking_system;
USE hotel_booking_system;
CREATE TABLE IF NOT EXISTS customers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  phone VARCHAR(25) NOT NULL,
  email VARCHAR(120)
);
CREATE TABLE IF NOT EXISTS rooms (
  id INT AUTO_INCREMENT PRIMARY KEY,
  room_number VARCHAR(20) NOT NULL UNIQUE,
  room_type VARCHAR(50) NOT NULL,
  price_per_night DECIMAL(10,2) NOT NULL,
  status VARCHAR(20) NOT NULL DEFAULT 'AVAILABLE'
);
CREATE TABLE IF NOT EXISTS bookings (
  id INT AUTO_INCREMENT PRIMARY KEY,
  customer_id INT NOT NULL,
  room_id INT NOT NULL,
  check_in DATE NOT NULL,
  check_out DATE NOT NULL,
  total_amount DECIMAL(10,2) NOT NULL,
  status VARCHAR(20) NOT NULL DEFAULT 'CONFIRMED',
  CONSTRAINT fk_booking_customer FOREIGN KEY(customer_id) REFERENCES customers(id),
  CONSTRAINT fk_booking_room FOREIGN KEY(room_id) REFERENCES rooms(id)
);
