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

}
