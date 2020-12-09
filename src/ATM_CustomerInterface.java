import java.util.Scanner;

// TODO: Replace all of this with GUI
/**
 * This represent the user-interface viewed by customers when they login to the
 * online bank ATM page
 **/
public class ATM_CustomerInterface {
    private Customer customer;

    public ATM_CustomerInterface(Customer customer) {
        this.customer = customer;
        userActions();
    }

    public void userActions() {
        System.out.println("1.Open an bank Account  2. View Account transaction and Balance "
                + " 3. Request Loan  4.Deposit  5.Withdraw");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // customer.openAccount();
                // TODO: Start an interface for choosing what kind of account
                break;
            case 2:
                // customer.viewBankAccount("s102");
                // TODO: Start ui for choosing which account to view
                break;
            case 3:
                // customer.requestLoan();
                // TODO: Start ui for taking out loan
                break;
            default:
                // etc...
                break;

        }
    }
}
