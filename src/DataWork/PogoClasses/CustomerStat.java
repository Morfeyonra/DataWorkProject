package DataWork.PogoClasses;

import java.util.ArrayList;
import java.util.List;

public class CustomerStat {

    private final String name;
    private final List<Purchase> purchases = new ArrayList<>();

    private long totalExpenses;

    public CustomerStat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public long getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses() {

        long count = 0;

        for (Purchase purchase : purchases) {
            count += purchase.getExpenses();
        }

        this.totalExpenses = count;
    }
}
