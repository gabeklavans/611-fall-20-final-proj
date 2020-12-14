/**
 * Defines functions for managing an interest rate. Intended to be applied to an
 * account that generates interest of some sort.
 */
public interface InterestGenerator {

    /**
     * Calculate generated interest and add it to the current balance.
     */
    public void generateInterest();

    /**
     * 
     * @param type The unit of currency to return the interest rate in
     * @return The interest rate in terms of the specified unit of currency
     */
    public double getInterestRate(Currency type);

    /**
     * 
     * @param rate The new interest rate
     * @param type The unit of currency that the new interest rate is in terms of
     */
    public void setInterestRate(double rate, Currency type);

}
