public class FactorialCalculator {

    public static long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        if (number > 20) {
            throw new IllegalArgumentException("Number must be less than or equal to 20");
        }
        if (number == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}