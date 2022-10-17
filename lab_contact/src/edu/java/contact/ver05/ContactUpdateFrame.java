package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;
import edu.java.contact.ver04.ContactDaoImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {  // Main과 달리 JFrame을 상속받음. --> 따라서 (예) 그냥 setTitle만 작성할 수 있음.
    @FunctionalInterface
    public interface ContactUpdateListener {
        void contactUpdateNotify();
    }
    
    private ContactUpdateListener listener;
    
    private Component parent; // 업데이트 창을 실행시킨 부모 컴포넌트.
    private int index; // 수정할 연락처의 인덱스.
    private ContactDaoImpl dao; // 연락처 검색(read), 업데이트(update), ...
    
    private JPanel contentPane;
    private JTextField textName;
    private JTextField textNumber;
    private JTextField textEmail;


    /**
     * Launch the application.
     */
    public static void newContactUpdateFrame(Component parent/*부모 JFrame을 말함...*/, int index, ContactUpdateListener listener) {
    
        // 프로그램 main 하나! --> 일반 메서드러 격하..\
        // 메인메서드고 존재하면 혼자 단독으로 실행될 수 있음.
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContactUpdateFrame frame = new ContactUpdateFrame(parent, index, listener);
                // Component
                // |__ 모든 UI(?)는 상속받음. (예) JFrame 따라서 showConfirmDialog의 첫 번째 요소에 JFrame 타입인 frame 넣어도 가능했다.
                
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.  생성자!!
     * 메인은 initialize()를 호출한 것처럼 수정함.
     */
    
    public ContactUpdateFrame(Component parent, int index, ContactUpdateListener listener) {
        this.parent = parent; //  부모 컴포넌트를 초기화. (static이 아니기 때문에 따로 작성)
        this.index = index; // 수청할 연락처의 인덱스를 멤버로 저장.
        this.dao = ContactDaoImpl.getInstance(); // DAO 싱글턴 객체를 가져옴. ContactDaoImpl 활성화.
        this.listener = listener; // 업데이트 창을 만든 메인 창의 주소를 저장.
        
        initialize(); // UI 컴포넌트들을 생성, 초기화.
        
        initializeContactInfo(); // 수정하려는 인덱스의 연락처 정보를 JTextField에 채움.
        
        
    }
    
    void initializeContactInfo() {
        Contact contact = dao.read(index); // 수정하려는 연락처 정보
        // index를 메인에서 가져왔음을..
        
        // 각 JTextField에 연락처 정보를 씀.
        textName.setText(contact.getName());
        textNumber.setText(contact.getPhone());
        textEmail.setText(contact.getEmail());
        
    }
    
    //메서드
    private void initialize() {
        setTitle("새 연락처 보기/수정"); // JFrame을 상속받았기 때문에 메인에서 frame.setTitle()이 아니라 그냥 setTitle().
        
        // 기존에 있던 생성자를 이름을 initalize()로 바꾼 다음 ContactCreateFrame()에서 호출
        // 메인과 비슷하게 만들음.
        
        // 닫기 버튼(X)을 클릭했을 때의 기본 동작 설정 - 현재 창만 닫기로 변경!
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        int x = parent.getX(); // 부모 컴포넌트의 x 좌표(위치)
        int y = parent.getY(); // 부모 컴포넌트의 y 좌표(위치)
        setBounds(x, y, 298, 300); // 창이 뜨는 위치를 직접 설정하기...
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        lblName.setBounds(12, 23, 82, 27);
        contentPane.add(lblName);
        
        JLabel lblNumber = new JLabel("전화번호");
        lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        lblNumber.setBounds(12, 76, 82, 27);
        contentPane.add(lblNumber);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        lblEmail.setBounds(12, 128, 82, 27);
        contentPane.add(lblEmail);
        
        textName = new JTextField();
        textName.setHorizontalAlignment(SwingConstants.CENTER);
        textName.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
        textName.setBounds(106, 16, 156, 41);
    
        contentPane.add(textName);
        textName.setColumns(10);
    
        
        textNumber = new JTextField();
        textNumber.setHorizontalAlignment(SwingConstants.CENTER);
        textNumber.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
        textNumber.setColumns(10);
        textNumber.setBounds(106, 69, 156, 41);
        contentPane.add(textNumber);
        
        textEmail = new JTextField();
        textEmail.setHorizontalAlignment(SwingConstants.CENTER);
        textEmail.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
        textEmail.setColumns(10);
        textEmail.setBounds(106, 121, 156, 41);
        contentPane.add(textEmail);
        
        
        
        
        
        
        
        JButton btnSave = new JButton("수정");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });
        btnSave.setFont(new Font("굴림", Font.ITALIC, 25));
        btnSave.setBounds(12, 210, 121, 41);
        contentPane.add(btnSave);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setFont(new Font("굴림", Font.ITALIC, 25));
        btnCancel.setBounds(145, 210, 121, 41);
        contentPane.add(btnCancel);
    }

    private void updateContact() {
        // 각 JTextField에 입력된 내용을 읽음.
        String name = textName.getText();
        String number = textNumber.getText();
        String email = textEmail.getText();
        
        // Contact 타입 객체 생성
        Contact contact = new Contact(name, number, email);
        
        // DAO의 메서드를 사용해서 연락처 정보 (파일) 업데이트.
        dao.update(index, contact);
        
        // 창 닫기
        dispose();
        
        // 메인 창(window)에게 연락처 정보 업데이트 됐다고 알려주기.
        listener.contactUpdateNotify(); // listener에게 contactUpdateNotify 메서드 인터페이스로 만들음.
        
    }

}
