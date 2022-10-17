package edu.java.variable02;

public class VariableMain02 {

	public static void main(String[] args) {
		// 문자(character):  문자 1개. 작은 따옴표('')를 반드시 사용. 문자 한 개를 사용할 때만 작은 따옴표를 사용!!
		// 문자열(String): 큰따옴표("")를 사용.
		// char char = 'a'; ERROR -  Syntax error on token "char", invalid VariableDeclaratorID
		char ch = 'a';
		// ch = "a"; ERROR - Type mismatch: cannot convert from String to char --> ""를 사용할 경우 String으로 인식한다.
		
		System.out.println(ch);
		System.out.println((int) ch); // Casting: 강제 타입 변환
		
		ch = 'b';
		System.out.println(ch);
		System.out.println((int)ch);
		
		ch = '한';
		System.out.println(ch);
		System.out.println((int)ch);
		
		String s = "한글";
		System.out.println(s);
//		System.out.println((int)s); // char 타입은 int로 변환 가능! 그러나 String은 int로 변환 불가! (Cannot cast from String to int).
	}

}
