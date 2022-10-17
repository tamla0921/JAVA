package edu.java.set02;
        
public class Score {
    // field
    private int java;
    private int web;
    
    // 생성자
    public Score() {}

    public Score(int java, int web) {
        this.java = java;
        this.web = web;
    }
    
    // getters / setters

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getWeb() {
        return web;
    }

    public void setWeb(int web) {
        this.web = web;
    }
    
    
    @Override
    public String toString() {
        return String.format("Score(Java = %d, web = %d)", java, web);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Score) {
        Score s = (Score) obj;
        return (this.java == s.java) && (this.web == s.web); // Int는 기본 타입이므로 같은 지 다른 지 비교할 때 등호를 사용할 수 있다.
        }
        return false;
        
    }
    
    @Override // hashset은 같은 지 다른 지를 비교할 때, hashcode 먼저 비교한다.
    public int hashCode() {
        return Integer.valueOf(java).hashCode() + Integer.valueOf(web).hashCode();
        // java의 equals 값이 같으면, Hash 코드 값이 같다. (명제)
        // Hash 코드 값이 다르면, java의 equals 값이 다르다. (대우)
        // 따라서 java의 값이 같으므로 hash 코드 값이 같을 것이다. 따라서 두 숫자를 합치면 값은 같다.
    }
    
}