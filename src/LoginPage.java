import java.util.ArrayList;
import java.util.Scanner;

/**
 * An LoginPage provide both customers and manager a way to login to the bank user-interface.
 */

public class LoginPage {
    private String inputLoginAccount;
    private String inputpassword;
    private ArrayList<String> customerData;
    private String managerPassword;
    private Customer customer;
    private String registeredUserAccountID;
    private String registeredPassword;
    private String registeredUserName;
    private UserData registeredUserData;

    public LoginPage(ArrayList<String> customerData,String mPassword){
        this.customerData = customerData;
        this.managerPassword = mPassword;
        this.customer = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Login as manager 2.Login as customer 3. Create an User Account(Enter choice number)");
        int choice = scanner.nextInt();
        if( choice == 1){
            managerLogin();
        }else if(choice == 2){
            customerLogin();
        }else {
            customerRegister();
        }

    }
    public void managerLogin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password");
        String input = scanner.nextLine();
        if(input.equals(managerPassword)){
            System.out.println("Manager interface");
        }
        else {
            System.out.println("wrong password");
        }
    }

    public void customerLogin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your account");
        inputLoginAccount = scanner.nextLine();
        System.out.println("Enter password");
        inputpassword = scanner.nextLine();

        if(customerLoginValidator(inputLoginAccount, inputpassword)){
            new ATM_CustomerInterface(this.customer);
        }else {
            System.out.println("login fails");
        }
    }

    public void customerRegister(){
        Scanner scanner = new Scanner(System.in);
        boolean endFlag;
        do{
            endFlag = false;
            System.out.println("Enter user account");
            registeredUserAccountID = scanner.nextLine();
            for(String s : customerData){
                String element[] = s.split(",");
                if(!element[0].equals(registeredUserAccountID)){
                    continue;
                }else {
                    System.out.println("This account has already been registered");
                    endFlag = true;
                }
            }
        }while (endFlag);
        System.out.println("Enter user name");
        registeredUserName = scanner.nextLine();
        System.out.println("Enter password");
        registeredPassword = scanner.nextLine();
        registeredUserData = new UserData(registeredUserName,registeredPassword);
        BankSystem.updateCustomersData(registeredUserData);
        this.customer = new Customer(registeredUserData);
        new ATM_CustomerInterface(this.customer);
    }

    public boolean customerLoginValidator(String account, String password){
        for(String data : customerData){
            String element[] = data.split(",");
            if(element[0].equals(account)){
                if(element[2].equals(password)){ ;
                    System.out.println("Welcome come back "+element[1]);
                    customer = initialCustomer(data);
                    return true;
                }
                else {
                    System.out.println("The password is wrong");
                    return false;
                }
            }
        }
        System.out.println("Account does not exist");
        return false;
    }

    public Customer initialCustomer(String data){
        String element[] = data.split(",");
                            /** 0.LoginAccountNumber, 1.Name, 2. password 3.account list 5.loan**/
        UserData newData = new UserData(element[0],element[1]);
        return new Customer(newData);
    }
}
