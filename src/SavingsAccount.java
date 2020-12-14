import java.util.ArrayList;

/**
 * A Savings Account functions similarly to a Checking Account but has the
 * additional function of gaining interest over time.
 */
public class SavingsAccount extends Account implements InterestGenerator {

    /* set a very rational, profit-minded default interest rate in UIV */
    public static final double defaultInterestRate = Double.MIN_NORMAL;

    private Interest interestRate;
    private double interestBalanceRequirement; // TODO: May want to move this out of here and into a BankManager class

    /**
     * Create a Savings account with the default interest rate.
     * 
     * @param startingBalance
     * @param type                       of currency
     * @param interestBalanceRequirement The lowest balance that qualifies for
     *                                   generating interest
     */
    public SavingsAccount(double startingBalance, Currency type, double interestBalanceRequirement) {
        this(startingBalance, defaultInterestRate, type, interestBalanceRequirement);
    }

    /**
     * Create a new Savings Account with specified interest rate.
     * 
     * @param startingBalance
     * @param interestRate               The fraction of the balance generated for
     *                                   every interest payment
     * @param type                       The unit of currency that the interest rate
     *                                   is in terms of
     * @param interestBalanceRequirement The lowest balance that qualifies for
     *                                   generating interest
     */
    public SavingsAccount(double startingBalance, double interestRate, Currency type,
            double interestBalanceRequirement) {
        super(startingBalance, type, "S");
        this.interestRate = new Interest(interestRate, type);
        this.interestBalanceRequirement = interestBalanceRequirement;
    }

    /**
     * Private constructor for loading a SavingsAccount
     */
    private SavingsAccount(String openDate, String accountNumber, double balance, double interestRate,
            double interestBalanceRequirement, ArrayList<Transaction> transactions) throws BankException {
        super(openDate, accountNumber, balance, transactions);
        this.interestRate = new Interest(interestRate, Currency.UIV);
        this.interestBalanceRequirement = interestBalanceRequirement;
    }

    /**
     * Load the info for a pre-existing Savings Account and return the constructed
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
    public static SavingsAccount loadAccount(String openDate, String accountNumber, double balance, double interestRate,
            double interestBalanceRequirement, ArrayList<Transaction> transactions) throws BankException {
        return new SavingsAccount(openDate, accountNumber, balance, interestRate, interestBalanceRequirement,
                transactions);
    }

    /**
     * Only generates the interest if the balance meets the minimum required to
     * generate interest. This is defined per-account.
     */
    @Override
    public void generateInterest() {
        if (getBalance(Currency.UIV) >= interestBalanceRequirement) {
            double generatedInterest = getBalance(Currency.UIV) * interestRate.getInterestRate(Currency.UIV);
            deposit(generatedInterest, Currency.UIV);
        }
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
        return Bank.DATE_FORMAT.format(getOpenDate()) + "," + getAccountNumber() + ","
                + String.valueOf(getBalance(Currency.UIV)) + "," + String.valueOf(getInterestRate(Currency.UIV)) + ","
                + String.valueOf(interestBalanceRequirement);
    }

}
