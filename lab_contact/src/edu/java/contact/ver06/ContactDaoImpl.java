package edu.java.contact.ver06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleDriver;


import static edu.java.contact.ver06.Contact.Entity.*;
import static edu.java.contact.ver06.OracleConnection.*;
import static edu.java.contact.ver06.ContactSql.*;

public class ContactDaoImpl implements ContactDao {

    // Singleton
    private static ContactDaoImpl instance = null;

    private ContactDaoImpl() {
    }

    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }

        return instance;
    }

    @Override
    public List<Contact> read() {
        List<Contact> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_READ_ALL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer cid = rs.getInt(COL_CID);
                String name = rs.getString(COL_NAME);
                String phone = rs.getString(COL_PHONE);
                String email = rs.getString(COL_EMAIL);

                Contact contact = new Contact(cid, name, phone, email);
                list.add(contact);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Contact read(Integer cid) {
        Contact contact = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_READ_BY_CID);
            stmt.setInt(1, cid);

            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer id = rs.getInt(COL_CID);
                String title = rs.getString(COL_NAME);
                String phone = rs.getString(COL_PHONE);
                String email = rs.getString(COL_EMAIL);

                contact = new Contact(id, title, phone, email);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return contact;
    }

    @Override
    public int create(Contact contact) {
        int result = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_CREATE);

            stmt.setString(1, contact.getName()); // Ui를 만들지 않더라도, contact 객체가 파라미터로 있으니, contact의 메서드도 사용할 수 있음...
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public int update(Contact contact) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            stmt.setInt(4, contact.getCid());
            
            result = stmt.executeUpdate();
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return result;
    }

    @Override
    public int delete(Integer cid) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_DELETE);
            
            stmt.setInt(1, cid);
            
            result = stmt.executeUpdate();
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return result;
    }

    @Override
    public List<Contact> read(String keyword) {
        List<Contact> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_SELECT_BY_KEYWORD);
            stmt.setString(1, "%" + keyword.toLowerCase() + "%");
            stmt.setString(2, "%" + keyword.toLowerCase() + "%");
            stmt.setString(3, "%" + keyword.toLowerCase() + "%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Integer cid = rs.getInt(COL_CID);
                String name = rs.getString(COL_NAME);
                String phone = rs.getString(COL_PHONE);
                String email = rs.getString(COL_EMAIL);
                
                Contact contact = new Contact(cid, name, phone, email);
                list.add(contact);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return list;
    }

}
