package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */


public class Divide {
    public int perform(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return num1 / num2;
    }

    public int getRemainder(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return num1 % num2;
    }
}
