package edu.java.generic01;

public class AppleBox {
    private Apple apple;
    
    public void put(Apple apple) {
        this.apple = apple;
    }
    
    public Apple get() {
        return apple;
    }
}


class Apple { // public이 아니면 다른 패키지에서 사용 불가.
    private String type;
    
    public Apple(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    
}
