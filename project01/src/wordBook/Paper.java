package wordBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import static wordBook.WordBook.Entity.*;
import static wordBook.WordBookSql.*;

public class Paper extends JFrame{
    public interface PaperListener {
        void paperNotify(List<String> answerList, List<WordBook> randomList, List<String> ckList);
    }
    private PaperListener address;
    private PaperListener listener;
    private String from;
    private String to;
    private JPanel contentPane;
    private JTextField textQuiz;
    private JTextField textAnswer;

    private WordBookDaoImpl dao;
    private List<WordBook> randomList;
    private int quizNumber = 1;
    private JButton btnNext;

    private List<String> answerList = new ArrayList<>();
    private List<String> ckList = new ArrayList<>();

    /**
     * Launch the application.
     */
    public static void paper(String from, String to, PaperListener l) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                Paper frame = new Paper(from, to, l);
                frame.setVisible(true);

            }
        });
    }

    /**
     * Create the frame.
     */
    public Paper(String from, String to, PaperListener l) {
        dao = WordBookDaoImpl.getInstance();
        this.from = from;
        this.to = to;
        this.listener = l;

        randomList = dao.get10words(from, to);
        System.out.println(randomList);
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 178, 331);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("훈과 음을 입력하세요!");
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(null);

        textQuiz = new JTextField();
        textQuiz.setEditable(false);
        textQuiz.setBounds(18, 5, 116, 157);
        panel_1.add(textQuiz);
        textQuiz.setColumns(10);
        textQuiz.setText(randomList.get(0).getWord());

        textAnswer = new JTextField();
        textAnswer.setBounds(18, 181, 116, 21);
        panel_1.add(textAnswer);
        textAnswer.setColumns(10);

        btnNext = new JButton("→");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gogogo();
            }
        });
        btnNext.setBounds(30, 224, 97, 23);
        panel_1.add(btnNext);
    }

    protected void gogogo() {
        if (quizNumber < randomList.size()) {
            String answer = textAnswer.getText();

            answerList.add(answer);
            System.out.println(answerList);
            quizNumber = changeQuiz(quizNumber);

            textAnswer.setText("");
        } else {
            String answer = textAnswer.getText();
            answerList.add(answer);
            JOptionPane.showMessageDialog(this, "결과를 출력합니다.");
            System.out.println(answerList);
            paperResult();
            dispose();
            
            listener.paperNotify(answerList, randomList, ckList);

            
        }

        if (quizNumber == randomList.size()) {
            btnNext.setText("결과 확인");
        }

    }


    private void paperResult() {
        for (int i = 0; i < answerList.size(); i++) {
            if (answerList.get(i).replace(" ", "")
                    .equals((randomList.get(i).getMeaning() + randomList.get(i).getPronunciation()))) {
                System.out.println("정답입니다!");
                ckList.add("O");
            } else {
                ckList.add("X");
            }
        }
        

    }

    private int changeQuiz(int quizNumber) {
        System.out.println(quizNumber);
        textQuiz.setText(randomList.get(quizNumber).getWord());
        quizNumber += 1;

        return quizNumber;

    }
    
    public void getAddress(PaperListener address) {
        this.address = address;
    }
}


    // TODO: 추출한 랜덤단어리스트와, O,X값 리스트를 메인 창에서 출력하고 싶습니다.
