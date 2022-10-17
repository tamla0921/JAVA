package edu.java.inheritance09;

public class Square extends Rectangle{
    // 필드
    //double length; 멤버 변수도 필요없음. 상위 클래스인 Rectangle에서 이미 가로 세로의 필드 멤버가 있기 때문이다.
    // 파라미터로 받은 값을 상위 클래스에 이미 존재했던 필드 멤버에게 값을 주면 끝.
    
    // 생성자
    public Square(double length) {
        super("정사각형", length, length);
    }
    
    // 메서드
    //public double area() {
    //    return super.area();
    //}
    
    //public double perimeter() {
    //   return super.perimeter();
    //}
    
    // 오버라이드 할 필요가 없다. 어차피 계산 방법은 상위 클래스의 Rectangle과 같기 때문이다. 따라서 그대로 물려받은 상위 클래스의 메서드를 사용하면 된다.
}
