package edu.java.file08;

import java.io.Serializable;

public class Student implements Serializable { // 리스트는 직렬화가 되어 있지만, 리스트 속 원소들은 직렬화가 되어있지 않다.
    // field 
    private int id;
    private String name;
    private Score score;
    
    // 생성자: (1) 기본 생성자, (2) argument가 3개인 생성자
    public Student() {}
    
    public Student(int id, String name, Score score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    // getters/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    // toSring
    
    @Override
    public String toString() {
        
        return String.format("학생의 아이디: %d, 학생의 이름: %s, 학생의 점수: %s", this.id, this.name, this.score/*.toString()*/);
        // Score클래스도 tostring을 가지고 있기 때문에 가능하다.
        
        
    }

} // 클래스 닫음
