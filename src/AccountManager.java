import java.io.*;
import java.util.ArrayList;

/**
 * Data manager for Accounts in the system
 */
public class AccountManager extends DataManager<Account> {

    private String fileName = "AccountsList.csv"; /** file contains all accounts' data **/
    public AccountManager(String filepath) {
        super(filepath);
    }


    /**
     * Load Accountdata from the AccountsList file and initialize the instance of Account based on the
     * the data loaded, and add the instance to ArrayList<Account> data.
     * */
    @Override
    public void loadData() throws BankException {
        // TODO Auto-generated method stub
        ArrayList<String> allAccounts = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFilepath()+"/"+fileName));
            String line = null;
            while((line=reader.readLine())!=null){
                allAccounts.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(String userdata : allAccounts){
            String element[] = userdata.split(",");
            CharSequence accountType = element[1].subSequence(0,1);
            if(((String)accountType).equals("S")){
                getData().add(SavingsAccount.loadAccount(element[0],element[1],Double.parseDouble(element[2]),Double.parseDouble(element[3]),Double.parseDouble(element[4])));
            }
            else if(((String)accountType).equals("C")){
                getData().add(CheckingAccount.loadAccount(element[0],element[1],Double.parseDouble(element[2])));
            }
            else {
                getData().add(LoanAccount.loadAccount(element[0],element[1],Double.parseDouble(element[2]),Double.parseDouble(element[3]),Double.parseDouble(element[4])));
            }
        }

    }

    /**
     * Store the Accounts in to the AccountList file
     * */
    @Override
    public void writeData() {
        // TODO Auto-generated method stub
        try {
            File dir = new File(getFilepath());
            if(!dir.exists()) dir.mkdir();
            File csv = new File(getFilepath()+'/'+fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));
            ArrayList<Account> accounts= getData();
            for(Account s : accounts){
                bw.write(s.getAccountInfo());
                bw.newLine();
            }
            bw.close();

        } catch (FileNotFoundException e) {
            // File catch exception when initialization
            e.printStackTrace();
        } catch (IOException e) {
            // BufferedWriter catch exception when close
            e.printStackTrace();
        }

    }

    /**
     * Add an account to the database.
     * 
     * @param acct
     */
    public void addAccount(Account acct) {
        getData().add(acct);
        writeData();
    }

    /**
     * 
     * @param acct to subtract from
     * @param amt  to subtract
     * @param type of currency the amount is in
     * @return the new balance in the unit of currency specified
     * @throws BankException
     */
    public double subtractBalance(Account acct, double amt, Currency type) throws BankException {
        acct.withdraw(amt, type);

        writeData();

        return acct.getBalance(type);
    }

    /**
     * 
     * @param acct to add to
     * @param amt  to add
     * @param type of currency the amount is in
     * @return the new balance in the unit of currency specified
     * @throws BankException
     */
    public double addBalance(Account acct, double amt, Currency type) throws BankException {
        acct.deposit(amt, type);

        writeData();

        return acct.getBalance(type);
    }

}
