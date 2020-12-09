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

}
