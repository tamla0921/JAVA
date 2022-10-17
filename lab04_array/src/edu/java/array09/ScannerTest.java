package edu.java.array09;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        // 시스템의 입력장치(콘솔창)를 이용하는 Scanner 객체를 만듦.
        Scanner sc = new Scanner(System.in);
        
        System.out.print("정수 입력> ");
        int n = sc.nextInt(); // 시스템 입력장치(콘솔창)에서 정수를 읽음.
        sc.nextLine(); //버퍼 지우기!!
        System.out.println("n = " + n);
        // 123  456 => 123을 읽고 int n에 저장
        // nextInt(): 토큰 단위로 읽어서 정수로 변환 (공백, 탭. 줄바꿈으로 구분되는 문자열)
        // 남아있는 문자들 공백(2개) 456 /n 이러한 것들은 아직 변환하지 않은 상태로 임시 버퍼에 남겨져 있다..
        
        System.out.print("정수 입력> ");
        n =sc.nextInt();
        sc.nextLine();
        System.out.println("n = " + n);
        
        
        
        System.out.print("문자열 입력> ");
        String s = sc.next();
        // next(): 토큰(공백, 탭. 줄바꿈으로 구분되는 문자열) 단위로 읽어서 문자열을 반환
        sc.nextLine();
        System.out.println("s= " + s);
        
        
        
        
        System.out.print("문자열 입력> ");
        s = sc.nextLine();
        System.out.println("s =" + s);
        // 123  456 입력 시, s =  456이 뜸.
        // nextLine(): 줄바꿈까지 읽음. 입력 버퍼를 비움.
        
        
        /* --> 123  456
         * 첫 번째 n 123
         * 두 번째 n 456
         * s =
         * 엔터를 불러와서 공백처럼 보임.
         */
        
        
        /* 입력버퍼에서는 줄바꿈까지 문자열로 읽고, 
         * 읽어들인 문자열을 원하는 타입(int, double, ...)으로 변환. 
         */
        
        System.out.print("정수 입력> ");
        s = sc.nextLine(); //줄바꿈까지 문자열 읽음.
        n = Integer.parseInt(s); //문자열을 정수(int)로 변환.
        System.out.println("n= " + n);
        

    }

}
