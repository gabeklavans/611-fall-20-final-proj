/**
 * An UserData stores a customer's information in the bank
 *
 */

public class UserData {
    private String userName;
    private String loginPassword;
    private String collateral;

    public UserData(String userName, String loginPassword, String collateral) {
        this.userName = userName;
        this.loginPassword = loginPassword;
        this.collateral = collateral;
    }

    @Override
    public String toString() {
        return "UserData{" +
                ", userName='" + userName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", collateral='" + collateral + '\'' +
                '}';
    }

    public String getStringInfo(){
        return userName+','+loginPassword+','+collateral;
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

    public String getCollateral() {
        return collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }
}
