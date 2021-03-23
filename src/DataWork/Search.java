package DataWork;

import DataWork.PogoClasses.BadCustomer;
import DataWork.PogoClasses.Expense;
import DataWork.PogoClasses.Good;
import DataWork.PogoClasses.LastName;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Search {

    private Queue<LastName> lastNames;
    private Queue<Good> goods;
    private Queue<Expense> expenses;
    private Queue<BadCustomer> badCustomers;

    public Queue<LastName> getLastNames() {
        return lastNames;
    }
    public void setLastNames(Queue<LastName> lastNames) {
        this.lastNames = lastNames;
    }

    public Queue<Good> getGoods() {
        return goods;
    }
    public void setGoods(Queue<Good> goods) {
        this.goods = goods;
    }

    public Queue<Expense> getExpenses() {
        return expenses;
    }
    public void setExpenses(Queue<Expense> expenses) {
        this.expenses = expenses;
    }

    public Queue<BadCustomer> getBadCustomers() {
        return badCustomers;
    }
    public void setBadCustomers(Queue<BadCustomer> badCustomers) {
        this.badCustomers = badCustomers;
    }

    public boolean parseSearch(String inputString) {

        inputString = inputString.replaceAll(" +", "")
                .replaceAll("\n+", "")
                .replaceAll("\r+", "");

        if (isBroken(inputString)) {
            return true;
        }

        inputString = inputString.replaceAll("\"+", "");

        setLastNames(lastNameAdding(inputString));
        setGoods(goodsAdding(inputString));
        setExpenses(expensesAdding(inputString));
        setBadCustomers(badCustomersAdding(inputString));

        return false;
    }

    public Queue<LastName> lastNameAdding(String inputString) {

        Queue<LastName> lastNames = new ArrayDeque<>();

        Pattern pattern = Pattern.compile("\\{lastName:.+?}");
        boolean power = true;

        while (power) {

            Matcher matcher0 = pattern.matcher(inputString);

            if (matcher0.find()) {

                LastName lastName = new LastName(matcher0.group().substring(10).replaceFirst("}", ""));
                lastNames.add(lastName);
                inputString = matcher0.replaceFirst("");

            } else {
                power = false;
            }
        }
        return lastNames;
    }

    public Queue<Good> goodsAdding(String inputString) {

        Queue<Good> goods = new ArrayDeque<>();

        Pattern pattern0 = Pattern.compile("\\{productName:.+?,");
        Pattern pattern1 = Pattern.compile("minTimes:.+?}");
        boolean power = true;

        while (power) {

            Matcher matcher0 = pattern0.matcher(inputString);
            Matcher matcher1 = pattern1.matcher(inputString);

            if (matcher0.find() && matcher1.find()) {

                String prodName = matcher0.group().substring(13).replaceFirst(",", "");
                String prodNum = matcher1.group().substring(9).replaceFirst("}", "");
                Good good = new Good(prodName, Long.parseLong(prodNum));
                goods.add(good);

                inputString = matcher0.replaceFirst("");
                inputString = matcher1.replaceFirst("");

            } else {
                power = false;
            }
        }
        return goods;
    }

    public Queue<Expense> expensesAdding(String inputString) {

        Queue<Expense> expenses = new ArrayDeque<>();

        Pattern pattern0 = Pattern.compile("\\{minExpenses:.+?,");
        Pattern pattern1 = Pattern.compile("maxExpenses:.+?}");
        boolean power = true;

        while (power) {

            Matcher matcher0 = pattern0.matcher(inputString);
            Matcher matcher1 = pattern1.matcher(inputString);

            if (matcher0.find() && matcher1.find()) {

                String minExpenses = matcher0.group().substring(13).replaceFirst(",", "");
                String maxExpenses = matcher1.group().substring(12).replaceFirst("}", "");
                Expense expense = new Expense(Long.parseLong(minExpenses), Long.parseLong(maxExpenses));
                expenses.add(expense);

                inputString = matcher0.replaceFirst("");
                inputString = matcher1.replaceFirst("");

            } else {
                power = false;
            }
        }
        return expenses;
    }

    public Queue<BadCustomer> badCustomersAdding(String inputString) {

        Queue<BadCustomer> badCustomers = new ArrayDeque<>();

        Pattern pattern0 = Pattern.compile("\\{badCustomers:.+?}");
        boolean power = true;

        while (power) {
            Matcher matcher0 = pattern0.matcher(inputString);

            if (matcher0.find()) {
                long nOBC = Long.parseLong(matcher0.group().substring(14).replaceFirst("}", ""));
                BadCustomer badCustomer = new BadCustomer(nOBC);
                badCustomers.add(badCustomer);
                inputString = matcher0.replaceFirst("");
            } else {
                power = false;
            }
        }
        return badCustomers;
    }

    public boolean isBroken(String inputString) {

        Pattern pattern = Pattern.compile("\\{\"criterias\":\\[");
        Matcher matcher = pattern.matcher(inputString);

        if (!matcher.find()) {
            return true;
        }

        matcher.reset();

        pattern = Pattern.compile("\\{\"lastName\":\".+?\"},?");
        matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            inputString = matcher.replaceAll("");
        }

        matcher.reset();

        pattern = Pattern.compile("\\{\"productName\":\".+?\",\"minTimes\":\\d+?},?");
        matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            inputString = matcher.replaceAll("");
        }

        matcher.reset();

        pattern = Pattern.compile("\\{\"minExpenses\":\\d+?,\"maxExpenses\":\\d+?},?");
        matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            inputString = matcher.replaceAll("");
        }

        matcher.reset();

        pattern = Pattern.compile("\\{\"badCustomers\":\\d+?},?");
        matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            inputString = matcher.replaceAll("");
        }

        matcher.reset();

        pattern = Pattern.compile("]}");
        matcher = pattern.matcher(inputString);

        if (!matcher.find()) {
            return true;
        }

        if (inputString.equals("{\"criterias\":[]}")) {
            return false;
        }
        return true;
    }
}