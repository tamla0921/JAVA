package edu.java.exception03;

import java.util.Scanner;

public class ExceptionMain03 {
    
    private Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
       ExceptionMain03 app = new ExceptionMain03(); // static이 아닌 메서드를 쓰려면 클래스 타입의 객체를 생성!
       
       //ExceptionMain03.inputInteger()은 static일 경우에 사용하는 것.
       
       int x = app.inputInteger();
       System.out.println("x는 " + x);

    }
    
    private int inputInteger() {
        // TODO: Scanner를 사용해서 입력받은 정수를 리턴.
        // Integer.parseInt(), scanner.nextLine() 사용.
        // NumberFormatException을 처리.
        boolean run = true;
        int num ;
        
        while (true) {
        try { // 블록에서 변수 선언, 블록 변수 (try 포함) 밖에 가면 사라진다.
            System.out.print("숫자를 입력하세요: ");
            num = Integer.parseInt(scanner.nextLine());
            // try에서 return num; --> 안 되는 이유, 만약 예외가 있다면 catch의 리턴이 없는 것이나 마찬가지이기 때무에 에러가 발생한다.
            break;
            // run = true; 하고, run = false도 좋지만, break를 사용하면 반복문을 빠져나올 수 있다!!!
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        }
        
        return num;
        
        /* run = false;
         * int x;
         * 로 설정하면 The local variable x may not have been intialized. 에러가 뜬다.
         * 왜냐하면 run이라는 변수가 언제나 바뀔 수 있기 때문에
         * return x를 한다면 초기값이 설정이 되어 있지 않는 에러가 발생할 수 있기 때문에 int x = 0;으로 초기값을 설정해야 한다.
         * 
         * 그러나 true와 break를 선언한다면,
         * while(true) 문은 항상 무한 반복한다는 말이다. 따라서 int x에 값을 부여하지 않아도, 문제가 생길 수 없다. 단
         * while문에 break;를 작성하지 않는다면 밑 return 값은 unreachable code 에러가 발생한다.
         */
        
    }

}

