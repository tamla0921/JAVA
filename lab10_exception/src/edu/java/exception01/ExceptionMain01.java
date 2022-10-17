package edu.java.exception01;

import java.util.Scanner;

// 오류(error) vs 예외(exception)
// 오류(error)의 종류:
// 1. 시스템 에러: (예) OOM(Out-Of-Memory, 메모리 부족) - 입출력 관련된 장치들이 비정상적으로 작동 해, 프로그램이 제대로 동작하지 못하는 경우. -> 수정 불가능 하거나 힘듦.
// 2. 컴파일(compile) 에러: 문법 오류. -> 반드시 수정!
// 3. 논리적 오류: 프로그램이 정상적으로 컴파일되고 실행/종료 되지만 원하는 결과가 나오지 않는 경우.
/* int[] a = new int[10];
 * int i = 0;
 * if (i < 0 && i >=10) {
 * a[i] = 1;
 * } --> 문법적 오류는 전혀 없지만, 논리가 이상해 원하는 결과가 나오지 않음.
 * --> 반드시 수정. 수정 힘듦.
*/
// 4. 예외(exception): 프로그램 실행 중에 발생할 수 있는 비정상적인 상황 -> 반드시 수정.
//  -> (1) if-else 문장
//  -> (2) try-catch 문장

public class ExceptionMain01 {

    public static void main(String[] args) {
        String s = "";
        // 스트링 타입에 null을 지정할 경우...
        // NullPointerException: cannot invoke "String.length()" because "s" is null
        if (s == null) {
            System.out.println("null");
        } else {
        System.out.println("문자열의 길이 = " +s.length());
        }
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("x = ");
        int x = Integer.parseInt(sc.nextLine());
        
        System.out.print("y = ");
        int y = Integer.parseInt(sc.nextLine());
        
        // y = 0으로 나누면... Exception in thread "main" java.lang.ArithmeticException: / by zero
        if (y == 0) {
            System.out.println("0으로는 나눌 수 없습니다.");
        } else {
            int result = x / y;
            System.out.println("몫 = " + result);
        }
        
       

    }

}
