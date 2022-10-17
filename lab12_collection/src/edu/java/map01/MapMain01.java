package edu.java.map01;

import java.util.HashMap;
import java.util.Set;

/* 
 * Collection<E>
 * |__ List<E>, Set<E>
 * List<E>, Set<E>의 공통점: 한 가지 타입의 객체를 여러 개 저장할 수 있는 자료 타입.
 * List<E>: 인덱스가 있음. 저장하는 순서가 중요. 중복된 값들을 저장할 수 있음.
 * Set<E>: 인덱스가 없음. 중복된 값들을 저장할 수 없음.
 * 
 * ArrayList<E>: get 속도 빠름. add/remove 속도 느림.
 * |__ [ , , , , , , , ,] 연속된 공간인 배열에 저장. 인덱스만 알면 해당 위치로 바로 갈 수 있다.
 * |__ 배열의 크기를 늘리려면 기존의 배열을 복사한 후 새로운 것들을 추가해야 함.
 * |__ 삭제를 하려면, 작아진 배열을 새로 만들어서 해당 객체를 제외하고 복사를 해서 새로 만들음.
 * 
 * LinkedList<E>: add/remove 속도 빠름. get 속도 느림
 * |__ 데이터를 저장하는 원소와 다음 원소를 저장하는 부분(인덱스 부분)이 나눠져 있음.
 * |__ 따라서 추가하고 싶을 경우 다음 원소를 저정하는 부분에 주소값만 추가하면 가능.
 * |__ 연속된 공간에 저장을 하지 않음. 이전 원소와 다음 원소 사이에 인덱스만 저장.
 * |__ 지우겠다는 것은 이전 원소에 저장되어 있는 다음 원소의 주소값을 변경만 하면 삭제가 가능하다.
 * |__ 그러나 이전 원소가 가리키고 있는 다음 원소의 주솟값들을 읽어서 찾고자 하는 원소를 찾아야 하기 때문에 ArrayList보다 느리다.
 * 
 * HashSet<E>: 검색을 빨리 하기 위한 Set.
 * TreeSet<E>: 정렬을 빨리 하기 위한 Set.
 * 
 * 
 * Map<K, V>
 * |__ HashMap<K, V>, TreeMap<K, V>
 * Map<K, V>: Key(키)와 Value(값)의 쌍으로 구성된 데이터를 저장하는 자료 구조.
 * 1) Key: 중복된 값을 가질 수 없음. 리스트의 인덱스와 비슷한 역할.
 *      |__ Key의 역할은 데이터를 저장/검색/수정/삭제할 때 값을 찾기 위한 용도.
 * 2) Value: 중복된 값을 가질 수 있음.
 * 3) HashMap<K, V>: 검색을 빨리 하기 위한 Map.
 * 4) TreeMap<K, V>: 정렬을 빨리 하기 위한 Map.
 */

public class MapMain01 {

    public static void main(String[] args) {
        // 정수를 Key, 문자열을 Value로 하는 HashMap을 선언, 생성
        HashMap<Integer, String> map = new HashMap</* Integer, String */>();
        System.out.println(map); // 리스트, 집합: [대괄호 사용], 맵: {중괄호 사용}
        
        // put(K, V): Map(K, V)에 key-value 쌍의 데이터를 저장.
        map.put(1, "홍길동");
        System.out.println(map); // {key=value}
        
        map.put(10, "오쌤");
        System.out.println(map);
        
        map.put(10, "강낭콩");
        System.out.println(map); // 기존의 있던 value 값이 변겅된다.
        
        map.put(5, "Scott");
        System.out.println(map); // 해쉬코드의 값에 따라 정렬.
        
        // get(K): key에 해당하는 value를 리턴. 만약 key가 존재하지 않으면 null을 리턴.
        System.out.println(map.get(10));
        System.out.println(map.get(2)); // 오류는 뜨지 않고 null 값이 나온다.
        
        // getOrDefault(K, V): 검색할 key와 Key가 존재하지 않을 때 리턴할 기본 값을 argument로 전달.
        System.out.println(map.getOrDefault(1, "Unknown"));
        System.out.println(map.getOrDefault(2, "Unknown")); // null 대신의 지정한 값이 나옴.
        
        // remove(K): key에 매핑된 key-value 원소를 삭제하고, 삭제한 value(값)을 리턴.
        System.out.println(map.remove(1));
        System.out.println(map);
        
        // remove() 메서드는 key에 매핑된 key-value 원소가 없으면 null을 리턴.
        System.out.println(map.remove(2));
        System.out.println(map); // 오류는 뜨지 않고 map의 값이 그대로 나온다.
        
        // put(K, V): Key가 존재하지 않으면 key-value 원소를 저장.
        // key가 존재하면 해당 키의 value만 변경.
        System.out.println(map.put(5, "홍길동"));
        System.out.println(map);
        
        // Map(K, V)과 반복문.
        // KeySet(): Set<K>를 리턴. Map에서 key들로만 이루어진 Set을 리턴.
        System.out.println(map.keySet()); // Key들만 꺼내겠다. Set<Integer> 키는 중복되지 않으므로, 집합과 같다. Integer는 우리가 설정한 타입..
        
        Set<Integer> kset = map.keySet();
        System.out.println(kset);
        
        for (Integer k : kset) {
            String v = map.get(k);
            System.out.println(k + " - " + v);
        }
        

    } // 매서드

} // 클래스
