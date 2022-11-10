import mockitostuff.Calculator;
import mockitostuff.CalculatorService;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.mockito.ArgumentMatchers.argThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//With inspiration from Telusko youtube channel
public class MockitoStuffTest {

    Calculator c;

    @Mock
    CalculatorService service = Mockito.mock(CalculatorService.class);

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @BeforeEach
    public void setUp() {
        c = new Calculator(service);
    }

    //How do you verify that a mock was called?
    @Test
    public void question1() {
        when(service.add(2,3)).thenReturn(5);
        assertEquals(10, c.calculate(2,3 ));
        verify(service).add(2, 3);
    }

    //How do you verify that a mock was NOT called?
    @Test
    public void question2() {
        when(service.add(2,3)).thenReturn(5);
        //assertEquals(10, c.calculate(2,3 ));
        verify(service, never()).add(2, 3);
    }

    //How do you specify how many times a mock should have been called?
    @Test
    public void question3() {
        when(service.add(2,3)).thenReturn(5);
        assertEquals(10, c.calculate(2,3 ));
        assertEquals(10, c.calculate(2,3 ));
        verify(service, times(2)).add(2, 3);
    }


    //How do you verify that a mock was called with specific arguments?
    @Test
    public void question4() {
        when(service.add(2,3, argThat((a, b) -> a==2 && b==3))).thenReturn(5);
        assertEquals(10, c.calculate(2,3 ));
        verify(service).add(2,3);
    }

    //How do you use a predicate to verify the properties of the arguments given to a call to the mock?
    @Test
    public void question5() {
        when(service.add(2,3)).thenReturn(5);
        assertEquals(10, c.calculate(2,3 ));
        verify(service, argThat(a -> true)).add(2,3);
    }




}
