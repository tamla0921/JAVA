package edu.java.contact.ver04;

import java.util.List;
import java.util.Scanner;

import edu.java.contact.menu.MainMenu;

// MVC 아키텍쳐에서 View에 해당하는 클래스. UI(User Interface).
public class ContactMain04 {
    private Scanner scanner = new Scanner(System.in);
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();

    public static void main(String[] args) {
        System.out.println("***** 연락처 프로그램 Version 0.4 *****");
        
        ContactMain04 app = new ContactMain04();
        
        boolean run = true;
        
        while (run) {
            try {
                int n = app.chooseMenu();
                MainMenu menu = MainMenu.getValue(n);
                
                switch (menu) {
                case QUIT:
                    run = false;
                    break;
                    
                case SELECT_ALL:
                    app.selectAllContacts();
                    break;
                    
                case SELECT_BY_INDEX:
                    app.selectContactByIndex();
                    break;
                    
                case CREATE:
                    app.insertNewContact();
                    break;
                    
                case UPDATE:
                    app.updateContact();
                    break;
                    
                case DELETE:
                    app.deleteContact();
                    break;
                    
                default:
                    System.out.println("지원하지 않는 메뉴입니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }

    } // 메인 닫음

    private void deleteContact() {
        System.out.println("----- 연락처 삭제 -----");
        System.out.println("삭제할 인덱스>>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        int result = dao.delete(index);
        
        if (result == 1) {
            System.out.println("연락처 삭제 성공!");
        } else {
            System.out.println("연락처 삭제 실패...");
        }
        
    }

    private void updateContact() {
        System.out.println("----- 연락처 수정 -----");
        System.out.println("수정할 인덱스>>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        System.out.println("수정할 이름: ");
        String name = scanner.nextLine();
        
        System.out.println("수정할 번호: ");
        String number = scanner.nextLine();
        
        System.out.println("수정할 이메일: ");
        String email = scanner.nextLine();
        
        Contact contact = new Contact(name, number, email);
        int result = dao.update(index, contact);
        
        if (result == 1) {
            System.out.println("연락처 수정 성공!");
        } else {
            System.out.println("연락처 수정 실패..");
        }
        
    }

    private void insertNewContact() {
        System.out.println("----- 연락처 저장 -----");
        System.out.println("이름 입력: ");
        String name = scanner.nextLine();
        
        System.out.println("번호 입력: ");
        String phone = scanner.nextLine();
        
        System.out.println("이메일 입력: ");
        String email = scanner.nextLine();
        
        Contact contact = new Contact(name, phone, email);
        
        int result = dao.create(contact);
        
        if (result == 1) {
            System.out.println("연락처 저장 성공!");
        } else {
            System.out.println("연락처 저장 실패..");
        }
    }

    private void selectContactByIndex() {
        System.out.println("----- 연락처 수정 -----");
        System.out.println("수정할 인덱스>>> ");
        int n = Integer.parseInt(scanner.nextLine());
        // int result = dao.read(n); read(n)의 반환값은 Contact이지, int가 아님
        Contact c = dao.read(n);
        
        if (c != null) {
            System.out.println(c);
        } else {
            System.out.println("해당 인덱스에는 전화번호가 없습니다.");
        }
        
    }

    private void selectAllContacts() {
        System.out.println("----- 연락처 전체 리스트 -----");
        List<Contact> contacts = dao.read();
        
        for (Contact x : contacts) {
            System.out.println(x);
        }
        
        
        
    }

    private int chooseMenu() {
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3] 새연락처 [4]수정 [5]삭제 [0]종료");
        System.out.println("----------------------------------------------------------------");
        System.out.println("메뉴 선택> ");
        int n = Integer.parseInt(scanner.nextLine());
        
        return n;
    }

} // 클래스 닫음
