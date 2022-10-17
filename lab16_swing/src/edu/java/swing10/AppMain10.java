package edu.java.swing10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class AppMain10 {

    private JFrame frame;
    private JTextField textK;
    private JTextField textE;
    private JTextField textM;
    private JTable table;
    private DefaultTableModel model;
    private final Object[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain10 window = new AppMain10();
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
    public AppMain10() { // 생성자
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        
        
        // Label
        JLabel lblK = new JLabel("국어");
        lblK.setHorizontalAlignment(SwingConstants.CENTER);
        lblK.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblK.setBounds(12, 10, 116, 38);
        frame.getContentPane().add(lblK);
        
        JLabel lblE = new JLabel("영어");
        lblE.setHorizontalAlignment(SwingConstants.CENTER);
        lblE.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblE.setBounds(12, 67, 116, 38);
        frame.getContentPane().add(lblE);
        
        JLabel lblM = new JLabel("수학");
        lblM.setHorizontalAlignment(SwingConstants.CENTER);
        lblM.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblM.setBounds(12, 124, 116, 38);
        frame.getContentPane().add(lblM);
        
        
        
        
        
        // TextField
        textK = new JTextField();
        textK.setBounds(157, 10, 116, 38);
        frame.getContentPane().add(textK);
        textK.setColumns(10);
        
        textE = new JTextField();
        textE.setColumns(10);
        textE.setBounds(157, 67, 116, 38);
        frame.getContentPane().add(textE);
        
        textM = new JTextField();
        textM.setColumns(10);
        textM.setBounds(157, 124, 116, 38);
        frame.getContentPane().add(textM);
        
        
        // Button
        JButton btnAdd = new JButton("입력");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputScore();
            }
        });
        btnAdd.setBounds(325, 137, 97, 23);
        frame.getContentPane().add(btnAdd);
        
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });
        btnDelete.setBounds(325, 10, 97, 23);
        frame.getContentPane().add(btnDelete);
        
        
        // Table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 170, 434, 231);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable(); // JTable 생성
        
        model = new DefaultTableModel(null, COLUMN_NAMES); // 컬럼 이름만 갖는 테이블 모델 생성
        
        table.setModel(model); // 테이블 모델을 테이블에 세팅.
        

        scrollPane.setViewportView(table);
    }

    protected void deleteRow() {
        //테이블에서 삭제하기 위해서 선택된 행(row) 인덱스를 찾음.
        
        // 행 인덱스를 사용해서 테이블 모델에서 행을 삭제
        
        int index = table.getSelectedRow();
        
        if (index == -1) { // 테이블에서 선택된 행이 없는 경우
        JOptionPane.showMessageDialog(frame, "삭제할 부분을 눌러 주세요.", "오류", JOptionPane.WARNING_MESSAGE);
        return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(frame, index + "번째 행을 정말 삭제하겠습니까?", "혹시모름", JOptionPane.YES_NO_OPTION);
            // 제일 마지막 요소 optionType: an int designating the options available on the dialog: YES_NO_OPTION, YES_NO_CANCEL_OPTION,or OK_CANCEL_OPTION
        
        if (confirm == JOptionPane.YES_OPTION) {// 다이얼로그에서 Yes를 클릭했을 때
            model.removeRow(index);
        }
        
       
        
    }

    private void inputScore() {
        // 3개의 JTextField에서 읽은 문자열을 정수(int)로 변환
        
        int korean = 0;
        int english = 0;
        int math = 0;
        
        try {
            korean = Integer.parseInt(textK.getText());
            english = Integer.parseInt(textE.getText());
            math = Integer.parseInt(textM.getText());
            // try안에서 변수를 선언하면 블록이 끝나면 사라짐.
            // 블록 밖에서 선언하고, 그 값을 수정하는 것은 그대로 남기 때문에 사용이 가능하다.
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    frame, 
                    "숫자만 입력하세요.", 
                    "입력 오류", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        } finally {
            clearAllTextFields();
        }
        
        // 입력값들을 사용해서 Score 객체 생성
        Score score = new Score(korean, english, math);
        
        // 테이블의 행(row)에 추가할 데이터를 1차원 배열로 만들 수 있음.
        Object[] rowData = {
                score.getKorean(),
                score.getEnglish(),
                score.getMath(),
                score.sum(),
                score.average(),
        };
                
        // row data를 테이블 모델에 추가
        model.addRow(rowData);
        
        
    }
    
    private void clearAllTextFields() {
        textK.setText("");
        textE.setText("");
        textM.setText("");
    }
    
    
    
    
    
}
