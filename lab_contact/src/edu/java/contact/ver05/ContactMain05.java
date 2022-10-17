package edu.java.contact.ver05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.ver04.Contact;
import edu.java.contact.ver04.ContactDaoImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import edu.java.contact.ver05.ContactCreateFrame.ContactInsertListener;
import edu.java.contact.ver05.ContactUpdateFrame.ContactUpdateListener;

public class ContactMain05 implements ContactInsertListener, ContactUpdateListener {
    private static final String[] COLUMN_NAMES = {"이름", "전화번호"};

    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private ContactDaoImpl dao;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactMain05 window = new ContactMain05();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application. 생성자
     */
    public ContactMain05() { //생성자가 initialize()를 호출.
        initialize(); // UI 컴포넌트 생성, 초기화
        dao = ContactDaoImpl.getInstance(); // 연락처 데이터 관리(추가, 삭제, 변경, 검색, ...)
        loadContactDataFromFile(); // 데이터 파일에 저장된 데이터를 로드해서 테이블에 설정.
    }
    
    private void loadContactDataFromFile() {
        List<Contact> list = dao.read();
        for (Contact c : list) {
            addContactToTableModel(c); 
            // list에 있는 contact 객체들을 하나씩
            // addContactToTableModel() 호출! ↓ 바로 밑 ↓
        }
    }
    
    

    private void addContactToTableModel(Contact c) {
        // 테이블에 내용 가져오기.
        // (1) initialize()
        // (2) loadContactDataFromFile()을 각 객체마다 호출
        // (3) 1차 배열 만들기 Object[] rowData {c.getName(), c.getPhone()};
        // (4) table = new JTable(); // 엑셀창..
        //     model = new DefaultTableModel(null, COLUMN_NAMES); // 행렬의 자료들..
        //     table.setModel(model
        //        ); 로 가져온 model에 addRow(rowData)!! // 테이블에 model(행렬의 자료들)을 가져온다.
        
        
        
        // 테이블 모델에 추가할 행(row) 데이터
        Object[] rowData = {c.getName(), c.getPhone()};
        
        // 테이블 모델에 데이터 추가
        model.addRow(rowData); // <-> removeRow();
        // 창에 보여지는 것은 간단.. 그러나 다른 창에서 만들어진 정보를 또 다른 창으로 옮기는 것이 복잡.
        
        
        
        
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("contact Ver 0.5"); // 애플리케이션 타이틀을 설정
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        // 버튼
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        JButton btnCreate = new JButton("연락처 생성");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactCreateFrame.newContactCreateFrame(frame, ContactMain05.this); //this: 그 객체가 생성된 주소.
                // 익명클래스의 this. actionlistener타입의 객체를 말하게 되는 것.
                // ContactMain05.this: 외부클래스의 주소..?
                // ContactCreateFrame 클래스의 static 메서드인 newContactCreateFrame() 불러오기.
                // 새 창을 띄울 때, 뜨는 자리를 고정하고 싶다면, 메서드에 argument를 작성해준다.
                //TODO
            }
        });
        btnCreate.setFont(new Font("돋움체", Font.PLAIN, 12));
        buttonPanel.add(btnCreate);
        
        JButton btnUpdate = new JButton("연락처 상세");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUpdateFrame();
                
            }
        });
        btnUpdate.setFont(new Font("돋움체", Font.PLAIN, 12));
        buttonPanel.add(btnUpdate);
        
        JButton btnDelete = new JButton("연락처 삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });
        btnDelete.setFont(new Font("돋움체", Font.PLAIN, 12));
        buttonPanel.add(btnDelete);
        
        JButton btnSearch = new JButton("연락처 검색");
        btnSearch.setFont(new Font("돋움체", Font.PLAIN, 12));
        buttonPanel.add(btnSearch);
        
        
        // 스크롤
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model
                );
        scrollPane.setViewportView(table);
    }
    
    private void deleteContact() {
        int row = table.getSelectedRow(); // 테이블에서 선택된 행 인덱스
        
        if (row == -1) { // 테이블에서 선택된 행이 없으면
            JOptionPane.showMessageDialog(frame, "아래의 항목에서 삭제할 전화번호를 선택하세요", //메시지
                     "오류", // 타이틀
                    JOptionPane.WARNING_MESSAGE); // 메시지 타입
            return;
        }
        
        
        
        int confirm = JOptionPane.showConfirmDialog(frame, 
                "선택한 연락처를 정말 삭제할까요?",  // 메시지
                "삭제확인", // 타이틀
                JOptionPane.YES_NO_OPTION); // Yes-No-Cancel 옵션
        
        if (confirm == JOptionPane.YES_OPTION) {
        // DAO의 메서드를 사용해서 연락처를 삭제, 파일에 저장.
        dao.delete(row);
        
        // 테이블 갱신
        model.removeRow(row); // 삭제하기는 바로 존재.. (창이 뜨지 않기 때문)
        
        JOptionPane.showMessageDialog(frame, "삭제 완료!");
        }
        
    }

    private void showUpdateFrame() {
        // 테이블에서 수정하기 위해서 선택한 행 번호를 찾음.
        int row = table.getSelectedRow();
    
        if (row == -1) {
            JOptionPane.showMessageDialog(frame,
                    "아래의 항목에서 수정할 전화번호를 선택하세요", // 메시지
                    "오류", // 타이틀
                    JOptionPane.WARNING_MESSAGE); // 메시지 타입
            return;
        }
        
        // 업데이트 창에서는 수정 전의 정보를 화면에 출력하기 위해서,
        // 행 번호(=연락처 리스트의 인덱스)를 argument로 전달하면서 ContactUpdateFrame을 생성한다.
        ContactUpdateFrame.newContactUpdateFrame(frame, row, ContactMain05.this);
        //아 여기선 public static void newContactUpdateFrame()메서드를 호출하는 것.
        //생성자는 메서드 호출 후.. 생성...
        
    }

    // ContactCreateFrame.ContactInsertListener 인터페이스의 메서드를 구현.
    @Override
    public void contactInsertNotify(Contact c) {
        // ContactDaoImpl의 메서드를 사용해서 새 연락처 정보를 파일에 저장.
        System.out.println(c);
        int result = dao.create(c);
        
//        Object[] rowData = {
//                c.getName(),
//                c.getPhone(),
//                c.getEmail()
//        };
//        
//        
//        model.addRow(rowData); // 만드는 메서드가 따로 있었다..
        if (result == 1) {
            // 메인 화면의 테이블을 갱신.
            addContactToTableModel(c);
            JOptionPane.showMessageDialog(frame, c.getName()+"이(가) 추가되었습니다.");
        }
        
        
        
        
    }

    @Override // ContactUpdateLister 인터페이스를 구현
    public void contactUpdateNotify() {
        // 테이블 모델 초기화
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        
        // 연락처 데이터 새로 로딩
        loadContactDataFromFile();
        JOptionPane.showMessageDialog(frame, "수정 성공!");
    }

}
