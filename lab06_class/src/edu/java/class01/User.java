package edu.java.class01;


// 클래스: 데이터 + 기능 + 생성자 ==> 데이터 타입
public class User {
     // 객체가 가지는 속성들(데이터)
     String userId;
     String password;
     int age;
     
     
     // 생성자(Constructor)
     // 객체를 메모리에 생성하고 초기화해 주는 기능을 담당.
     // 모든 클래스는 생성자가 적어도 하나 이상은 있어야 함.
     // 클래스를 작성할 때 생성자를 하나도 정의하지 않으면,
     // 자바 컴파일러가 기본 생성자를 자동으로 만들어 줌.
     // 클래스를 작성할 때 생성자를 정의하면, 자바 컴파일러는 기본 생성자를 자동으로 만들지 않음!
     // 생성자의 이름은 클래스의 이름과 동일. 생성자는 리턴 타입을 사용하지 않음!
     
     // 기본 생성자(default constructor) - argument를 갖지 않는 생성자
     // 모든 속성들을 그 타입의 기본값으로 초기화함.
     // 숫자 타입+char 기본값:0, boolean 타입 기본값: false, 참조 타입 기본값: null 
     public User() { // constructor-1 /* 생성자의 이름은 클래스의 이름과 무조건 똑같아야 함! (차이: Public class Name{}, Public Name{})
         // Do nothing.
     }
     
     // argument를 갖는 생성자
     public User(String userId, String password, int age) { // constructor-2
         this.userId = userId;
         this.password = password;
         this.age = age; // this: 나 자신의 age에 파라미터 age 값을 넣을 것!
     }
     
     public User(String userId, String password) { // constructor-3
//         this.userId = userId;
//         this.password = password;
         // age 파라미터가 존재하지 않음. 따라서 여기서 User의 age는 0.
         this(userId, password, 0); // constructor-2를 호출. 오버로딩된 다른 생성자 호출!!
     }
     
     public User(String userId) { // constructor-4
//         this.userId = userId;
//         this(userId, null, 0); // constructor-2 호출
        this(userId,null); // constructor-3 호출
     }
     
     // 생성자 오버로딩(overloading): 파라미터가 다른 생성자를 여러개 정의하는 것.
     
     /* this의 의미:
      * (1) 생성된 객체의 주소: (예) this.userId, this.password, ...
      * (2) 생성자: overloading된 다른 생성자를 사용할 때 **overloading**
      */
     
     

}
