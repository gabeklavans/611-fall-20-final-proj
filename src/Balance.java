/**
 * Represents an account's balance. This representation is
 * currency-type-agnostic. The balance is stored as a unified internal value
 * (UIV) and all deposits/withdraws must have a specified unit of currency to do
 * the proper conversion.
 */
public class Balance {

    private double internalValue;

    /**
     * 
     * @param initialValue Initial value of balance in units of UIV
     */
    public Balance(double initialValue) {
        internalValue = initialValue;
    }

    /**
     * 
     * @return The UIV representation of this balance
     */
    public double getInternalValue() {
        return internalValue;
    }

    /**
     * 
     * @param type The unit of currency to get the balance in. Performs the
     *             conversion from UIV automatically.
     * @return The balance in terms of the type of currency
     */
    public double getBalance(Currency type) {
        return internalValue / type.getUivExchangeRate();
    }

    /**
     * 
     * @param amt  The amount in terms of the unit of currency to deposit
     * @param type The unit of currency to make this deposit in terms of
     * @return The updated balance in terms of the specified unit of currency
     */
    public double deposit(double amt, Currency type) {
        internalValue += amt * type.getUivExchangeRate();
        return internalValue / type.getUivExchangeRate();
    }

    /**
     * 
     * @param amt  The amount to withdraw
     * @param type The unit of currency that the withdrawal amount is in terms of
     * @return The new balance after the withdrawal
     * @throws Exception if there is not enough money in the balance to make the
     *                   withdrawal
     */
    public double withdraw(double amt, Currency type) throws Exception {
        if (internalValue - (amt * type.getUivExchangeRate()) < 0) {
            throw new Exception("The balance is too low to make this withdrawal.");
        }

        internalValue -= amt * type.getUivExchangeRate();
        return internalValue / type.getUivExchangeRate();
    }

}
