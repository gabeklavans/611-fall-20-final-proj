/**
 * Data manager for the users in the system
 */
public class UserManager extends DataManager<User> {

    public UserManager(String filepath) {
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
     * Register an account with a user, adding it to their list of accounts and
     * adding it to the database entry for that user.
     * 
     * @param user
     * @param acct
     */
    public void registerAccountWithUser(Customer user, Account acct) {
        user.registerNewAccount(acct);
        writeData();
    }

    /**
     * Register a new user to the database.
     * 
     * @param user
     */
    public void registerUser(Customer user) {
        getData().add(user);
        writeData();
    }

}
