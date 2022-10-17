package edu.java.contact.ver02;

import edu.java.contact.menu.MainMenu;

import java.util.Scanner;

// MVC 아키텍쳐에서 View(UI)에 해당하는 클래스.
public class ContactMain02 {
	
	private Scanner scanner = new Scanner(System.in);
	private ContactDaoImpl dao = ContactDaoImpl.getInstance(); // 컨트롤러(연락처 저장, 검색, 수정) 클래스.

	public static void main(String[] args) {
		System.out.println("***** 연락처 프로그램 Version 0.2 *****");
		// static이 아닌 메서드들을 호출하기 위해서 객체를 생성할 필요가 있음.
		ContactMain02 app = new ContactMain02();
		
		boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
		while (run) {
		    // 메인 메뉴 선택
			int n = app.chooseMenu();
			// 메인 메뉴 숫자를 enum MainMenu 타입으로 변환.
			MainMenu menu = MainMenu.getValue(n);
			switch (menu) {
	
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
				
			case QUIT:
				run = false;
				break;
				
			default:
				System.out.println("지원하지 않는 메뉴입니다. 다시 선택해주세요.");
			}
		}
		
		System.out.println("*** 프로그램 종료 ***");

	} // end main

	private void updateContact() {
		System.out.println("수정할 연락처 인덱스>> ");
		int index = Integer.parseInt(scanner.nextLine());
		
		if (index < 0 || index >= dao.getCount()) {
			System.out.println("해당 인덱스에는 수정할 수 있는 연락처가 없습니다.");
			return;
		}
		
		System.out.print("수정 전>>> ");
		System.out.println(dao.read(index));
		
		System.out.print("수정할 이름>> ");
		String name = scanner.nextLine();
		System.out.print("수정할 전화번호>> ");
		String phone = scanner.nextLine();
		System.out.print("수정할 이메일>> ");
		String email = scanner.nextLine();
		
		int result = dao.update(index, name, phone, email);
		if (result == 1) {
			System.out.print("수정 후>>> ");
			System.out.println(dao.read(index));
			System.out.println("연락처 정보 업데이트 성공");
		} else {
			System.out.println("연락처 정보 업데이트 실패");
		}
		
	}

	private void insertNewContact() {
	    if (!dao.isMemoryAvailable()) {
	        System.out.println("새 연락처를 저장할 공간이 부족합니다.");
	        return;
	    }
	    
	    
		//if (dao.getCount() == dao.MAX_LENGTH) {
		//	System.out.println("새 연락처를 저장할 공간이 부족합니다.");
		//	return;
		//}
	    
		System.out.print("이름 입력>> ");
		String name = scanner.nextLine();
		
		System.out.print("전화번호 입력>> ");
		String phone = scanner.nextLine();
		
		System.out.print("이메일 입력>> ");
		String email = scanner.nextLine();
		
		
		Contact x = new Contact(name, phone, email);
		int result = dao.create(x); // controller 메서드 사용해서 배열에 연락처 정보 저장.
		if (result == 1) {
			System.out.println("연락처 생성/저장 성공");
		} else {
			System.out.println("연락처 생성/저장 실패");
		}
	}

	private void selectContactByIndex() {
		System.out.print("검색할 인덱스>> ");
		int index = Integer.parseInt(scanner.nextLine());
		
		if (!dao.isValidIndex(index)) {
		    // 인덱스가 유효하지 않으면. (0보다 작거나 또는 저장된 연락처 갯수보다 많다면)
		    System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
		    return; // 메서드 종료
		}
		
		Contact m = dao.read(index); // controller 메서드 사용.
		System.out.println(m);
		
		//System.out.println(dao.read(index));
		
	}

	private void selectAllContacts() {
		System.out.println("--- 연락처 전체 리스트 ---");
		Contact[] contacts = dao.read(); // controller의 메서드를 호출.
		for (Contact x : contacts) {
			System.out.println(x);
		}
	}

	private int chooseMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------");
		System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [0]종료");
		System.out.println("--------------------------------------------------------");
		System.out.print("메뉴 선택> ");
		
		int n = Integer.parseInt(scanner.nextLine());
		return n;
	}
	

}
