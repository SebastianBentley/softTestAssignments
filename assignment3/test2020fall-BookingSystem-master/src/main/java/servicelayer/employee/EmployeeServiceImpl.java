package servicelayer.employee;

import datalayer.employee.EmplyeeStorage;
import dto.Employee;

import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService {
    private EmplyeeStorage employeeStorage;

    public EmployeeServiceImpl(EmplyeeStorage employeeStorage) {
        this.employeeStorage = employeeStorage;
    }

    @Override
    public int createEmployee(Employee employee) throws EmployeeServiceException {
        try {
            return employeeStorage.createEmployee(employee);
        }catch (SQLException throwables) {
            throw new EmployeeServiceException(throwables.getMessage());
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) throws SQLException {
        //yeah this is kinda stupid, just following the requirements, instead of returning a Collection or altering the datalayer return type...
        return employeeStorage.getEmployeeWithId(employeeId).stream().findAny().orElse(null);
    }
}
