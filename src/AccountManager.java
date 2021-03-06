import java.io.*;
import java.util.ArrayList;

/**
 * Data manager for Accounts in the system
 */
public class AccountManager extends DataManager<Account> {

    /**
     * 
     * @throws BankException
     **/
    public AccountManager(String filepath) throws BankException {
        super(filepath, "AccountsList.csv");
    }

    /**
     * Load Accountdata from the AccountsList file and initialize the instance of
     * Account based on the the data loaded, and add the instance to
     * ArrayList<Account> data.
     */
    @Override
    public void loadData() throws BankException {
        // TODO Auto-generated method stub
        ArrayList<String> allAccounts = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFilepath() + "/" + getFileName()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                allAccounts.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String userdata : allAccounts) {
            String element[] = userdata.split(",");
            CharSequence accountType = element[1].subSequence(0, 1);
            ArrayList<Transaction> transactions = new ArrayList<>();
            if (((String) accountType).equals("S")) {
                if (element.length < 6) {
                    transactions = new ArrayList<>();
                } else {
                    transactions = convertStringToTransaction(element[5]);
                }
                getData().add(SavingsAccount.loadAccount(element[0], element[1], Double.parseDouble(element[2]),
                        Double.parseDouble(element[3]), Double.parseDouble(element[4]), transactions));
            } else if (((String) accountType).equals("C")) {
                if (element.length < 4) {
                    transactions = new ArrayList<>();
                } else {
                    transactions = convertStringToTransaction(element[3]);
                }
                getData().add(CheckingAccount.loadAccount(element[0], element[1], Double.parseDouble(element[2]),
                        transactions));
            } else {
                if (element.length < 6) {
                    transactions = new ArrayList<>();
                } else {
                    transactions = convertStringToTransaction(element[5]);
                }
                getData().add(LoanAccount.loadAccount(element[0], element[1], Double.parseDouble(element[2]),
                        Double.parseDouble(element[3]), element[4], transactions));
            }
        }

    }

    /**
     * Store the Accounts in to the AccountList file
     */
    @Override
    public void writeData() {
        // TODO Auto-generated method stub
        try {
            File dir = new File(getFilepath());
            if (!dir.exists())
                dir.mkdir();
            File csv = new File(getFilepath() + '/' + getFileName());
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));
            ArrayList<Account> accounts = getData();
            for (Account s : accounts) {
                bw.write(s.getAccountInfo() + "," + convertTranctionsToString(s.getTransactions()));
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
     * convert the the account's transactions Arraylist into a string version for
     * writing it into file
     *
     * @param transactions
     */

    public String convertTranctionsToString(ArrayList<Transaction> transactions) {
        String tranction = " ";
        for (int i = 0; i < transactions.size(); i++) {
            if (i == transactions.size() - 1) {
                tranction += transactions.get(i).toString();
            } else {
                tranction += transactions.get(i).toString() + "|";
            }
        }
        return tranction;
    }

    /**
     * convert the string version of transactions into an Arraylist<Transaction>
     *
     * @param transactionString
     */
    public ArrayList<Transaction> convertStringToTransaction(String transactionString)
            throws BankException, ArrayIndexOutOfBoundsException {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        try {
            String transaction[] = transactionString.split("\\|");
            for (int i = 0; i < transaction.length; i++) {
                String transactionElement[] = transaction[i].split("-");
                transactions.add(Transaction.loadTransaction(Transaction.Type.valueOf(transactionElement[1]),
                        Double.parseDouble(transactionElement[2]), Currency.UIV, transactionElement[0]));
            }
        } catch (BankException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            return transactions;
        }
        return transactions;
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

    /**
     * 
     * @param accountId of the account to search for
     * @return the account with the provided ID
     * @throws BankException if the account could not be found
     */
    public Account getAccount(String accountId) throws BankException {
        for (Account account : getData()) {
            if (account.getAccountNumber().equals(accountId)) {
                return account;
            }
        }

        throw new BankException("The account with ID {" + accountId + "} could not be found in the system");
    }

    /**
     * 
     * @param accountId
     * @return the removed account, null if not found
     */
    public Account removeAccount(String accountId) {
        ArrayList<Account> accts = getData();
        for (int i = 0; i < accts.size(); i++) {
            if (accts.get(i).getAccountNumber().equals(accountId)) {
                Account removedAcct = accts.remove(i);
                writeData();
                return removedAcct;
            }
        }

        return null;
    }

}
