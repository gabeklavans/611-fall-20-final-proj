import java.util.ArrayList;
import java.util.Scanner;

public class LoginPage {
    private String inputLoginAccount;
    private String inputpassword;
    private ArrayList<String> customerData;
    private String managerPassword;
    private Customer customer;

    public LoginPage(ArrayList<String> customerData,String mPassword){
        this.customerData = customerData;
        this.managerPassword = mPassword;
        this.customer = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Login as manager 2.Login as customer (Enter choice number)");
        if(scanner.nextInt() == 1){
            managerLogin();
        }else{
            customerLogin();
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
            System.out.println("Customer online bank interface");
            System.out.println(this.customer.getUserinfo().getUserName());
            System.out.println(this.customer.getSavingList());
            System.out.println(this.customer.getCheckingtList());

//            new ATM_CustomerInterface(this.customer);
        }else {
            System.out.println("login fails");
        }
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
                            /** 0.LoginAccountNumber, 1.Name, 2. password 3.SavingList 4.CheckingList 5.loan**/
        UserData newData = new UserData(element[0],element[1],element[2],element[3],element[4],element[5]);
        return new Customer(newData);
    }
}
