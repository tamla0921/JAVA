package edu.java.lambda01;

@FunctionalInterface // 함수형 인터페이스, 람다를 쓸 수 있는 지 없는 지... 추상메서드가 하나만 있어야함!
public interface Calculable {
    
    double calculate(double x, double y);

}
