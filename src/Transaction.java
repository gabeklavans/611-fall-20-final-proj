import java.util.Date;

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
    /** Exact date/time of the transaction's creation */
    private Date date;

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
        this.date = new Date();
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    /**
     * 
     * @return One of the Type enum strings (i.e. WITHDRAWAL, DEPOSIT, or PAYMENT)
     */
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return getDate() + "," + getType() + "," + getAmount();
    }

}
