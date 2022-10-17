package edu.java.list02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class ListMain02 {

    public static void main(String[] args) {
        // 1. 정수를 저장하는 LinkedList 변수(numbers) 선언/생성
        
        // 2. 리스트에 [0, 100) 범위의 정수 난수 20개를 저장.
        
        // 3. 난수가 저장된 리스트(numbers)를 출력.
        
        // 4. 홀수들만 저장하는 LinkedList 변수(odds) 선언, 객체 생성.
        
        // 5. 난수들이 저장된 리스트 numbers에서 홀수들만 리스트 odds에 저장.
        
        // 6. 리스트 odds를 출력.
        
        // 7. 짝수 제곱들을 저장하는 LinkedList 변수(evenSquares) 선언, 객체 생성.
        
        // 8. 난수들이 저장된 리스트 numbers에서 짝수들을 찾아서 그 제곱을 evenSquares에 저장.
        
        // 9. 리스트 evenSquares를 출력.
        
        Random random = new Random(); // Argument 필요 없음.
        // int i = 0;
        
        // (1) (2) (3)
        LinkedList<Integer> numbers = new LinkedList</*Integer*/>(); // 임폴트 해야 사용 가능!!
        
        //while (i < 20) {
         //   numbers.add(random.nextInt(0,100));
         //   i++;
        //}
        
        for (int i = 0 ; i < 20 ; i++) { // (초기화 부분 ; 조건 부분 ; 증감 부분)
            numbers.add(random.nextInt(100)); // 0부터 시작할 경우 숫자 한개만 입력할 경우 0 이상 n 미만의 수를 무작위로 저장한다. //메서드 오버로딩.
        }
        
        System.out.println(numbers);
        
        
        
        // (4) (5) (6)
        LinkedList<Integer> odds = new LinkedList</*Integer*/>();
        LinkedList<Integer> odds2 = new LinkedList</*Integer*/>();
        
        for (int i = 0 ; i < numbers.size(); i++) {
            if ((numbers.get(i) % 2) != 0 ) {
                odds.add(numbers.get(i));
            }
        }
            
        for (int x : numbers) { // odds는 LinkedList타입의 Integer들의 리스트들이므로, 변수 x도 Integer가 되는 것이 맞다. (integer ==> int, auto-unboxing.)
            if ((x % 2) == 1) {
                odds2.add(x);
            }
        }

        
        System.out.println(odds);
        System.out.println(odds2);
        
        // (7) (8) (9)
        LinkedList<Integer> evenSquares = new LinkedList</*Integer*/>();
        
        for (int i = 0 ; i < numbers.size(); i++) {
            // Integer x = numbers.get(i); : 굳이 변수를 선언하는 이유? 똑같은 긴 코드가 반복되어 사용되므로 가독성이 떨어질 수 있기 때문. 
            if ((numbers.get(i) % 2) == 0) { 
                evenSquares.add(numbers.get(i) * numbers.get(i));
            }
        }
        System.out.println(evenSquares);
        
        // Iterator<E>
        Iterator<Integer> itr = evenSquares.iterator(); // 리스트의 반복자 만들기. iterator의 반환하는 타입에 따라 변수의 타입도 설정한다.
        // Iterator 반복자는 현재 리스트의 맨 처음(0)에 있음.
        
        System.out.println(itr); // 주소값이 뜸.
        
        while (itr.hasNext()) { // 리스트에서 현재 위치하고 있는 곳에서 다음 원소가 있는지 true/false 리턴.
            System.out.print(itr.next() + ", "); // next: 현재 가리키고 있는 위치를 출력하고, iterator가 가리키고 있는 위치를 다음으로 옮김.
        }
        
        System.out.println();
        
    } // 메인 메서드 닫는 곳

} // 클래스 닫는 곳
