import java.util.ArrayList;

public class Customer extends User{
    private ArrayList<Account> savingAccountList = new ArrayList<>();
    private ArrayList<Account> checkingAccountList = new ArrayList<>();
    private ArrayList<String> savingList = new ArrayList<>();
    private ArrayList<String> checkingtList = new ArrayList<>();
    private int loan; /** maybe need a class for loan **/
    private UserData userinfo;
    private String filepath;

    public Customer(UserData userinfo) {
        this.userinfo = userinfo;
        this.filepath = userinfo.getUserName()+"_statement";
        accountDataInitialization();
        this.filepath = userinfo.getUserName();
    }

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
    }

    public void openAccount(){
        System.out.println("open an account");
    }

    public void viewBankAccount(){ /** parameter: Account account **/
        System.out.println("view bank account");
    }

    public void deposit(){ /** parameter: Account account **/
        System.out.println("deposit money");
    }

    public void withdraw(){ /** parameter: Account account **/
        System.out.println("withdraw money");
    }

    public void requestLoan(){
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
