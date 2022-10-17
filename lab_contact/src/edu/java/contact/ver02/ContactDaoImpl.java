package edu.java.contact.ver02;

// MVC 아키텍쳐에서 Controller (구현) 클래스
public class ContactDaoImpl implements ContactDao{
	
	public static final int MAX_LENGTH = 3;
	
	private Contact[] contactList = new Contact[MAX_LENGTH];
	
	private int count = 0;
	
	public int getCount() {
		return count;
	}
	
	// 싱글톤
	private static ContactDaoImpl instance = null;
	private ContactDaoImpl() {}
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	// 오버라이드 하기

	@Override
	public Contact[] read() {
	    // contactList에 저장된 Contact 객체의 갯수만큼 크기의 배열을 새로 생성.
		Contact[] contacts = new Contact[count];
		for (int i = 0 ; i < count ; i++) {
			contacts[i] = contactList[i]; // null이 아닌 값들만 복사.
		}
		return contacts;
	}

	@Override
	public Contact read(int index) {
		if (index >= 0 && index < count) {
			return contactList[index];
		} else {
		return null;
		}
	}
	
	public boolean isValidIndex(int index) {
	    return (index >= 0) && (index < count); // 직접 T / F 값 저장하지 않아도 된다.
	}
	
	public boolean isMemoryAvailable() {
	    return (count < MAX_LENGTH);
	}

	@Override
	public int create(Contact c) {
		if (count >= MAX_LENGTH) {
		    // 배열에 저장된 갯수와 배열의 최대 크기가 같으면(>=, ==)
			return 0;
		}
		contactList[count] = c;
		count++;
		
		return 1;
	}

	@Override
	public int update(int index, String Name, String Phone, String Email) { // 객체를 새로 만들어서 한 개만 argument로 전달해도 가능.
		if (index >= 0 && index < count) {
			contactList[index].setName(Name);
			contactList[index].setPhone(Phone);
			contactList[index].setEmail(Email);
			return 1;
		} else {
			return 0;
		}
	}

}
