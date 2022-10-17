package edu.java.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppMain08 {

    private JFrame frame;
    private JTextField txtField;
    private JButton btnDelete;
    private JScrollPane scrollPane;

    JList<String> list;
    
    // JList의 원소들을 관리하는 객체.
    // JList에 새로운 워소 추가, 원소 삭제, 선택된 원소에 대한 정보, ...
    DefaultListModel<String> listModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain08 window = new AppMain08();
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
    public AppMain08() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 321, 522);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        txtField = new JTextField();
        txtField.setFont(new Font("맑은 고딕 Semilight", Font.BOLD | Font.ITALIC, 28));
        txtField.setBounds(12, 10, 281, 63);
        frame.getContentPane().add(txtField);
        txtField.setColumns(10);
        
        JButton btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToList();
            }
        });
        btnInput.setBounds(12, 83, 97, 23);
        frame.getContentPane().add(btnInput);
        
        btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItemFromList();
            }
        });
        btnDelete.setBounds(196, 83, 97, 23);
        frame.getContentPane().add(btnDelete);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 116, 281, 357);
        frame.getContentPane().add(scrollPane);
        
        list = new JList<>(); // JList 객체 생성
       
        
        // JList의 원소들을 관리하는 ListModel 객체를 생성.
        listModel = new DefaultListModel<>(); // listModel에서 지우고 추가하면, 리스트에서 지우고 추가가 됨.
        
        list.setModel(listModel); // Jlist에 listModel을 설정.
        list.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        scrollPane.setViewportView(list);
    }

    protected void addItemToList() {
        // JTextField에 입력된 내용을 읽음.
        String input = txtField.getText();
        
        // JTxtField에 입력된 내용이 없는 경우 getText() 메서드는 빈 문자열("")을 리턴!
        if (input.equals("")) {
            JOptionPane.showMessageDialog(frame, "비어있는 문자 불가!", "경고경경고", JOptionPane.WARNING_MESSAGE);
            return; // addItemToList() 메서드를 종료
        }
        
        // JList에 새로운 원소로 추가.
        listModel.addElement(input);
        
        txtField.setText(""); // 너무 메서드만 생각하지 말기.
        
    }

    private void deleteItemFromList() {
        // JList에서 선택된 원소의 인덱스를 찾음.
        int index = list.getSelectedIndex(); // 선생님도 헷갈려하심.. 리스트 항목은 다 찾아보기
        // getSelectedInedx()에서 값이 없을 경우 -1을 리턴
        
        if (index == -1) { // JList에서 선택된 원소가 없을 때
            JOptionPane.showMessageDialog(frame, "리스트에서 눌러서 삭제", "에러에러에러에러에러", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // 사용자에게 삭제 여부를 확인
        int confirm = JOptionPane.showConfirmDialog(frame, "진짜 삭제?", "주의!!!", JOptionPane.YES_NO_OPTION);
        // System.out.println(confirm);
        // DaefultListModel에서 원소를 삭제하면 JList에서 그 원소가 자동으로 삭제됨.
        if (confirm == JOptionPane.YES_OPTION){  // YES_, NO_OPTION ... 상수!
        listModel.remove(index);
        }
    }
    
    private void deleteList() {
        
        
        int index = list.getSelectedIndex(); // JList의 메서드. 
        
        
        try {
            listModel.remove(index);
        } catch (ArrayIndexOutOfBoundsException e1) {
            
        }
        
    }

    private void inputList(ActionEvent e) {
        String a = txtField.getText();
        listModel.addElement(a);


    }
}
