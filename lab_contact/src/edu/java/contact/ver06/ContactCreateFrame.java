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

public class ContactCreateFrame extends JFrame {
    public interface CreateListener {
        void createNotify();
    }

    
    private ContactDaoImpl dao;
    
    private JPanel contentPane;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    
    private Component parent;
    private CreateListener listener;

    /**
     * Launch the application.
     */
    public static void createContact(Component parent, CreateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                ContactCreateFrame frame = new ContactCreateFrame(parent, listener);
                frame.setVisible(true);

            }
        });
    }

    /**
     * Create the frame.
     */
    public ContactCreateFrame(Component parent, CreateListener listener) {
        dao = ContactDaoImpl.getInstance();
        this.parent = parent;
        this.listener = listener;
        initialize();
    }
    
    private void initialize() {
        setTitle("생성하기");
        
        int x = parent.getX();
        int y = parent.getY();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(x, y, 331, 165);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("이름");
        lblName.setBounds(12, 10, 57, 15);
        contentPane.add(lblName);

        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setBounds(12, 54, 57, 15);
        contentPane.add(lblPhone);

        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setBounds(12, 101, 57, 15);
        contentPane.add(lblEmail);

        textName = new JTextField();
        textName.setBounds(81, 7, 116, 21);
        contentPane.add(textName);
        textName.setColumns(10);

        textPhone = new JTextField();
        textPhone.setColumns(10);
        textPhone.setBounds(81, 51, 116, 21);
        contentPane.add(textPhone);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(81, 98, 116, 21);
        contentPane.add(textEmail);

        JButton btnCreate = new JButton("생성");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                create();
            }
        });
        btnCreate.setBounds(229, 97, 74, 23);
        contentPane.add(btnCreate);
    }

    protected void create() {
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        if (name.equals("") || phone.equals("")) {
            JOptionPane.showMessageDialog(this, "빈 칸은 입력할 수 없습니다.", "진행 불가", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Contact contact = new Contact(null, name, phone, email);
        int result = dao.create(contact);
        
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "연락처를 생성했습니다.");
            dispose();
            listener.createNotify();
        } else {
            JOptionPane.showMessageDialog(this, "연락처를 저장할 수 없습니다", "진행 불가", JOptionPane.WARNING_MESSAGE);
        }
        
        
        
        
    }
}
