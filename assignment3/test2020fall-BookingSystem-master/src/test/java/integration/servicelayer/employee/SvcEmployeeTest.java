package integration.servicelayer.employee;

import datalayer.employee.EmployeeStorageImpl;
import datalayer.employee.EmplyeeStorage;
import dto.Employee;
import integration.ContainerizedDbIntegrationTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.employee.EmployeeService;
import servicelayer.employee.EmployeeServiceException;
import servicelayer.employee.EmployeeServiceImpl;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SvcEmployeeTest extends ContainerizedDbIntegrationTest {
    private EmployeeService svc;
    private EmplyeeStorage storage;

    @BeforeAll
    public void setup() {
        runMigration(4);
        storage = new EmployeeStorageImpl(getConnectionString(),"root", getDbPassword());
        svc = new EmployeeServiceImpl(storage);
    }

    @Test
    public void mustSaveCustomerToDatabaseWhenCallingCreateCustomer() throws SQLException, EmployeeServiceException {
        // Arrange
        var firstName = "John";
        var lastName = "Johnson";
        Employee employee = new Employee(firstName, lastName, new Date(Calendar.getInstance().getTime().getTime()));
        int id = svc.createEmployee(employee);

        // Act
        var createdEmployee = storage.getEmployeeWithId(id);

        // Assert
        assertEquals(firstName, createdEmployee.stream().findAny().get().getFirstname());
        assertEquals(lastName, createdEmployee.stream().findAny().get().getLastname());
    }
}
