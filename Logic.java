package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

public class Logic implements LogicInterface {
    protected ActivityInterface mOut;

    public Logic(ActivityInterface out) {
        mOut = out;
    }

    public static final int ADD = 1;
    public static final int SUBTRACT = 2;
    public static final int MULTIPLY = 3;
    public static final int DIVIDE = 4;

    public interface Operation {
        int perform(int argumentOne, int argumentTwo);
    }

    public class Add implements Operation {
        @Override
        public int perform(int argumentOne, int argumentTwo) {
            return argumentOne + argumentTwo;
        }
    }

    public class Subtract implements Operation {
        @Override
        public int perform(int argumentOne, int argumentTwo) {
            return argumentOne - argumentTwo;
        }
    }

    public class Multiply implements Operation {
        @Override
        public int perform(int argumentOne, int argumentTwo) {
            return argumentOne * argumentTwo;
        }
    }

    public class Divide implements Operation {
        @Override
        public int perform(int argumentOne, int argumentTwo) {
            if (argumentTwo == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return argumentOne / argumentTwo;
        }

        public int getRemainder(int argumentOne, int argumentTwo) {
            if (argumentTwo == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return argumentOne % argumentTwo;
        }
    }

    public void process(int argumentOne, int argumentTwo, int operation) {
        Operation op;
        int result;
        String output;

        switch (operation) {
            case ADD:
                op = new Add();
                result = op.perform(argumentOne, argumentTwo);
                output = "Result: " + result;
                break;
            case SUBTRACT:
                op = new Subtract();
                result = op.perform(argumentOne, argumentTwo);
                output = "Result: " + result;
                break;
            case MULTIPLY:
                op = new Multiply();
                result = op.perform(argumentOne, argumentTwo);
                output = "Result: " + result;
                break;
            case DIVIDE:
                try {
                    Divide div = new Divide();
                    int quotient = div.perform(argumentOne, argumentTwo);
                    int remainder = div.getRemainder(argumentOne, argumentTwo);
                    output = "Result: " + quotient + " Remainder: " + remainder;
                } catch (ArithmeticException e) {
                    output = "Error: " + e.getMessage();
                }
                break;
            default:
                output = "Unknown operation";
                break;
        }

        mOut.print(output);
    }
}