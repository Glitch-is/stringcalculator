package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.hamcrest.Matcher;

public class CalculatorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testEmptyString()
    {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testOneNumber()
    {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void testTwoNumbers()
    {
        assertEquals(10, Calculator.add("5,5"));
    }

    @Test
    public void testMultipleNumbers()
    {
        assertEquals(6, Calculator.add("1,1,1,2,1"));
    }

    @Test
    public void testNewline()
    {
        assertEquals(15, Calculator.add("5\n4,3\n2,1"));
    }

    @Test
    public void testOneNegativeNumber()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Negatives not allowed: -1");

        Calculator.add("-1,2");
    }

    @Test
    public void testMultipleNegativeNumber()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Negatives not allowed: -1,-4");

        Calculator.add("-1,2,3,-4");
    }

    @Test
    public void testLargerThanThousand()
    {
        assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testCustomDelimiter()
    {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }

}

