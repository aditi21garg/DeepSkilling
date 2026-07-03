import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AAAPatternTest {

    private int a;
    private int b;

    @Before
    public void setUp() {
        // Runs before each test - setup fixtures
        a = 5;
        b = 3;
        System.out.println("Setup: a=" + a + ", b=" + b);
    }

    @Test
    public void testAddition() {
        // Arrange
        int expected = 8;

        // Act
        int result = a + b;

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testSubtraction() {
        // Arrange
        int expected = 2;

        // Act
        int result = a - b;

        // Assert
        assertEquals(expected, result);
    }

    @After
    public void tearDown() {
        // Runs after each test - cleanup
        System.out.println("Teardown complete");
        a = 0;
        b = 0;
    }
}