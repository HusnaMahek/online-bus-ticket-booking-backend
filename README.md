# Online Bus Ticket Booking Backend

This is a backend project for an online bus ticket booking system.

I built this project using Java and Spring Boot to practise creating REST APIs, connecting a database, and handling booking-related operations.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Postman

## Features

- Add a new bus
- View all buses
- Search buses by source and destination
- Book a seat
- Check available seats
- Prevent booking the same seat twice on the same bus
- View all bookings
- Cancel a booking

## API Endpoints

### Bus APIs

`POST /buses` - Add a new bus.

`GET /buses` - Get all buses.

`GET /buses/search?source=Hyderabad&destination=Warangal` - Search for buses between two locations.

`GET /buses/{busId}/available-seats` - View the available seats for a bus.

### Booking APIs

`POST /bookings` - Create a new booking.

Example:

```json
{
  "passengerName": "Ali",
  "busId": 1,
  "seatNumber": 5
}
GET /bookings - View all bookings.

DELETE /bookings/{id} - Cancel a booking.

HOW TO RUN:
Clone this repository.
Open the project in IntelliJ IDEA.
Make sure Java is installed.
Run BusBookingBackendApplication.
The application runs on http://localhost:8080.

The APIs can be tested using Postman.
What I Learned

While working on this project, I got hands-on practice with Spring Boot, REST APIs, layered backend architecture, JPA, database operations, and handling basic booking logic.

This project is part of my learning journey in Java backend development.
