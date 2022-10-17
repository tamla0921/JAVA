package edu.java.modifier04;

public class Test {
    private int a;
    private double b;
    private boolean c;
    private String d;
    
 // 마우스 오른쪽 클릭 -> Source -> Generate constructor using fields
    public Test(int a, double b, boolean c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    // 마우스 오른쪽 클릭 -> Source -> Generate Getters/Setters
    public int getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public boolean isC() { // boolean은 T/F 만 있기 때문에, get 대신 is를 적음.
        return c;
    }

    public Test() {
    }

    public Test(int a, double b, boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    
    
    
}
