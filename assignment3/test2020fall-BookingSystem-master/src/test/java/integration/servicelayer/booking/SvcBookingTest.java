package integration.servicelayer.booking;

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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.booking.BookingService;
import servicelayer.booking.BookingServiceException;
import servicelayer.booking.BookingServiceImpl;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SvcBookingTest extends ContainerizedDbIntegrationTest {

    private BookingService bookingService;
    private BookingStorage bookingStorage;
    private CustomerStorage customerStorage;
    private EmplyeeStorage emplyeeStorage;

    @BeforeAll
    public void setup() throws SQLException {
        runMigration(4);
        bookingStorage = new BookingStorageImpl(getConnectionString(),"root", getDbPassword());
        bookingService = new BookingServiceImpl(bookingStorage);
        customerStorage = new CustomerStorageImpl(getConnectionString(), "root", getDbPassword());
        emplyeeStorage = new EmployeeStorageImpl(getConnectionString(), "root", getDbPassword());

        addFakeBooking();
    }

    private void addFakeBooking() throws SQLException {
        customerStorage.createCustomer(new CustomerCreation("Hans", "testname", Optional.of("12345678")));
        emplyeeStorage.createEmployee(new Employee("Emp", "testemp", new java.sql.Date(Calendar.getInstance().getTime().getTime())));
        Booking b = new Booking(1, 1, 1, new java.sql.Date(Calendar.getInstance().getTime().getTime()), Time.valueOf("12:00:00"), Time.valueOf("13:00:00"));
        bookingStorage.createBooking(b);
    }

    @Test
    public void mustSaveBookingToDatabaseWhenCallingCreateBooking() throws BookingServiceException, SQLException {
        // Arrange
        int id = bookingService.createBooking(1, 1,  new java.sql.Date(Calendar.getInstance().getTime().getTime()), Time.valueOf("12:00:00"), Time.valueOf("13:00:00"));
        // Act

        //Get with customerId
        Collection<Booking> createdBookingCustomerId = bookingService.getBookingForCustomer(1);

        //Get with employeeId
        Collection<Booking> createdBookingEmployeeId = bookingService.getBookingForEmployee(1);
        // Assert
        assertEquals(1, createdBookingCustomerId.stream().findAny().get().getCustomerId());
        assertEquals(1, createdBookingEmployeeId.stream().findAny().get().getEmployeeId());
    }



}
