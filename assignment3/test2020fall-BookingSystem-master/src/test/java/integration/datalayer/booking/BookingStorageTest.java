package integration.datalayer.booking;

import datalayer.booking.BookingStorage;
import datalayer.booking.BookingStorageImpl;
import datalayer.customer.CustomerStorage;
import datalayer.customer.CustomerStorageImpl;
import datalayer.employee.EmployeeStorageImpl;
import datalayer.employee.EmplyeeStorage;
import dto.Booking;
import dto.CustomerCreation;
import dto.Employee;
import integration.ContainerizedDbIntegrationTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.booking.BookingServiceException;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("integration")
public class BookingStorageTest extends ContainerizedDbIntegrationTest {
    private BookingStorage bookingStorage;
    private CustomerStorage customerStorage;
    private EmplyeeStorage emplyeeStorage;

    @BeforeAll
    public void Setup() throws SQLException {
        runMigration(4);

        bookingStorage = new BookingStorageImpl(getConnectionString(), "root", getDbPassword());
        customerStorage = new CustomerStorageImpl(getConnectionString(), "root", getDbPassword());
        emplyeeStorage = new EmployeeStorageImpl(getConnectionString(), "root", getDbPassword());

        addFakeBooking();
    }

    private void addFakeBooking() throws SQLException {
            customerStorage.createCustomer(new CustomerCreation("Hans", "testname", Optional.of("12345678")));
            emplyeeStorage.createEmployee(new Employee("Emp", "testemp", new Date(Calendar.getInstance().getTime().getTime())));
            Booking b = new Booking(1, 1, 1, new Date(Calendar.getInstance().getTime().getTime()), Time.valueOf("12:00:00"), Time.valueOf("13:00:00"));
            bookingStorage.createBooking(b);
    }

    @Test
    public void mustSaveBookingInDatabaseWhenCallingCreateBooking() throws SQLException {
        // Arrange
        Booking testBooking = new Booking(2, 1, 1,  new Date(Calendar.getInstance().getTime().getTime()), Time.valueOf("12:00:00"), Time.valueOf("13:00:00"));
        // Act
        bookingStorage.createBooking(testBooking);
        // Assert
        Collection<Booking> bookings = bookingStorage.getBookingsForCustomer(1);
        assertTrue(
                bookings.stream().anyMatch(x ->
                        x.getCustomerId() == 1 &&
                                x.getEmployeeId() == 1));
    }

    @Test
    public void mustReturnLatestId() throws SQLException {
        // Arrange
        // Act
        Booking testBooking1 = new Booking(3, 1, 1,  new Date(Calendar.getInstance().getTime().getTime()), Time.valueOf("12:00:00"), Time.valueOf("13:00:00"));
        Booking testBooking2 = new Booking(4, 1, 1,  new Date(Calendar.getInstance().getTime().getTime()), Time.valueOf("12:00:00"), Time.valueOf("13:00:00"));

        int id1 = bookingStorage.createBooking(testBooking1);
        int id2 = bookingStorage.createBooking(testBooking2);
        // Assert
        assertEquals(1, id2 - id1);
    }

    @Test
    public void getBookingWithIdOneHasCorrectCustomer() throws SQLException {
        // Act
        Collection<Booking> bookings = bookingStorage.getBookingsForCustomer(1);
        // Assert
        assertTrue(
                bookings.stream().anyMatch(x ->
                        x.getCustomerId() == 1 &&
                                x.getEmployeeId() == 1));
    }

    @Test
    public void getBookingWithNonExistingCustomerId() throws SQLException {
        // Assert
        Collection<Booking> bookings = bookingStorage.getBookingsForCustomer(-1);
        assertTrue(bookings.isEmpty());
    }

    @Test
    public void getBookingWithIdOneHasCorrectEmployee() throws SQLException {
        // Act
        Collection<Booking> bookings = bookingStorage.getBookingsForEmployee(1);
        // Assert
        assertTrue(
                bookings.stream().anyMatch(x ->
                        x.getCustomerId() == 1 &&
                                x.getEmployeeId() == 1));
    }

    @Test
    public void getBookingWithNonExistingEmployeeId() throws SQLException {
        // Assert
        Collection<Booking> bookings = bookingStorage.getBookingsForEmployee(-1);
        assertTrue(bookings.isEmpty());
    }

}
