import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        BankSystem bk = new BankSystem();

        /** test method of storing account statement **/
        String testSt = "2020_3_20-transfer To C023-400";
        ArrayList<String> state = new ArrayList<>();
        state.add(testSt);
        BankSystem.saveUserAccountStatement("abc_statement","S032",state);
    }
}
