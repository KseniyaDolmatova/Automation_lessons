import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(FactorialCalculator.factorial(5), 120);
        Assert.assertEquals(FactorialCalculator.factorial(6), 720);
    }

    @Test
    public void testFactorialOfOne() {
        Assert.assertEquals(FactorialCalculator.factorial(1), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Number must be non-negative")
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.factorial(-1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Number must be less than or equal to 20")
    public void testFactorialExceedsMaxLimit() {
        FactorialCalculator.factorial(21); // Проверка на верхнюю границу
    }
}