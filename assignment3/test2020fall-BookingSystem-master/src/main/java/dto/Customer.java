package dto;

import java.util.Optional;

public class Customer {
    private final int id;
    private final String firstname, lastname;
    private final Optional<String> phonenumber;

    public Customer(int id, String firstname, String lastname, Optional<String> phonenumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Optional<String> getPhonenumber() {
        return phonenumber;
    }
}
