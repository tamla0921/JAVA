package edu.java.generic01;

public class GenericMain01 {

    public static void main(String[] args) {
        // AppleBox 타입 객체 생성
        AppleBox appleBox = new AppleBox();
        
        // 사과 상자에 사과 객체를 저장
        // Apple apple = new Apple("대구사과");
        appleBox.put(new Apple("안동사과")); // 괄호 안에 새로운 객체를 바로 선언하기도 가능함을 잊지 말기.
        
        // 사과 상자에서 사과 객체를 꺼냄.
        System.out.println(appleBox.get().getType()); // 애플박스의 메서드의 리턴은 애플 타입형, 그래서 애플 타입의 메서드를 사용할 수 있음.
        //appleBox의 get() 메서드, return apple. 주소값을 가져옴.
        
        
        // OrangeBox 타입의 객체 생성
        OrangeBox orangeBox = new OrangeBox();
        
        // OrangeBox에 Orange 타입 객체를 저장.
        orangeBox.put(new Orange(90));
        
        // OrangeBox에 저장된 Orange 객체를 꺼냄
        System.out.println(orangeBox.get().getSugar());
    }

}
