package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AppMain04 {

    private JFrame frame;
    private JTextField textNumber1;
    private JTextField textNumber2;
    private JTextArea textArea;
    private JButton btnPlus;
    private JButton btnSub;
    private JButton btnMulti;
    private JButton btnDivide;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    } // 메인 닫음

    /**
     * Create the application.
     */
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setBounds(100, 100, 350, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNumber1 = new JLabel("num1");
        lblNumber1.setBackground(new Color(136, 219, 247));
        lblNumber1.setForeground(new Color(0, 0, 0));
        lblNumber1.setOpaque(true);
        lblNumber1.setBounds(12, 34, 77, 45);
        frame.getContentPane().add(lblNumber1);
        
        JLabel lblNumber2 = new JLabel("num2");
        lblNumber2.setOpaque(true);
        lblNumber2.setBackground(new Color(136, 219, 247));
        lblNumber2.setBounds(12, 92, 77, 45);
        frame.getContentPane().add(lblNumber2);
        
        textNumber1 = new JTextField();
        textNumber1.setBounds(136, 46, 116, 21);
        frame.getContentPane().add(textNumber1);
        textNumber1.setColumns(10);
        
        textNumber2 = new JTextField();
        textNumber2.setColumns(10);
        textNumber2.setBounds(136, 104, 116, 21);
        frame.getContentPane().add(textNumber2);
        
        
        
       
        
        
        
        
        
        
        
        btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//          파라미터 ActionEvent e : 이벤트가 발생한 컴포넌트, 이벤트의 종류 등에 대한...
//                System.out.println(e.getSource() == btnPlus);
//                ActionEvent.getSource(): 이벤트가 발생한 컴포넌트를 리턴.
                
                performCalculation(e); // 참조를 안해도...
                
//                double num1 = Integer.parseInt(textNumber1.getText());
//                double num2 = Integer.parseInt(textNumber2.getText());
                
                
            }
        });
        

        btnPlus.setBounds(12, 162, 97, 23);
        frame.getContentPane().add(btnPlus);
        
        btnSub = new JButton("-");
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation(e);
                
            }
        });
        
        
        
        
        
        btnSub.setBounds(121, 162, 97, 23);
        frame.getContentPane().add(btnSub);
        
        btnMulti = new JButton("X");
        btnMulti.addActionListener((e) -> performCalculation(e));
            
        
//            public void actionPerformed(ActionEvent e) {
//                double num1 = Integer.parseInt(textNumber1.getText());
//                double num2 = Integer.parseInt(textNumber2.getText());
//                
//                textArea.setText(Double.toString(num1 * num2));
//            }
        btnMulti.setBounds(12, 195, 97, 23);
        frame.getContentPane().add(btnMulti);
        
        btnDivide = new JButton("/");
        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performCalculation(e);
               
            }
        });
        btnDivide.setBounds(121, 195, 97, 23);
        frame.getContentPane().add(btnDivide);
        
        textArea = new JTextArea();
        textArea.setBounds(12, 271, 310, 88);
        frame.getContentPane().add(textArea);
        
 
    }
    
    protected void performCalculation(ActionEvent e) {
        // JTextField에 입력된 문자열을 읽고, double 타입으로 변환
        String s1 = textNumber1.getText();
        String s2 = textNumber2.getText();
        
        
        double number1 = 0;
        double number2 = 0;
        
        try {
        number1 = Double.parseDouble(s1);
        number2 = Double.parseDouble(s2);
        } catch (NumberFormatException ex) {
            textArea.setText("number1 또는 number2는 숫자 타입으로 입력하세요.");
            return;
            
        }
        double result = 0; // 산술 연산 결과를 저장하기 위한 변수.
        String op = "";
        
        Object source = e.getSource(); // 이벤트가 발생한 컴포넌트.
        if (source == btnPlus) {
            result = number1 + number2;
            op = " + ";
        } else if (source == btnSub) {
            result = number1 - number2;
            op = " - ";
        } else if (source == btnMulti) {
            result = number1 * number2;
            op = " * ";
        } else if (source == btnDivide) {
            result = number1 / number2;
            op = " / ";
        }
        
        String output = String.format("%f %s %f = %f",
                number1,
                op,
                number2,
                result);
        
        textArea.setText(output);

        
    }

 

} // 클래스 닫음
