package edu.java.lambda02;
import edu.java.lambda02.Calculator.Calculable;

public class Adder implements Calculable{
    public double calculate(double x, double y) {
        return x + y;
    }


}
