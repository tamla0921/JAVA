package wordBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import wordBook.WordBookDetailFrame.UpdateListener;
import wordBook.WordBookNewFrame.NewListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class wordMain implements UpdateListener, NewListener {
    private static final String[] COLUMN_NAMES = { "no", "단어", "뜻", "급수", "배운 날짜" };
    private DefaultTableModel model;

    private WordBookDaoImpl dao;

    private JFrame frame;
    private JTable table;
    private JTextField textSearch;
    private JComboBox sadari;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    wordMain window = new wordMain();
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
    public wordMain() {
        initialize();
        dao = WordBookDaoImpl.getInstance();
        initializeTable();
    }

// 메서드  ------------------------------------------------------------------------------- //    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 842, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JButton btnNewButton = new JButton("자세히 보기");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetail();
            }
        });

        JButton btnNew = new JButton("한자 추가");
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNew();
            }
        });
        panel.add(btnNew);
        panel.add(btnNewButton);

        JButton btnDelete = new JButton("ㅠㅠ");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });
        panel.add(btnDelete);

        sadari = new JComboBox<>();
        String[] comboBoxItems = { "단어", "음", "훈", "부수", "급수" };
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(comboBoxItems);
        sadari.setModel(comboBoxModel);
        sadari.setSelectedIndex(0);
        panel.add(sadari);

        textSearch = new JTextField();
        panel.add(textSearch);
        textSearch.setColumns(10);

        JButton btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchWordByKeyword();
            }
        });
        panel.add(btnSearch);

        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);
    }

    

    // 테이블 새로고침
    private void initializeTable() {
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);

        List<WordBook> list = dao.read();

        for (WordBook w : list) {
            Object[] rowData = { w.getNo(), w.getWord(), w.getMeaning() + " " + w.getPronunciation(), w.getGrade(), w.getDay() };
            model.addRow(rowData);
        }
    }
// 데이터 변경 메서드 모음
    
    // TODO 단어 검색
    protected void searchWordByKeyword() {
        String keyword = textSearch.getText();
        if (keyword.equals("")) {
            JOptionPane.showMessageDialog(frame, "검색어 입력...");
            textSearch.requestFocus();

            return;
        }

        int type = sadari.getSelectedIndex();
        System.out.println("type = " + type + ", keyword = " + keyword);

        List<WordBook> list = dao.read(type, keyword);

        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        
    
        for (WordBook w : list) {
            Object[] row = {w.getNo(), w.getWord(), w.getMeaning(), w.getGrade()};
            model.addRow(row);
        }
    }
    
    
    // 단어 삭제
    protected void delete() {
        int row = table.getSelectedRow();
        
        if (row == -1) {
            JOptionPane.showMessageDialog(frame, "한자를 클릭해주세요!!");
            return;
        }
        
        Integer value = (Integer) model.getValueAt(row, 0);

        int result = dao.delete(value);

        if (result == 1) {
            JOptionPane.showMessageDialog(frame, "삭제완료");
            initializeTable();
        } else {
            JOptionPane.showMessageDialog(frame, "불가...");
        }

    }

    // 단어 추가
    protected void showNew() {
        WordBookNewFrame.showNew(frame, wordMain.this);

    }

    // 단어 자세히 보기
    private void showDetail() {
        int row = table.getSelectedRow();
        
        if (row == -1) {
            JOptionPane.showMessageDialog(frame, "한자를 클릭해주세요!!");
            return;
        }
        
        Integer value = (Integer) model.getValueAt(row, 0);
        WordBookDetailFrame.showDetail(frame, value, wordMain.this);

    }

    // 단어 변경 완료
    @Override
    public void updateNotify() {
        initializeTable();

    }

    // 단어 추가 완료
    @Override
    public void newNorify() {
        initializeTable();

    }

}
