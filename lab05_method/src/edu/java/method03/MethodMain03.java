package edu.java.method03;

public class MethodMain03 {

    public static void main(String[] args) {
        countdown(10);
        return;

    }
    
    public static void countdown(int n) {
        if (n < 0) {
            System.out.println("n은 0이상의 정수여야 합니다.");
            return; // 메서드 종료
            
        }
        for (int i = n; i >= 0 ; i--) {
            System.out.println(i);
        }
    }

}
