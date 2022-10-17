package edu.java.loop06;

public class LoopMain06 {

    public static void main(String[] args) {
        // for 반복문
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        
        System.out.println("-----");
        int n = 1;
        while (n <= 5) {
            System.out.println(n);
            n++;
        }
        
        System.out.println("-----");
        //10부터 1까지 정수들을 내림차순으로 한 줄에 출력하세요. (10 9 8 ... 3 2 1)
        
        for (int i = 10; i > 0 ; i--) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("-----");
        n = 10;
        while (n > 0) {
            System.out.print(n + " ");
            n--;
        }
        System.out.println();
        System.out.println("-----");
        
        for (int i = 1 ; i <= 10 ; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        
        System.out.println();
        System.out.println("-----");
        
        for (int i = 1; i < 10 ; i +=2 ) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("-----");
        
        n = 1;
        while (n < 10) {
            System.out.print(n + " ");
            n += 2;
        }
        
        System.out.println();
        System.out.println("-----");
        
        n = 1;
        while (n < 10) {
            if (n % 2 == 1) { // n이 홀수이면,
                System.out.print(n + " ");
            }
            n++;
        }
        

    }

}
