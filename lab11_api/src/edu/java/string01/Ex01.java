package edu.java.string01;

import java.util.Arrays;

public class Ex01 {

    public static void main(String[] args) {
        // String 클래스의 메서드들을 사용
        
        // ex-1. 아래의 주민번호 문자열에서 성별을 표시하는 위치의 문자만 출력.
        String ssn = "991231-1234567";
        
        System.out.println("1번 문제");
        System.out.println(ssn.charAt(7));
        
        // ex-2. 아래의 문자열 배열에서 "홍길동"의 인덱스를 출력.
        // 만약에 "홍길동"이 배열에 없는 경우에는 -1을 출력.
        String[] names = {"오쌤", "홍길동", "John", "Jane", "홍길동"};
        // TODO
        System.out.println("\n2번 문제");
        int index = -1;
        for (int i = 0; i < names.length ; i++) {
            if (names[i].equals("홍길동")) {
                index = i;
                break;
            }
        }
        System.out.println(index);
        // System.out.println("\n2번 문제");
        // System.out.println(Arrays.asList(names).indexOf("홍길동"));
          
        
        // ex-3. 아래의 문자열 배열에서 5글자 이상인 문자열들만 출력.
        String[] languages = {"Java", "SQL", "JavaScript", "Python"};
        // TODO
        System.out.println("\n3번 문제");
        for (String s : languages) {
        if (s.length() >= 5) {
            System.out.println(s);
        }
        
        //for (int i = 0 ; i < languages.length ; i++) {
        //    if (languages[i].length() >= 5) {
        //        System.out.println(languages[i]);
        //    }
        }
        
        // ex-4. 아래의 문자열 배열에서 대소문자 구별없이 "est"를 포함하는 문자열들을 출력.
        String[] tests = {"TEST", "test", "Test", "tEst", "테스트", "ttt"};
        // TODO
        System.out.println("\n4번 문제");
        for (int i = 0 ; i < tests.length ; i++) {
            if (tests[i].toLowerCase().contains("est")) { // CharSequence: SuperClass, String: DerivedClass
                System.out.println(tests[i]);
            }
        }
        
        // ex-5 아래의 "YYYY-MM-DD" 형식의 날짜 문자열에서 년/월/일 정보를
        // int 타입 변수에 저장하고 출력.
        String date= "2022-09-07";
        // TODO
        System.out.println("\n5번 문제");
        String[] array = date.split("-");
        int year = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int day = Integer.parseInt(array[2]);
        
        
        //int year = Integer.parseInt(date, 0, 4, 10);

        //System.out.println(year);
        //int month = Integer.parseInt(date, 5, 7, 10);
        //int day = Integer.parseInt(date, 8, 10, 10);
        
        // String 메서드로 풀기!
        
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        
        
        

    }
}

