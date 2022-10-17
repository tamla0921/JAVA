package edu.java.lambda02;

import edu.java.lambda02.Calculator.Calculable;

public class LambdaMain02 {

    public static void main(String[] args) {
        // Ex.1
        Calculator adder = new Calculator(1, 2);
        
        double result = adder.calculate(new Calculable() { // 인터페이스의 객체 생성은 원래 불가하므로 익명 내부 클래스를 이용해야 함.
            // 임폴트 안 했으면, new Calculator.Calculabe()
            
            @Override // Calculable 인터페이스 안에 있는 메서드...
            public double calculate(double x, double y) {
                return x + y;
            }
        });
        
        // double result = adder.calculate((x, y) -> x + y);
        System.out.println("adder result = " + result); // 3.0
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Ex.2 뺄셈을 계산하는 계산기 기능
        Calculator subtractor = new Calculator(1,2); // -1.0
        result = subtractor.calculate(new Calculable() {
            @Override
            public double calculate(double x, double y) {
        
                return x - y;
            }
        });
        
        // result = subtractor.calculate((x, y) -> x - y);
        System.out.println("subtractor result = " + result);
        
        // Ex.3 곱셈을 계산하는 계산기
        Calculator multiplier = new Calculator(1, 2); //2.0
        
        result = multiplier.calculate(new Calculable() {
            
            @Override
            public double calculate(double x, double y) {
                // TODO Auto-generated method stub
                return x * y;
            }
        }); // 쉼표!
        
        //result = multiplier.calculate((x, y) -> x * y);
        System.out.println("multiplier result = " + result);
        
        // Ex.4 나눗셈을 계산하는 계산기
        Calculator divider = new Calculator(1, 2); // 0.5
        result = divider.calculate((x, y) -> x / y);
        System.out.println("divider result = " + result);
        
        // Ex.5 두 숫자 중에서 더 크거나 갖은 수를 찾는 계산기
        Calculator greater= new Calculator(1, 2); //2.0
        
        result = greater.calculate(new Calculable() {
            
            @Override
            public double calculate(double x, double y) {
                return (x > y) ? x : y;
            }});
        
        //result = greater.calculate((x, y) -> (x > y) ? x : y);
        System.out.println(result);
        
        
        result = greater.calculate((x, y) -> {
            if (x > y) {
                return x;
            } else {
                return y;
            }
        }); // 람다 표현식이 꼭 한 줄만 작성하는 것은 아님.
    }

}
