package datalayer.booking;

import dto.Booking;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class BookingStorageImpl implements BookingStorage {
    private String connectionString;
    private String username, password;

    public BookingStorageImpl(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, username, password);
    }

    private final String CREATE_BOOKING = "INSERT INTO Bookings (customerId, employeeId, date, start, end) VALUES (?, ?, ?, ?, ?);";

    @Override
    public int createBooking(Booking booking) throws SQLException {
        try (Connection con = getConnection()) {
            PreparedStatement stmt = con.prepareStatement(CREATE_BOOKING, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, booking.getCustomerId());
            stmt.setInt(2, booking.getEmployeeId());
            stmt.setDate(3, booking.getDate());
            stmt.setTime(4, booking.getStart());
            stmt.setTime(5, booking.getEnd());

            stmt.executeUpdate();

            ResultSet resultSet = stmt.getGeneratedKeys();
            resultSet.next();
            int newId = resultSet.getInt(1);
            return newId;

        }
    }

    private final String GET_BOOKINGS_FOR_CUSTOMER = "SELECT ID, customerId, employeeId, date, start, end FROM Bookings WHERE customerId = ?";

    @Override
    public Collection<Booking> getBookingsForCustomer(int customerId) throws SQLException {
        try (Connection con = getConnection()) {
            ArrayList<Booking> bookings = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(GET_BOOKINGS_FOR_CUSTOMER);
            stmt.setInt(1, customerId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int custId = resultSet.getInt("customerId");
                int empId = resultSet.getInt("employeeId");
                Date date = resultSet.getDate("date");
                Time start = resultSet.getTime("start");
                Time end = resultSet.getTime("end");

                Booking booking = new Booking(id, custId, empId, date, start, end);
                bookings.add(booking);
            }
            return bookings;
        }
    }

    private final String GET_BOOKINGS_FOR_Employee = "SELECT ID, customerId, employeeId, date, start, end FROM Bookings WHERE employeeId = ?";

    @Override
    public Collection<Booking> getBookingsForEmployee(int employeeId) throws SQLException {
        try (Connection con = getConnection()) {
            ArrayList<Booking> bookings = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(GET_BOOKINGS_FOR_Employee);
            stmt.setInt(1, employeeId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int custId = resultSet.getInt("customerId");
                int empId = resultSet.getInt("employeeId");
                Date date = resultSet.getDate("date");
                Time start = resultSet.getTime("start");
                Time end = resultSet.getTime("end");

                Booking booking = new Booking(id, custId, empId, date, start, end);
                bookings.add(booking);
            }
            return bookings;
        }
    }
}
