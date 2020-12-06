import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * An Account stores a Balance that represents the value of this account in UIV.
 * Can be used to add or subtract from its Balance.
 */
public abstract class Account {

    private Date openDate;
    private String accountNumber;
    private Balance balance;

    /**
     * Create a new account with a starting balance.
     * 
     * @param startingBalance
     */
    public Account(double startingBalance) {
        balance = new Balance(startingBalance);
        openDate = new Date();
        accountNumber = UUID.randomUUID().toString();
    }

    /**
     * Load an existing account with its relevant parameters.
     * 
     * @param openDate
     * @param accountNumber
     * @param balance
     * @throws BankException
     */
    public Account(String openDate, String accountNumber, double balance) throws BankException {
        try {
            this.openDate = new SimpleDateFormat("MM/dd/yyyy").parse(openDate);
        } catch (ParseException e) {
            throw new BankException("Invalid account open date format.", e);
        }
        this.accountNumber = accountNumber;
        this.balance = new Balance(balance);
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
        return balance.withdraw(amt, type);
    }
}
