package DataWork.PogoClasses;

public class Expense {
    private final long minExpenses;
    private final long maxExpenses;

    public Expense(long minExpenses, long maxExpenses) {
        this.minExpenses = minExpenses;
        this.maxExpenses = maxExpenses;
    }

    public long getMinExpenses() {
        return minExpenses;
    }

    public long getMaxExpenses() {
        return maxExpenses;
    }
}
