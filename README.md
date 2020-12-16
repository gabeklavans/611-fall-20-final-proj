# CS 611 Fall '20 Final Project

## Compilation Instructions
### Compile
    cd src/     // cd to wherever the src folder is from where you are currently
    javac *.java
### Run
In the same folder

    java GUI

## Bank System

All interactions with the backend are performed through the `Bank` class. This is a Singleton Pattern class that maintains a single global instance of the Bank and its `DataManager`s. When the first instance of `Bank` is requested, the constructor loads all the data from the database files into the system. Any objects returned by the `Bank` class's functions are intended as "read-only", or for displaying purposes for the GUI, and any time the client wants to change the state of the system, it should be done through the `Bank` class's methods.

### Data Management
Data managers extend the `DataManager` abstract class. It ensures that there is read/write functionality for whatever kind of data the manager is managing and a way to access the list of objects of that type of data. We have a `DataManager` for `Account`s and for `User`s in the system. This ensures that whenever the backend needs to go to change data in the system, it is always written through. The only time data is loaded from file is on the program's start up (more specifically, upon the instantiation of the global `Bank` singleton object). This ensures consistency between the data in the program and the data on the next load of the file, since the files are overwritten with the entire state of the program every time an interaction occurs.

### Accounts
There are three types of accounts: `CheckingAccount`, `SavingsAccount`, and `LoanAccount`. They all extend the `Account` abstract class, ensuring they have a `Balance` object and methods surrounding basic account info, such as getting the account number (account ID) or depositing/withdrawing from a balance. 

- A checking account simply stores a `Balance` and not much else
- A savings account stores a `Balance` and an `Interest` rate for that account, as well as a minimum balance required to start generating interest (per spec).
- A loan is essentially just an account that also generates interest. It's balance however is not perceived in the same way, as it is an "outstanding" balance that can really only be "withdrawn" from (payed off) but from a data standpoint, the backend doesn't really care about that distinction.

#### Interest
Since both Savings and Loan accounts can generate interest, they implement an `InterestGenerator` interface that specifies the functions for interaction with `Interest`, such as generating the interest and applying it to the balance. `SavingsAccount` and `LoanAccount` each have their own static hard-coded default interest rate for convenience.

#### Transactions
All transactions for an account are logged and stored in the database. There are really only two types of transaction from the ATM's point of view: `WITHDRAWAL` and `DEPOSIT`. Any other higher level of transaction (like a transfer) can be broken down to these. There is of course the opening and closing of the account, but the opening is logged by the open data attribute of the account and once the account is closed, the ATM doesn't really care about the account anymore.

### Currency
Currency in the system is stored in a unified amount, dubbed Unified Internal Value (UIV). To create the facade of multiple currencies, there are different currency types provided by the `Currency` enum class that each have a conversion to UIV (with UIV being 1, as the standard). The class also provides a public static method for `convert`ing between different currencies.

With this design choice, the accounts and balances do not have to worry about what kind of currency is being displayed/inputted at any given moment, as they are all converted to UIV when stored in the system. This allows us to quickly introduce an arbitrary amount of currency types and easily switch between them for the client.

## Customers
`Customer` extends `User` and stores data about the customer, such as name and login info. A customer can log in as a user to the system to see all their accounts and perform actions on them. We have abstracted the data for a `User` into the `UserData` class for tidiness.
