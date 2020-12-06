/**
 * Interest is a representation of an interest rate for a Savings Account. The
 * interest rate is stored in UIV for consistency.
 */
public class Interest {

    private double interestRate; // Stored in UIV

    /**
     * 
     * @param rate The interest rate
     * @param type The unit of currency that the rate is specified in
     */
    public Interest(double rate, Currency type) {
        setInterestRate(rate, type);
    }

    /**
     * 
     * @param type The unit of currency to return the interest rate in terms of
     * @return The interest rate in terms of the specified unit of currency
     */
    public double getInterestRate(Currency type) {
        return Currency.convert(interestRate, Currency.UIV, type);
    }

    /**
     * 
     * @param rate The new interest rate
     * @param type The unit of currency that the rate is in terms of
     */
    public void setInterestRate(double rate, Currency type) {
        interestRate = Currency.convert(rate, type, Currency.UIV);
    }
}
