package wordBook;

import static wordBook.WordBook.Entity.COL_DAY;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.util.Date;

public class WordBookDetailFrame extends JFrame {
    public interface UpdateListener {
        void updateNotify();
    }

    private UpdateListener listener;
    private WordBookDaoImpl dao;

    private JPanel contentPane;
    private JTextField textWord;
    private JTextField textGrade;
    private JTextField textMeaning;
    private JTextField textRadical;

    private Integer value;
    private Component parent;
    private JTextField textPronun;
    private JButton btnDay;

    /**
     * Launch the application.
     */

    public static void showDetail(Component parent, Integer value, UpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                WordBookDetailFrame frame = new WordBookDetailFrame(parent, value, listener);
                frame.setVisible(true);

            }
        });
    }

    /**
     * Create the frame.
     */
    public WordBookDetailFrame(Component parent, Integer value, UpdateListener listener) {
        dao = WordBookDaoImpl.getInstance();
        this.parent = parent;
        this.value = value;
        this.listener = listener;
        initialize();

        datail();
    }

    void initialize() {
        setTitle("한자 자세히 보기");

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        int x = parent.getX();
        int y = parent.getY();

        setBounds(x, y, 260, 330);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textWord = new JTextField();
        textWord.setHorizontalAlignment(SwingConstants.CENTER);
        textWord.setFont(new Font("굴림", Font.BOLD, 99));
        textWord.setEditable(false);
        textWord.setBounds(62, 49, 120, 120);
        contentPane.add(textWord);
        textWord.setColumns(10);

        textGrade = new JTextField();
        textGrade.setHorizontalAlignment(SwingConstants.RIGHT);
        textGrade.setBounds(124, 18, 58, 21);
        contentPane.add(textGrade);
        textGrade.setColumns(10);

        textMeaning = new JTextField();
        textMeaning.setHorizontalAlignment(SwingConstants.CENTER);
        textMeaning.setBounds(62, 179, 120, 21);
        contentPane.add(textMeaning);
        textMeaning.setColumns(10);

        textRadical = new JTextField();
        textRadical.setColumns(10);
        textRadical.setBounds(124, 254, 58, 21);
        contentPane.add(textRadical);

        JButton btnOk = new JButton("√");
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        btnOk.setFont(new Font("굴림", Font.BOLD, 10));
        btnOk.setBounds(191, 250, 41, 31);
        contentPane.add(btnOk);

        JLabel lblRadical = new JLabel("부수: ");
        lblRadical.setBounds(62, 257, 58, 15);
        contentPane.add(lblRadical);

        textPronun = new JTextField();
        textPronun.setHorizontalAlignment(SwingConstants.CENTER);
        textPronun.setColumns(10);
        textPronun.setBounds(62, 210, 120, 21);
        contentPane.add(textPronun);

        JButton btnNext = new JButton("▶");
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shownext();
                
            }
        });
        btnNext.setBounds(193, 88, 51, 59);
        contentPane.add(btnNext);

        JButton btnPrevious = new JButton("◀");
        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPrevious();
            }
        });
        btnPrevious.setBounds(-1, 88, 51, 59);
        contentPane.add(btnPrevious);

        btnDay = new JButton();

        if (dao.days(value) == null) {
            btnDay.setText("날짜 생성");
        } else {
            btnDay.setText(dao.days(value).toString());
        }
        btnDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                birthday();
                btnDay.setText(dao.days(value).toString());
            }
        });
        btnDay.setBounds(-1, 17, 113, 23);
        contentPane.add(btnDay);
    }

    // ---------- 외운 날짜 버튼 ---------- //
    protected void birthday() {
        WordBook wrd = dao.read(value);
        Integer n = wrd.getNo();
        dao.birthday(n);
    }

    // ---------- 자세히 보는 창 ---------- //
    private void datail() {
        WordBook wrd = dao.read(value);

        textGrade.setText(wrd.getGrade().toString());
        textWord.setText(wrd.getWord());
        textMeaning.setText(wrd.getMeaning());
        textPronun.setText(wrd.getPronunciation());
        textRadical.setText(wrd.getRadical());

    }

// ---------- 이전 항목 보기 버튼 ---------- //
    protected void showPrevious() {
        int value2 = value;
        value = dao.previousNo(value);
        WordBook wrd = dao.read(value);

        try {

            textGrade.setText(wrd.getGrade().toString());
            textWord.setText(wrd.getWord());
            textMeaning.setText(wrd.getMeaning());
            textPronun.setText(wrd.getPronunciation());
            textRadical.setText(wrd.getRadical());
            if (dao.days(value) == null) {
                btnDay.setText("날짜 생성");
            } else {
                btnDay.setText(dao.days(value).toString());
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "첫 페이지입니다...");
            value = value2;

        }

    }

// ---------- 다음 항목 보기 버튼 ---------- //
    protected void shownext() {
        int value2 = value;
        value = dao.nextNo(value);
        WordBook wrd = dao.read(value);

        try {

            textGrade.setText(wrd.getGrade().toString());
            textWord.setText(wrd.getWord());
            textMeaning.setText(wrd.getMeaning());
            textPronun.setText(wrd.getPronunciation());
            textRadical.setText(wrd.getRadical());
            if (dao.days(value) == null) {
                btnDay.setText("날짜 생성");
            } else {
                btnDay.setText(dao.days(value).toString());
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "마지막 페이지입니다...");
            value = value2;
        }

    }

// ---------- 수정하기 버튼 ---------- //
    private void update() {
        String w = textWord.getText();
        String r = textRadical.getText();
        String m = textMeaning.getText();
        String p = textPronun.getText();
        Integer g = Integer.parseInt(textGrade.getText());

        // TODO
        WordBook wrd = new WordBook(value, w, r, m, p, g, null);
        System.out.println(wrd);

        int result = dao.update(wrd);

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "수정성공");
            dispose();
            listener.updateNotify();
        } else {
            JOptionPane.showMessageDialog(this, "변경할 수 없습니다.");
        }

    }
}
