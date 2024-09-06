**Customer Rewards Management API**
This is a Spring Boot application that provides a simple API for managing customer rewards and cashback history. The API allows customers to retrieve their current cashback balance and view their cashback transaction history. Swagger UI is used to document and test the API endpoints.

**Table of Contents**
Features
Technologies
Installation
Database Configuration
Running the Application
Database Initialization
Swagger API Documentation
API Endpoints
Get Customer Reward Balance
Get Customer Cashback History
Error Handling


**Features**
Retrieve the total cashback and current balance for a customer.
View the list of cashback transactions for a customer.
Technologies
Java 21
Spring Boot
Spring Data JPA (MySQL database)
Swagger (for API documentation)

**Installation**
Prerequisites
Java 21 or higher
Maven
MySQL (or a MySQL-compatible database)
IDE 


**Steps to Set Up the Project**
1. Clone the repository:
git clone https://github.com/Popsyynn/CustomerRewardsApi.git

2.Navigate to the project directory:
cd CustomerRewardsApi

3.Build the project using Maven:
mvn clean install

4.Database Configuration
This project uses a MySQL database. The database parameters such as the URL, username, and password are configured using environment variables. Ensure that you set the following environment variables before running the application:

db_url: The URL of your MySQL database (e.g., jdbc:mysql://localhost:3306/customer).
db_username: The username for your MySQL database.
db_password: The password for your MySQL database.

For example, you can set these variables in your terminal or configure them in your IntelliJ IDE:


5.Running the Application
Once the environment variables are set, you can run the application using:

mvn spring-boot:run
The application will now connect to the MySQL database using the provided credentials.

**Database Initialization**
Sample data is automatically inserted into the database using the @PostConstruct annotation in the main. This means that when the application starts, it will execute a method annotated with @PostConstruct to send some sample data to the database. This allows you to test the API endpoints without manually adding data.

Note: Ensure that your database is properly configured and accessible to allow the application to insert the sample data.

**Swagger API Documentation**
This project uses Swagger to document and test the API. You can access the Swagger UI at:

http://localhost:8181/swagger-ui.html
The Swagger UI provides an interactive interface to test the API endpoints. You can view detailed information about the endpoints, including the request methods, parameters, and response formats.

**API Endpoints**
Get Customer Reward Balance
Endpoint: /api/rewards/balance/{customerId}
Request Type: GET
Description: Retrieve the total cashback and current balance for a specific customer.
Request Parameters:
customerId (path parameter): The ID of the customer.
Response:
Success (302 FOUND): A JSON object containing customerId, totalCashback, and currentBalance.
Error (404 NOT FOUND): If the customer ID is not found.
Example Request:

GET /api/rewards/balance/1
Example Response:

json
{
  "customerId": 1,
  "totalCashback": 500.0,
  "currentBalance": 200.0
}

Get Customer Cashback History
Endpoint: /api/rewards/history/{customerId}
Request Type: GET
Description: Retrieve a list of cashback transactions for a specific customer.
Request Parameters:
customerId (path parameter): The ID of the customer.
Response:
Success (302 FOUND): A JSON array of cashback transactions, each containing transactionId, transactionDate, amountEarned, and description.
Error (404 NOT FOUND): If the customer ID is not found.
Example Request:

GET /api/rewards/history/1
Example Response:

json
[
  {
    "transactionId": 1001,
    "transactionDate": "2023-08-25",
    "amountEarned": 100.0,
    "description": "Booking cashback"
  },
  {
    "transactionId": 1002,
    "transactionDate": "2023-08-20",
    "amountEarned": 50.0,
    "description": "Shopping cashback"
  }
]
Error Handling
If a customer is not found, the API will return an appropriate 404 NOT FOUND response with an error message.
