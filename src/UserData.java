public class UserData {
    private String loginAccount;
    private String userName;
    private String loginPassword;
    private String savingAccount;  /** For account and loan attributesif user does not have the account, the value will be N; otherwise assign the value as string **/
    private String checkingAccount;
    private String loan;

    public UserData(String loginAccount, String userName, String loginPassword, String savingAccount, String checkingAccount, String loan) {
        this.loginAccount = loginAccount;
        this.userName = userName;
        this.loginPassword = loginPassword;
        this.savingAccount = savingAccount;
        this.checkingAccount = checkingAccount;
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "loginAccount='" + loginAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", savingAccount='" + savingAccount + '\'' +
                ", checkingAccount='" + checkingAccount + '\'' +
                ", loan='" + loan + '\'' +
                '}';
    }
    public String getStringinfo(){
        return loginAccount+','+userName+','+loginPassword+','+savingAccount+','+checkingAccount+','+loan;
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

    public String getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(String savingAccount) {
        this.savingAccount = savingAccount;
    }

    public String getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(String checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }
}
