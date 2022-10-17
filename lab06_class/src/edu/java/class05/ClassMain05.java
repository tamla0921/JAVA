package edu.java.class05;

public class ClassMain05 {

    public static void main(String[] args) {
        // Score 타입의 객체를 생성, 메서드들을 테스트.
        Score score1 = new Score();
        System.out.println("score1= " + score1);
//        System.out.println("score1 korean= " + score1.korean);
//        System.out.println("score1 english= " + score1.english);
//        System.out.println("score1 math= " + score1.math);
        score1.printScore(); // printScore()하더라고 (0,0,0)으로 뜬다. 왜냐하면 Score의 필드값이 int이기 때문에 0,0,0으로 기본설정된다. (이해가 잘...)
        
        System.out.println("----------");
        
        
        Score score2 = new Score(100,50,31);
//        System.out.println("국어 점수는 " + score2.korean);
//        System.out.println("영어 점수는 " + score2.english);
//        System.out.println("수학 점수는 " + score2.math);
//        System.out.println("score2 = " + score2);
//        System.out.println("----------");
        
        score2.printScore();
        System.out.println("총점계산하기: " + score2.total());
        System.out.println("평균계산하기: " + score2.average());
    
        // Student 타입의 객체를 생성, 메서드를 테스트.
        Student student1 = new Student();
        // student1.score = score1; (student1에는 score가 아예 null  --> NullPointerException, score1에서는 0,0,0으로 초기화)
        Student student2 = new Student(2015, "바나", score2);
//        System.out.println(student2.stuName+"의 국어점수: " + student2.score.korean);
        Student student202 = new Student(202, "허쉬", null);
        Student student203 = new Student(203, "초콜렛", new Score(10,2,5)); // 생성자 직접 넣어 만들기! ... 코드에 new란 게 나오면 heap 영역에 새로운 객체가 생김.
        Student student3 = new Student(2022, "프레소", 10, 50, 50);
//        System.out.println("테스트: " + student3.score.korean);
        
        
        student1.information();
        student2.information();
        student202.information();
        student203.information();
        student3.information();
        
        
        

    }

}
