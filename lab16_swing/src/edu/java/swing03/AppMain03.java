package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class AppMain03 {

    private JFrame frame;
    private JTextField textNumber;
    private JTextField textEmail;
    private JLabel lblName;
    private JLabel lblNumber;
    private JLabel lblEmail;
    private JTextField textName;
    private JButton btnInput;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
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
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblName = new JLabel("이름");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblName.setBounds(13, 10, 82, 38);
        frame.getContentPane().add(lblName);
        
        lblNumber = new JLabel("전화번호");
        lblNumber.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumber.setBounds(13, 77, 82, 38);
        frame.getContentPane().add(lblNumber);
        
        lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblEmail.setBounds(13, 139, 82, 38);
        frame.getContentPane().add(lblEmail);
        
        textName = new JTextField();
        textName.setBounds(107, 10, 188, 38);
        frame.getContentPane().add(textName);
        textName.setColumns(10);
        
        textNumber = new JTextField();
        textNumber.setColumns(10);
        textNumber.setBounds(107, 77, 188, 38);
        frame.getContentPane().add(textNumber);
        
        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(107, 139, 188, 38);
        frame.getContentPane().add(textEmail);
        
        btnInput = new JButton("입력");
        btnInput.setFont(new Font("돋움체", Font.ITALIC, 20));
//        btnInput.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//             String name = textName.getText();
//             String number = textNumber.getText();
//             String email = textEmail.getText();
//             
//             textArea.setText("이름: " + name + "\n전화번호: " + number + "\n이메일: " + email);
             
            // 람다 표현식
//          버튼에 이벤트 핸들러를 등록
//          이벤트 핸들러: 이벤트가 발생됐을 때 자동으로 호출되는 메서드.
          btnInput.addActionListener((e) -> printInfo());
            
    
        btnInput.setBounds(326, 10, 82, 167);
        frame.getContentPane().add(btnInput);
        
        textArea = new JTextArea();
        textArea.setBackground(new Color(128, 255, 255));
        textArea.setForeground(new Color(0, 0, 0));
        textArea.setBounds(13, 193, 409, 58);
        frame.getContentPane().add(textArea);
    }
    
    // "입력" 버튼을 클릭했을 때 실행할 내용.
    private void printInfo() {
//      JTextField에 입력된 내용을 읽음.
      String name = textName.getText();
      String number = textNumber.getText();
        String email = textEmail.getText();
        
//    JTextArea에 출력할 문자열 만들기
StringBuilder buffer = new StringBuilder();
buffer.append("이름: ").append(name).append("\n")
.append("전화번호: ").append(number).append("\n")
.append("이메일: ").append(email);

//만들어진 문자열을 JTextArea에 출력
textArea.setText(buffer.toString()); //buffer는 StringBuilder 타입..
    }
}
