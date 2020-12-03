import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;



public class BankSystem {
    private ArrayList<String> customerdataReader = new ArrayList<>();
    private ArrayList<String> customerdataWriter = new ArrayList<>();
    private String managerPassword;
    private LoginPage loginPage;



    public BankSystem(){

        writeData();
        readData();
        managerPassword = "123";
        loginPage = new LoginPage(customerdataReader,managerPassword);

    }
    public void readData(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CustomerB/CustomeData.csv"));
//            reader.readLine();
            String line = null;
            while((line=reader.readLine())!=null){
                customerdataReader.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void writeData(){
        try {
            String filepath = "CustomerB";
            File dir = new File(filepath);
            if(!dir.exists()) dir.mkdir();
            String fileName = "CustomeData.csv";
            File csv = new File(filepath+'/'+fileName); // CSVFile
//            File parentDir = csv.getAbsoluteFile().getParentFile();
//            String parentDirName = csv.getAbsoluteFile().getParent();
//            System.out.println(parentDir);
//            System.out.println(parentDirName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));

            UserData testD = new UserData("abc@bu.edu","Bustudent","123456","2020_12_2-S023-2300|2020_12_3-S022-3300","N","N");
            UserData testD2 = new UserData("john@bu.edu","john","123456","N","N","N");
            customerdataWriter.add(testD.getStringinfo());
            customerdataWriter.add(testD2.getStringinfo());
            for(String s : customerdataWriter){
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

//    public static void main(String[] args) {
//        new BankSystem();
//
//    }



}
