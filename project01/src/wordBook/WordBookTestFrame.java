package wordBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import wordBook.Paper.PaperListener;

import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class WordBookTestFrame extends JFrame {

    private WordBookDaoImpl dao;
    
    private JPanel contentPane;
    private JTextField textFromYear;
    private JTextField textFromMonth;
    private JTextField textFromDay;
    private JTextField textToYear;
    private JTextField textToMonth;
    private JTextField textToDay;
    
    private PaperListener l;

    /**
     * Launch the application.
     */
    public static void testFrame(PaperListener l) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                WordBookTestFrame frame = new WordBookTestFrame(l);
                frame.setVisible(true);

            }
        });
    }

    /**
     * Create the frame.
     */
    public WordBookTestFrame(PaperListener l) {
        this.l = l;
        
        initialize();

    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lbl1 = new JLabel("날짜를 입력해주세요.");
        panel.add(lbl1);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(null);

        textFromYear = new JTextField();
        textFromYear.setBounds(12, 22, 86, 21);
        panel_1.add(textFromYear);
        textFromYear.setColumns(10);

        textFromMonth = new JTextField();
        textFromMonth.setColumns(10);
        textFromMonth.setBounds(165, 22, 86, 21);
        panel_1.add(textFromMonth);

        textFromDay = new JTextField();
        textFromDay.setColumns(10);
        textFromDay.setBounds(276, 22, 86, 21);
        panel_1.add(textFromDay);

        textToYear = new JTextField();
        textToYear.setColumns(10);
        textToYear.setBounds(12, 136, 86, 21);
        panel_1.add(textToYear);

        textToMonth = new JTextField();
        textToMonth.setColumns(10);
        textToMonth.setBounds(165, 136, 86, 21);
        panel_1.add(textToMonth);

        textToDay = new JTextField();
        textToDay.setColumns(10);
        textToDay.setBounds(276, 136, 86, 21);
        panel_1.add(textToDay);

        JLabel lblNewLabel = new JLabel("년");
        lblNewLabel.setBounds(99, 28, 57, 15);
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("년");
        lblNewLabel_1.setBounds(99, 139, 57, 15);
        panel_1.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("월");
        lblNewLabel_1_1.setBounds(252, 28, 57, 15);
        panel_1.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("월");
        lblNewLabel_1_1_1.setBounds(252, 142, 57, 15);
        panel_1.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("일");
        lblNewLabel_1_1_1_1.setBounds(367, 28, 57, 15);
        panel_1.add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("일");
        lblNewLabel_1_1_1_1_1.setBounds(367, 142, 57, 15);
        panel_1.add(lblNewLabel_1_1_1_1_1);

        JLabel lblNewLabel_2 = new JLabel("~");
        lblNewLabel_2.setBounds(182, 79, 57, 15);
        panel_1.add(lblNewLabel_2);

        JButton btnStart = new JButton("시작!");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        btnStart.setBounds(315, 193, 97, 23);
        panel_1.add(btnStart);
    }

    protected void start() {
        String fromYear = textFromYear.getText();
        String fromMonth = textFromMonth.getText();
        String fromDay = textFromDay.getText();
        String toYear = textToYear.getText();
        String toMonth = textToMonth.getText();
        String toDay = textToDay.getText();

        if (fromYear.equals("") || fromMonth.equals("") || fromDay.equals("") || toYear.equals("") || toMonth.equals("")
                || toDay.equals("")) {
            JOptionPane.showMessageDialog(this, "빈 칸은 입력할 수 없습니다.");
            return;
        }

        String from = String.format(fromYear + "/" + fromMonth + "/" + fromDay);
        String to = String.format(toYear + "/" + toMonth + "/" + toDay);

        Paper.paper(from, to, l);
        
        dispose();

        System.out.println("dd: " + from);
        System.out.println("ee: " + to);

    }

}
