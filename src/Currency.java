/**
 * Different kinds of currency that the system knows about. Each currency is
 * built with its conversion factor to unified internal value (UIV).
 * Technically, all transactions and money calculations are done in terms of UIV
 * for the system's consistency, and every other currency is just a bit of
 * display configuration for different users to use.
 */
public enum Currency {
    UIV("Unified Internal Value", "UIV", 1), //
    BC("Bitcoin", "BC", 3.14159), //
    DGC("Dogecoin", "DgC", 4.20), //
    HYRU("Hyrulian Rupees", "HyRu", 0.24);

    private String name, shorthand;
    private double exchangeRate;

    private Currency(String name, String shorthand, double eRate) {
        this.name = name;
        this.shorthand = shorthand;
        this.exchangeRate = eRate;
    }

    /**
     * 
     * @return The short-form string representation of the currency
     */
    public String getShorthand() {
        return shorthand;
    }

    /**
     * One of this currency is worth "exchangeRate" UIV.
     * 
     * e.g. if exchangeRate = 2, then 1 of this currency is worth 2 UIV.
     * 
     * @return The factor to multiply by to get this currency's value in UIV
     */
    public double getUivExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Convert from one unit of currency to another.
     * 
     * @param amt  Amount in terms of the "from" currency
     * @param from The currency converting from
     * @param to   The currency converting to
     * @return The converted amount in terms of the "to" currency
     */
    public static double convert(double amt, Currency from, Currency to) {
        double amtInUiv = amt * from.getUivExchangeRate();
        return amtInUiv / to.getUivExchangeRate();
    }
}
