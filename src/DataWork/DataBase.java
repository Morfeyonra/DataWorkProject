package DataWork;

import DataWork.PogoClasses.*;
import com.google.gson.Gson;

import java.sql.*;
import java.util.Queue;

class DataBase {

    private final String url = "jdbc:postgresql:test_DB";
    private final String user = "postgres";
    private final String password = "qwerty";

    public String getNames(Queue<LastName> lastNames) {

        StringBuilder results = new StringBuilder();

        Gson gson = new Gson();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {

                while (!lastNames.isEmpty()) {

                    results.append("{\"criteria\":")
                            .append(gson.toJson(lastNames.peek()))
                            .append(",\"results\":[");

                    try (ResultSet resultSet = statement
                            .executeQuery("SELECT lastName, firstName FROM Customers " +
                            "WHERE " +
                            "lastName = '" + lastNames.poll().getLastName() + "';")) {

                        while (resultSet.next()) {
                            Customer customer = new Customer(resultSet.getString("lastName"),
                                    resultSet.getString("firstName"));

                            results.append(gson.toJson(customer))
                                    .append(",");
                        }

                        if (results.charAt(results.length() - 1) != '[') {
                            results.deleteCharAt(results.length() - 1);
                        }

                        results.append("]}");

                    } catch (Exception ex) {
                        System.out.println("Ошибка подключения к БД или ошибочные данные");
                        return null;
                    }

                    results.append(",");
                }
            } catch (SQLException ex) {
                System.out.println("Ошибка подключения к БД");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к БД");
            return null;
        }

        return results.toString();
    }

    public String getNamesFromGoods(Queue<Good> goods) {

        StringBuilder results = new StringBuilder();

        Gson gson = new Gson();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {

                while (!goods.isEmpty()) {

                    results.append("{\"criteria\":")
                            .append(gson.toJson(goods.peek()))
                            .append(",\"results\":[");

                    try (ResultSet resultSet = statement
                            .executeQuery("SELECT lastname, firstname, good, COUNT(*) " +
                                    "FROM customers LEFT OUTER JOIN sales \n" +
                                    "ON (id = customerid)\n" +
                                    "GROUP BY lastname, firstname, good\n" +
                                    "HAVING COUNT(*) >= " + goods.peek().getMinTimes() +
                                    " and good = '" + goods.poll().getProductName() + "';")) {

                        while (resultSet.next()) {
                            Customer customer = new Customer(resultSet.getString("lastName"),
                                    resultSet.getString("firstName"));

                            results.append(gson.toJson(customer))
                                    .append(",");
                        }

                        if (results.charAt(results.length() - 1) != '[') {
                            results.deleteCharAt(results.length() - 1);
                        }

                        results.append("]}");

                    } catch (Exception ex) {
                        System.out.println("Ошибка подключения к БД или ошибочные данные");
                        return null;
                    }

                    results.append(",");
                }

            } catch (SQLException ex) {
                System.out.println("Ошибка подключения к БД");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к БД");
            return null;
        }
        return results.toString();
    }

    public String getNamesFromExpenses(Queue<Expense> expenses) {

        StringBuilder results = new StringBuilder();

        Gson gson = new Gson();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {

                while (!expenses.isEmpty()) {

                    results.append("{\"criteria\":")
                            .append(gson.toJson(expenses.peek()))
                            .append(",\"results\":[");

                    try (ResultSet resultSet = statement
                            .executeQuery("SELECT lastname, firstname FROM\n" +
                                    "(SELECT lastname, firstname, SUM(price) as prices \n" +
                                    "FROM customers LEFT OUTER JOIN sales\n" +
                                    "ON (id = customerid) \n" +
                                    "LEFT OUTER JOIN goods\n" +
                                    "ON (sales.good = goods.good)\n" +
                                    "GROUP BY lastname, firstname) AS foo\n" +
                                    "WHERE prices >= '" + expenses.peek().getMinExpenses() +
                                    "' AND prices <= '" + expenses.poll().getMaxExpenses() + "';")) {

                        while (resultSet.next()) {
                            Customer customer = new Customer(resultSet.getString("lastName"),
                                    resultSet.getString("firstName"));

                            results.append(gson.toJson(customer))
                                    .append(",");
                        }

                        if (results.charAt(results.length() - 1) != '[') {
                            results.deleteCharAt(results.length() - 1);
                        }

                        results.append("]}");

                    } catch (Exception ex) {
                        System.out.println("Ошибка подключения к БД или ошибочные данные");
                        return null;
                    }

                    results.append(",");
                }

            } catch (SQLException ex) {
                System.out.println("Ошибка подключения к БД");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к БД");
            return null;
        }
        return results.toString();
    }

    public String getNamesOfBaddies(Queue<BadCustomer> badCustomers) {

        StringBuilder results = new StringBuilder();

        Gson gson = new Gson();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {

                while (!badCustomers.isEmpty()) {

                    results.append("{\"criteria\":")
                            .append(gson.toJson(badCustomers.peek()))
                            .append(",\"results\":[");

                    try (ResultSet resultSet = statement
                            .executeQuery("SELECT lastname, firstname, COUNT(good) as boughtgoods \n" +
                                    "FROM customers LEFT OUTER JOIN sales\n" +
                                    "ON (id = customerid) \n" +
                                    "GROUP BY lastname, firstname\n" +
                                    "ORDER BY boughtgoods ASC\n" +
                                    "LIMIT " + badCustomers.poll().getBadCustomers() + ";")) {

                        while (resultSet.next()) {
                            Customer customer = new Customer(resultSet.getString("lastName"),
                                    resultSet.getString("firstName"));

                            results.append(gson.toJson(customer))
                                    .append(",");
                        }

                        if (results.charAt(results.length() - 1) != '[') {
                            results.deleteCharAt(results.length() - 1);
                        }

                        results.append("]}");

                    } catch (Exception ex) {
                        System.out.println("Ошибка подключения к БД или ошибочные данные");
                        return null;
                    }

                    results.append(",");
                }

            } catch (SQLException ex) {
                System.out.println("Ошибка подключения к БД");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к БД");
            return null;
        }
        return results.toString();
    }

    public String getStatistics(Stat stat) {

        Gson gson = new Gson();
        StatOutput statOutput = new StatOutput();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)) {

                try (ResultSet totalDays = statement
                        .executeQuery("SELECT ('" + stat.getEndDate() + "'::date " +
                                "- '" + stat.getStartDate() + "'::date) AS days;")) {
                    totalDays.next();
                    statOutput.setTotalDays(totalDays.getInt("days"));

                } catch (SQLException ex) {
                    System.out.println("Ошибка подключения к БД или неверные входные данные");
                    ExceptionPogo exceptionPogo = new ExceptionPogo();
                    exceptionPogo.setMessage("Ошибка подключения к БД или неверные входные данные");
                    return gson.toJson(exceptionPogo);
                }

                try (ResultSet resultSet = statement
                        .executeQuery("SELECT (lastname || ' ' || firstname) AS name," +
                                " sales.good, SUM(price) AS expenses\n" +
                                "FROM customers LEFT OUTER JOIN sales\n" +
                                "ON (id = customerid) LEFT OUTER JOIN goods\n" +
                                "ON (sales.good = goods.good)\n" +
                                "WHERE date BETWEEN '" + stat.getStartDate() + "' AND '" + stat.getEndDate() + "'\n" +
                                "GROUP BY name, sales.good\n" +
                                "ORDER BY name, expenses DESC\n")) {

                    while (resultSet.next()) {

                        String currentName = resultSet.getString("name");
                        CustomerStat customerStat = new CustomerStat(resultSet.getString("name"));

                        do {
                            if (currentName.equals(resultSet.getString("name"))) {

                                Purchase purchase = new Purchase(resultSet.getString("good"),
                                        resultSet.getLong("expenses"));

                                customerStat.getPurchases().add(purchase);

                            } else {
                                resultSet.previous();
                                break;
                            }
                        } while (resultSet.next());

                        customerStat.setTotalExpenses();

                        statOutput.getCustomers().add(customerStat);

                    }

                } catch (SQLException ex) {
                    System.out.println("Ошибка подключения к БД");
                    ExceptionPogo exceptionPogo = new ExceptionPogo();
                    exceptionPogo.setMessage("Ошибка подключения к БД");
                    return gson.toJson(exceptionPogo);
                }
            } catch (SQLException ex) {
                System.out.println("Ошибка подключения к БД");
                ExceptionPogo exceptionPogo = new ExceptionPogo();
                exceptionPogo.setMessage("Ошибка подключения к БД");
                return gson.toJson(exceptionPogo);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к БД");
            ExceptionPogo exceptionPogo = new ExceptionPogo();
            exceptionPogo.setMessage("Ошибка подключения к БД");
            return gson.toJson(exceptionPogo);
        }

        statOutput.setTotalExpenses();
        statOutput.setAvgExpenses();

        return gson.toJson(statOutput);
    }
}