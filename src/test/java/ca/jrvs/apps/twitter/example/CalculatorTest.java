package ca.jrvs.apps.twitter.example;

import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;
    
    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void evaluateHappyPath() {
        int sum = calculator.evaluate("1+2");

        assertNotNull(sum);

        //approach 1
        if (sum == 3) {
            System.out.println("It's correct");
        } else {
            throw new RuntimeException("Incorrect");
        }

        //approach 2
        assertTrue(3 == sum);

        //approach 3
        assertEquals(3, sum);

        assertEquals(2, sum);
    }

    @Test
    public void evaluateSadPath() {
        try {
            int sum = calculator.evaluate("1.1+2");
            fail();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
