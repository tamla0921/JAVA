package edu.java.contact.ver03;
import java.util.List;
import java.util.Scanner;
import edu.java.contact.menu.MainMenu;
import edu.java.contact.ver02.Contact;

public class ContactMain03 {
    
    private Scanner scanner = new Scanner(System.in);
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();

    public static void main(String[] args) {
        System.out.println("***** 연락처 프로그램 Version 0.3 *****");
        
        ContactMain03 app = new ContactMain03(); // ContactMain03의 메서드들을 이용하기 위하여 변수 선언.
        // String a = app.scanner.nextLine();
        
        boolean run = true;
        while (run) {
            try {
            int n = app.chooseMenu();
            MainMenu menu = MainMenu.getValue(n); // enum도 타입이므로 자료형으로 생성 가능. // 자료형 선언과 동시에, 자료형의 메서드도 바로 사용 가능.
            
            switch (menu) {  // 만약 n = 1 이었다면, menu[1] 즉, SELECT_ALL을 리턴했음
            // menu 변수의 값과 case의 값과 일치하는 지 찾기.
            
            case QUIT:
                run = false;
                break;
                
            case SELECT_ALL: // switch (menu)에 해당하는 부분과 일치하는 곳을 선택, SELECT_ALL = case SELECT_ALL 일치하므로 여기가 해당.
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
                System.out.println("지원하지 않는 메뉴입니다. 다시 선택해주세요.");
            }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }  catch(IndexOutOfBoundsException e) {
                System.out.println("해당 인덱스에는 연락처가 없습니다.");
            } 
        }
          System.out.println("프로그램을 종료합니다.");
          

    } //메인 메서드 닫음.
    
    
    // ContactMain03의 메서드 모음.
    private void deleteContact() {
        System.out.println("연락처를 삭제합니다.");
        System.out.print("삭제할 연락처 인덱스>>> ");
        int index = Integer.parseInt(scanner.nextLine());
        int result = dao.delete(index);
        
        if (result == 1) {
             System.out.println("연락처 삭제 성공!");
        } else {
             System.out.println("연락처를 삭제할 수 없습니다.");
        }       
    }

    private void updateContact() {
        System.out.println("연락처를 변경합니다. ");
        System.out.print("수정할 연락처 인덱스>>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        System.out.print("수정 전>>> ");
        System.out.println(dao.read(index));
            
        System.out.print("수정할 이름>>> ");
        String name = scanner.nextLine();
            
        System.out.print("수정할 전화번호>>> ");
        String phone = scanner.nextLine();
            
        System.out.print("수정할 이메일>>> ");
        String email = scanner.nextLine();
            
        Contact x = new Contact(name, phone, email);
            
        int result = dao.update(index, x);
        if (result == 1) {
            System.out.println("수정 후>>> ");
            System.out.println(dao.read(index));
            System.out.println("연락처 정보 업데이트 성공");
        } else {
            System.out.println("연락처 정보 업데이트 실패");
        }
            
        
        
        
    }

    private void insertNewContact() {
        System.out.println("연락처를 저장합니다.");
        
        System.out.print("이름 입력>> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호 입력>> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 입력>> ");
        String email = scanner.nextLine();
        
        Contact x = new Contact(name, phone, email);
        int result = dao.create(x);
        
        if (result == 1) {
            System.out.println("연락처 생성/저장 성공");
        } else {
            System.out.println("연락처 생성/저장 실패");
        }
        
    }

    // 클래스 메서드 모음
    private int chooseMenu() {
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3] 새연락처 [4]수정 [5]삭제 [0]종료");
        System.out.println("----------------------------------------------------------------");
        System.out.println("메뉴 선택> ");
        int n = Integer.parseInt(scanner.nextLine());
        
        return n;
    }
    
//    while (true) {
//        try {
//            int num = Integer.parseInt(scanner.nextLine());
//            
//            return num; // return : 반복에서 벗어나겠다!
//        } catch (NumberFormatException e) {
//            System.out.println("정수를 입력하세요>> ");
//        }
//    }
    
    private void selectAllContacts() {
        System.out.println("--- 연락처 전체 리스트---");
        List<Contact> contacts = dao.read();
        for (Contact x : contacts) {
            System.out.println(x);
        }
    }   
    
    private void selectContactByIndex() {
        System.out.println("연락처를 검색합니다. ");
        System.out.println("검색할 인덱스>>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        System.out.println(dao.read(index));
        
        //Contact byIndex = dao.read(index);
        //System.out.println(byIndex);
        
        
    }
    
    

} //클래스
