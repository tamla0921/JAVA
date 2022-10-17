package edu.java.inheritance01;

// 스마트 TV는 TV이다. (Smart TV "is a" TV).
// BasicTv: super/parent/base 클래스
// SmartTv: sub/child/derived 클래스

public class SmartTv extends BasicTv {
    // field(속성)
    private String ip;
    
    // getters/setters
    public String getIp() {
       return ip; 
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }

}
