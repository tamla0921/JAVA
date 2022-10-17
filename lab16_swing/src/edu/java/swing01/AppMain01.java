package edu.java.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AppMain01 {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // 쓰레드를 EventQueue에 등록. -> 자바 가상 머신이 쓰레드를 실행시킴. -> run() 실행.
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain01 window = new AppMain01();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain01() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 425, 300); // 1, 2번 째: 프레임이 시작되는 위치(좌상단을 기준), 3, 4번 째: 프레임의 크기(가로, 세로).
                                              // 디자인 창에서 크기를 변경하면, 소스 코드에서도 자동으로 반영이 됨.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        JLabel lblText = new JLabel("첫 번째 GUI~"); // JLabel 객체 생성.
        lblText.setHorizontalAlignment(SwingConstants.CENTER);
        lblText.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 40));
        frame.getContentPane().add(lblText, BorderLayout.CENTER); // JLabel  객체를 화면에 추가.
        
        JLabel lblText2 = new JLabel("자바 프로그램");
        lblText2.setHorizontalAlignment(SwingConstants.CENTER);
        lblText2.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 40));
        frame.getContentPane().add(lblText2, BorderLayout.NORTH);
    }

}
