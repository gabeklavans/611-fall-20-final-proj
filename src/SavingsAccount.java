/**
 * A Savings Account functions similarly to a Checking Account but has the
 * additional function of gaining interest over time.
 */
public class SavingsAccount extends Account {

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
        super(startingBalance, type);
        this.interestRate = new Interest(interestRate, type);
        this.interestBalanceRequirement = interestBalanceRequirement;
    }

    /**
     * Private constructor for loading a SavingsAccount
     */
    private SavingsAccount(String openDate, String accountNumber, double balance, double interestRate,
                          double interestBalanceRequirement) throws BankException {
        super(openDate, accountNumber, balance);
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
     * @throws BankException if the open date formatting is invalid
     */
    public static SavingsAccount loadAccount(String openDate, String accountNumber, double balance, double interestRate,
            double interestBalanceRequirement) throws BankException {
        return new SavingsAccount(openDate, accountNumber, balance, interestRate, interestBalanceRequirement);
    }

    /**
     * Calculate generated interest and add it to the current balance.
     */
    public void generateInterest() {
        double generatedInterest = getBalance(Currency.UIV) * interestRate.getInterestRate(Currency.UIV);
        deposit(generatedInterest, Currency.UIV);
    }

    /**
     * 
     * @param type The unit of currency to return the interest rate in
     * @return The interest rate in terms of the specified unit of currency
     */
    public double getInterestRate(Currency type) {
        return interestRate.getInterestRate(type);
    }

    /**
     * 
     * @param rate The new interest rate
     * @param type The unit of currency that the new interest rate is in terms of
     */
    public void setInterestRate(double rate, Currency type) {
        interestRate.setInterestRate(rate, type);
    }

    @Override
    public String getAccountInfo() {
        return getOpenDate()+","+getAccountNumber()+
                String.valueOf(getBalance(Currency.UIV))+
                String.valueOf(getInterestRate(Currency.UIV))+
                String.valueOf(interestBalanceRequirement);
    }

}
