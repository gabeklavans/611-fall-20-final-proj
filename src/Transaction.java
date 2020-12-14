import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    /** Private constructor used for loading a pre-existing Transaction */
    private Transaction(Type type, double amt, Currency currencyType, String date) throws BankException {
        this.type = type;
        this.amount = Currency.convert(amt, currencyType, Currency.UIV);
        try {
            this.date = Bank.DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new BankException("Invalid date format");
        }
    }

    /**
     * Load the info for a pre-existing Savings Account and return the constructed
     * account.
     *
     * @param type
     * @param amt
     * @param currencyType
     * @param date
     * @throws BankException if the open date formatting is invalid
     */
    public static Transaction loadTransaction(Type type, double amt, Currency currencyType, String date)
            throws BankException {
        return new Transaction(type, amt, currencyType, date);
    }

    /**
     * 
     * @return One of the Type enum strings (i.e. WITHDRAWAL, DEPOSIT, or PAYMENT)
     */
    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return Bank.DATE_FORMAT.format(getDate()) + "-" + getType() + "-" + getAmount();
    }

}
