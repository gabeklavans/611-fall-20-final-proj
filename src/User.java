public abstract class User {
    /** all customer's information in this bank **/
    private UserData userData;

    public User(UserData userData) {
        this.userData = userData;
    };

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
