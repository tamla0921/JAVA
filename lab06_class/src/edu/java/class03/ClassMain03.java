package edu.java.class03;

public class ClassMain03 {

    public static void main(String[] args) {
        // Rectangle 타입 변수 선언, Rectangle 객체 생성 저장.
        // 1) 기본 생성자 이용
        Rectangle rect1 = new Rectangle();
        
        System.out.println("rect1 가로 = " + rect1.width);
        System.out.println("rect1 세로 = " + rect1.height);
        
        System.out.println();
        
        // Rectangle 객체의 메서드 테스트.
        System.out.println("rect1 둘레 = " + rect1.perimeter());
        // 안에 rectangle.width, rectangle.height 안 해도 됨. 메서드에서 return this.... 를 적으면 자동으로 반환되기 때문에!! 다양한 방법이 존재...
        System.out.println("rect1 넓이 = " + rect1.area());
        
        System.out.println();
        
        // argument 2개를 갖는 생성자를 이용.
        Rectangle rect2 = new Rectangle(3, 4);
        
        System.out.println("rect2 가로 = " + rect2.width);
        System.out.println("rect2 세로 = " + rect2.height);
        
        System.out.println();
        
        System.out.println("rect2 둘레 = " + rect2.perimeter());
        System.out.println("rect2 넓이 = " + rect2.area());

    }

}
