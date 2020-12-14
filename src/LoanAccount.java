import java.util.ArrayList;

/**
 * A Loan is functionally exactly the same as a SavingsAccount: they both have a
 * balance that can be raised or lowered, and they both accrue interest.
 */
public class LoanAccount extends Account implements InterestGenerator {

    /** A very rational, profit-minded default interest rate in UIV */
    public static final double defaultInterestRate = 1; // It's 1! So low!

    private Interest interestRate;

    /**
     * Create a Loan account with the default interest rate.
     * 
     * @param startingBalance
     * @param type            of currency
     */
    public LoanAccount(double startingBalance, Currency type) {
        this(startingBalance, defaultInterestRate, type);
    }

    /**
     * Create a new Loan Account with specified interest rate.
     * 
     * @param startingBalance
     * @param interestRate    The fraction of the balance generated for every
     *                        interest payment
     * @param type            The unit of currency that the interest rate is in
     *                        terms of
     */
    public LoanAccount(double startingBalance, double interestRate, Currency type) {
        super(startingBalance, type, "L");
        this.interestRate = new Interest(interestRate, type);
    }

    /**
     * Private constructor for loading a LoanAccount.
     */
    private LoanAccount(String openDate, String accountNumber, double balance, double interestRate,
            double interestBalanceRequirement, ArrayList<Transaction> transactions) throws BankException {
        super(openDate, accountNumber, balance, transactions);
        this.interestRate = new Interest(interestRate, Currency.UIV);
    }

    /**
     * Load the info for a pre-existing Loan Account and return the constructed
     * account.
     * 
     * @param openDate
     * @param accountNumber
     * @param balance
     * @param interestRate               The fraction of the balance generated for
     *                                   every interest payment (should be in UIV
     *                                   from database)
     * @param interestBalanceRequirement The lowest balance that qualifies for
     *                                   generating interest
     * @param transactions               The list of transactions this account kept
     *                                   track of
     * @throws BankException if the open date formatting is invalid
     */
    public static LoanAccount loadAccount(String openDate, String accountNumber, double balance, double interestRate,
            double interestBalanceRequirement, ArrayList<Transaction> transactions) throws BankException {
        return new LoanAccount(openDate, accountNumber, balance, interestRate, interestBalanceRequirement,
                transactions);
    }

    @Override
    public void generateInterest() {
        double generatedInterest = getBalance(Currency.UIV) * interestRate.getInterestRate(Currency.UIV);
        deposit(generatedInterest, Currency.UIV);
    }

    @Override
    public double getInterestRate(Currency type) {
        return interestRate.getInterestRate(type);
    }

    @Override
    public void setInterestRate(double rate, Currency type) {
        interestRate.setInterestRate(rate, type);
    }

    @Override
    public String getAccountInfo() {
        return Bank.DATE_FORMAT.format(getOpenDate()) + "," + getAccountNumber() + "," + getBalance(Currency.UIV) + ","
                + String.valueOf(getInterestRate(Currency.UIV));
    }
}
