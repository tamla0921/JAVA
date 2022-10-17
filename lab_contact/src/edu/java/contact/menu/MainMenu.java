package edu.java.contact.menu;


// enum: 열거형 상수들을 정의하는 특별한 종류의 "클래스".
// -> 생성자, 메서드를 정의할 수 있음.
// -> 변수 타입, 메서드 리턴 타입, 파라미터 타입을 선언할 때 enum 이름을 사용할 수 있음.
public enum MainMenu {
    QUIT, SELECT_ALL, SELECT_BY_INDEX, CREATE, UPDATE, DELETE, UNKNOWN; // 열거형 "상수"들
    
    public static MainMenu getValue(int n) { // enum도 타입이라 반환형에 적을 수 있다.
        // 정수 n을 enum 타입 값으로 변환해서 리턴.
        MainMenu[] menu = values();
        
        if (n < 0 || n >= menu.length) {
            return menu[menu.length - 1]; // 지정된 범위 밖이면 menu.length (= 7)에서 1을 뺀 값을 리턴한다. menu[6] 즉, UNKNKOWN이 있는 위치.
            // length - 1로 설정한 것은... 메뉴들이 늘어나고 줄어나는 것을 대비하는 것.
        }
        return menu[n];
        }
    }

/* 왜 return menu[n]에 else 문을 안 붙여도 될까?
 * if 문이 false라면 실행되지 않고 밑 return이 반환
 * 만약 if 문이 true라면 if문의 return 값이 반환
 * 따라서 else를 붙이지 않아도 되고, Unreachable Code도 발생하지 않음.
 */

