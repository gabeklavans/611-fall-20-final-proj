public class SavingsAccount extends Account {

    /* set a very rational, profit-minded default interest rate in UIV */
    private static final double defaultInterestRate = Double.MIN_NORMAL;

    private Interest interestRate;
    private double interestBalanceRequirement; // TODO: May want to move this out of here and into a BankManager class

    /**
     * Create a Savings account with the default interest rate.
     * 
     * @param startingBalance
     * @param interestBalanceRequirement The lowest balance that qualifies for
     *                                   generating interest
     */
    public SavingsAccount(double startingBalance, double interestBalanceRequirement) {
        this(startingBalance, defaultInterestRate, Currency.UIV, interestBalanceRequirement);
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
        super(startingBalance);
        this.interestRate = new Interest(interestRate, type);
        this.interestBalanceRequirement = interestBalanceRequirement;
    }

    /**
     * Load a pre-existing Savings Account using necessary parameters.
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
    public SavingsAccount(String openDate, String accountNumber, double balance, double interestRate,
            double interestBalanceRequirement) throws BankException {
        super(openDate, accountNumber, balance);
        this.interestRate = new Interest(interestRate, Currency.UIV);
        this.interestBalanceRequirement = interestBalanceRequirement;
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

}
