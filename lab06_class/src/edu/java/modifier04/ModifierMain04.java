package edu.java.modifier04;

public class ModifierMain04 {

    public static void main(String[] args) {
        // Member 타입의 객체 생성.
        Member member = new Member("guest", "0000");
        
        System.out.println(member.getId());
//        member.get_ID();
//        m.id = ""; // private 멤버는 다른 클래스에서 직접 사용할 수 없음.
        System.out.println(member.getPassword());
        
        member.setPassword("willit321");
        System.out.println(member.getPassword());
        
        
        

    }

}
