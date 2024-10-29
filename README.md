# Banking Transaction API

This project is a simple RESTful banking transactions API that allows users to create accounts, perform fund transfers, and retrieve transaction history. The API is built with **Java Spring Boot** in a three-layered design and includes validation, dependency injection, and data transfer via DTOs (Data Transfer Objects).

## Table of Contents
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [Endpoints](#endpoints)
- [Error Handling](#error-handling)
- [Demo Video](#demo-video)

---

## Project Structure

The project follows a three-layered architecture:
1. **Controller Layer**: Handles HTTP requests and responses.
2. **Service Layer**: Contains the business logic of the application.
3. **Repository Layer**: Manages in-memory storage.

### Folder Breakdown

- `src/main/java/com/example/demo`
  - `controller/`: Contains REST controllers for each resource (Account, Transaction).
  - `service/`: Holds the services implementing the business logic for accounts and transactions.
  - `repository/`: Manages in-memory data storage and data retrieval.
  - `model/`: Contains Java objects (`Account`, `Transaction`) representing the data.
    - `Account.java`: Contains an accountHolderName, an accountId, a balance and a list of transactions
    - `Transaction.java`: Contains a transactionId, a fromAccountId, a toAccountId, a amount(can't be zero) and a timestamp
  - `dto/`: Contains Data Transfer Objects (DTOs) to decouple entity data from the external API.
  
---

## How to Run
To get started,
- Clone the repo
- Go to banking-transaction/demo folder
- Run `mvn clean install` then `mvn compile` finally `mvn spring-boot:run`
- Server will be on `localhost:8080`
- Use postman to send API requests, ex. `POST localhost:8080/api/accounts` See [endpoints](#endpoints) section for details.
- Now you are ready! :)

---

## Endpoints

1. **Create Account**
   - **Endpoint**: `POST /api/accounts`
   - **Description**: Creates a new account with an initial balance. "accountHolderName" field is OPTIONAL.
   - **Request Body**:
     ```json
     {
       "accountHolderName": "Alice",
       "initialBalance": 1000.00
     }
     ```
   - **Response**:
     ```json
     {
       "accountId": 1,
       "accountHolderName": "Alice",
       "initialBalance": 1000.00
     }
     ```

2. **Transfer funds**
   - **Endpoint**: `POST /api/transactions/create`
   - **Description**: Transfering non-zero funds from one valid account to another. Outputs Insufficient funds and invalid account IDs if not successful.
   - **Request Body**:
     ```json
      {
        "fromAccountId": 2,
        "toAccountId": 1,
        "amount": 10.00
      }
     ```
   - **Response**:
     ```
     Transaction processed successfully
     ```

3. **Get Account Transaction History by ID**
   - **Endpoint**: `GET /api/accounts/{accountId}/transactions`
   - **Description**: Retrieves account transaction history by account ID using path variable {accountId}. Both incoming and outcoming transactions will be in the transaction history. The following response will be from accountId 1.
   - **Response**:
     ```json
     [
       {
        "transactionId": "7e228fd8-9c4a-4d9a-941e-de09ddf365e0",
        "fromAccountId": 2,
        "toAccountId": 1,
        "amount": 10.0,
        "timestamp": "2024-10-28T21:06:33.4475234"
        }  
      ]
     ```

4. **List All Accounts**
   - **Endpoint**: `GET /api/accounts`
   - **Description**: Retrieves the list of all accounts for debugging purposes.
   - **Response**:
     ```json
     [
       {
          "accountHolderName": "Alice1",
          "accountId": 1,
          "balance": 1000.0,
          "transactions": []
       },
       {
         "accountHolderName": "Alice2",
         "accountId": 2,
         "initialBalance": 500.00,
         "transactions": []
       }
     ]
     ```
5. **Health Check**
   - **Endpoint**: `Get /api/transactions/transfer`
   - **Description**: Health check for debugging purposes.
   - **Response**:
     ```
     UP
     ```
     
---

## Error Handling

The API gracefully handles errors, providing clear messages and appropriate HTTP status codes:

- **404 Not Found**: 
  - Returned if an account or transaction is not found.

- **400 Bad Request**: 
  - Returned if the request data is invalid, such as when attempting to transfer an amount exceeding the account balance or providing invalid account ids.

---

## Demo Video
Click [HERE](https://youtu.be/1m8l2FI4VLw) to see the demo.
