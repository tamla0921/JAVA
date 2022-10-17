package edu.java.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class AppMain06 {
    // field
    JButton btnConfirmDlg;
    private JFrame frame;
    private JButton btnMsgDlg;
    private JButton btnOptionDlg;
    private JButton btnInputDlg;
    private JButton btnCustomDlg;
    private JButton btnCustomFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain06 window = new AppMain06();
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
    public AppMain06() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(700, 400, 450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //[닫기] 버튼 클릭 동작 -> 프로그램 종료.
        frame.getContentPane().setLayout(null);
        
        
        
        
        btnMsgDlg = new JButton("Message Dialog");
        btnMsgDlg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnMsgDlg.setBorderPainted(false);
        btnMsgDlg.setForeground(new Color(255, 255, 255));
        btnMsgDlg.setBackground(new Color(0, 128, 255));
        btnMsgDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 익명 클래스에서는 지역 변수를 접근 할 수 없으므로, 멤버 변수로 선언해야 한다.
//                JOptionPane.showMessageDialog(frame, "안녕하세요");
                // 새로운 dialog가 어디 위에서 보일 것인지, 부모 컴퍼넌트는, 어디 창인지..!
                JOptionPane.showMessageDialog(
                        frame, // 다이얼로그가 실행될 부모 컴퍼넌트
                        "안녕안녕?", // 다이얼로그에 표시될 메시지
                        "메시지...", // 다이얼로그의 타이틀
                        JOptionPane.INFORMATION_MESSAGE, //  메시지 타입, _MESSAGE로 끝나는 것들.
                         null // 아이콘, null이면 자동으로 메시지 타입의 아이콘으로 바뀜.
                         ); // 메시지 타입
                
            }
        });
        btnMsgDlg.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 29));
        btnMsgDlg.setBounds(12, 10, 410, 57);
        frame.getContentPane().add(btnMsgDlg);
        
        btnConfirmDlg = new JButton("Confirm Dialog");
        btnConfirmDlg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                int result = JOptionPane.showConfirmDialog(frame, "삭제할까요?");
                int result = JOptionPane.showConfirmDialog(
                        frame, // 다이얼로그의 부모 컴포넌트
                        "선택한 파일을 삭제할까요?", // 다이얼로그의 메시지
                        "선택 확인?", // 다이얼로그의 타이틀(제목 표시줄)
                        JOptionPane.YES_NO_OPTION, // 확인 옵션(YES-NO, YES-NO_CANCEL, ...)
                        JOptionPane.QUESTION_MESSAGE, // 메시지 타입(-> 아이콘을 자동으로 설정)
                        null // 아이콘
                        );
                // X창 Yes, No, Cancel 모두 리턴 값이 있음 (-1, 0, 1, 2)
                // showConfirmDialog의 리턴값:
                // YES= 0 , NO= 1, CANCEL= 2, X(종료)= -1
                
                btnConfirmDlg.setText("Confirm= " + result);
                System.out.println(result);
            }
        });
        btnConfirmDlg.setForeground(Color.WHITE);
        btnConfirmDlg.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 29));
        btnConfirmDlg.setBorderPainted(false);
        btnConfirmDlg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnConfirmDlg.setBackground(new Color(0, 128, 255));
        btnConfirmDlg.setBounds(12, 77, 410, 57);
        frame.getContentPane().add(btnConfirmDlg);
        
        btnOptionDlg = new JButton("Option Dialog");
        btnOptionDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"아니오", "어려워요", "재밌어요"};
                int result = JOptionPane.showOptionDialog( // 리턴 값: int, Cofirm Dialog의 일종.
                        frame,      // 다이얼로그의 부모 컴포넌트
                        "Swing GUI 재미있나요?",           // 다이얼로그의 메시지
                        "확인",           // 다이얼로그의 타이틀
                        JOptionPane.YES_NO_CANCEL_OPTION,              // 다이얼로그의 옵션 타입(Yes-No, Yes-No-Cancel, ...)
                        JOptionPane.QUESTION_MESSAGE,              // 메시지 타입(QUESTION, INFORMATION, ...)
                        null,           // 아이콘
                        options,           // 옵션 버튼에서 사용할 문자열 배열
                        options[2]               // 다이얼로그가 실행될 때 포커스클 받는 버튼 옵션.
                        );
                System.out.println(result);
                
            }
        });
        btnOptionDlg.setForeground(Color.WHITE);
        btnOptionDlg.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 29));
        btnOptionDlg.setBorderPainted(false);
        btnOptionDlg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnOptionDlg.setBackground(new Color(0, 128, 255));
        btnOptionDlg.setBounds(12, 144, 410, 57);
        frame.getContentPane().add(btnOptionDlg);
        
        btnInputDlg = new JButton("Input Dialog");
        btnInputDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String input = JOptionPane.showInputDialog("이름");
//                String input = JOptionPane.showInputDialog(frame, "이름");
                
                Object[] selectionValues = {"10's", "20's", "30's", "40's"};
                Object input = JOptionPane.showInputDialog(
                        frame, //부모 컴퍼넌트
                        "나이", // 메시지
                        "자기소개...", // 타이틀
                        JOptionPane.QUESTION_MESSAGE, // 메시지 타입
                        null, // 아이콘
                        selectionValues, // 선택 값들의 배열
                        selectionValues[1] // 선택 값들 중에서 포커스를 받는 컴포넌트
                        );
                // -> OK 버튼을 클릭하면 입력한 내용이 리턴, Cancel을 클릭하면 빈 문자열을 리턴.
                 btnInputDlg.setText("I'm in my " + input); // 문자열 + object --> 문자열과 더하기 위해 자동으로 toString실행
            }
        });
        btnInputDlg.setForeground(Color.WHITE);
        btnInputDlg.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 29));
        btnInputDlg.setBorderPainted(false);
        btnInputDlg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnInputDlg.setBackground(new Color(0, 128, 128));
        btnInputDlg.setBounds(12, 211, 410, 57);
        frame.getContentPane().add(btnInputDlg);
        
        btnCustomDlg = new JButton("Custom Dialog");
        btnCustomDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyCustomDialog.showMyCustomDialog();
            }
        });
        btnCustomDlg.setForeground(new Color(0, 0, 0));
        btnCustomDlg.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 29));
        btnCustomDlg.setBorderPainted(false);
        btnCustomDlg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnCustomDlg.setBackground(new Color(255, 255, 255));
        btnCustomDlg.setBounds(12, 278, 410, 57);
        frame.getContentPane().add(btnCustomDlg);
        
        btnCustomFrame = new JButton("Custom Frame");
        btnCustomFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyCustomFrame.showMyCustomFrame();
            }
        });
        btnCustomFrame.setForeground(Color.BLACK);
        btnCustomFrame.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 29));
        btnCustomFrame.setBorderPainted(false);
        btnCustomFrame.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnCustomFrame.setBackground(Color.WHITE);
        btnCustomFrame.setBounds(12, 344, 410, 57);
        frame.getContentPane().add(btnCustomFrame);
    }
}
