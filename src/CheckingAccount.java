import java.util.ArrayList;

/**
 * The most basic type of Account. Can be used to store a balance and
 * withdraw/deposit from that balance. No additional functionality is added.
 */
public class CheckingAccount extends Account {

    /**
     * Open a new checking account with a starting balance.
     * 
     * @param startingBalance
     */
    public CheckingAccount(double startingBalance, Currency type) {
        super(startingBalance, type, "C");
    }

    /**
     * Private constructor for loading a Checking Account.
     */
    private CheckingAccount(String openDate, String accountNumber, double balance, ArrayList<Transaction> transactions)
            throws BankException {
        super(openDate, accountNumber, balance, transactions);
    }

    /**
     * Load in a pre-existing checking account with its necessary parameters.
     * 
     * @param openDate
     * @param accountNumber
     * @param balance
     * @param transactions  The list of transactions this account kept track of
     * @throws BankException if the open date is in an invalid format
     */
    public static CheckingAccount loadAccount(String openDate, String accountNumber, double balance,
            ArrayList<Transaction> transactions) throws BankException {
        return new CheckingAccount(openDate, accountNumber, balance, transactions);
    }

    @Override
    public String getAccountInfo() {
        return getOpenDate() + "," + getAccountNumber() + "," + String.valueOf(getBalance(Currency.UIV));
    }
}
