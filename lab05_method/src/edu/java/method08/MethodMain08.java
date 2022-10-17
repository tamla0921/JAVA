package edu.java.method08;

public class MethodMain08 {

    public static void main(String[] args) {
        // main 메서드의 arguments
        System.out.println("args length = " + args.length); //원소도 한 개도 가지지 않는 메인메서드의 배열... null은 아님!
        String[] a = new String[0]; // != null (배열 조차도 없는 상태)
        for (String arg : args) {
            System.out.println(arg);
        }
    }

}
