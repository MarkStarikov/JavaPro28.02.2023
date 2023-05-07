package org.example;
public class Main {
    public static void main(String[] args)  {

        try {
            System.out.println(calculator(args[0], args[1], args[2]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static double calculator(String firstArgument,  String operator, String secondArgument)
            throws WrongOperatorException, DivisionByZeroException {
        double firstParameter = Double.parseDouble(firstArgument);
        double secondParameter = Double.parseDouble(secondArgument);
        if (secondParameter == 0 && operator.equals(":")){
            throw new DivisionByZeroException("division by zero is not possible");
        }
        return switch (operator) {
            case "+" -> firstParameter + secondParameter;
            case "-" -> firstParameter - secondParameter;
            case "x" -> firstParameter * secondParameter;
            case ":" -> firstParameter / secondParameter;
            default -> throw new WrongOperatorException("Incorrect operator");
        };
    }
}