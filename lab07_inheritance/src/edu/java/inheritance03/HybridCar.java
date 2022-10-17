package edu.java.inheritance03;

public class HybridCar extends Car {
    // field
    private int battery;
    
    public HybridCar(double fuel, double speed, int battery) {
        super(fuel, speed);
        this.battery = battery;
        
    }
    
    // 메서드/생성자 overload:
    // 파라미터가 다르면 같은 이름으로 여러개의 메서드/생성자를 만드는 것.
     
    // 메서드 override:
    // 상위 클래스의 메서드를 하위 클래스에서 재정의하는 것. (상속이 전제되어야 함!!)
    // 리턴 타입, 메서드 이름, 파라미터 선언이 모두 같아야 함.
    // 접근제한 수식어는 상위 클래스에서의 수식어보다 범위가 같거나 넓어짐.
    
    @Override // 애너테이션(annotation): 소스 코드에서 추가적인 기능을 넣어주는 것. 오버라이드 되었으니, 컴파일러에게 확인시켜주는 기능.
    public void drive() { // 상위클래스의 타입, 리턴형, 메소드명은 동일
        System.out.println("speed: " + getSpeed() + ", fuel: " + getFuel() + ", battery: " + battery);
    }

    
    
    // 

}
