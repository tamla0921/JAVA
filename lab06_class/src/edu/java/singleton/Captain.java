package edu.java.singleton;

// singleton: 객체가 오직 한 번만 생성될 수 있는 객체.
// singleton = (1) private static field + (2) private constructor + (3) public static method

public class Captain {
    // (1) private static field
    private static Captain instance = null;
    // ??? Captain 클래스 ??? 생성된 객체의 주소를 적을 수 있을 만큼의 메모리를 확보하세요. (= 4 bytes, 모든 클래스)
    
    private String name = "캡틴 아메리카";
    
    // private 생성자
    // -> 다른 클래스에서 생성자가 안 보임. -> 다른 클래스에서는 객체를 생성할 수 없음.
    // 예) new Math() 생성자는 private (ERROR: The constructor Math() is not visible) 단 Math의 static 메서드는 사용할 수 있도록 함.
    private Captain() {}
    
    // (3) public static Captain 타입을 리턴하는 메서드.
    public static Captain getInstance() {
        if (instance == null) {
            instance = new Captain();
        }
        
        return instance;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}
