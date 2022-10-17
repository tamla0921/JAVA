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

public class Paper extends JFrame {
    private String from;
    private String to;
    private JPanel contentPane;
    private JTextField textQuiz;
    private JTextField textAnswer;
    
    private WordBookDaoImpl dao;
    private List<WordBook> list;
    private int quizNumber = 1;

    /**
     * Launch the application.
     */
    public static void paper(String from, String to) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                Paper frame = new Paper(from, to);
                frame.setVisible(true);

            }
        });
    }

    /**
     * Create the frame.
     */
    public Paper(String from, String to) {
        dao = WordBookDaoImpl.getInstance();
        this.from = from;
        this.to = to;
        
        list = dao.get10words(from, to);
        System.out.println(list);
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
        textQuiz.setText(list.get(0).getWord());
        
        textAnswer = new JTextField();
        textAnswer.setBounds(18, 181, 116, 21);
        panel_1.add(textAnswer);
        textAnswer.setColumns(10);
        
        JButton btnNext = new JButton("→");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gogogo();
            }
        });
        btnNext.setBounds(30, 224, 97, 23);
        panel_1.add(btnNext);
    }

    protected void gogogo() {
        
        if (quizNumber < list.size()) {
        String answer = textAnswer.getText();
        List<String> answerList = new ArrayList<>();
        answerList.add(answer);
        
        quizNumber= changeQuiz(quizNumber);
        
        textAnswer.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "끝!!");
            return;
        }
    
    }

    private int changeQuiz(int quizNumber) {
        System.out.println(quizNumber);
        textQuiz.setText(list.get(quizNumber).getWord());
        quizNumber += 1;
        return quizNumber;
        
    
        
    }

}
