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
        readData();
//        writeData();
        managerPassword = "123";
        loginPage = new LoginPage(customerdataReader,managerPassword);

    }
    public void readData(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CustomeData.csv"));
//            reader.readLine();
            String line = null;
            while((line=reader.readLine())!=null){
                customerdataReader.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for(String s : customerdataReader ){
//            System.out.println(s);
//        }

    }


    public void writeData(){
        try {
            File csv = new File("CustomeData.csv"); // 
//            File parentDir = csv.getAbsoluteFile().getParentFile();
//            String parentDirName = csv.getAbsoluteFile().getParent();
//            System.out.println(parentDir);
//            System.out.println(parentDirName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));

            UserData testD = new UserData("abc@bu.edu","Bustudent","123456","N","500","N");
            UserData testD2 = new UserData("john@bu.edu","john","123456","N","500","N");
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



}
