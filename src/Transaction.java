/**
 * Represents a single transaction made on an Account. These are stored in order
 * to produce an account statement that acts a record of all the things that
 * this account has done since its creation.
 */
public class Transaction {

    public enum Type {
        WITHDRAWAL, DEPOSIT, PAYMENT;
    }

    /** Type of transaction */
    private Type type;
    /** Amount in UIV */
    private double amount;

    /**
     * 
     * @param type         of transaction
     * @param amt          of money involved in the transaction
     * @param currencyType of the amount specified (will be converted to UIV for
     *                     storing the transaction)
     */
    public Transaction(Type type, double amt, Currency currencyType) {
        this.type = type;
        this.amount = Currency.convert(amt, currencyType, Currency.UIV);
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        // TODO
        return "";
    }

}
