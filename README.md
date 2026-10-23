# Bank Account Simulation

A console-based banking simulation built using Core Java. It demonstrates object-oriented programming, methods, input validation, and an `ArrayList`-based transaction history.

## Features
- Create an account with account holder name and initial balance
- Deposit money and withdraw when sufficient balance is available
- Check account holder and current balance
- View transaction history
- Validate empty names, invalid menu choices, non-numeric input, zero/negative transaction amounts, and invalid initial balances

## Technologies
- Java (JDK 8 or later)
- Core Java and OOP
- `ArrayList` / `List`
- `Scanner` for console input

## Project files
- `Main.java` — menu, user input, and application flow
- `BankAccount.java` — account details, deposit/withdraw operations, balance, and transaction history

## How to run
1. Open this folder in VS Code or a terminal.
2. Make sure Java JDK is installed.
3. Compile:
   ```bash
   javac Main.java BankAccount.java
   ```
4. Run:
   ```bash
   java Main
   ```

## Note
This is an educational console project. It does not connect to a real bank or store account data permanently.
