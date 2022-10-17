package edu.java.ojdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;
import edu.java.ojdbc.view.BlogCreateFrame.BlogCreateListener;
import edu.java.ojdbc.view.BlogUpdateFrame.OnBlogUpdateListener;

import static edu.java.ojdbc.controller.JdbcSql.*;

import static edu.java.ojdbc.model.Blog.Entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class BlogMain implements BlogCreateListener, OnBlogUpdateListener {
    // 메인 화면에서 보여줄 JTable의 컬럼 이름들
    private static final String[] COLUMN_NAMES = { COL_BLOG_NO, COL_TITLE, COL_AUTHOR, COL_MODIFIED_DATE };

    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;

    private BlogDaoImpl dao;
    private JComboBox<String> sadari;
    private JTextField textKeyword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogMain window = new BlogMain();
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
    public BlogMain() {
        initialize(); // UI 컴포넌트 생성, 초기화
        dao = BlogDaoImpl.getInstance();
        initializeTable(); // 메인 화면에서의 JTable 데이터 초기화
    }

    private void initializeTable() {
        // 데이터는 없는, 컬럼 이름들만 설정된 테이블 모델 객체를 생성. -> 데이터 초기화.
        model = new DefaultTableModel(null, COLUMN_NAMES);

        // 테이블에 모듈 객체를 설정.
        table.setModel(model);

        // DB에서 데이터를 검색.
        List<Blog> list = dao.select();
        for (Blog b : list) {
            Object[] row = { b.getBlogNo(), b.getTitle(), b.getAuthor(), b.getModifiedDate() };
            model.addRow(row); // 테이블 모델에 행(row) 데이터로 추가.
        }

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.setBounds(600, 300, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("블로그");

        JPanel buttnPanel = new JPanel();
        frame.getContentPane().add(buttnPanel, BorderLayout.NORTH);

        JButton btnCreate = new JButton("새 글 작성");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 새 블로그 글 작성 Frame 만들기.
                BlogCreateFrame.newBlogCreateFrame(frame, BlogMain.this);
                // this: this가 속한 클래스의 객체, 주솟값을 말함
                // --> 익명 클래스임. 만약 BlogMain.this라고만 적을 시, 이 this는 익명 클래스의 주소를 말함.
                // --> 따라서 메인 클래스의 주소를 적고 싶다면 BlogMain.this를 작성해야 함.
            }
        });

        JButton btnReadAll = new JButton("새로 고침");
        btnReadAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeTable();
            }

        });
        btnReadAll.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        buttnPanel.add(btnReadAll);
        btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        buttnPanel.add(btnCreate);

        JButton btnRead = new JButton("상세보기");
        btnRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetailFrame();
            }
        });
        btnRead.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        buttnPanel.add(btnRead);

        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteTitle();
            }
        });
        btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        buttnPanel.add(btnDelete);

        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        scrollPane.setViewportView(table);

        JPanel searchPanel = new JPanel();
        frame.getContentPane().add(searchPanel, BorderLayout.SOUTH);

        sadari = new JComboBox<>();
        String[] comboBoxItems = { "제목", "내용", "제목 + 내용", "작성자" };
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(comboBoxItems);
        sadari.setModel(comboBoxModel);
        sadari.setSelectedIndex(2);
        searchPanel.add(sadari);

        textKeyword = new JTextField();
        searchPanel.add(textKeyword);
        textKeyword.setColumns(10);

        JButton btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBlogsByKeyword();
            }
        });
        searchPanel.add(btnSearch);
    }

    private void searchBlogsByKeyword() {
        String keyword = textKeyword.getText();
        if (keyword.equals("")) { // 검색어 JTextField가 비어 있으면
            JOptionPane.showMessageDialog(frame, // parentComponent
                    "검색어를 입력하세요.", // message
                    "진행 불가", // title
                    JOptionPane.WARNING_MESSAGE); // messageType
            return;
        }
        
        int type = sadari.getSelectedIndex();
        System.out.println("type = " + type + ", keyword = " + keyword);
        
        // TODO: DAO에 검색 타입과 검색어를 argument를 갖는 검색 메서드 호출.
        List<Blog> list = dao.select(type, keyword);
        
        
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        
        for (Blog b : list) {
            Object[] row = {b.getBlogNo(), b.getTitle(), b.getAuthor(), b.getModifiedDate()};
            model.addRow(row); }
    }

    private void showDetailFrame() {
        int row = table.getSelectedRow();
        System.out.println(row);

        if (row == -1) {
            JOptionPane.showMessageDialog(frame, // parentComponent
                    "행을 클릭 해 주세요.", // message
                    "진행 불가", // title
                    JOptionPane.ERROR_MESSAGE); // messageType
            return;
        }

        Integer blogNo = (Integer) model.getValueAt(row, 0);

        BlogUpdateFrame.newBlogUpdateFrame(frame, blogNo, BlogMain.this); // 여기서는 BlogMain.this = this

    }

    protected void deleteTitle() {
        int blogNo = table.getSelectedRow(); // 테이블에서 선택된 행 인덱스
        if (blogNo == -1) { // JTable에서 선택된 행이 없는 경우,
            JOptionPane.showMessageDialog(frame, // parentComponent
                    "아래의 항목에서 삭제할 전화번호를 선택하세요", // message
                    "오류", // title
                    JOptionPane.WARNING_MESSAGE); // messageType
            return; // 메서드 종료.
        }

        // 선택된 행에서 인덱스 0번 컬럼의 값(BLOG_NO)을 읽음.

        Integer value = (Integer) model.getValueAt(blogNo, 0);
        System.out.println("blogNo = " + value);

        int confirm = JOptionPane.showConfirmDialog(frame, // parentComponent
                "정말 삭제하시겠습니까?", // message
                "확인!", // title
                JOptionPane.YES_NO_OPTION); // 확인 버튼 종류

        if (confirm == JOptionPane.YES_OPTION) {
            // Dao 객체의 delete 메서드를 사용해서 DB에서 삭제.
            int result = dao.delete(value);
            if (result == 1) {
                JOptionPane.showMessageDialog(frame, value + "번 글 삭제되었습니다.");
                initializeTable(); // 테이블 갱신
            } else {
                JOptionPane.showMessageDialog(frame, "블로그 글 삭제 실패", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    @Override // BlogCreateFrame.OnBlogInsertListener 인터페이스의 메서드 구현.
    public void blogcreatenotify() {
        initializeTable();

    }

    @Override // BlogUpdateFrame.OnBlogUpdateListener 인터페이스 메서드 구현.
    public void onBlogUpdated() {
        initializeTable();

    }

}
