import java.util.ArrayList;

/**
 * A Customer can open either saving or checking account in this bank, and
 * other actions through a User-interface.
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

    /**
     * 
     * @param accountBalance
     * @param type           of currency
     */
    public void openCheckingAccount(double accountBalance, Currency type) {
        CheckingAccount newAccount = new CheckingAccount(accountBalance, type);

        accounts.add(newAccount);

        // String testAccount = "S002";
        // String directory = this.filepath;
        // String testSt = "2020_3_20-transfer To C003-400 UIV";
        // ArrayList<String> state = new ArrayList<>();
        // state.add(testSt);
        // BankSystem.saveUserAccountStatement(directory, testAccount, state);
    }

    /**
     * Open a new Savings Account with the default interest rate.
     * 
     * @param accountBalance
     * @param type                       of currency
     * @param interestBalanceRequirement
     */
    public void openSavingsAccount(double accountBalance, Currency type, double interestBalanceRequirement) {
        SavingsAccount newAccount = new SavingsAccount(accountBalance, type, interestBalanceRequirement);

        accounts.add(newAccount);
    }

    /**
     * Open a new Savings Account with specified interest rate.
     * 
     * @param accountBalance
     * @param type                       of currency that the balance AND interest
     *                                   rate are in
     * @param interestRate
     * @param interestBalanceRequirement
     */
    public void openSavingsAccount(double accountBalance, Currency type, double interestRate,
            double interestBalanceRequirement) {
        SavingsAccount newAccount = new SavingsAccount(accountBalance, interestRate, type, interestBalanceRequirement);

        accounts.add(newAccount);
    }

    /**
     * Take out a Loan with the default interest rate and open a LoanAccount for
     * this user.
     * 
     * @param loanAmount
     * @param type       of currency
     */
    public void takeOutLoan(double loanAmount, Currency type) {
        LoanAccount newLoan = new LoanAccount(loanAmount, type);

        accounts.add(newLoan);
    }

    /**
     * Take out a Loan with specified interest rate and open a LoanAccount for this
     * user.
     * 
     * @param loanAmount
     * @param interestRate
     * @param type         of currency that the loan amount AND interest rate are in
     */
    public void takeOutLoan(double loanAmount, double interestRate, Currency type) {
        LoanAccount newLoan = new LoanAccount(loanAmount, interestRate, type);

        accounts.add(newLoan);
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

}
