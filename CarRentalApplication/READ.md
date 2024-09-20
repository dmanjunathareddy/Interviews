# Car Rental Application
## Overview
This is a simple car rental application that allows users to rent cars and calculate the rental cost based on the number of days and the car's rate structure.
The application uses Spring Boot and provides an API to calculate the total rental cost for a given car and rental duration.
## Features
- **Car Management**: Manage different cars with their details such as model, make, and rental rate.
- **Rate Management**: Associate dynamic rates with cars based on the duration of the rental.
- **Rental Cost Calculation**: Calculate rental costs dynamically based on how many days the car is rented for and the corresponding rate range.
## Technologies Used
- **Spring Boot**: Backend framework.
- **Hibernate**: ORM for database interactions.
- **H2 Database**: In-memory database for development and testing.
- **Java 8**: Programming language.
## API Endpoints
- `GET /rental/cost/{carId}/{days}`: Calculate the rental cost for a car based on the given number of rental days.

## Sample Data
- **Car**:
    - **Alto**: ₹2,000 per day (fixed).
    - **Swift**:
        - ₹4,000 per day (1-6 days),
        - ₹3,000 per day (7-15 days),
        - ₹2,500 per day (more than 15 days).
    - **Innova**:
        - ₹10,000 per day (1-6 days),
        - ₹8,000 per day (7-30 days),
        - ₹6,000 per day (31-50 days),
        - ₹5,000 per day (more than 50 days).
- `POST /rate/add`
- **Request Body**:
```json
{
  "carModel": "Swift",
  "rateRanges": [
    {
      "minDays": 1,
      "maxDays": 6,
      "rate": 4000
    },
    {
      "minDays": 7,
      "maxDays": 14,
      "rate": 3000
    },
    {
      "minDays": 15,
      "maxDays": 1000000,
      "rate": 2500
    }
  ]
}
## Upcoming Features
- **Customer Management**: Add, update, and track customers and their rental history.
- **Payment Integration**: Integrate online payment gateways for processing payments.
- **Car Availability Tracking**: Ensure availability of cars based on reservations and dates.
- **Discounts**: Implement discount mechanisms for long-term rentals or special promotions.