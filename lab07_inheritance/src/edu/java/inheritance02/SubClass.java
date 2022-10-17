package edu.java.inheritance02;

public class SubClass extends SuperClass {
    
    public SubClass() {
        super(0);
        // superclass가 기본 생성자를 가지고 있지 않기 때문에,
        // 명시적으로(explicitly) superclass의 argument를 가지는 생성자를 호출해야만 함!
    }
    
    public SubClass(int a) {
        super(a);
    }
    

}
