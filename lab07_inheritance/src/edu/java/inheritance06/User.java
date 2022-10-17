package edu.java.inheritance06;

public class User {
    // field: 사용자 아이디, 비밀번호
    private String id;
    private String password;
    
    // 생성자: 기본 생성자, argument를 갖는 생성자.
    public User() {}
    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }
    
    // getters/setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    // toString() 재정의: User 객체를 출력할 때 아이디와 비밀번호가 출력될 수 있도록.
    @Override
    public String toString() {
        // point = String.format("아이디: %s, 비밀번호: %s", this.id, this.password);
        return String.format("아이디: %s, 비밀번호: %s", this.id, this.password); // 변수 지정 안 하고 바로 리턴할 수 있음(String.format())
        // return "User(아이디= " + this.id + ", 비밀번호= " + this.password +")"; //String을 바로 리턴할 수 있음.
        
    }
    
    //equals() 재정의: 아이디가 일치하는 User 객체는 같은 객체.
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        
        if (obj instanceof User) {
            User pt = ((User) obj);
            result = (this.id.equals(pt.id)); // String은 this.id == pt.id 하면 안 된다고 한다. 틀리다고 나올 수도 있다고 함.
        }
        return result;
    }
    
    //hashCode() 재정의: 아이디가 같으면 해쉬코드(int)도 같음.
    //@Override
    public int hashCode() {

        return this.id.hashCode(); //문자는 이미 번호가 적혀 있으므로 Integer은 필요 없음.
    }
    
}
