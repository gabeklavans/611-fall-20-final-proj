/**
 * The most basic type of Account. Can be used to store a balance and withdraw/deposit from that balance. No additional functionality is added.
 */
public class CheckingAccount extends Account {

    /**
     * Open a new checking account with a starting balance.
     * 
     * @param startingBalance
     */
    public CheckingAccount(double startingBalance) {
        super(startingBalance);
    }

    /**
     * Load in a pre-existing checking account with its necessary parameters.
     * 
     * @param openDate
     * @param accountNumber
     * @param balance
     * @throws BankException if the open date is in an invalid format
     */
    public CheckingAccount(String openDate, String accountNumber, double balance) throws BankException {
        super(openDate, accountNumber, balance);
    }

}
