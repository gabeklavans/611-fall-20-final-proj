import java.util.ArrayList;

/**
 * The central, global, Singleton class that serves as the initial access point
 * to all the data in the Bank.
 */
public class Bank {

    /** The authoritative global instance of the Bank */
    private static Bank bankManager;

    private static final String ACCOUNTS_FILEPATH = "path/to/file";
    private static final String USERS_FILEPATH = "path/to/file";

    private AccountManager accountsManager;
    private UserManager usersManager;

    private Bank(String accountsFilepath, String usersFilepath) {
        accountsManager = new AccountManager(accountsFilepath);
        usersManager = new UserManager(usersFilepath);
    }

    /**
     * 
     * @return an instance of the Bank, creating one if it does not exist yet
     */
    public static Bank getBank() {
        if (bankManager == null) {
            bankManager = new Bank(ACCOUNTS_FILEPATH, USERS_FILEPATH);
        }
        return bankManager;
    }

    /**
     * 
     * @return a deep copy of the list of accounts in the system
     */
    public ArrayList<Account> getAccounts() {
        return accountsManager.getData();
    }

    /**
     * 
     * @return a deep copy of the list of users in the system
     */
    public ArrayList<User> getUsers() {
        return usersManager.getData();
    }

    /**
     * Open a new checking account with a user.
     * 
     * @param user
     * @param accountBalance
     * @param type           of currency
     * @return True if the account was successfully created
     */
    public boolean openCheckingAccount(Customer user, double accountBalance, Currency type) {
        CheckingAccount newAccount = new CheckingAccount(accountBalance, type);

        accountsManager.addAccount(newAccount);
        usersManager.registerAccountWithUser(user, newAccount);

        return true;
    }

    /**
     * Open a new Savings account with a user.
     * 
     * @param user
     * @param accountBalance
     * @param type                       of currency
     * @param interestBalanceRequirement
     * @return True if the account was successfully created
     */
    public boolean openSavingsAccount(Customer user, double accountBalance, Currency type,
            double interestBalanceRequirement) {
        SavingsAccount newAccount = new SavingsAccount(accountBalance, type, interestBalanceRequirement);

        accountsManager.addAccount(newAccount);
        usersManager.registerAccountWithUser(user, newAccount);

        return true;
    }

    /**
     * Open a new Savings account with a user.
     * 
     * @param user
     * @param accountBalance
     * @param type                       of currency
     * @param interestRate
     * @param interestBalanceRequirement
     * @return True if the account was successfully created
     */
    public boolean openSavingsAccount(Customer user, double accountBalance, Currency type, double interestRate,
            double interestBalanceRequirement) {
        SavingsAccount newAccount = new SavingsAccount(accountBalance, interestRate, type, interestBalanceRequirement);

        accountsManager.addAccount(newAccount);
        usersManager.registerAccountWithUser(user, newAccount);

        return true;
    }

    /**
     * Take out a Loan with the default interest rate and open a LoanAccount for
     * this user.
     * 
     * @param user
     * @param loanAmount
     * @param type       of currency
     * @return True if the account was successfully created
     */
    public boolean openLoan(Customer user, double loanAmount, Currency type) {
        LoanAccount newAccount = new LoanAccount(loanAmount, type);

        accountsManager.addAccount(newAccount);
        usersManager.registerAccountWithUser(user, newAccount);

        return true;
    }

    /**
     * Take out a Loan with the default interest rate and open a LoanAccount for
     * this user.
     * 
     * @param user
     * @param loanAmount
     * @param interestRate
     * @param type         of currency
     * @return True if the account was successfully created
     */
    public boolean openLoan(Customer user, double loanAmount, double interestRate, Currency type) {
        LoanAccount newAccount = new LoanAccount(loanAmount, interestRate, type);

        accountsManager.addAccount(newAccount);
        usersManager.registerAccountWithUser(user, newAccount);

        return true;
    }

}
