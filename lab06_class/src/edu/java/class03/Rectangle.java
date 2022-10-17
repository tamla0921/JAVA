package edu.java.class03;


//class = filed + constructor + method ==> data type
public class Rectangle {
    // field - 가로, 세로
    double width; // 직사각형의 가로 길이, double = 8 bytes.
    double height; // 직사각형의 세로 길이, double = 8 bytes.
    
    // constructor - 기본 생성자, argument 2개를 갖는 생성자
    
    public Rectangle() {
        
    }
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        
    }
        
    
    // method - 둘레 길이, 넓이
    public double perimeter() {
        return 2 * (width + height); //this 생략 가능!! 왜냐하면 parameter값이 없기 때문에 여기서 return은 멤버변수를 찾는다.
                
    }
    
    public double area() {
        return this.width * this.height;
    }
    

}
