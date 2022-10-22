package datalayer.employee;

import dto.Employee;

import java.sql.SQLException;
import java.util.Collection;

public interface EmplyeeStorage {
    int createEmployee(Employee employee) throws SQLException;
    Collection<Employee> getEmployeeWithId(int employeeId) throws SQLException;
}
