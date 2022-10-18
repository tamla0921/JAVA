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

import wordBook.Paper.PaperListener;
import wordBook.WordBookDetailFrame.UpdateListener;
import wordBook.WordBookNewFrame.NewListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.CardLayout;

public class wordMain implements UpdateListener, NewListener, PaperListener {
    private static final String[] COLUMN_NAMES = { "no", "단어", "뜻", "급수", "배운 날짜" };
    private static final String[] COLUMN_NAMES2 = { "no", "한자", "뜻", "O/X" };
    private DefaultTableModel model;

    private WordBookDaoImpl dao;

    private JFrame frame;
    private JTable table;
    private JTextField textSearch;
    private JComboBox sadari;
    private JButton btnNew;
    private JButton btnDetail;
    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnTest;

    private List<WordBook> randomList;
    private List<String> ckList;
    private List<String> answerList;
    private JPanel card;
    private JComboBox comboBox;
    private JButton btnReset;

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

        btnDetail = new JButton("자세히 보기");
        btnDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetail();
            }
        });

        btnNew = new JButton("한자 추가");
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNew();
            }
        });
        panel.add(btnNew);
        panel.add(btnDetail);

        btnDelete = new JButton("삭제하기");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });
        panel.add(btnDelete);

        sadari = new JComboBox<>();
        sadari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            

            }
        });
        String[] comboBoxItems = { "단어", "음", "훈", "부수", "급수" };
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(comboBoxItems);
        sadari.setModel(comboBoxModel);
        sadari.setSelectedIndex(0);
        panel.add(sadari);

        card = new JPanel();
        panel.add(card);
        card.setLayout(new CardLayout(0, 0));

        textSearch = new JTextField();
        card.add(textSearch, "name_1655138942184100");
        textSearch.setColumns(10);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
        card.add(comboBox, "name_1655153711218500");

        btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                searchWordByKeyword();
                
            }
        });
        panel.add(btnSearch);

        btnTest = new JButton("TEST!!");
        btnTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearTable();

            }
        });
        panel.add(btnTest);

        btnReset = new JButton("초기화");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                initializeTable();
            }
        });
        panel.add(btnReset);

        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);
    }

    protected void clearTable() {
        model = new DefaultTableModel();
        table.setModel(model);
        hidebuttons();
        WordBookTestFrame.testFrame(this);

    }

    private void hidebuttons() {
        btnNew.setEnabled(false);
        btnDelete.setEnabled(false);
        btnDetail.setEnabled(false);
        btnSearch.setEnabled(false);
        btnTest.setEnabled(false);
        sadari.setEnabled(false);
        textSearch.setEnabled(false);
        btnReset.setEnabled(false);

    }

    private void reopenButtons() {
        btnNew.setEnabled(true);
        btnDelete.setEnabled(true);
        btnDetail.setEnabled(true);
        btnSearch.setEnabled(true);
        btnTest.setEnabled(true);
        sadari.setEnabled(true);
        textSearch.setEnabled(true);
        btnReset.setEnabled(true);
    }

    // 테이블 새로고침
    private void initializeTable() {
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);

        List<WordBook> list = dao.read();

        for (WordBook w : list) {
            Object[] rowData = { w.getNo(), w.getWord(), w.getMeaning() + " " + w.getPronunciation(), w.getGrade(),
                    w.getDay() };
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
            Object[] row = { w.getNo(), w.getWord(), w.getMeaning() + " " + w.getPronunciation(), w.getGrade() };
            model.addRow(row);
        }

    }

    // 단어 삭제
    protected void delete() {
        int result = 0;
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(frame, "한자를 클릭해주세요!!");
            return;
        }

        Integer value = (Integer) model.getValueAt(row, 0);
        int choice = JOptionPane.showConfirmDialog(frame, "진짜 삭제할까요?", "경고!!", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {

            result = dao.delete(value);
        } else {
            return;
        }

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

    @Override
    public void paperNotify(List<String> answerList, List<WordBook> randomList, List<String> ckList) {
        this.answerList = answerList;
        this.randomList = randomList;
        this.ckList = ckList;
        reopenButtons();
        model = new DefaultTableModel(null, COLUMN_NAMES2);

        for (int i = 0; i < randomList.size(); i++) {
            if (answerList.get(i).replace(" ", "")
                    .equals((randomList.get(i).getMeaning() + randomList.get(i).getPronunciation()))) {
                System.out.println("정답입니다!");
                ckList.add("O");
            } else {
                ckList.add("X");
            }

        }

        for (int i = 0; i < randomList.size(); i++) {
            Object[] rowdata = { randomList.get(i).getNo(), randomList.get(i).getWord(),
                    randomList.get(i).getMeaning() + " " + randomList.get(i).getPronunciation(), ckList.get(i) };
            model.addRow(rowdata);

        }

        table.setModel(model);

    }

    @Override
    public void paperNotify() {
        reopenButtons();
        initializeTable();

    }

}
