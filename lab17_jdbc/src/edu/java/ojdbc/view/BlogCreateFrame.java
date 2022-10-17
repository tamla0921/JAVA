package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.Content;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BlogCreateFrame extends JFrame {
    public interface BlogCreateListener{
        void blogcreatenotify();
    }

    private BlogDaoImpl dao; // DB 테이블 insert 기능을 가지고 있는 객체.
    private BlogCreateListener listener;

    private JPanel contentPane;
    private JTextField textTitle;
    private JTextField textAuthor;
    private JScrollPane scrollPane;
    private JLabel lblContent;
    private JTextArea textContent;

    private Component parent;

    /**
     * Launch the application.
     */
    public static void newBlogCreateFrame(Component parent, BlogCreateListener listener ) {
        // BlogCreateListener대신 BlogMain main을 작성하도 된다면, 만약 BlogCreateFrame을 사용하는 다른 클래스가 있다면, 또 중복되서 작성해야 함.
        // 그렇기 때문에 중복을 막기 위해 BlogCreateListener라는 인터페이스를 만들어 공통의 부모, 다형성 형성.
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                BlogCreateFrame frame = new BlogCreateFrame(parent, listener);
                // static 메서드에 생성자 호출 --> 멤버들에 static을 적지 않아도 static 처럼 사용할 수 있게 된다.
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */
    public BlogCreateFrame(Component parent, BlogCreateListener listener) {
        this.parent = parent;
        this.listener = listener;
        this.dao = BlogDaoImpl.getInstance();
        initialize(); // UI 컴포넌트들(JLabel, JTextField, JTextArea, ...)이 생성, 초기화.
    }

    public void initialize() {
        setTitle("새 블로그 글 작성"); // JFrame의 타이틀

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // JFrame의 닫기 버튼 동작 - 현재 창 닫기.

        int x = parent.getX(); // 부모 창의 x 좌표
        int y = parent.getY(); // 부모 창의 y 좌표

        setBounds(x, y, 336, 503);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("제목");
        lblTitle.setBounds(12, 29, 57, 15);
        contentPane.add(lblTitle);

        JLabel lblAuthor = new JLabel("글쓴이");
        lblAuthor.setBounds(12, 61, 57, 15);
        contentPane.add(lblAuthor);

        textTitle = new JTextField();
        textTitle.setBounds(81, 26, 227, 21);
        contentPane.add(textTitle);
        textTitle.setColumns(10);

        textAuthor = new JTextField();
        textAuthor.setColumns(10);
        textAuthor.setBounds(81, 58, 227, 21);
        contentPane.add(textAuthor);

        JButton btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewBlogPost(); // 메서드를 만드는 방법 중 하나: 보기 편하기 위해..
            }
        });
        btnSave.setBounds(211, 441, 97, 23);
        contentPane.add(btnSave);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 86, 296, 349);
        contentPane.add(scrollPane);

        textContent = new JTextArea();
        scrollPane.setViewportView(textContent);

        lblContent = new JLabel("내용을 작성하세요.");
        lblContent.setBounds(12, 445, 187, 15);
        contentPane.add(lblContent);
    }

    private void createNewBlogPost() {
        // 제목, 내용, 작성자 정보 읽음.

        String title = textTitle.getText();
        String author = textAuthor.getText();
        String content = textContent.getText();

//        dao = BlogDaoImpl.getInstance(); -- 생성자에서 초기화하기. --> 한 번 작성으로 여러 곳에서 사용할 수 있음.
        if (title.equals("") || content.equals("") || author.equals("")) {
            JOptionPane.showMessageDialog(this, // parentComponent -> BlogCreateFrame의 인스턴스 주소.
                    "빈 칸을 작성하세요.", // parentComponent
                    "에러", // title
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 제목, 내용, 작성자 -> Blog 객체 생성
        Blog blog = new Blog(null, title, content, author, null, null); // 아~ 알 수 없는 것은 null로 주면 됨. 왜냐하면 번호, 날짜는
                                                                        // nullable이기 때문이다.

        // dao의 insert 메서드를 호출 -> DB에 저장
        int result = dao.insert(blog);

        if (result == 1) { // insert 성공
            JOptionPane.showMessageDialog(this, "새 블로그 글을 작성하였습니다.");
            dispose(); // 현재 창 닫기
            listener.blogcreatenotify();
            
            
            /*
             * Blog main = new BlogMain();
             * main.initializeTable(); // 메서드를 public으로 바꾸고..
             * 
             * 이거는 메인 창 업데이트가 안 됨!
             * 왜냐하면 BlogCreateFrame 창이 새로 메인 창을 만든다는 의미가 되기 때문이다.
             */

        } else { // insert 실패
            JOptionPane.showMessageDialog(this, "작성할 수 없습니다.", "에러", JOptionPane.ERROR_MESSAGE);
        }
    }

}
