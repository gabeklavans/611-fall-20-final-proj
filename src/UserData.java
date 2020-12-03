import java.util.ArrayList;

public class UserData {
    private String loginAccount;
    private String userName;
    private String loginPassword;
    private String savingAccountList;  /** For account and loan attributesif user does not have the account, the value will be N; otherwise assign the value as string **/
    private String checkingAccountList;
    private String loan;

    public UserData(String loginAccount, String userName, String loginPassword, String savingAccountList, String checkingAccountList, String loan) {
        this.loginAccount = loginAccount;
        this.userName = userName;
        this.loginPassword = loginPassword;
        this.savingAccountList = savingAccountList;
        this.checkingAccountList = checkingAccountList;
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "loginAccount='" + loginAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", savingAccount=" + savingAccountList +
                ", checkingAccount=" + checkingAccountList +
                ", loan='" + loan + '\'' +
                '}';
    }

    public String getStringinfo(){
        return loginAccount+','+userName+','+loginPassword+','+savingAccountList+','+checkingAccountList+','+loan;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getSavingAccountList() {
        return savingAccountList;
    }

    public void setSavingAccountList(String savingAccountList) {
        this.savingAccountList = savingAccountList;
    }

    public String getCheckingAccountList() {
        return checkingAccountList;
    }

    public void setCheckingAccountList(String checkingAccountList) {
        this.checkingAccountList = checkingAccountList;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }
}
