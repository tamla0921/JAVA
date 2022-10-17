package edu.java.class05;

public class Student {
    // field
    int stuNo; // 학번(학생 아이디)
    String stuName; // 학생 이름
    Score score; // 국어, 영어, 수학 점수


    // constructor
    // (1) 기본 생성자
    public Student() {

    }
    // (2) argument: int, Srting, Score
    public Student(int stuNo, String stuName, Score score) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.score = score;
    }
    // (3) argument: int, String, int, int, int
    public Student(int stuNo, String stuName, int korean, int english, int math) {
//        this.stuNo = stuNo;
//        this.stuName = stuName;
//        this.score = new Score(korean, english, math);
          
        /* this.score = new Score();
        * this.score.korean = korean;
        * this.score.english = english;
        * this.score.math = math;
        * 이것도 가능!! (new Score()를 통해서 객체가 새로 생성되었기 때문) */
        this(stuNo, stuName, new Score(korean, english, math)); //오버로딩된 생성자 호출 시, this만 입력하기!!
    }
    
    // method - 학생 정보(학번, 이름, 국/영/수 과목 점수, 총점, 평균)를 출력
    
   public void information() {
       
       if (score == null) {
           this.score = new Score(); /* (0,0,0) 안 해도 됨. Score객체를 새로 만들면, 0, 0 ,0으로 초기화가 자동으로 되기 때문에...??? */
       }
        System.out.println("----- 학생 정보 -----");
        System.out.println("학번: " + this.stuNo);
        System.out.println("이름: " + this.stuName);
        this.score.printScore(); /* 국어, 영어, 수학 점수 출력 */
        // NullPointerException : score. 객체를 찾아가는 데 아예 없을 때(.연산자 시 에러, null을 가리키면서 다른 일을 하려고 할 때 생기는 에러)
//        System.out.println("국어: " + this.score.korean);
//        System.out.println("영어: " + this.score.english);
//        System.out.println("수학: " + this.score.math);
        System.out.println("총점: " + this.score.total());
        System.out.println("평균: " + this.score.average());
        
        
/* if (score != null) {
 *  this.score.printScore(); //국/영/수 점수 출력
 *  System.out.println("총점: " + this.score.total());
 *  System.out.println("평균: " + this.score.average();
 * } else {
 * System.out.println("점수: null");
 * }
 */
        
    }
}

