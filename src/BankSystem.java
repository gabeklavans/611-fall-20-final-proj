import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * An bankSystem maintains the running of the bank. The bank system is responsible for saving and loading
 * all the data of the bank
 */

public class BankSystem {
    private static ArrayList<String> allCustomerData = new ArrayList<>();
    private String managerPassword;
    private LoginPage loginPage;
    private static String filepath = "Customers";
    private static String fileName = "CustomesData.csv";



    /**
     * Create a BankSystem and load all stored data.
     * show a login page to users
     */
    public BankSystem(){
        dataFileInitial();
        readData();
        managerPassword = "123"; /** set a temple managerPassword for test, maybe store manager info in an other file later **/
        loginPage = new LoginPage(allCustomerData,managerPassword);
    }

    /**
     * loading all customers' data when BankSystem is initialized
     */
    public void readData(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath+"/"+fileName));
//            reader.readLine();
            String line = null;
            while((line=reader.readLine())!=null){
                allCustomerData.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * When there is new customer, the new customer's information will be updated to the datafile
     * @param userData the userData of new registered customer
     */
    public static void updateCustomersData(UserData userData){
        try {
            File dir = new File(filepath);
            if(!dir.exists()) dir.mkdir();
            File csv = new File(filepath+'/'+fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));
            allCustomerData.add(userData.getStringinfo());
            for(String s :allCustomerData){
                bw.write(s);
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
     * store the users' account statement
     * @param directory each user has a folder for their bank Account statement
     * @param userfilename each bank account of has a different file name. Ex. a saving account file name maybe: S0123
     * @param statement all transactions are stored as string in the arraylist
     */
    public static void saveUserAccountStatement(String directory, String userfilename, ArrayList<String> statement){
        try{
            File dir = new File(filepath+'/'+directory);
            if(!dir.exists()){
                dir.mkdir();
            }
            File csv = new File(filepath+'/'+directory+'/'+userfilename+".csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));
            for(String s : statement){
                bw.write(s);
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
     * When the data file does not exist, create one
     */
    public void dataFileInitial(){
        try {
            File dir = new File(filepath);
            if(!dir.exists()){
                dir.mkdir();

            }
            File csv = new File(filepath+'/'+fileName); // CSVFile
            if(!csv.exists()){
                dir.mkdir();
                BufferedWriter bw = new BufferedWriter(new FileWriter(csv,true));
                bw.close();
            }
        } catch (FileNotFoundException e) {
            // File catch exception when initialization
            e.printStackTrace();
        } catch (IOException e) {
            // BufferedWriter catch exception when close
            e.printStackTrace();
        }
    }


    public static String getFilepath() {
        return filepath;
    }

    public static String getFileName() {
        return fileName;
    }
}
