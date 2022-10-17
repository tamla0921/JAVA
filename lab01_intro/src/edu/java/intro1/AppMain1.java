// 주석(comment):프로그램에 대한 설명을 작성.
// 주석은 컴파일할 때 제외됨. (실행되지 않는 코드)
// 오로지 소스코드에만 있고, 컴파일 할 때는 제거가 된다.


package edu.java.intro1; // 모든 소스코드의 첫 번째 줄은 패키지 선언문! 내가 생성한 클래스가 어느 폴더에 위치해 있는지 알려준다.

// 자바의 모든 문장은 세미콜론(;)으로 끝남.

// 클래스 선언(정의)
public class AppMain1 {

	
	// main 메서드(method): 자바 프로그램의 시작과 끝.
	public static void main(String[] args) { // main 메소드: 프로그램이 시작하는 부분
		System.out.println(
				"Hello, 자바!"
				);
	} // end main, 프로그램이 끝나는 부분

} // 마지막에 끝났다는 의미인 ;를 생략. 클래스 정의를 알리는 중괄호가 끝나는 부분인 줄 아니까 


// 주석 작성 방법 한 가지: // 이후부터는 라인 끝까지 주석

/* 주석 시작
 * 
 * 주석 끝*/ //이러한 작성하는 주석을 

// 이 방법은 inline comment
/* 이 방법은 block comment
 * 이 안에 포함되어 있다면 모두 주석! *
 /* block comment주석은 문서화 주석(documentation comment)를 만들 때 주로 사용. bbf
  */

