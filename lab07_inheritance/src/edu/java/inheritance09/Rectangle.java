package edu.java.inheritance09;

public class Rectangle extends Shape {
    //field
    protected double width;
    protected double height;
    
    //생성자
    protected Rectangle(String shape, double width, double height) {
        super(shape); // super("Rectanlge") 여기서는 별 의미가 없으므로...
        this.width = width;
        this.height = height;
        
        /*protected Rectangle() {
         * super();
         * 하위 클래스의 기본 생성자(생성자를 만들지 않았을 때  
         *  } */
    }
    
    //메서드
    @Override
    public double area() {
        return this.width * this.height;
    }
    
    @Override
    public double perimeter() {
        return 2.0 * (this.width + this.height);
    }

}
