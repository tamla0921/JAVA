package edu.java.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaMain03 {
    
    public static void main(String[] args) {
        // 정수들을 저장하는 리스트
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(numbers);
        
        ArrayList<Integer> evens = new ArrayList<> (); // numbers에서 짝수들만 선택해서 저장한 리스트.
        List<Integer> odds = new ArrayList<> (); // numbers에서 홀수들만 선택해서 저장한 리스트. //List는 인터페이스.
        for (Integer x : numbers) { // 리스트의 모든 원소를 차례로 반복하면서
            if (x % 2 == 0) { // 짝수들을 필터링
                evens.add(x);
            } else {
                odds.add(x);
            }
        }
        
        
        List<Integer> evens2 = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evens2);
        
        List<Integer> odds2 = numbers.stream()   //스트림..필터... 모으기
                .filter(x -> x % 2 == 1)
                .collect(Collectors.toList());
        System.out.println(odds2);
        System.out.println(odds);
        
        
        // 짝수들의 제곱
        List<Integer> result = new ArrayList<> ();
        for (int x : numbers) {
            if (x % 2 == 0) {
            result.add(x*x);
            }
        }
        
        System.out.println(result);
        
        List<Integer> result2 = numbers.stream()
                .filter(x -> x % 2 == 0) // 조건식
                .map(x -> x *x) // 걸러진 것들만 실행. (참일 경우)
                .collect(Collectors.toList());
        
        
        System.out.println("필터의 결과: " + result2);
       
         List<String> langs = Arrays.asList("Java", "SQL", "HTML", "JavaScript", "Python");
         
         System.out.println("필터 전: " + langs);
         
         // langs에서 5글자 이상의 문자열들을 찾고, 모두 소문자로 변환한 리스트.
         // [javascript, python]
         
         List<String> langs55 = new ArrayList<> ();
         
         for (String x : langs) {
             if (x.length() >= 5) {
                 langs55.add(x.toLowerCase());
             }
         }
         
         System.out.println("반복문을 사용한 거르기" + langs55);
         
         List<String> langs5 = langs.stream()
                 .filter(x -> x.length() >= 5)
                 //.map(x -> x.toLowerCase())
                 .map(String::toLowerCase)
                 .collect(Collectors.toList());
         
         System.out.println("스트림을 사용한 거르기" + langs5);
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
        
    }

}
