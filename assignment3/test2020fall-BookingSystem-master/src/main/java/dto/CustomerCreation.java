package dto;

import java.util.Optional;

public class CustomerCreation {

    private final String firstname;
    private final String lastname;

    public CustomerCreation(String firstname, String lastname, Optional<String> phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
