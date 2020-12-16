import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * An Account stores a Balance that represents the value of this account in UIV.
 * Can be used to add or subtract from its Balance.
 */
public abstract class Account {

    // TODO: track all the transactions in an account

    /* Specifies the types of accounts that can be created */
    public enum Type {
        CHECKING, SAVINGS, LOAN;
    }

    private Date openDate;
    private String accountNumber;
    private Balance balance;
    private ArrayList<Transaction> transactions;

    /**
     * Create a new account with a starting balance.
     * 
     * @param startingBalance
     * @param type            of currency the starting balance is in terms of
     * @param accountType     NOTE: used as an easier way to store account type
     */
    public Account(double startingBalance, Currency type, String accountType) {
        balance = new Balance(startingBalance, type);
        openDate = new Date();
        transactions = new ArrayList<>();
        accountNumber = accountType + UUID.randomUUID().toString();
    }

    /**
     * Load an existing account with its relevant parameters.
     * 
     * @param openDate
     * @param accountNumber
     * @param balance       in UIV, as it's stored in the database
     * @throws BankException
     */
    public Account(String openDate, String accountNumber, double balance, ArrayList<Transaction> transactions)
            throws BankException {
        try {
            this.openDate = Bank.DATE_FORMAT.parse(openDate);
        } catch (ParseException e) {
            throw new BankException("Invalid account open date format.", e);
        }
        this.accountNumber = accountNumber;
        this.balance = new Balance(balance, Currency.UIV);
        this.transactions = transactions;
    }

    /**
     * 
     * @param type The unit of currency to return the balance amount in
     * @return The balance amount
     */
    public double getBalance(Currency type) {
        return balance.getBalance(type);
    }

    /**
     * Deposit money into the account's balance.
     * 
     * @param amt  to deposit
     * @param type of currency the amount is specified in
     * @return The new balance after the deposit
     */
    public double deposit(double amt, Currency type) {
        if (amt < 0) {
            return balance.getBalance(type);
        }
        Transaction trx = new Transaction(Transaction.Type.DEPOSIT, amt, type);
        transactions.add(trx);
        return balance.deposit(amt, type);
    }

    /**
     * Withdraw money from the account's balance.
     * 
     * @param amt  to withdraw
     * @param type of currency the amount is specified in
     * @return The new balance after the withdrawal
     * @throws BankException if the account's balance is too low to make the
     *                       withdrawal
     */
    public double withdraw(double amt, Currency type) throws BankException {
        if (amt < 0) {
            return balance.getBalance(type);
        }
        if (this instanceof LoanAccount) {
            Transaction trx = new Transaction(Transaction.Type.PAYMENT, amt, type);
            transactions.add(trx);
        } else {
            Transaction trx = new Transaction(Transaction.Type.WITHDRAWAL, amt, type);
            transactions.add(trx);
        }
        return balance.withdraw(amt, type);
    }

    /**
     * Add a transaction to this account's list of transactions.
     * 
     * @param transaction
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Date getOpenDate() {
        return openDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public abstract String getAccountInfo();

}
