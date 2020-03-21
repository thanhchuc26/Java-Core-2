/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_ExceptionsAndAssertions;

/**
 *
 * @author June
 */
// creating a user-defined exception class
class CalculatorException extends Exception { // line 1

    public CalculatorException() {
    }
// constructor with Throwable object as parameter

    public CalculatorException(Throwable cause) {
        super(cause);
    }
// constructor with a message string and Throwable object as parameter

    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }
// creating the Calculator class
}

class Calculator { // line 2
// method to divide two numbers

    public void divide(int a, int b) throws
            CalculatorException // line 3
    {
// try-catch block
        try {
            int result = a / b; // performing division
            System.out.println("Result is " + result);
        } catch (ArithmeticException ex) {
// throwing the wrapper exception – line 4
            throw new CalculatorException("Denominator cannot be zero", ex);
        }
    }
}

// creating the TestCalculator class
public class TestCalculator {
    public static void main(String[] args) {
        try {
// creating object of Calculator class
            Calculator objCalc = new Calculator();
// invoking the divide method
            objCalc.divide(10, 0);
        } catch (CalculatorException ex) {
// getting the cause from the wrapper
            Throwable t = ex.getCause(); // line 5
// printing the message and the cause
            System.out.println("Error: " + ex.getMessage()); //line 6
            System.out.println("Cause: " + t); // line 7
        }
    }
}
