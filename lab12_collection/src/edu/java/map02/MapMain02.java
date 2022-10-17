package edu.java.map02;

import java.util.Set;
import java.util.TreeMap;

public class MapMain02 {

    public static void main(String[] args) {
        // key는 문자열 타입이고 value는 정수 타입인 TreeMap을 선언, 생성.
        
        TreeMap<String, Integer> menu = new TreeMap<> ();
        
        menu.put("짜장면", 8000);
        menu.put("짬뽕", 9000);
        menu.put("볶음밥", 9000);
        
        System.out.println(menu); // 볶음밥, 짜장면, 짬뽕 순으로 출력. Key의 오름차순으로 출력이 된다.
        
        System.out.println(menu.get("짜장면"));
        System.out.println(menu.get("냉면"));
        System.out.println(menu.getOrDefault("냉면", 0));
        
        
        Set<String> kset = menu.keySet(); // 오름차순 키 집합
        
        System.out.println(kset);
        
        for (String k : kset) {
            System.out.println(k + " : " + menu.get(k));
        }
        
        Set<String> descKset = menu.descendingKeySet(); // 내림차순 키 집합(TreeMap에만 있음.)
        System.out.println(descKset);
        
        for (String k : descKset) {
            System.out.println(k + " : " + menu.get(k));
        }

    } // 메서드

} // 클래스