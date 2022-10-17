package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class BlogUpdateFrame extends JFrame {

    public interface OnBlogUpdateListener {
        void onBlogUpdated();
    }

    private OnBlogUpdateListener listener;

    private JPanel contentPane;
    private JTextField textBlogNo;
    private JTextField textTitle;

    private Component parent;

    private Integer blogNo;
    private JTextArea textContent;
    private BlogDaoImpl dao;
    private JTextField textAuthor;
    private JTextField textCreatedDate;
    private JTextField textmodifiedDate;

    /**
     * Launch the application.
     */
    public static void newBlogUpdateFrame(Component parent, Integer blogNo, OnBlogUpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                BlogUpdateFrame frame = new BlogUpdateFrame(parent, blogNo, listener);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */
    public BlogUpdateFrame(Component parent, Integer blogNo, OnBlogUpdateListener listener) {
        this.dao = BlogDaoImpl.getInstance();
        this.parent = parent; // 부모 컴포넌트 객체 저장.
        this.blogNo = blogNo; // 상세보기/수정할 블로그 글 번호.
        this.listener = listener; // 블로그 글 업데이트 결과를 통지할 수 있는 메서드를 가지고 있는 객체.
        initialize(); // UI 컴포넌트 생성, 초기화.

        initializeBlogData(); // JTextField, JTextArea의 내용을 DB에서 검색한 내용으로 채움.
    }

    private void initializeBlogData() {
        Blog blog = dao.select(blogNo);
        if (blog != null) {
            textBlogNo.setText(blog.getBlogNo().toString()); // toString 무조건 붙이기!!
            textTitle.setText(blog.getTitle()); // BlogNo는 Integer타입이기 때문에 toString()을 붙여야 했음.
            
            textContent.setText(blog.getContent());
            textAuthor.setText(blog.getAuthor());
            textCreatedDate.setText(blog.getCreatedDate().toString());
            textmodifiedDate.setText(blog.getModifiedDate().toString());

        }

    }

    public void initialize() {
        setTitle("블로그 상세 보기");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int x = parent.getX();
        int y = parent.getY();

        setBounds(x, y, 431, 620);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblBlogNo = new JLabel("번호");
        lblBlogNo.setBounds(12, 10, 57, 15);
        contentPane.add(lblBlogNo);

        JLabel lblTitle = new JLabel("제목");
        lblTitle.setBounds(12, 35, 57, 15);
        contentPane.add(lblTitle);

        textBlogNo = new JTextField();
//        textBlogNo.setText(blogNo.toString()); // 글 번호 보여주기
        textBlogNo.setEditable(false);
        textBlogNo.setBounds(81, 7, 322, 21);
        contentPane.add(textBlogNo);
        textBlogNo.setColumns(10);

        textTitle = new JTextField();
        textTitle.setColumns(10);
        textTitle.setBounds(81, 32, 322, 21);
        contentPane.add(textTitle);

        JButton btnUpdate = new JButton("수정");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBlog();
            }
        });
        btnUpdate.setBounds(159, 548, 97, 23);
        contentPane.add(btnUpdate);

        JLabel lblAuthor = new JLabel("작성자");
        lblAuthor.setBounds(12, 59, 57, 15);
        contentPane.add(lblAuthor);

        textAuthor = new JTextField();
        textAuthor.setEditable(false);
        textAuthor.setColumns(10);
        textAuthor.setBounds(81, 56, 322, 21);
        contentPane.add(textAuthor);

        JLabel lblCreatedDate = new JLabel("작성 시간");
        lblCreatedDate.setBounds(12, 90, 57, 15);
        contentPane.add(lblCreatedDate);

        textCreatedDate = new JTextField();
        textCreatedDate.setEditable(false);
        textCreatedDate.setColumns(10);
        textCreatedDate.setBounds(81, 87, 129, 21);
        contentPane.add(textCreatedDate);

        JLabel lblModifiedDate = new JLabel("수정 시간");
        lblModifiedDate.setBounds(217, 90, 57, 15);
        contentPane.add(lblModifiedDate);

        textmodifiedDate = new JTextField();
        textmodifiedDate.setEditable(false);
        textmodifiedDate.setColumns(10);
        textmodifiedDate.setBounds(274, 87, 129, 21);
        contentPane.add(textmodifiedDate);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 127, 391, 398);
        contentPane.add(scrollPane);

        textContent = new JTextArea();
        scrollPane.setViewportView(textContent);

    }

    private void updateBlog() {
        String title = textTitle.getText();
        String content = textContent.getText();
        
        if (title.equals("") || content.equals("")) {
            JOptionPane.showMessageDialog(this, 
                    "빈 칸은 입력할 수 없습니다.",
                    "진행 불가",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Blog blog = new Blog(blogNo, title, content, null, null, null); // blogNo는 nullable이 아님.
        
        int result = dao.update(blog);
        
        
        
        // BlogMainㅇ게 업데이트 성공을 알려줌.
        if (result == 1) {
            JOptionPane.showMessageDialog(this, blogNo + "번 블로그 업데이트 성공");
            // DetailFrame은 닫음.
            dispose();
            // BlogMain에게 업데이트 성공을 알려줌.
            listener.onBlogUpdated();
        } else {
            JOptionPane.showMessageDialog(this, blogNo + "번 블로그 업데이트 실패");
        }

    }
}
