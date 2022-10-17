package edu.java.set01;

import java.util.Iterator;
import java.util.TreeSet;

/*
 * Collection<E>
 * |__ List<E>
 *     |__ ArrayList<E>, LinkedList<E>, ...
 *
 * Collection<E>
 * |__ Set<E>
 *     |__ HashSet<E>, TreeSet<E>, ...
 *  
 *
 * Set<E>의 특징:
 * 1. 중복된 값을 저장하지 않음. (예) {1, 2} = {1, 2, 1, 2}
 * 2. 저장하는 순서가 중요하지 않음. 인덱스가 없음! 일반적안 for문 사용 불가...(향상된 for문, iterator는 가능) (예) {1, 2} = {2, 1}
 * 
 *  HashSet<E>: Hash 알고리즘(검색을 빨리할 수 있는 알고리즘)을 사용한 Set.
 *  TreeSet<E>: Tree 알고리즘(정렬을 빨리할 수 있는 알고리즘)을 사용한 Set.
 *   
 */
public class SetMain01 {

    public static void main(String[] args) {
        // String을 원소로 갖는 TreeSet을 선언, 생성
        TreeSet<String> set = new TreeSet<>();
        System.out.println(set); // []
        System.out.println(set.size()); // size(): Set의 원소 갯수를 리턴.
        
        // add(Object o), remove(Object o) 메서드만 가지고 있고,
        // 인덱스를 이용한 검색/추가/삭제 메서드는 제공하지 않음.
        
        set.add("hello");
        System.out.println(set);
        
        set.add("hello");
        System.out.println(set);

        set.add("apple");
        System.out.println(set);
        
        set.add("banana");
        System.out.println(set);
        
        set.add("zip");
        System.out.println(set);
        
        // Set은 for 문장을 사용할 수 없지만 for-each 문장과 Iterator<E>을 사용할 수 있음.
        
        for (String s : set) {
            System.out.println(s + ", ");
        }
        System.out.println();
        
        // set에서 "banana" 문자열을 삭제.
        set.remove("banana");
        System.out.println(set);
        
        
        Iterator<String> itr = set.iterator();
        
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
            
        }
        
        System.out.println();
        
        Iterator<String> descItr = set.descendingIterator(); // 내림차순 반복자. 트리셋에서만 존재!!
        // --> descendingIterator() 메서드는 정렬 기능을 가지고 있는 TreeSet만 가지고 있음.
        while (descItr.hasNext()) {
            System.out.print(descItr.next() +", ");
        }
        
        System.out.println();
     
    }

}
