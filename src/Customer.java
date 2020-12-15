import java.util.ArrayList;

/**
 * A Customer can open either saving or checking account in this bank, and other
 * actions through a User-interface.
 */
public class Customer extends User {
    /** store customer's opened Accounts **/
    private ArrayList<Account> accounts;

    /**
     * create an instance of Customer. If the customer is an new customer, the
     * userinfo will be initialized when the customer registered otherwise, the
     * userinfo will be loaded from data file
     * 
     * @param userData
     */
    public Customer(UserData userData) {
        super(userData);
        accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * Add an account to this user's registered list of accounts.
     * 
     * @param acct to register
     */
    public void registerNewAccount(Account acct) {
        accounts.add(acct);
    }

}
