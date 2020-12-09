/**
 * Data manager for Accounts in the system
 */
public class AccountManager extends DataManager<Account> {

    public AccountManager(String filepath) {
        super(filepath);
    }

    @Override
    public void loadData() {
        // TODO Auto-generated method stub

    }

    @Override
    public void writeData() {
        // TODO Auto-generated method stub

    }

    /**
     * Add an account to the database.
     * 
     * @param acct
     */
    public void addAccount(Account acct) {
        getData().add(acct);
        writeData();
    }

    /**
     * 
     * @param acct to subtract from
     * @param amt  to subtract
     * @param type of currency the amount is in
     * @return the new balance in the unit of currency specified
     * @throws BankException
     */
    public double subtractBalance(Account acct, double amt, Currency type) throws BankException {
        acct.withdraw(amt, type);

        writeData();

        return acct.getBalance(type);
    }

    /**
     * 
     * @param acct to add to
     * @param amt  to add
     * @param type of currency the amount is in
     * @return the new balance in the unit of currency specified
     * @throws BankException
     */
    public double addBalance(Account acct, double amt, Currency type) throws BankException {
        acct.deposit(amt, type);

        writeData();

        return acct.getBalance(type);
    }

}
