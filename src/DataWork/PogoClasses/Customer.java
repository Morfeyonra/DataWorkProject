package DataWork.PogoClasses;

public class Customer {

    private final String lastName;
    private final String firstname;

    public Customer(String lastName, String firstname) {
        this.lastName = lastName;
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFirstname() {
        return firstname;
    }
}
