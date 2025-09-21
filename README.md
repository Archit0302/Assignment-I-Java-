# Banking Application

This is a simple Java-based Banking Application that allows users to create accounts, deposit money, withdraw money, view account details, and update their contact information. The application simulates a basic banking system with support for multiple accounts, including necessary validation for account creation, deposits, withdrawals, and updates.

## Features

- **Create a New Account**: Allows the user to create a new account by providing a name, email, phone number, and an initial deposit.
- **Deposit Money**: Enables users to deposit a specified amount into their account. It includes validation for positive amounts.
- **Withdraw Money**: Allows users to withdraw money from their account, ensuring they don't withdraw more than the available balance.
- **View Account Details**: Displays the account number, account holder's name, balance, email, and phone number for a specified account.
- **Update Contact Details**: Provides the ability to update an account's email and phone number.
- **Error Handling**: Includes error handling for invalid input such as incorrect account number formats, negative amounts, and invalid email or phone number formats.

## Prerequisites

- Java Development Kit (JDK) version 8 or higher.
- A text editor or an IDE (e.g., IntelliJ IDEA, Eclipse, etc.) to run the application.

## Running the Application

### 1. Compile the Java Code

Make sure you have the Java Development Kit (JDK) installed on your system. Open a terminal or command prompt and navigate to the directory containing the `BankingApplication.java` file.

To compile the code, use the following command:

```bash
javac BankingApplication.java
