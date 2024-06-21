import code.solutions.CriticalReasoning;
import code.solutions.java.numbers.NumberCalculations;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CodeTest {
//    @Test
    public void testBouncingBall() {
        assertEquals(3, CriticalReasoning.bouncingBall(3, 0.66, 1.5), 0.0);
        assertEquals(-1, CriticalReasoning.bouncingBall(3, 1, 1.5), 0.0);
        assertEquals(-1, CriticalReasoning.bouncingBall(6, 0.1, 6), 0.0);
        assertEquals(1, CriticalReasoning.bouncingBall(6, 0.1, 2), 0.0);
    }

    @Test
    public void testGetSum() {
        assertEquals(-5, NumberCalculations.getSum(-5, 4));
        assertEquals(55, NumberCalculations.getSum(0, 10));
        assertEquals(0, NumberCalculations.getSum(-3, 3));
        assertEquals(1, NumberCalculations.getSum(1, 1));
        assertEquals(-55, NumberCalculations.getSum(-10, 0));
    }
}