package edu.java.inheritance09;

public class Circle extends Shape {
    // field
    protected double radius;
    
    // 생성자
    protected Circle(String shape, double radius) {
        super(shape);
        this.radius = radius;
    /* public Circle(double radius) {
     * super("Circle");
     * this.raius = radius'
     */
    }
    
    // 메서드
    @Override
    public double area() {
        return this.radius * this.radius * Math.PI;
    }
    
    @Override
    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }

}
