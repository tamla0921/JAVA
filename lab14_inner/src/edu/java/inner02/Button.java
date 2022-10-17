package edu.java.inner02;

public class Button {
    // static inner interface
    public static interface OnClickListener { // class와 달리 값 변경할 수 있는 멤버 생성 불가!
        /* (public abstract) */ void onClick (); // public abstract 생략 가능. interface 자체가 추상 메서드를 정의하기 위해 만들기 때문. 따라서 public으로 해서 다른 곳에서 몸체를 만들어야 함.
    }
    
    // field 
    private String btnName; // 인터페이스의 부분이 아님
    private OnClickListener listener;
    
    // constructor
    public Button(String btnName) {
        this.btnName = btnName;
    }
    
    // method
    public void setOnClickListener(OnClickListener l) {
        this.listener = l;
    }
    
    public void click() {
        System.out.println(btnName + "버튼:");
        listener.onClick(); // 아직 listener == null인 상태.
        // 버튼 클릭 -> 버튼 클릭 기능 실행.
    }

} // 클래스 닫음
