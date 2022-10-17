package edu.java.set03;

import java.util.HashSet;
import java.util.Random;

public class SetMain03 {

    public static void main(String[] args) {
        // HashSet<E> 사용. 
        // [0,10) 범위의 정수 난수 5개를 저장.
        // Set의 내용을 출력.
        Random random = new Random();
        
        HashSet<Integer> nums = new HashSet<> ();
        
        while (nums.size() != 5) {
            nums.add(random.nextInt(0,10));
            
            System.out.println("현재 집합: " + nums);
        }
        
        System.out.println(nums); // 해시집합의 정렬 순서는 해시코드 순으로 !
        

    }

}
