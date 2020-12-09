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
    public Balance(double initialValue, Currency type) {
        internalValue = Currency.convert(initialValue, type, Currency.UIV);
    }

    /**
     * 
     * @param type The unit of currency to get the balance in. Performs the
     *             conversion from UIV automatically.
     * @return The balance in terms of the type of currency
     */
    public double getBalance(Currency type) {
        return Currency.convert(internalValue, Currency.UIV, type);
    }

    /**
     * 
     * @param amt  The amount in terms of the unit of currency to deposit
     * @param type The unit of currency to make this deposit in terms of
     * @return The updated balance in terms of the specified unit of currency
     */
    public double deposit(double amt, Currency type) {
        internalValue += Currency.convert(amt, type, Currency.UIV);
        return Currency.convert(amt, Currency.UIV, type);
    }

    /**
     * 
     * @param amt  The amount to withdraw
     * @param type The unit of currency that the withdrawal amount is in terms of
     * @return The new balance after the withdrawal
     * @throws Exception if there is not enough money in the balance to make the
     *                   withdrawal
     */
    public double withdraw(double amt, Currency type) throws BankException {
        if (internalValue - (Currency.convert(amt, type, Currency.UIV)) < 0) {
            throw new BankException("The balance is too low to make this withdrawal.");
        }

        internalValue -= Currency.convert(amt, type, Currency.UIV);
        return Currency.convert(amt, Currency.UIV, type);
    }

}
