package edu.java.map03;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapMain03 {

    public static void main(String[] args) {
        // 단어 갯수 세기(word counting)
        String sentence = "하늘 바다 땅 하늘 땅 사람";
        
        // 문자열 sentence에 등장하는 단어를 key로 하고
        // 그 단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고 출력.
        // 결과: {땅=2, 바다=1, 사람=1, 하늘=2}
        
        // sentence 문자열을 공백으로 구분해서 단어들로만 이루어진 배열을 만듦.
        // 배열의 원소(단어)들을 하나씩 반복하면서
        //  단어가 Map에 Key로 존재하지 않으면, "단어=1"을 Map에 저장.
        //  단어가 map에 key로 존재하면, key에 해당하는 value(기존 등장 횟수) + 1" 값을 Map에 저장.
    
        HashMap<String, Integer> count = new HashMap<>();
        TreeMap<String, Integer> count2 = new TreeMap<>();
        
        String[] words = sentence.split(" ");
        System.out.println(words); // 배열은 그 안에 들어 있는 원소를 직접 볼 수 없다. 주소값이 보임.
        
        for (String w : words) {
            System.out.print(w + " ");
        }
        System.out.println();
    
        for (String word : words) {
            Integer counto = count2.get(word);
            if (counto == null) {
                count2.put(word, 1);
            } else {
                count2.put(word, counto + 1);
            }
            System.out.println(count2);
        }
        System.out.println(count2);
        
        for (int i = 0 ; i < words.length ; i++) {
            String x = words[i];
            
            if (count.get(x) == null) {
                count.put(x, 1);
            } else {
                count.put(x, count.get(x) + 1);
            }
            
        }
        
        System.out.println(count);
        
        
        HashMap<String, Integer> wordCounts2 = new HashMap<>();
        
        for (String w : words) {
            Integer count3 = wordCounts2.getOrDefault(w,0);
            wordCounts2.put(w, count3 + 1);
            System.out.println(wordCounts2);
        }
        System.out.println(wordCounts2);
        
    } // 메서드

} // 클래스
