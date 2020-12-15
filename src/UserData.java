/**
 * An UserData stores a customer's information in the bank
 *
 */

public class UserData {
    private String userName;
    private String loginPassword;
    private String collateral;
    private String accountList; /** String representation of a list which contains all user's account (Saving, Checking, Loan) **/

    public UserData(String userName, String loginPassword, String accountList, String collateral) {
        this.userName = userName;
        this.loginPassword = loginPassword;
        this.accountList = accountList;
        this.collateral = collateral;
    }

    @Override
    public String toString() {
        return "UserData{" +
                ", userName='" + userName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", accountList='" + accountList + '\'' +
                ", collateral='" + collateral + '\'' +
                '}';
    }

    public String getStringInfo(){
        return userName+','+loginPassword+','+accountList+','+collateral;
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
