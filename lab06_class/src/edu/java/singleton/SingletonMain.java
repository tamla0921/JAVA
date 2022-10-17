package edu.java.singleton;

public class SingletonMain {

    public static void main(String[] args) {
        // Captain 타입 객체 생성
        Captain captain1 = Captain.getInstance();
        System.out.println(captain1);
        System.out.println(captain1.getName());
        
        
        
        Captain captain2 = Captain.getInstance();
        System.out.println(captain2); // 주소값이 captain1과 같다. 즉, 같은 객체를 가리킴.
        System.out.println(captain2.getName());
        
        captain2.setName("아이언맨");
        System.out.println(captain1.getName());
        System.out.println(captain2.getName());
    }

}
