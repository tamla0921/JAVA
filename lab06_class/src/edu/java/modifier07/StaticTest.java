package edu.java.modifier07;

public class StaticTest {
    int instanceVariable; // 인스턴스 변수
    static int staticVariable; // static 변수
    
    public void printVariables() {
        // 생성자를 호출할 때 인스턴스 변수가 만들어지기 때문에, 메서드를 사용할 수 있다?
        System.out.println("--- instance method ---");
        System.out.println("인스턴스 변수 = " + instanceVariable);
        System.out.println("static 변수 = " + staticVariable);
    }
    
    public static void printVariables2() {
        System.out.println("--- static method ---");
//        System.out.println("인스턴스 변수 = " + instanceVariable); // Cannot make a static reference to the non-static field instanceVariable
        // ** static 멤버는 static이 아닌 멤버를 사용할 수 없다!! 따라서 instanceVariable은 인스턴스 변수이기 때문에 불가
        // ** static은 객체를 생성하지 않아도, 이름만으로 접근이 가능.
        System.out.println("static 변수 = " + staticVariable);
    }
    
    
}

