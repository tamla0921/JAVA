package edu.java.contact.ver06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.ver06.ContactCreateFrame.CreateListener;
import edu.java.contact.ver06.ContactUpdateFrame.UpdateListener;

public class ContactMain implements CreateListener, UpdateListener {
    private static final String[] COLUMN_NAMES = { "번호", "이름", "전화번호" };
    private DefaultTableModel model;
    private DefaultTableModel tableModel;
    private ContactDaoImpl dao;

    private JFrame frame;
    private JTable table;
    private JTextField textSearchKeyword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactMain window = new ContactMain();
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
    public ContactMain() {
        initialize();
        dao = ContactDaoImpl.getInstance();
        initializeTable();
    }

    private void initializeTable() {
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model); // setModel를 해줘야 컬럼들이 보임.
        List<Contact> list = dao.read();
        for (Contact l : list) {
            Object[] rowdata = { l.getCid(), l.getName(), l.getPhone() };
            model.addRow(rowdata);
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 533);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 284, 33);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchContacts();
            }
        });
        btnSearch.setBounds(215, 9, 69, 23);
        panel.add(btnSearch);
        
        textSearchKeyword = new JTextField();
        textSearchKeyword.setBounds(12, 10, 191, 21);
        panel.add(textSearchKeyword);
        textSearchKeyword.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 33, 284, 419);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 452, 284, 45);
        frame.getContentPane().add(panel_1);
        
                JButton btnCreate = new JButton("생성");
                panel_1.add(btnCreate);
                
                        JButton btnUpdate = new JButton("자세히");
                        panel_1.add(btnUpdate);
                        
                                JButton btnDelete = new JButton("삭제");
                                panel_1.add(btnDelete);
                                
                                JButton btnF5 = new JButton("새로고침");
                                btnF5.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        initializeTable();
                                    }
                                });
                                panel_1.add(btnF5);
                                btnDelete.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        delete();
                                    }
                                });
                        btnUpdate.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                update();
                            }
                        });
                btnCreate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        create();

                    }
                });

    }

    protected void searchContacts() {
        String keyword = textSearchKeyword.getText();
        if (keyword.equals("")) {
            JOptionPane.showMessageDialog(frame, "검색 키워드를 먼저 입력.");
             textSearchKeyword.requestFocus();
             return;
        }
        
        List<Contact> list = dao.read(keyword);
        resetTableModel();
        addDataToTableModel(list);
        
    }

    private void addDataToTableModel(List<Contact> list) {
        for (Contact c : list) {
            Object[] rowData = {c.getCid(), c.getName(), c.getPhone()};
            tableModel.addRow(rowData);
        }
        
    }

    private void resetTableModel() {
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(tableModel);
        
    }

    protected void delete() {
        int row = table.getSelectedRow();
        
        if (row == -1) {
            JOptionPane.showMessageDialog(frame, "전화번호를 클릭해 주세요.", "...", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Integer value = (Integer) model.getValueAt(row, 0);
        
        int yes = JOptionPane.showConfirmDialog(frame, "진짜 삭제?", "...", JOptionPane.YES_NO_OPTION);
        
        if (yes == JOptionPane.YES_OPTION) {
        int result = dao.delete(value);
        if (result == 1) {
            JOptionPane.showMessageDialog(frame, "삭제 성공!");
            initializeTable();
        } else {
            JOptionPane.showMessageDialog(frame, "삭제 할 수 없습니다.", "...", JOptionPane.WARNING_MESSAGE);
        }
        }
        
        
    }

    protected void update() {
        int row = table.getSelectedRow();
        
        if (row == -1) {
            JOptionPane.showMessageDialog(frame, "아래 칸에서 전화번호를 입력하세요", "...", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Integer value = (Integer) model.getValueAt(row, 0);

        ContactUpdateFrame.contactUpdate(frame, value, ContactMain.this);

    }

    protected void create() {
        ContactCreateFrame.createContact(frame, ContactMain.this);

    }

    @Override
    public void createNotify() {
        initializeTable();

    }

    @Override
    public void updateNotify() {
        initializeTable();

    }
}
