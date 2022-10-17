package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {  // Main과 달리 JFrame을 상속받음. --> 따라서 (예) 그냥 setTitle만 작성할 수 있음.

    @FunctionalInterface
    public interface ContactInsertListener {
        void contactInsertNotify(Contact c);}
        
    private ContactInsertListener listener;
    
    private JPanel contentPane;
    private Component parent;
    private JTextField textName;
    private JTextField textNumber;
    private JTextField textEmail;

    /**
     * Launch the application. // 메인 메서드를 일반 메서드로 변형.
     */
    public static void newContactCreateFrame(Component parent, ContactInsertListener listener) { // 프로그램 main 하나! --> 일반 메서드러 격하..
        EventQueue.invokeLater(new Runnable() { // 스레드... 
            public void run() {
                ContactCreateFrame frame = new ContactCreateFrame(parent, listener); // 생성자
                // Main의 요소들을 받을 수 있음!!
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
    
    public ContactCreateFrame(Component parent, ContactInsertListener listener) {
        this.parent = parent; //  부모 컴포넌트를 초기화. (static이 아니기 때문에 따로 작성)
        this.listener = listener; // contactInsertNotify() 메서드를 가지고 있는 객체를 초기화.
        
        // parent, listener 모두 우리가 따로 작성.
        
        initialize(); // UI 컴포넌트들을 생성, 초기화.
    }
    
    //메서드
    private void initialize() {
        // 실행 순서
        // (1) Main의 ContactCreateFrame.newContactCreateFrame(frame, ContactMain05.this)
        // - ContactMain05는  ContactInsertListener의 인터페이스를 가졌기 때문에
        // - ContactMain05는 ContactInsertListener의 타입이기도 하다.
        // - 왜 ContactInsertListener라는 새로운 인터페이스를 만들었는가?
        // - AppMain05 타입으로 해도 되지만, 만약 다른 프로그램을 새로 만든다면, 클래스를 만들어야 하기 때문에 일일히 새로 작성해야 함.
        // - 다른 프로그램에서도 이 클래스를 사용할 수 있도록 (예: ContacteMain06...) 하기 위함.
        // - 즉 제각기 다른 프로그램에서 오는 타입들을 한 가지로 통일하기 위함(다항성!)
        // (2) 이 클래스의 메서드 호출 뒤, new ContactCreateFrame(Component parent, ContactInsertListener listener) 생성자로 객체 만들음.
        // (3) 이 클래스의 필드(멤버 변수)의 parent, listener를 Main값에서 받아옴.
        // (4) initialize, 화면 띄우기.
        // (5) 연락처 입력 후 저장 버튼 --> createNewContact() 메서드 호출
        // (6) textField에서 얻어 온 정보들을 모아서 Contact객체 생성
        // (7) listener.contactInsertNotify(contact) 호출.
        // - listener는 ContactMain05의 주솟값. 즉, ContactMain05 클래스의 메서드를 호출
        // (8) ContactMain05의 contactInsertNotify(Contact c) 실행
        // (9) (현재는) 프린트문 작동.
        
        
        setTitle("새 연락처 추가");
        // JFrame을 상속받았기 때문에 메인에서 frame.setTitle()이 아니라 그냥 setTitle().
        
        // 기존에 있던 생성자를 이름을 initalize()로 바꾼 다음 ContactCreateFrame()에서 호출
        // 메인과 비슷하게 만들음.
        
        // 닫기 버튼(X)을 클릭했을 때의 기본 동작 설정 - 현재 창만 닫기로 변경!
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // JFrame이 화면에 보이게 될 좌표와 크기(가로/세로)를 설정.
        int x = parent.getX(); // 부모 컴포넌트의 x 좌표(위치)
        int y = parent.getY(); // 부모 컴포넌트의 y 좌표(위치)
        // parent - Main의 값. Main에서 호출하면서 파라미터들을 가져왔기 때문에 사용이 가능 함.
        
        setBounds(x, y, 450, 300); // 창이 뜨는 위치를 직접 설정하기...
        
        
        
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
        
        JButton btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            @Override // 버튼 누르기
            public void actionPerformed(ActionEvent e) {
                createNewContact();
            }
        });
        btnSave.setFont(new Font("굴림", Font.ITALIC, 25));
        btnSave.setBounds(12, 210, 121, 41);
        contentPane.add(btnSave);
        
        
        
        
        
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // JFrame의 메서드: 현재 창만 닫고, 부모 컴퍼넌트는 계속 실행.
            }
        });
        btnCancel.setFont(new Font("굴림", Font.ITALIC, 25));
        btnCancel.setBounds(145, 210, 121, 41);
        contentPane.add(btnCancel);
    }

    protected void createNewContact() {
        // 3개의 JTextField의 입력된 문자열을 읽음.
        String name = textName.getText();
        String number = textNumber.getText();
        String email = textEmail.getText();
        // Contact 객체 생성
        
        Contact contact = new Contact(name, number, email);
        
        // 새 연락처가 생성됐음을 알려줌.
        // 현재 창 닫기
        dispose(); // 창이 먼저 닫아도 아래줄 실행 가능.
        
        listener.contactInsertNotify(contact); // Contact 객체를 파라미터로 가지도록 설정.
        // ContactMain에서 ContactMain05.this의 주솟값을 받음
        // 따라서 listener은 COntactMian05.this의 특징을 가짐.
        
        // 이 모든 것이 createNewContact()의 메서드
        
    }

}
