package edu.java.method01;

// 메서드(method): 클래스 안에서 정의하는 함수(function, 기능).
// 프로그램에서 반복되는 기능을 코드 블록으로 작성한 것.
// 자바는 클래스 안에서만 함수를 작성할 수 있음. (자바에서는 클래스 밖에서 함수를 작성할 수 없음.)
// 자바는 메서드 안에서 메서드를 정의할 수 없음!!!

// argument: 인수. 메서드를 호출하는 곳에서 메서드에게 전달하는 값.
// parameter: 매개변수. 인자. argument를 저장하기 위한 메서드의 지역 변수.
// return value: 반환값. 메서드가 기능을 모두 수행한 후에 메서드를 호출한 곳으로 반환하는 값.
    // 메서드는 리턴값이 있을 수도 있고, 없을 수도 있음.

/* 메서드 정의(선언) 방법:
 * [수식어] / 리턴타입 / 메서드이름([파라미터 선언, ...]) / { ... }
 * [public static - 단 ! 메인에서는 반드시 적어야 함]/ void / main(String[] args) {...}
 * void: 함수가 리턴하는 값이 없을 때 사용하는 리턴 타입. (반환값이 있다면 void 대신 int, double... 입력) 
 * class 안에만 있다면 메서드를 생성할 수 있다! 메인 메서드가 기준이 아님!
 */


public class MethodMain01 { 
    // main 메서드 - 프로그램 시작점.
    public static void main(String[] args) {
        System.out.println("1"); // println() 메서드 호출, 여기서 "1"
        newLine(); // newLine() 메서드 호출(사용), 메서드를 호출해야 함수 정의 부분이 실행!(따라서 함수 정의의 순서는 중요하지 않다.)
        System.out.println("2");
        newLines(3); // newLines() 메서드를 호출하면서 3을 argument로 전달.
        // newLines 메서드의 진짜 이름: edu.java.method1.MethodMain01.newLines(int n)
        System.out.println("3");
    }
    
    // 함수 정의(선언)
    /**
     * 콘솔에 빈 줄 하나를 출력.
     */
    
    // 메서드 위에 /**를 입력하고 엔터를 누른 후에, 내용 입력 시 문서화 가능(이클립스의 기능)
    public static void newLine(/*[파라미터 선언은 생략 가능]*/) {
        System.out.println();
    }
    
    // 파라미터를 가지고 있는 메서드 정의(선언)
    /**
     * 
     * 빈 줄 n개를 출력.
     * 
     * @param n 출력할 빈 줄의 개수. 양의 정수. (파라미터에 대한 설명을 해주는데 자동 생성)
     */
    public static void newLines(int n) {
        for (int i = 0 ; i < n; i++) {
            //System.out.println();
            newLine(); // 메서드가 메서드를 정의할 수는 없지만, 호출은 가능하다!
        }
    }

}
