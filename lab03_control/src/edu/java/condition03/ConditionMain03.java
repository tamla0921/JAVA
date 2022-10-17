package edu.java.condition03;

import java.util.Scanner; // Scanner생성 후 Ctrl + Space 누르면 자동 생성.

public class ConditionMain03 {

    public static void main(String[] args) {
        // Scanner 타입의 변수 선언, 초기화.
        
        // int 타입 변수에 콘솔에서 입력한 정수를 저장.
        
        /* 입력한 점수가 90점 이상이면, A
         * 80점 이상이면, B
         * 70점 이상이면, c
         * 60점 이상이면, D
         * 60점 미만이면, F출력
         */
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("점수를 입력하시오: ");
        int score = scanner.nextInt();
        System.out.println("입력된 점수는 " + score +"점 입니다.");
        
        if (score >= 90) {
            System.out.println("A학점");
        } else if (score >= 80) {
            System.out.println("B학점");
        } else if (score >= 70) {
            System.out.println("C학점");
        } else if (score >= 60) {
            System.out.println("D학점");
            
        } else {
            System.out.println("F학점");
        }
        
    }

}
