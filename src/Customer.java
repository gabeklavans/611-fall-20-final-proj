import java.util.ArrayList;
import java.util.Date;

/**
 * An Customer can open either saving or checking account in this bank, and other actions through
 * an User-interface.
 */



public class Customer extends User{
    private ArrayList<Account> savingAccountList = new ArrayList<>(); /** store customer's all saving Account **/
    private ArrayList<Account> checkingAccountList = new ArrayList<>(); /** store customer's all checking Account **/
    private ArrayList<String> savingList = new ArrayList<>();/** each saving Account data will be converted to a string so that the data can be stored into data file
                                                                Ex. AccountNumber - Balance - openDate **/
    private ArrayList<String> checkingtList = new ArrayList<>();
    private int loan; /** maybe need a class for loan **/
    private UserData userinfo; /** all customer's infomation in this bank **/
    private String filepath; /** path to access where user's bankAccount info stored **/

    /**
     * create an instance of Customer.
     * If the customer is an new customer, the userinfo will be initialized when the customer registered
     * otherwise, the userinfo will be loaded from data file
     * @param userinfo
     */
    public Customer(UserData userinfo) {
        this.userinfo = userinfo;
        this.filepath = userinfo.getUserName()+"_statement";
        accountDataInitialization();
    }

    /**
     * When the instance of an exiting customer is initialized, scan the account lists to if the customer
     * has any bank account. If the customer does, initialize the instances of accounts.
     */
    public void accountDataInitialization(){
        String savingList = userinfo.getSavingAccountList();
        if(!savingList.equals("N")){
            String accounts[] = savingList.split("\\|");
            for(String s : accounts){
                this.savingList.add(s);
            }
        }
        String checkingList = userinfo.getCheckingAccountList();
        if(!checkingList.equals("N")){
            String accounts[] = savingList.split("\\|");
            for(String s : accounts){
                this.checkingtList.add(s);
            }
        }
        // TODO: after get string info of all bank account, initialize the instance of accounts based
        //  on the data from the string Accountlsit
    }

    public void openAccount(){
        // TODO: open an Account
        /** test storing account statement **/
        String testAccount = "S002";
        String directory = this.filepath;
        String testSt = "2020_3_20-transfer To C003-400 UIV";
        ArrayList<String> state = new ArrayList<>();
        state.add(testSt);
        BankSystem.saveUserAccountStatement(directory,testAccount,state);
    }

    /** @param accountNum  **/
    public void viewBankAccount(String accountNum){

        System.out.println("view bank account");
    }

    public void deposit(){ /** parameter: Account Number **/
        System.out.println("deposit money");
    }

    public void withdraw(){ /** parameter: Account Numbeer **/
        System.out.println("withdraw money");
    }

    public void requestLoan(){ /** parameter: Account Number **/
        System.out.println("loan money from bank");
    }

    public UserData getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserData userinfo) {
        this.userinfo = userinfo;
    }

    public ArrayList<Account> getSavingAccountList() {
        return savingAccountList;
    }

    public void setSavingAccountList(ArrayList<Account> savingAccountList) {
        this.savingAccountList = savingAccountList;
    }

    public ArrayList<Account> getCheckingAccountList() {
        return checkingAccountList;
    }

    public void setCheckingAccountList(ArrayList<Account> checkingAccountList) {
        this.checkingAccountList = checkingAccountList;
    }

    public ArrayList<String> getSavingList() {
        return savingList;
    }

    public void setSavingList(ArrayList<String> savingList) {
        this.savingList = savingList;
    }

    public ArrayList<String> getCheckingtList() {
        return checkingtList;
    }

    public void setCheckingtList(ArrayList<String> checkingtList) {
        this.checkingtList = checkingtList;
    }
}
