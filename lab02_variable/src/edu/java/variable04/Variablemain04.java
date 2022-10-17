package edu.java.variable04;

import java.util.Scanner;

public class Variablemain04 {

    public static void main(String[] args) {
        // 콘솔 창에서 키보드로 숫자를 입력받아서 변수에 저장:

        // 1. Scanner 타입의 변수를 선언하고 초기화.
        Scanner scanner = new Scanner(System.in); // scanner의 생성자: new Scanner(InputStream source) 파라미터에 System.in을 넣은 것.

        // System.out.println("정수를 입력>>>");

        // 2. Scanner 객체를 사용해서 콘솔 창에서 정수를 입력받고 저장.
        // int number = scanner.nextInt();
        // System.out.println("number= " + number);

        // 시험 점수에 대한 총점과 평균 구하기.

        // Java 시험 점수(정수)를 입력하시오.
        // SQL 시험 점수(정수)를 입력하시오.
        // JSP 시험 점수(정수)를 입력하시오.
        // 세 과목의 총점(정수)을 계산하고, 출력하시오.
        // 세 과목의 평균(실수)을 계산하고, 출력하시오.

        System.out.println("JAVA 시험 점수 입력>>> ");
        System.out.println("SQL 시험 점수 입력>>> ");
        int java = scanner.nextInt();
        int sql = scanner.nextInt(); // System.out.println()은 우리에게 무엇을 하고 있는 지 출력만 해줄 뿐, 실제 입력이랑은 전혀 관련이 없다.
        // 따라서 System.out.println()을 연달아 출력하고, java와 sql의 값을 연달아 입력받을 때도 문제가 되지 않는다.
        System.out.println("JSP 시험 점수 입력>>> ");
        int jsp = scanner.nextInt();

        int score = java + sql + jsp;

        System.out.println("총점= " + score);
        System.out.println("평균= " + score / 3.0);

        /// Ctrl + Shift + F : 소스 코드 포맷팅 (자동 정렬)

    }

}
