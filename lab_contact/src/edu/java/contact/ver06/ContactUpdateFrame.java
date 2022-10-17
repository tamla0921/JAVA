package edu.java.contact.ver06;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {
    public interface UpdateListener {
        void updateNotify();
    }

    private JPanel contentPane;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;

    private Component parent;
    private UpdateListener listener;
    private Integer value;
    
    private ContactDaoImpl dao;

    /**
     * Launch the application.
     */
    public static void contactUpdate(Component parent, Integer value, UpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                ContactUpdateFrame frame = new ContactUpdateFrame(parent, value, listener);
                frame.setVisible(true);

            }
        });
    }

    /**
     * Create the frame.
     */
    public ContactUpdateFrame(Component parent, Integer value, UpdateListener listener) {
        this.parent = parent;
        this.listener = listener;
        this.value = value;
        dao = ContactDaoImpl.getInstance();
        initialize();
        
        initializeBlogData();
    }

    private void initializeBlogData() {
        Contact contact = dao.read(value);
        
        textName.setText(contact.getName());
        textPhone.setText(contact.getPhone());
        textEmail.setText(contact.getEmail());
        
    }

    void initialize() {
        setTitle("자세히 보기...");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = parent.getX();
        int y = parent.getY();
        
        setBounds(x, y, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("이름");
        lblName.setBounds(12, 10, 57, 15);
        contentPane.add(lblName);

        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setBounds(12, 98, 57, 15);
        contentPane.add(lblPhone);

        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setBounds(12, 213, 57, 15);
        contentPane.add(lblEmail);

        textName = new JTextField();
        textName.setBounds(81, 7, 116, 21);
        contentPane.add(textName);
        textName.setColumns(10);

        textPhone = new JTextField();
        textPhone.setColumns(10);
        textPhone.setBounds(81, 95, 116, 21);
        contentPane.add(textPhone);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(81, 210, 116, 21);
        contentPane.add(textEmail);

        JButton btnUpdate = new JButton("수정");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        btnUpdate.setBounds(325, 209, 97, 23);
        contentPane.add(btnUpdate);
    }

    protected void update() { // 새롭게 만들어서...
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        if (name.equals("")||phone.equals("")) {
            JOptionPane.showMessageDialog(this, "빈 칸을 채워주세요", "...", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Contact contact = new Contact(value, name, phone, email);
        
        int result = dao.update(contact);
        
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "수정 성공~!");
            dispose();
            listener.updateNotify();
        } else {
            JOptionPane.showMessageDialog(this, "수정 실패", "...", JOptionPane.WARNING_MESSAGE);
        }
        
    }
}
