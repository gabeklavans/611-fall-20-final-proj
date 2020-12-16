import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws BankException {

        /** Initialize the global bank, loading in all the data from the database files */
        Bank bank = Bank.getBank();

        /** test code **/
        System.out.println(bank.getAccounts());
        ArrayList<User> users = bank.getUsers();
        System.out.println(users);
        // bank.openSavingsAccount((Customer) users.get(0), 100000.00, Currency.UIV, SavingsAccount.defaultInterestRate,
        //         Bank.MINIMUM_BALANCE_FOR_INTEREST);
        ArrayList<Account> accts = bank.getAccounts();
        // bank.deleteAccount("Sf1cd232e-5526-43db-9236-1e17041ab315");
        // bank.openLoan((Customer) users.get(2), 100000.00, LoanAccount.DEFAULT_INTEREST_RATE, Currency.UIV, "my dog");
        // bank.depositMoney(accts.get(0), 100000000000.00, Currency.UIV);
        // bank.withdrawMoney(accts.get(0), 500000, Currency.UIV);
        // bank.depositMoney(accts.get(3), 1.00, Currency.DGC);

        // bank.registerNewCustomer("hello", "hellothere", "mr obi wan");
        // bank.openSavingsAccount((Customer) users.get(0), 1000000, Currency.UIV, SavingsAccount.DEFAULT_INTEREST_RATE,
        //         Bank.MINIMUM_BALANCE_FOR_INTEREST);
        // bank.openCheckingAccount((Customer) users.get(1), 10.00, Currency.HYRU);



//         AccountManager am = new AccountManager("Customers");
// //        am.addAccount(new SavingsAccount(100, Currency.UIV,10));
// //        am.addAccount(new CheckingAccount(200, Currency.UIV));
// //        am.addAccount(new LoanAccount(300,Currency.UIV));

//         am.loadData();
//         ArrayList<Account> d = am.getData();
//         for(int i =0; i< d.size() ;i++){
//             System.out.println(d.get(i).getAccountInfo());
//             ArrayList<Transaction> trans = d.get(i).getTransactions();
//             for(Transaction transaction : trans){
//                 System.out.println(transaction);
//             }
//         }

// //        Transaction t1 = new Transaction(Transaction.Type.DEPOSIT,100,Currency.UIV);
// //        Transaction t2 = new Transaction(Transaction.Type.PAYMENT,100,Currency.UIV);
// //        Transaction t3 = new Transaction(Transaction.Type.WITHDRAWAL,100,Currency.UIV);
// //
// //        ArrayList<Transaction> tlist = new ArrayList<>();
// //        tlist.add(t1);
// //        tlist.add(t2);
// //        tlist.add(t3);
// //
// //        am.getData().get(0).setTransactions(tlist);
// //        am.writeData();

//         UserManager um = new UserManager("Customers");
//         um.loadData();
//         ArrayList<User> ud = um.getData();
//         for(User i : ud){
//             System.out.println(((Customer)i).getUserData());
        // }
//        um.getData().add(
//                new Customer(
//                        new UserData("test2@","test2","123",
//                                "2020-09-08|C023|100","10")));
//        um.writeData();

//        BankSystem bk = new BankSystem();


    }
}
