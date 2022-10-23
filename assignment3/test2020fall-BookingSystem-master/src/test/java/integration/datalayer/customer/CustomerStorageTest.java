package integration.datalayer.customer;

import com.github.javafaker.Faker;
import datalayer.customer.CustomerStorage;
import datalayer.customer.CustomerStorageImpl;
import dto.Customer;
import dto.CustomerCreation;
import integration.ContainerizedDbIntegrationTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("integration")
public class CustomerStorageTest extends ContainerizedDbIntegrationTest {
    private CustomerStorage customerStorage;

    @BeforeAll
    public void Setup() throws SQLException {
        runMigration(4);

        customerStorage = new CustomerStorageImpl(getConnectionString(), "root", getDbPassword());

        int numCustomers = customerStorage.getCustomers().size();
        if (numCustomers < 100) {
            addFakeCustomers(100 - numCustomers);
        }
    }

    private void addFakeCustomers(int numCustomers) throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < numCustomers; i++) {
            CustomerCreation c = new CustomerCreation(faker.name().firstName(), faker.name().lastName(), Optional.empty());
            customerStorage.createCustomer(c);
        }
    }


    @Test
    public void mustSaveCustomerToTheDatabase() throws SQLException {
        // Arrange
        CustomerCreation customer = new CustomerCreation("TestFirstname", "testLastname", Optional.of("12344321"));
        // Act
        customerStorage.createCustomer(customer);
        // Assert
        Collection<Customer> customers = customerStorage.getCustomers();
        assertTrue(
                customers.stream().anyMatch(x ->
                        x.getFirstname().equals("TestFirstname") &&
                                x.getLastname().equals("testLastname") &&
                                x.getPhonenumber().get().equals("12344321")));
    }


    @Test
    public void mustGetCustomerWithCorrectId() throws SQLException {
        Customer c = customerStorage.getCustomerWithId(1);
        assertFalse(c.getFirstname().isEmpty());
    }

    @Test
    public void mustNotBeEmptyWhenGettingAllCustomers() throws SQLException {
        Collection<Customer> c = customerStorage.getCustomers();
        assertFalse(c.isEmpty());
    }


}
