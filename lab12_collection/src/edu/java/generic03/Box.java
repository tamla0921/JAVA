package edu.java.generic03;

// generic 클래스: 타입 파라미터(들)을 갖는 클래스.
// class ClassName<A, B, ...> { ... }
// 타입 파라미터 갯수의 제한은 없음.
// 타입 파라미터는 필드 타입, 메서드 파라미터 타입, 메서드 리턴 타입으로 사용될 수 있음.
// 타입 파라미터는 기본 데이터 타입(boolean, int, long, double, ...)을 사용할 수 없음!
// 타입 파라미터에는 반드시 클래스 타입만 사용 가능! (단순히 이름이 아니라, 클래스객체를 나타냄)
// -> wrapper 클래스(Boolean, Integer, Long, Double, ...)들이 사용됨.

public class Box<아무이름적기> { // T대신 아무이름이나 적어도 가능.
    private 아무이름적기 content;
    
    public void put(아무이름적기 content) {
        this.content = content;
    }
    
    public 아무이름적기 get() {
        return content;
    }
}
