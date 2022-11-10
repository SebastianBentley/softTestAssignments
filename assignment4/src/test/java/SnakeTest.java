import org.junit.jupiter.api.Test;
import snake.GamePanel;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {

    GamePanel panel = new GamePanel();

    @Test
    public void test() {
        //arrange
        int expected = 0;
        //act
        int actual = panel.getX();
        //assert
        assertEquals(expected,actual );
    }
}
