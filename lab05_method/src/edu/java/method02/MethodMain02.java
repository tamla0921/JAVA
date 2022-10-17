package edu.java.method02;

public class MethodMain02 {

    public static void main(String[] args) {
        // 리턴 타입과 argument를 갖는 메서드 작성/호출 연습
        
        // 같은 클래스의 메서드를 호출할 때는 메서드 이름으로만 호출.
        
        // add() 메서드 호출.
        double result = add(1, 2); /* return 값을 변수에 저장할 수 있다.
        /* double result = add(1,2);
         * --> double result = 3.0;
         */
        System.out.println(result);
        
        // subtract() 메서드 호출.
        result = subtract(1,2);
        System.out.println(result);
        
        
        // multiply() 메서드 호출.
        System.out.println(multiply(1, 2));
        
        // divide() 메서드 호출.
        System.out.println(divide(1, 2));
        

    }
/**
 * 숫자 두개를 전달 받아서, 두 숫자의 덧셈 결과를 반환.
 * @param x double.
 * @param y double.
 * @return x + y.
 */
    public static double add(double x, double y) {
        // return : (1) 메서드를 호출한 곳에 값을 반환. (2) 메서드 종료.
        // void도 return값을 호출할 수 있다? return;만 가능.. 메서드를 호출한 곳으로 돌아가고, 메서드를 종료하겠다는 의미. 생략하는 것!
        return x + y;
    }
    /**
     * 숫자 두개를 전달 받아서, 두 숫자의 뺄셈 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x - y.
     */
    public static double subtract(double x, double y) {
        return x - y;
    }
    
    // Alt + 화살표 왼쪽 방향! 원래 방향으로 돌아간다.
    
    
    
    
    //과제: multiply 메서드(x * y), divide 메서드 (x / y) 만들기
    
    /**
     * 숫자 두개를 전달 받아서, 두 숫자의 곱셈 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x * y.
     */
    public static double multiply(double x, double y) {
        return x * y;
    }
    /**
     * 숫자 두개를 전달 받아서, 두 숫자의 나눗셈의 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x / y.
     */
    public static double divide(double x, double y) {
        return x / y;
    }
    
    
    
    
    
}
