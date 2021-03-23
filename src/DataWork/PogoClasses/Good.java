package DataWork.PogoClasses;

public class Good {
    private final String productName;
    private final long minTimes;

    public Good(String productName, long minTimes) {
        this.productName = productName;
        this.minTimes = minTimes;
    }

    public String getProductName() {
        return productName;
    }

    public long getMinTimes() {
        return minTimes;
    }
}
