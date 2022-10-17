package edu.java.exception06;

public class ExceptionMain06 {

    public static void main(String[] args)  {
        Calculator calc = new Calculator();
        
        // int result = calc.divide(100, 5); // 에러를 던지면, 본 메인도 에러를 던지겠다... main 메서드에게 throws Exception 입력.
        
        try {
            int result = calc.divide(100,0);
            // -> 반드시 예외 처리를 해야 하는 exception을 throw한다고 선언된 메서드를
            // 호출할 때는 try-catch 구문을 사용하거나 throws 선언문을 메서드 선언에 추가해야 함.
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace(); // 콘솔 창에 에러 문구 출력. 그러나 그냥 출력만 했을 뿐, 실행이 멈춘 것이 아님.
            // 예외가 발생한 이유와 예외가 발생되기 까지의 코드 호출 순서를 출력해줌.
            System.out.println(e.getMessage());
        }
        
        System.out.println("정상 종료");

    }

}
