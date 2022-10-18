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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class WordBookTestFrame extends JFrame {

    private WordBookDaoImpl dao;
    
    private JPanel contentPane;
    
    private PaperListener l;
    private JComboBox cbFromMonth;
    private JComboBox cbFromDay;
    private JComboBox cbToMonth;
    private JComboBox cbToDay;
    private JComboBox cbFromYear;
    private JComboBox cbToYear;

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
        dao = WordBookDaoImpl.getInstance();
        this.l = l;
        
        initialize();

    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
        
        cbFromMonth = new JComboBox();
        cbFromMonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
        cbFromMonth.setBounds(182, 21, 58, 23);
        panel_1.add(cbFromMonth);
        
        cbFromDay = new JComboBox();
        cbFromDay.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        cbFromDay.setBounds(296, 21, 66, 23);
        panel_1.add(cbFromDay);
        
        cbToMonth = new JComboBox();
        cbToMonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
        cbToMonth.setBounds(182, 135, 58, 23);
        panel_1.add(cbToMonth);
        
        cbToDay = new JComboBox();
        cbToDay.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        cbToDay.setBounds(296, 135, 59, 23);
        panel_1.add(cbToDay);
        
        
        //String[] year = {"2222", "3333"};
        String[] year = dao.getYear();
        
        cbFromYear = new JComboBox();
        cbFromYear.setModel(new DefaultComboBoxModel(year));
        cbFromYear.setBounds(12, 24, 75, 23);
        panel_1.add(cbFromYear);
        
        cbToYear = new JComboBox();
        cbToYear.setModel(new DefaultComboBoxModel(year));
        cbToYear.setBounds(12, 135, 75, 23);
        panel_1.add(cbToYear);
    }

    protected void start() {
        String fromYear = (String) cbFromYear.getSelectedItem();
        String fromMonth = (String) cbFromMonth.getSelectedItem();
        String fromDay = (String) cbFromDay.getSelectedItem();
        String toYear = (String) cbToYear.getSelectedItem();
        String toMonth = (String) cbToMonth.getSelectedItem();
        String toDay = (String) cbToDay.getSelectedItem();

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
