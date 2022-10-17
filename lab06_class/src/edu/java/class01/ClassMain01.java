package edu.java.class01;

public class ClassMain01 {

    public static void main(String[] args) {
        // User 클래스 타입으로 변수 선언, 객체 생성, 초기화.
        User user1 = new User();
        System.out.println(user1);
        System.out.println(user1.userId); //아무것도 넣지 않았다면, String의 기본값은 null(객체가 아직 만들어지지 않은 상태).
        System.out.println(user1.password);// null
        System.out.println(user1.age);// Int의 기본값은 0. // .(=참조 연산자): ~이 가지고 있는... 이라고 해석하면 이해하기 쉬움.
        
        user1.userId = "admin";
        user1.password = "abc123";
        user1.age = 16;
        
        System.out.println(user1.userId);
        System.out.println(user1.password);
        System.out.println(user1.age);
        
        User user2 = new User("guest", "guest", 0);
        
        System.out.println(user2);
        System.out.println(user2.userId);
        System.out.println(user2.password);
        System.out.println(user2.age);
        
        User user3 = new User("NoName");
        System.out.println(user3.userId);
        System.out.println(user3.password);
        System.out.println(user3.age);

    }

}
