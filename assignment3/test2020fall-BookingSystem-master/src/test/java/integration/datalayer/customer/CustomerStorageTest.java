package integration.datalayer.customer;

import datalayer.customer.CustomerStorage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("integration")
public class CustomerStorageTest {
    private CustomerStorage customerStorage;
}
