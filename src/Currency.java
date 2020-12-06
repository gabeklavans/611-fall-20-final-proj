/**
 * Different kinds of currency that the system knows about. Each currency is
 * built with its conversion factor to unified internal value (UIV).
 */
public enum Currency {
    BITCOIN("Bitcoin", "BC", 3.14159), DOGE_COIN("Dogecoin", "DgC", 4.20), HYRULIAN_RUPEES("Hyrulian Rupees", "HyRu", 0.24);

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
}
