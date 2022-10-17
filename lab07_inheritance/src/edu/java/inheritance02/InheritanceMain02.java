package edu.java.inheritance02;

public class InheritanceMain02 {

    public static void main(String[] args) {
        // Person 타입 객체를 기본 생성자를 사용해서 생성.
        Person p1 = new Person();
        System.out.println(p1.getName());
        
        // Person 타입 객체를 argument를 갖는 생성자를 사용해서 생성.
        Person p2 = new Person("오쌤");
        System.out.println(p2.getName());
        
        System.out.println("\n ----- ----- \n");
                
        // Student 타입 객체를 기본 생성자를 사용해서 생성.
        Student s1 = new Student(); // Person() 생성자 호출 뒤, Student() 생성자 호출 출력.
        // subclass의 생성자를 호출하면 superclass의 생성자가 먼저 호출되고난 후 subclass의 생성자가 호출됨.
        // 부모 타입 객체가 먼저 생성되야 자식 타입 객체도 생성될 수 있음.
        // subclass의 생성자에서 superclass의 생성자를 명시적으로 호출하는 코드가 없는 경우에는
        // superclass의 기본 생성자가 자동으로 호출됨.
        // superclass의 argument가 있는 생성자는 자동으로 호출되지 않음.
        // superclass의 argument가 있는 생성자를 사용하려면 반드시 명시적으로 호출해야만 함!
        // super(...)를 호출하는 코드는 생성자에서 가장 먼저 작성되어야 함.
        
        // this의 의미:
        // (1) 생성된 (자기자신) 객체의 주소: this.field, this.method
        // (2) overloading된 생성자: this(), this(...)
        
        // super의 의미:
        // (1) 생성된 부모 객체의 주소: super.field, super.method() // private 타입이면, 불가능할 수도 있음.
        // (2) superclass의 생성자: super(), super(...)
        
        // Student 타입의 객체를 argument 1개를 갖는 생성자로 생성.
        Student s2 = new Student("아이티윌");
        
        Student s3 = new Student("가나다", "아이티윌2");
        System.out.println(s3.getName());
        System.out.println(s3.getSchool());
        

    }

}
