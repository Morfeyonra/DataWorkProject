package DataWork.PogoClasses;

import DataWork.PogoClasses.CustomerStat;

import java.util.ArrayList;
import java.util.List;

public class StatOutput {

    private final String type = "stat";

    private long totalDays;

    private final List<CustomerStat> customers = new ArrayList<>();

    private long totalExpenses;
    private double avgExpenses;


    public String getType() {
        return type;
    }

    public long getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(long totalDays) {
        this.totalDays = totalDays;
    }

    public List<CustomerStat> getCustomers() {
        return customers;
    }

    public long getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses() {

        long count = 0;

        for (CustomerStat customerStat : customers) {
            count += customerStat.getTotalExpenses();
        }

        this.totalExpenses = count;
    }

    public double getAvgExpenses() {
        return avgExpenses;
    }

    public void setAvgExpenses() {

        long count = totalExpenses;

        if (customers.size() == 0 || count == 0) {
            this.avgExpenses = 0;
        } else {
            this.avgExpenses = (double) count / customers.size();
        }
    }
}
