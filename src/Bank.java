import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * The central, global, Singleton class that serves as the initial access point
 * to all the data in the Bank. The fee rates do NOT change with respect the
 * currency. If you don't like it, get a different currency!
 */
public class Bank {

    /** The authoritative global instance of the Bank */
    private static Bank bankManager;
    /** Rate charged to the intended deposit amount */
    private static final double depositFeeRate = 0.1;
    /** Rate charged to the intended withdrawal amount */
    private static final double withdrawalFeeRate = 0.1;
    /** Rate charged to the starting balance of a new savings/checking account */
    private static final double openAccountFeeRate = 0.1;

    private static final String ACCOUNTS_FILEPATH = "Customers";
    private static final String USERS_FILEPATH = "Customers";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yy/hh:mm:ss");
    /**
     * Default minimum balance required to start generating interest in a Savings
     * Account. It is very reasonable.
     */
    public static final double MINIMUM_BALANCE_FOR_INTEREST = 100000000.00;

    private AccountManager accountsManager;
    private UserManager usersManager;

    private Bank(String accountsFilepath, String usersFilepath) throws BankException {
        accountsManager = new AccountManager(accountsFilepath);
        usersManager = new UserManager(usersFilepath);

        // Register all the accounts for each user to that user initially
        for (User user : usersManager.getData()) {
            if (user instanceof Customer) {
                for (String accountId : user.getUserData().getAccountList().split("/")) {
                    if (accountId.equals("")) {
                        continue;
                    }
                    Account acct = accountsManager.getAccount(accountId);
                    Customer customer = (Customer) user;
                    customer.getAccounts().add(acct); // don't do this anywhere else...
                }
            }
        }
    }

    /**
     * 
     * @return an instance of the Bank, creating one if it does not exist yet
     * @throws BankException
     */
    public static Bank getBank() throws BankException {
        if (bankManager == null) {
            bankManager = new Bank(ACCOUNTS_FILEPATH, USERS_FILEPATH);
        }
        return bankManager;
    }

    /**
     * 
     * @param username
     * @param password
     * @return True if the username existed and the password was correct (successful
     *         login)
     */
    public boolean login(String username, String password) {
        User user = usersManager.getUser(username);
        return user.getUserData().getLoginPassword().equals(password);
    }

    /**
     * Create a new Customer user in the system.
     * 
     * @param username
     * @param password
     * @param collateral that the user is putting up to open their login account
     * @return The newly created user
     */
    public User registerNewCustomer(String username, String password, String collateral) {
        UserData userData = new UserData(username, password, "", collateral);
        Customer newCustomer = new Customer(userData);
        usersManager.registerUser(newCustomer);
        return newCustomer;
    }

    /**
     * 
     * @return a deep copy (read-only) of the list of accounts in the system
     */
    public ArrayList<Account> getAccounts() {
        return new ArrayList<Account>(accountsManager.getData());
    }

    /**
     * 
     * @return a deep copy (read-only) of the list of users in the system
     */
    public ArrayList<User> getUsers() {
        return new ArrayList<User>(usersManager.getData());
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
        double actualStartingBalance = accountBalance - (accountBalance * openAccountFeeRate);
        CheckingAccount newAccount = new CheckingAccount(actualStartingBalance, type);

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
     * @apiNote see SavingsAccount class for default interest rate
     */
    public boolean openSavingsAccount(Customer user, double accountBalance, Currency type, double interestRate,
            double interestBalanceRequirement) {
        double actualStartingBalance = accountBalance - (accountBalance * openAccountFeeRate);
        SavingsAccount newAccount = new SavingsAccount(actualStartingBalance, interestRate, type,
                interestBalanceRequirement);

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
     * @apiNote see LoanAccount class for default interest rate
     */
    public boolean openLoan(Customer user, double loanAmount, double interestRate, Currency type) {
        LoanAccount newAccount = new LoanAccount(loanAmount, interestRate, type);

        accountsManager.addAccount(newAccount);
        usersManager.registerAccountWithUser(user, newAccount);

        return true;
    }

    /**
     * 
     * @param acct
     * @param amt  the amount to deposit before fees
     * @param type of currency
     * @return the new balance
     * @throws BankException
     */
    public double depositMoney(Account acct, double amt, Currency type) throws BankException {
        if (acct instanceof LoanAccount) {
            throw new BankException("You cannot deposit money into a Loan");
        }

        double amountToActuallyAdd = amt - (amt * depositFeeRate);
        return accountsManager.addBalance(acct, amountToActuallyAdd, type);
    }

    /**
     * 
     * @param acct
     * @param amt  the amount to withdraw before fees
     * @param type of currency
     * @return the new balance
     * @throws BankException
     */
    public double withdrawMoney(Account acct, double amt, Currency type) throws BankException {
        if (acct instanceof LoanAccount) {
            throw new BankException("You cannot withdraw money from a Loan");
        }

        double amountToActuallySubtract = amt + (amt * withdrawalFeeRate);
        return accountsManager.subtractBalance(acct, amountToActuallySubtract, type);
    }

    /**
     * Subtract an amount from the outstanding balance of a Loan.
     * 
     * @param loanAcct
     * @param amt      to subtract from the outstanding balance
     * @param type     of currency
     * @return
     * @throws BankException
     */
    public double payLoan(Account loanAcct, double amt, Currency type) throws BankException {
        if (!(loanAcct instanceof LoanAccount)) {
            throw new BankException("You cannot make a loan payment on a non-loan account");
        }

        return accountsManager.subtractBalance(loanAcct, amt, type);
    }

    /**
     * Generate the interest for all accounts in the system based on their
     * individual interest rates
     */
    public void generateInterest() {
        for (Account account : accountsManager.getData()) {
            if (account instanceof InterestGenerator) {
                ((InterestGenerator) account).generateInterest();
            }
        }
    }

}
