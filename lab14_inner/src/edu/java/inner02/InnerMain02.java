package edu.java.inner02;

import edu.java.inner02.Button.OnClickListener;

public class InnerMain02 {

    public static void main(String[] args) {
        // Button 타입의 변수 선언, 객체 생성
        Button btnOpen = new Button("Open");
        
        // 생성된 버튼 객체의 setter 메서드를 호출하려면 
        // OnClickListent를 구현한 클래스의 객체를 argument로 전달해야 함.
        OnClickListener l = new OpenButtonListener(); // 아~~~ main에서 OpenButtonListener을 넘김. 
        btnOpen.setOnClickListener(l); // listenr = null에서 변경.
        // listener 변수 설정 -> 버튼이 해야 할 기능을 등록.
        btnOpen.click();
        
        /*
         * public void click() {
         *   System.out.println(btnName + "버튼:");
         *   listener.onClick();
         *   }
         */
        
        Button btnSave = new Button("Save");
        
        // 지역 (내부) 클래스(local class): 메서드 안에서 선언(정의)된 클래스
        // -> 선언된 메서드 안에서만 사용 가능.
        
        // 메서드 안에서 클래스를 정의할 경우, 해당 메서드 안에서만 이 클래스를 사용할 수 있음.
        class SaveButtonListener implements OnClickListener {
            
            @Override
            public void onClick() {
                System.out.println("저장합니다.");
                
            }
        }
        
        OnClickListener listener = new SaveButtonListener(); // SaveButtonListener는 OnclikListener에 포함된다.
        // SavebuttonListener listener = new SaveButtonListener(); 도 가능 함. SaveButtonListener이 해당 클래스에 적혀있기 때문이다.
        
        // 2) 버튼이 해야할 일 기능 등록 - 버튼 클릭 기능 등록
        btnSave.setOnClickListener(listener);
        
//        btnSave.setOnClickListener(new SaveButtonListener());
        
        // 3) 버튼 클릭 (기능 실행)
        btnSave.click();
        
        // 1) 버튼 생성
        Button btnClose = new Button("close");
        
        
        // 익명 클래스(anonymous class)
        OnClickListener listener2 = new OnClickListener() {
            
            @Override
            public void onClick() {
                System.out.println("파일 닫기");
                
            }
        };
        
        // 2) 버튼 기능 등록
        btnClose.setOnClickListener(listener2);

        // 3) 버튼 기능 실행
        btnClose.click();
        
        // 버튼 생성
        Button btnExit = new Button("EXIT");
        btnExit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("프로그램 종료");
            // TODO Auto-generated method stub
            
        }
        });
        
        // 3) 버튼 기능 실행
        btnExit.click();
        
        
         
    } // 메인 닫음

} // 클래스 닫음
