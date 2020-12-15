/**
 * An UserData stores a customer's information in the bank
 *
 */

public class UserData {
    private String userName;
    private String loginPassword;

    public UserData(String userName, String loginPassword) {
        this.userName = userName;
        this.loginPassword = loginPassword;
    }

    @Override
    public String toString() {
        return "UserData{" +
                ", userName='" + userName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                '}';
    }

    public String getStringInfo(){
        return userName+','+loginPassword;
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
    
}
