package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListMain03 {

    public static void main(String[] args) {
        // 문자열들을 원소로 갖는 리스트를 생성하고 초기화.
        List<String> languages = Arrays.asList("Java", "SQL", "HTML", // 리스트를 만들 때 처음부터 리스트에 항목이 포함되어 있기를 원하는 경우.
                "CSS", "JavaScript", "Servlet", "JSP", "Spring", "Python");  // List는 임폴트 해야 함!;
        
        System.out.print("전체 언어: ");
        System.out.println(languages);
        
        // 리스트 languages에서 5글자 이상인 문자열들만 저장하는 리스트를 생성, 출력.
        List<String> languages5 = new ArrayList<>(); // 다형성.
        // List<String> lanuages5 = new List<>(); 불가!! List는 클래스가 아닌 인터페이스임, 인터페이스는 객체를 생성할 수 없다.
        
        for (int i = 0 ; i < languages.size() ; i++) {
            if (languages.get(i).length() >= 5) {
                languages5.add(languages.get(i));
            }
        }
        
        System.out.print("다섯 글자 이상의 언어: ");
        System.out.println(languages5);
        
        // Iterator<E> 사용:
        List<String> longWords2 = new ArrayList<>();
        Iterator<String> itr = languages.iterator();
        
        while (itr.hasNext()) {
        String s =  itr.next();
        // next() 한 번 호출 후 "반환 값"을  s에 저장. 따라서 s를 연달아 쓰더라도, 변수 s의 값은 변하지 않음. 재호출 되는 것이 아니라 반환 값(String)을 저장하는 것 뿐임. 
        // while문이 재시작할 때 다시 next()를 호출하기 때문에 이 때 옮겨진 값을 호출.
        if (s.length() >= 5) {
            longWords2.add(s);
        }
        
        
        }
        
        System.out.println("롱월즈테스트: " + longWords2 );
        // 리스트 languages의 원소들의 글자수를 저장하는 리스트를 만들고 출력.
        
        ArrayList<Integer> countLength = new ArrayList<>();
        
        for (int i = 0 ; i < languages.size(); i++) {
            countLength.add(languages.get(i).length());
        }
        
        System.out.print("글자 수 세기: ");
        System.out.println(countLength);
        
        // 정수(1,2)들을 저장하는 리스트를 만들고 초기화.
        List<Integer> genderCodes= Arrays.asList(1, 1, 2, 2, 1, 2, 2); // ArrayList... 타입
        
        // 리스트 genderCodes의 원소가 1이면 "Male", 2이면 "Female"을 저장하는 리스트를 만들고 출력.
        ArrayList<String> genders = new ArrayList<> ();
        
        //for (int i = 0 ; i < genderCodes.size() ; i++) {
            //Integer x = genderCodes.get(i);
    
            //if (x == 1) {
            //    genders.add("Male");
            //} else {
            //    genders.add("Female"); // return문을 쓴다면, void메서드까지 탈출...
            //}
       // }
        
        for (Integer code : genderCodes) {
            
        
        //String gender = "";
        //if ( code == 1) {
        //    gender = "Male";
        //} else {
        //    gender = "Female";
        //}
        //    genders.add(gender);
        //}
            genders.add((code == 1) ? "Male" : "Female");}
        
        System.out.print("성별 구분: ");
        System.out.println(genders);
        
        
        
    } // 메인 메서드 닫는 곳
    
} // 클래스 닫는 곳
