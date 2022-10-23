package integration.datalayer.employee;

import datalayer.employee.EmployeeStorageImpl;
import datalayer.employee.EmplyeeStorage;
import dto.Employee;
import integration.ContainerizedDbIntegrationTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("integration")
public class EmployeeStorageTest  extends ContainerizedDbIntegrationTest {
    private EmplyeeStorage emplyeeStorage;

    @BeforeAll
    public void Setup() throws SQLException {
        runMigration(4);
        emplyeeStorage = new EmployeeStorageImpl(getConnectionString(), "root", getDbPassword());
        addFakeEmployees();
    }

    private void addFakeEmployees() throws SQLException {
        Employee e1 = new Employee("testFirstname", "testLastname", new Date(Calendar.getInstance().getTime().getTime()));
        Employee e2 = new Employee("testFirstname2", "testLastname2", new Date(Calendar.getInstance().getTime().getTime()));
        emplyeeStorage.createEmployee(e1);
        emplyeeStorage.createEmployee(e2);
    }



    @Test
    public void getEmployeeWithCorrectId() throws SQLException {
        // Act
        Collection<Employee> employees = emplyeeStorage.getEmployeeWithId(1);
        // Assert
        assertTrue(
                employees.stream().anyMatch(x ->
                        x.getId() == 1));
    }

    @Test
    public void mustReturnLatestId() throws SQLException {
        // Arrange
        Employee e1 = new Employee("testFirstname", "testLastname", new Date(Calendar.getInstance().getTime().getTime()));
        Employee e2 = new Employee("testFirstname2", "testLastname2", new Date(Calendar.getInstance().getTime().getTime()));
        // Act
        int id1 = emplyeeStorage.createEmployee(e1);
        int id2 = emplyeeStorage.createEmployee(e2);
        emplyeeStorage.createEmployee(e2);
        // Assert
        assertEquals(1, id2 - id1);
    }


}
