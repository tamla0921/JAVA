package edu.java.inheritance06;

public class UserMain {

    public static void main(String[] args) {
        User user1 = new User("dsad2", "1234");
        System.out.println("ID: " + user1.getId());
        System.out.println("PW: " + user1.getPassword());
        System.out.println(user1);
        
        User user2 = new User("dsad2", "5678");
        System.out.println(user1.equals(user2));
        
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        
        String u1 = new String("abc");
        String u2 = new String("abc");

        }

}
