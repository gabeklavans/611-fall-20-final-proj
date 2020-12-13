import java.util.ArrayList;
/**
 * An UserData stores a customer's information in the bank
 *
 */

public class UserData {
    private String loginAccount;
    private String userName;
    private String loginPassword;
    private String accountList; /** String representation of a list which contains all user's account (Saving, Checking, Loan) **/
//    private String savingAccountList;  /** For account and loan attributesif user does not have the account, the value will be N; otherwise assign the value as string **/
//    private String checkingAccountList;
//    private String loan;
    private String collateral;

    public UserData(String loginAccount, String userName, String loginPassword, String accountList, String collateral) {
        this.loginAccount = loginAccount;
        this.userName = userName;
        this.loginPassword = loginPassword;
        this.accountList = accountList;
        this.collateral = collateral;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "loginAccount='" + loginAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", accountList='" + accountList + '\'' +
                ", collateral='" + collateral + '\'' +
                '}';
    }

    public String getStringinfo(){
        return loginAccount+','+userName+','+loginPassword+','+accountList+','+collateral;
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

    public String getAccountList() {
        return accountList;
    }

    public void setAccountList(String accountList) {
        this.accountList = accountList;
    }

    public String getCollateral() {
        return collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }
}
