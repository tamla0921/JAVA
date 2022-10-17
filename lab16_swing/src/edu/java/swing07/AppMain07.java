package edu.java.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {

    private JFrame frame;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rbPrivate;
    private JRadioButton rbPackage;
    private JRadioButton rbProtected;
    private JRadioButton rbPublic;
    private JCheckBox cbAbstract;
    private JCheckBox cbFinal;
    private JCheckBox cbStatic;
    private JTextArea textArea;
    private JComboBox<String> comboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain07 window = new AppMain07();
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
    public AppMain07() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 392, 336);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        rbPrivate = new JRadioButton("private");
        rbPrivate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPrivate);
        rbPrivate.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        rbPrivate.setBounds(8, 17, 95, 23);
        frame.getContentPane().add(rbPrivate);
        
        rbPackage = new JRadioButton("package");
        rbPackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPackage);
        rbPackage.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        rbPackage.setBounds(104, 17, 95, 23);
        frame.getContentPane().add(rbPackage);
        
        rbProtected = new JRadioButton("protected");
        rbProtected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbProtected);
        rbProtected.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        rbProtected.setBounds(205, 17, 95, 23);
        frame.getContentPane().add(rbProtected);
        
        rbPublic = new JRadioButton("public");
        rbPublic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPublic);
        rbPublic.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        rbPublic.setBounds(304, 17, 73, 23);
        frame.getContentPane().add(rbPublic);
        
        cbAbstract = new JCheckBox("abstract");
        cbAbstract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printCheckBoxStatus(e);
            }
        });
        cbAbstract.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        cbAbstract.setBounds(8, 53, 95, 23);
        frame.getContentPane().add(cbAbstract);
        
        cbFinal = new JCheckBox("final");
        cbFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printCheckBoxStatus(e);
            }
        });
        cbFinal.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        cbFinal.setBounds(166, 53, 95, 23);
        frame.getContentPane().add(cbFinal);
        
        cbStatic = new JCheckBox("static");
        cbStatic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printCheckBoxStatus(e);
            }
        });
        cbStatic.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        cbStatic.setBounds(304, 53, 73, 23);
        frame.getContentPane().add(cbStatic);
        
        comboBox = new JComboBox<>();
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = (String) comboBox.getSelectedItem();
                // 콤보박스 안에 문자열 뿐만 아니라 이모티콘 등 다양한 걸 넣을 수 있기 때문에 Object타입으로 지정.
                // String으로 전환할 수 있다면 Object에서 String으로 타입을 변환할 수 있다.
                textArea.setText(a + " : selected"); 
            }
        });
        final String[] items = {"naver.com", "kakao.com", "gmail.com", "hanmail.net", "msn.com", "nate.com"}; //setIcon처럼... 타입 만들기
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
        
        comboBox.setModel(model);
        
        comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        comboBox.setBounds(12, 88, 91, 23);
        frame.getContentPane().add(comboBox);
        
        JButton btnShowInfo = new JButton("done");
        btnShowInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printInfo();
            }
        });
        btnShowInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        btnShowInfo.setBounds(267, 89, 97, 23);
        frame.getContentPane().add(btnShowInfo);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(8, 121, 356, 167);
        frame.getContentPane().add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("궁서체", Font.PLAIN, 15));
        scrollPane.setViewportView(textArea);
    }

protected void printInfo() {
        // RadioButton, CheckBox, ComboBox의 상태를 TextArea에 출력
        StringBuilder buffer = new StringBuilder(); // TextArea에 출력할 문자열을 만들기 위한 객체
        
        // 라디오버튼들 중에서 어떤 버튼이 선택됐는 지
        if (rbPrivate.isSelected()) {
            buffer.append(rbPrivate.getText()).append(" ");
        } else if (rbPackage.isSelected()) {
            buffer.append(rbPackage.getText()).append(" ") ;
        } else if (rbProtected.isSelected()) {
            buffer.append(rbProtected.getText()).append(" ");
        } else if (rbPublic.isSelected()) {
            buffer.append(rbPublic.getText()).append(" ");
        }
        
        buffer.append("라디오 버튼 선택\n");
        
        // 체크박스들 중에서 어떤 체크박스들이 선택됐는 지...
        if (cbAbstract.isSelected()) {
            buffer.append(cbAbstract.getText()).append(" ");
        }
        
        if (cbFinal.isSelected()) {
            buffer.append(cbFinal.getText()).append(" ");
        }
        
        if (cbStatic.isSelected()) {
            buffer.append(cbStatic.getText()).append(" ");
        }
        buffer.append("체크 박스 선택 \n");
        
        // ComboBx의 아이템들 중에서 어떤 아이템이 선택됐는 지
        
        String item = (String) comboBox.getSelectedItem();
        buffer.append(item).append(" 콤보박스 아이템 선택\n");
        
        // 버퍼의 내용을 TextArea에 출력
        textArea.setText(buffer.toString()); // StringBuilder 클래스의 toSting은 String을 변환!
        
    }

//    protected void printComboBoxStatus(ActionEvent e) {
//        JComboBox CheckCb = (JComboBox) e.getSource();
//        String CheckText = (String) CheckCb.getSelectedItem();
//        textArea.setText("" + CheckText);
//        
//    }

    protected void printCheckBoxStatus(ActionEvent e) {
        JCheckBox Checkbx = (JCheckBox) e.getSource(); // 이벤트가 발생한 체크박스
        String bxText = Checkbx.getText(); // 체크박스의 텍스트
        boolean selected = Checkbx.isSelected(); // 체크박스 선택/해제 여부
        
        textArea.setText(bxText + " : " + selected);
        
        
    }

    protected void printRadioButtonStatus(ActionEvent e) {

        JRadioButton radioBtn = (JRadioButton) e.getSource(); // 이벤트가 발생한 라디오 버튼
        String btnText = radioBtn.getText(); // 라디오 버튼의 텍스트
        boolean selected = radioBtn.isSelected(); // 라디오 버튼의 선택/해제 여부
        textArea.setText(btnText + " : " + selected);
        
        
    }
}
