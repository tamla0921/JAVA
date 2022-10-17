package edu.java.inner02;

import edu.java.inner02.Button.OnClickListener;

// Button.OnclickListener 인터페이스를 구현하는 클래스.
public class OpenButtonListener implements OnClickListener{ // public static으로 인터페이스 설정했기 때문에 임폴트가능.
    
    @Override
    public void onClick() {
        System.out.println("파일 열기");
    }

}
