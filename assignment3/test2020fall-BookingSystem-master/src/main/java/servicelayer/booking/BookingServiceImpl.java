package servicelayer.booking;

import datalayer.booking.BookingStorage;
import dto.Booking;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collection;

public class BookingServiceImpl implements BookingService {
    private BookingStorage bookingStorage;

    public BookingServiceImpl(BookingStorage bookingStorage) {
        this.bookingStorage = bookingStorage;
    }

    @Override
    public int createBooking(int customerId, int employeeId, Date date, Time start, Time end) throws BookingServiceException {
        try {
            return bookingStorage.createBooking(new Booking(customerId, employeeId, date, start, end));
        } catch (SQLException throwables) {
            throw new BookingServiceException(throwables.getMessage());
        }
    }

    @Override
    public Collection<Booking> getBookingForCustomer(int customerId) throws SQLException {
        return bookingStorage.getBookingsForCustomer(customerId);
    }

    @Override
    public Collection<Booking> getBookingForEmployee(int employeeId) throws SQLException {
        return bookingStorage.getBookingsForEmployee(employeeId);
    }
}
