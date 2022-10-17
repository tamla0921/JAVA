package edu.java.swing06;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyCustomDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void showMyCustomDialog() {
        // 메인 메소드가 두 개 이상일 필요는 없다. 그래서 main 메서드 이름을 바꿈.
        // 그러나 단독 실행을 불가능해져 AppMain06에서 호출해야 실행.
        // argument도 필요 없어져서 삭제.
        try {
            MyCustomDialog dialog = new MyCustomDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  // [닫기] 버튼 클릭 동작 -> 현재 다이얼로그만 종료.
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public MyCustomDialog() {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            
            JButton okButton = new JButton("OK");
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);
            
            
            JButton cancelButton = new JButton("Cancel");
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
            
        
    }

}
