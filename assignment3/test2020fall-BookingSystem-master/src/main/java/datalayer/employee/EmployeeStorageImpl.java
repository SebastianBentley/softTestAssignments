package datalayer.employee;

import dto.Booking;
import dto.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class EmployeeStorageImpl implements EmplyeeStorage {
    private String connectionString;
    private String username, password;

    public EmployeeStorageImpl(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, username, password);
    }


    private final String CREATE_EMPLOYEE = "INSERT INTO Employees(firstname, lastname, birthdate) VALUES (?, ?, ?);";

    @Override
    public int createEmployee(Employee employee) throws SQLException {
        try (Connection con = getConnection()) {
            PreparedStatement stmt = con.prepareStatement(CREATE_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, employee.getFirstname());
            stmt.setString(2, employee.getLastname());
            stmt.setDate(3, employee.getBirthdate());

            stmt.executeUpdate();

            ResultSet resultSet = stmt.getGeneratedKeys();
            resultSet.next();
            int newId = resultSet.getInt(1);
            return newId;
        }
    }

    private final String GET_EMPLOYEE_BY_ID = "SELECT ID, firstname, lastname, birthdate FROM Employees WHERE employeeId = ?";

    @Override
    public Collection<Employee> getEmployeeWithId(int employeeId) throws SQLException {
        try (Connection con = getConnection()) {
            ArrayList<Employee> employees = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(GET_EMPLOYEE_BY_ID);
            stmt.setInt(1, employeeId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                Date birthdate = resultSet.getDate("birthdate");
                Employee employee = new Employee(id, firstname, lastname, birthdate);
                employees.add(employee);
            }
            return employees;
        }
    }
}
