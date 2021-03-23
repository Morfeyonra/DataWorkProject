package DataWork.PogoClasses;

public class Purchase {

    private final String name;
    private final long expenses;

    public Purchase(String name, long expenses) {
        this.name = name;
        this.expenses = expenses;
    }

    public String getName() {
        return name;
    }

    public long getExpenses() {
        return expenses;
    }
}
