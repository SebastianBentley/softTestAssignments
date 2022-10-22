package main;

import datalayer.booking.BookingStorageImpl;
import dto.Booking;
import dto.Customer;
import datalayer.customer.CustomerStorageImpl;
import dto.CustomerCreation;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;

public class Main {

    private static final String conStr = "jdbc:mysql://localhost:3307/testassignment";
    private static final String user = "root";
    private static final String pass = "testuser123";

    public static void main(String[] args) throws SQLException {
        CustomerStorageImpl storage = new CustomerStorageImpl(conStr, user, pass);
        BookingStorageImpl booking = new BookingStorageImpl(conStr, user, pass);

        //CustomerCreation c1 = new CustomerCreation("test", "mcgee");

        //Booking b1 = new Booking(1, 1, 1, new Date(Calendar.getInstance().getTime().getTime()), Time.valueOf("12:00:00"), Time.valueOf("13:00:00"));
        //booking.createBooking(b1);




        System.out.println("Got customers: ");
        for(Customer c : storage.getCustomers()) {
            System.out.println(toString(c));
        }
        System.out.println("The end.");
    }

    public static String toString(Customer c) {
        return "{" + c.getId() + ", " + c.getFirstname() + ", " + c.getLastname() + ", " + c.getPhonenumber().orElse("no phonenumber") + "}";
    }
}
