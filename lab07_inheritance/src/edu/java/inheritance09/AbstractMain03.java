package edu.java.inheritance09;

public class AbstractMain03 {

    public static void main(String[] args) {
        // Rectangle, Circle 클래스를 구현(implement)
        // Rectangle, Circle 타입의 객체에서 draw() 메서드 동작 여부 테스트
        
        Rectangle new1 = new Rectangle("사각형", 3.0, 3.0);
        new1.draw();
        
        Circle new2 = new Circle("원", 3);
        new2.draw();
        
        Shape[] shapes = {
                new1, 
                new2, 
                new Rectangle("사각형", 4.0, 3.0), 
                new Circle("원", 10.0)};
        
        for (Shape x : shapes) {
            x.draw();
            
        }
        
        Square new3 = new Square(3);
        new3.draw();
        
//        Shape new3 = new Shape(); : Cannot instantiate the type Shape;
//        HHO new4 = new HHO(); // HHO cannot be resolved to a type --> abstract 클래스와 정의되지 않은 클래스의 에러 차이.
        

    }

}
