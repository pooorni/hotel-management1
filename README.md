# Hotel Room Booking System — Backend (Java + JDBC + MySQL)

This is a small console-based backend. It creates its own database and tables on first run, so it does not depend on the earlier database table structure.


## Included features
- Customer add, list and search
- Room add, list and available-room list
- Room maintenance/available status update via service method
- Booking creation with date validation, room availability checking and total calculation
- Booking list and cancellation
- JDBC connection and automatic schema initialization

## Requirements
- Java 17 or newer
- MySQL Server running
- Maven (VS Code can use its Java/Maven extensions)

## MySQL login configuration
Open `src/main/resources/application.properties` and check the settings:
- username defaults to `root`
- password defaults to blank
If your MySQL root account has a password, fill `db.password=` with your password. Do not share your password in screenshots.

## Run
From the project folder, in a terminal:

```bash
mvn compile
mvn exec:java
```
The first run creates database `hotel_booking_system` and tables automatically.

## Menu
1 Add customer
2 List customers
3 Search customer
4 Add room
5 List rooms
6 Available rooms
7 Book room
8 List bookings
9 Cancel booking
0 Exit

Booking dates use `YYYY-MM-DD`. Check-out date must be after check-in. Room availability is checked for overlapping confirmed bookings. Booking total is room price multiplied by nights.

