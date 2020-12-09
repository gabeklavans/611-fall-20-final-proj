import java.util.ArrayList;

/**
 * A Customer can open either saving or checking account in this bank, and other
 * actions through a User-interface.
 */
public class Customer extends User {
    /** store customer's opened Accounts **/
    private ArrayList<Account> accounts;
    /** all customer's infomation in this bank **/
    private UserData userinfo;
    /** path to access where user's bankAccount info stored **/
    private String filepath;

    /**
     * create an instance of Customer. If the customer is an new customer, the
     * userinfo will be initialized when the customer registered otherwise, the
     * userinfo will be loaded from data file
     * 
     * @param userinfo
     */
    public Customer(UserData userinfo) {
        accounts = new ArrayList<>();
        this.userinfo = userinfo;
        this.filepath = userinfo.getUserName() + "_statement";
        accountDataInitialization();
    }

    /**
     * When the instance of an exiting customer is initialized, scan the account
     * lists to see if the customer has any bank account. If the customer does,
     * initialize the instances of accounts.
     */
    public void accountDataInitialization() {
        // String savingList = userinfo.getSavingAccountList();
        // if (!savingList.equals("N")) {
        // String accounts[] = savingList.split("\\|");
        // for (String s : accounts) {
        // this.savingList.add(s);
        // }
        // }
        // String checkingList = userinfo.getCheckingAccountList();
        // if (!checkingList.equals("N")) {
        // String accounts[] = savingList.split("\\|");
        // for (String s : accounts) {
        // this.checkingList.add(s);
        // }
        // }
        // TODO: after get string info of all bank account, initialize the instance of
        // accounts based
        // on the data from the string Accountlsit
    }

    public UserData getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserData userinfo) {
        this.userinfo = userinfo;
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
