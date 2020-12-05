/**
 * Different kinds of currency that the system knows about.
 */
public enum Currency {
    BITCOIN("Bitcoin", "BC", 1.24), DOGE_COIN("Dogecoin", "DgC", 4.20), HYRULIAN_RUPEES("Hyrulian Rupees", "HyRu", 0.5);

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
     * One of this currency is worth "exchangeRate" of the "internal values".
     * 
     * e.g. if exchangeRate = 2, then 1 of this currency is worth 2 internal
     * value units.
     * 
     * @return The factor to multiply by the internal value to get this currency's
     *         representative amount
     */
    public double getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
