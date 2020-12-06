import java.util.Scanner;

/** This represent the user-interface viewed by customers when they login to the online bank ATM page**/
public class ATM_CustomerInterface {
    private Customer customer;

    public ATM_CustomerInterface(Customer customer) {
        this.customer = customer;
        userActions();
    }

    public void userActions(){
        System.out.println("1.Open an bank Account  2. View Account transaction and Balance " +
                " 3. Request Loan  4.Deposit  5.Withdraw");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                customer.openAccount();
                break;
            case 2:
                customer.viewBankAccount("s102");
                break;
            case 3:
                customer.requestLoan();
            case 4:

        }
    }
}
