package edu.java.class02;

// 클래스의 멤버들:
// 1. 필드(field) - 클래스의 객체들이 가질 수 있는 속성들(데이터). 변수.
// 2. 생성자(constructor) - 객체를 생성하고 초기화.
// 3. 메서드(method) - 클래스의 객체들이 갖는 기능(함수).

public class Product {
    // field
    int productId; // 상품 아이디
    String productName; // 상품 이름
    int price; // 상품 가격
    
    // constructor
    public Product(int productId, String productName, int price) {
        this.productId = productId; //  파라미터 명과, 필드의 멤버와 같을 시, 이를 구분하기 위해, 데이터에게 this를 붙힘. 만약 둘이 다를 경우 this를 생략해도 된다.
        this.productName = productName;
        this.price = price;
        
    }
    
    //  method
    
    public void setPrice(int price) { // 파라미터 앞에 자료형 꼭 입력하기! 파라미터도 변수이다.
        this.price = price;
    }
    

}
