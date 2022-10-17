package edu.java.contact.ver01;

import java.util.Scanner;

import edu.java.contact.menu.MainMenu;

public class ContactMain01 {
    // 상수// 입니다.
    private static final int MAX_LENGTH = 3; // 저장할 수 있는 연락처의 최대 갯수.
    
    // field
    private Scanner scanner = new Scanner(System.in); // 클래스의 필드로 선언, main메서드 뿐만 아니라, 여러 메서드들에서도 공통적으로 사용하기 위함.
    // new 뜨자마자 --> heap 영역에 새로운 무언갈 만듦... stack에 주소값 부여.
    // 배열 --> heap 영역에서 인덱스 --> 연락처 정보를 찾는 순서... --> 객체들을 찾아 찾아 찾아서 리턴.
    // 클래스 타입, 단지 주소값을 부여하기 위한 수단.. Contact[3] ==> 4바이트 * 3개
    private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처들의 배열
    private int count = 0; // 배열에 저장된 연락처의 개수. 세 연락처가 추가될 때마다 증가됨.
    
    
//    public ContactMain01() {
//        scanner = new Scanner(System.in); //scanner null 방지(nullPointer 방지)
//    }

    public static void main(String[] args) {
        // static이 아닌 메서드들을 호출하기 위해서 객체를 생성할 필요가 있음.
        ContactMain01 app = new ContactMain01(); // 생성자 호출, COntactMain01 클래스로 객체 생성!! 따라서 객체의 메서드 showMainMenu()를 사용할 수 있음.
        
        System.out.println("***** 연락처 프로그램 Version 0.1 *****");
        boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
        while (run) {
            // TODO 1. 메인 메뉴 보여 주기
            app.showMainMenu();
            
            // TODO 2. 메뉴 입력
            int n = Integer.parseInt(app.scanner.nextLine()); //app.scanner, scanner는 ContactMain01의 필드, 위에 ContactMain01 app = new ContactMain01을 해서 생성자 호출 후 사용 가능. scanner는 app. 참조변수를 통해 이용 간으.
            // int menu = app.scanner.nextInt()가 불가능한 이유: nextInt는 \n을 인식하지 못함. 엔터키는 다음 입력창으로 넘어감...
            // -> 꼭 쓰고 싶다면 nextLine();을 적을 것.
            MainMenu menu =  MainMenu.getValue(n);
            
            // TODO 3. switch-case
            switch (menu) {
            case QUIT: //종료
                run = false;
                break;
            case SELECT_ALL: // 전체리스트
                app.selectAllContacts();
                break;
            case SELECT_BY_INDEX: // 인덱스 검색
                app.selectContactByIndex();
                break;
            case CREATE: // 새 연락처 등록
                app.insertNewContact();
                break;
            case UPDATE: // 연락처 정보 수정
                app.updateContact();
                break;
            default:
                System.out.println("지원하지 않는 메뉴번호입니다. 다시 선택하세요.");
            }
            
        }
        
        System.out.println("***** 프로그램 종료 *****");
    } // end main
    
    private void updateContact() {
    // 수정할 인덱스 입력
        System.out.println("수정할 연락처의 인덱스를 입력하세요: ");
        int index = Integer.parseInt(scanner.nextLine());
        
        if (index < 0 || index >= count ) { //음수도 고려하기... [n, n]로 True, False 구분해보기.
            System.out.println("변경할 수 없습니다.");
            return;
        }
        
        
    // 수정 전 연락처 정보 출력
        System.out.print("수정 전 연락처 정보는 ");
        contacts[index].printContact();
        
    // 수정할 이름/전화번호/이메일 입력
        System.out.print("수정할 이름>> ");
        String name = scanner.nextLine();
        System.out.println("수정할 전화번호>> ");
        String phone = scanner.nextLine();
        System.out.println("수정할 이메일>> ");
        String email = scanner.nextLine();
        
    // 연락처 정보 업데이트.
        contacts[index].setName(name);
        contacts[index].setPhone(phone);
        contacts[index].setEmail(email);
        
    // 수정 후 연락처 정보 출력.
        System.out.print("수정 후>>> ");
        contacts[index].printContact();
        }
    


    private void selectContactByIndex() {
    // TODO: NullPointerException 또는 ArrayIndexOutOfBoundsException 발생할 수 있음.
        
    // 검색할 인덱스 입력
        System.out.println("검색할 인덱스>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
    // 해당 인덱스의 연락처 정보를 출력
        if (index < 0 || index >= count) { // 음수도 생각해보기
            System.out.println("저장한 연락처가 없습니다.");
            return;
        }
        contacts[index].printContact();
        
    
}

    private void showMainMenu() {
        // 1. static을 적지 않으면, main이 static이기 때문에 메서드 호출 불가.
        // 2. ContactMain01 app = new ContactMain01(); 작성
        System.out.println();
        System.out.println("---------------------------------------------------------------------");
        System.out.println("[1] 전체리스트 [2] 인덱스 검색 [3] 새 연락처 등록 [4] 수정 [0] 종료");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("메뉴 선택> ");
    }
    private void selectAllContacts() {
        // 배열 contacts에 저장된 Contact 객체들을 출력.
        System.out.println("--- 연락처 전체 리스트 ---");
        for (int i = 0 ; i < count; i++) {
            // 배열의 길이만큼 반복하는 것이 아니라, 배열에 실제로 저장된 연락처 갯수만큼만 반복함.
            contacts[i].printContact(); 

        }
        System.out.println("----------- 끝 -----------");
            
        }
    private void insertNewContact() {
        // TODO: ArrayIndexOutOfBoundsException 발생할 수 있음.
        
        if (count >= MAX_LENGTH) {
            System.out.println("더 이상 추가할 수 없습니다.");
            return;  // if문이 true일 때만 return, 따라서 unreachable 에러가 뜨지 않는다.
        }
        // 이름, 전화번호, 이메일 입력
        System.out.println("이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.println("전화번호를 입력하세요: ");
        String phone = scanner.nextLine();
        System.out.println("이메일을 입력하세요: ");
        String email = scanner.nextLine();
        
        // Contact 객체를 생성
        Contact c = new Contact(name, phone, email);

        // 배열에 추가
        contacts[count] = c;
        count++; // 배열에 저장된 연락처 갯수를 1증가
        
    }
    
    
    

} // end class
