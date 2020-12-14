import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws BankException {

        /** test code for UserManger and Account Manager **/
        AccountManager am = new AccountManager("Customers");
//        am.addAccount(new SavingsAccount(100, Currency.UIV,10));
//        am.addAccount(new CheckingAccount(200, Currency.UIV));
//        am.addAccount(new LoanAccount(300,Currency.UIV));

        am.loadData();
        ArrayList<Account> d = am.getData();
        for(int i =0; i< d.size() ;i++){
            System.out.println(d.get(i).getAccountInfo());
            ArrayList<Transaction> trans = d.get(i).getTransactions();
            for(Transaction transaction : trans){
                System.out.println(transaction);
            }
        }

//        Transaction t1 = new Transaction(Transaction.Type.DEPOSIT,100,Currency.UIV);
//        Transaction t2 = new Transaction(Transaction.Type.PAYMENT,100,Currency.UIV);
//        Transaction t3 = new Transaction(Transaction.Type.WITHDRAWAL,100,Currency.UIV);
//
//        ArrayList<Transaction> tlist = new ArrayList<>();
//        tlist.add(t1);
//        tlist.add(t2);
//        tlist.add(t3);
//
//        am.getData().get(0).setTransactions(tlist);
//        am.writeData();

        UserManager um = new UserManager("Customers");
        um.loadData();
        ArrayList<User> ud = um.getData();
        for(User i : ud){
            System.out.println(((Customer)i).getUserData());
        }
//        um.getData().add(
//                new Customer(
//                        new UserData("test2@","test2","123",
//                                "2020-09-08|C023|100","10")));
//        um.writeData();

//        BankSystem bk = new BankSystem();


    }
}
