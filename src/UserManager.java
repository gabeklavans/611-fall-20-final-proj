import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Data manager for the users in the system
 */
public class UserManager extends DataManager<User> {

    /**
     * Create a new User Manager.
     * 
     * @param filepath
     * @throws BankException
     */
    public UserManager(String filepath) throws BankException {
        super(filepath, "CustomersData.csv");
    }

    /**
     * Load Userdata from the CustomersData file and initialize the instance of User
     * based on the the data loaded, and add the instance to ArrayList<User> data.
     */

    @Override
    public void loadData() {
        // TODO Auto-generated method stub
        String filepath = getFilepath();
        String fileName = getFileName();
        ArrayList<String> allCustomerData = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath + "/" + fileName));
            String line = null;
            while ((line = reader.readLine()) != null) {
                allCustomerData.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String userdata : allCustomerData) {
            String element[] = userdata.split(",");
            UserData newData = new UserData(element[0], element[1]);
            getData().add(new Customer(newData));
        }
    }

    /**
     * Store the UserData in to the customers file
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
            ArrayList<User> data = getData();
            for (User s : data) {
                UserData userdata = ((Customer) s).getUserData();
                bw.write(userdata.getStringInfo());
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
     * Register an account with a user, adding it to their list of accounts and
     * adding it to the database entry for that user.
     * 
     * @param user
     * @param acct
     */
    public void registerAccountWithUser(Customer user, Account acct) {
        user.registerNewAccount(acct);
        writeData();
    }

    /**
     * Register a new user to the database.
     * 
     * @param user
     */
    public void registerUser(Customer user) {
        getData().add(user);
        writeData();
    }

    /**
     * 
     * @param username of the User to look for
     * @return The found user, null if the user was not found
     */
    public User getUser(String username) {
        for (User user : getData()) {
            if (user.getUserData().getUserName().equals(username)) {
                return user;
            }
        }

        return null;
    }

}
