package edu.java.swing10;

// MVC에서 Model 클래스 - 데이터를 정의하는 클래스. VO(Value Object)
public class Score { 
    private int korean;
    private int english;
    private int math;
    
    public Score() {}

    public Score(int korean, int english, int math) {
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public int getKorean() {
        return korean;
    }

    public int getEnglish() {
        return english;
    }

    public int getMath() {
        return math;
    }
    
    
    
    
    
    
    
    // 총점 리턴
    public int sum() {
        return this.korean + this.english + this.math;
    }
    
    public double average() {
        return (double) this.sum() / 3.0;
    }
    
    
    
    @Override
    public String toString() {
        return String.format("Score(korean = %d, english = %d, math = %d, sum = %d, average = %.2f", this.korean, this.english, this.math, this.sum(), this.average());
    }
    
    
    
}
