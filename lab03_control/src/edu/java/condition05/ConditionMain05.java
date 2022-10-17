package edu.java.condition05;

import java.util.Random;

public class ConditionMain05 {

    public static void main(String[] args) {
        Random random = new Random();
        
        int java = random.nextInt(101);
        int sql = random.nextInt(101);
        int jsp = random.nextInt(101);
        
        System.out.println("자바 점수= " + java);
        System.out.println("SQL 점수= " + sql);
        System.out.println("JSP 점수= " + jsp);
        
        double average = (java + sql + jsp) / 3.0;
        
        System.out.println("평균= " + average);
        
        if ((average >= 60) && (java >= 40) && (sql >= 40) && (jsp >= 40)) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }
        
        String pNp = ((average >= 60) && (java >= 40) && (sql >= 40) && (jsp >= 40)) ? ("합격") : ("불합격");
        System.out.println(pNp);
        
        if (java < 40 || sql < 40 || jsp < 40) {
            System.out.println("불합격2");
        } else if (average >= 60) {
            System.out.println("합격2");
        } else {
            System.out.println("불합격2");
        }
        
        // Random 타입 변수를 선언하고, 초기화
        // Java 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        // SQL 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        // JSP 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        // 세 과목의 평균을 계산.
        // 모든 과목의 점수가 40점 이상이고, 평균 60점 이상이면 "합격",
        // 그렇지 않으면 "불합격" 출력

    }

}
