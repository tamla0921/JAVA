package edu.java.condition02;

public class ConditionMain02 {

    public static void main(String[] args) {
        // 중첩 조건문
        
        double x = -3.14; //  소수의 기본 데이터는 Double,  float x = 3.14; 작성 시, ERROR - Type mismatch: cannot convert from double to float
                         /* float x = 3.14F 로 한다면 가능!*/
        
        // if - else if - else 문장
        if (x > 0) {
            System.out.println("양수");
        } else if (x < 0) {
            System.out.println("음수");
        } else {
            System.out.println("영");
        }

        if (x > 0) {
            System.out.println("Positive");
        } else {
            // 중첩 조건문
            if (x < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }
        
    }

}
