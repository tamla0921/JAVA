package edu.java.contact.ver03;

import java.util.ArrayList;
import java.util.List;

import edu.java.contact.ver02.Contact;

// 클래스 시작
public class ContactDaoImpl implements ContactDao{
    
    // 연락처 정보를 저장할 List 
    ArrayList<Contact> contactList = new ArrayList<>();
    
    // 싱글톤
    private static ContactDaoImpl instance = null; // static이기 때문에 프로그램이 실행되면 메서드 영역에 instance 변수 저장.
    private ContactDaoImpl() {}
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl(); // 생성자 호출... null이 아니게 됨.
        }
        return instance;
    }

    @Override
    public List<Contact> read() {
        return contactList;
    }

    @Override
    public Contact read(int index) {
        try {
        return contactList.get(index); 
    } catch (IndexOutOfBoundsException e) {
        return null;
    }
    }
    
    
    // if (isValidIndex(index)) {
            //return null;
    // }
            // return contacts.get(index);
            //}
        

    @Override
    public int create(Contact contact) {
        contactList.add(contact);
        
        return 1;
    }

    @Override
    public int update(int index, Contact contact) {
        //contactList.remove(index);
        //contactList.add(index, contact);
        
        contactList.set(index, contact);
        return 1;
    }
        
        
//        if (!isValidIndex(index)) {
//            // valid index: index >= 0 && index < size
//            // not valid:
//            return 0;
//        }
//    
//        Contact c = contactList.get(index);
    // 생성자를 메인에서 만들지 말고, 여기서 파라미터로 가져 온 Contact타입에서 get으로 리턴 값 불러와서 set해도 됨.
//        before.setName(contact.getName());
//        before.setPhone(contact.getPhone());
//        before.setEmailcontact.getEmail));
//        
//        return 1;
    

    @Override
    public int delete(int index) {
        
//        if (contactList.remove(index) != null) {;
//        return 1;
//        }
//        return 0;
//    }
        if (!isValidIndex(index)) {
            return 0;
        }
        
        contactList.remove(index);
        return 1;
        
    }
        
    
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < contactList.size());
    }

    
} // 클래스 끝
