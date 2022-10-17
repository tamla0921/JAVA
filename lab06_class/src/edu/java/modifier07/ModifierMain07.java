package edu.java.modifier07;

// 객체(object): 프로그램에서 만들 대상. (비유) 붕어빵
// 클래스(class): 객체를 생성하기 위한 설계도. 데이터 타입. (비유) 붕어빵 틀
// 인스턴스(instance): 메모리에 생성된 객체. (비유) 만들어진 붕어빵

// 인스턴스 멤버(변수/필드, 메서드)
// - static 수식어가 사용되지 않은 멤버.
// - 객체를 생성한 후에, 참조 변수를 이용해서 사용.
// - Java Runtime이 사용하는 메모리 공간 중 Heap(힙) 영역에 생성됨.

// static 멤버(변수/필드, 메서드)
// - static 수식어가 사용된 멤버.
// - 객체를 생성하지 않아도 사용할 수 있는 멤버.
// - 클래스 이름을 이용해서 사용. (예) Math.PI, Math.sqrt()
// - Java Runtime이 사용하는 메모리 공간 중 Method(메서드) 영역에 생성됨.
// - 프로그램 시작 시점(main 메서드 시작 전)에 메모리에 생겨남.
// - static 멤버들은 static 멤버들만 접근(사용) 가능.
// - 지역 변수에는 사용할 수 없음. (지역 변수는 블록이 끝나면 사라지기 때문에)
// - 자바가상머신이 객체 생성할 필요 없이 바로 뭔갈 하길 위해서 static...

// final 수식어: 클래스, 멤버(필드/변수, 생성자, 메서드), 지역 변수에 사용됨.
// final 지역 변수: 값이 한 번 저장되면 변경할 수 없는 변수.
// final 멤버 변수: 객체가 생성될 때 값이 초기화되면 변경할 수 없는 멤버 변수.

public class ModifierMain07 {
    
    public static void main(String[] args) {
        // static 멤버(변수, 메서드)는 클래스 이름으로 참조해서 사용.
        System.out.println(StaticTest.staticVariable);
        StaticTest.staticVariable = 100;
        StaticTest.printVariables2();
        
        // 인스턴스 멤버(변수, 메서드)는 객체 생성 후 참조 변수를 이용해서 사용.
        StaticTest test1 = new StaticTest(); // 객체 생성!
        System.out.println(test1.instanceVariable);
        System.out.println(test1.staticVariable); // 100, 이미 staticVariable 변수가 Method 영역에서 만들어져 있다. 동일한 static 변수를 공유.
        // static 변수를 참조 변수를 이용해서 사용할 수는 있지만, 권장하지 않는 방법.
        // static 변수는 클래스 이름으로 참조하는 것을 권장.
        
        

        test1.instanceVariable = 1000;
        test1.printVariables();
        
        StaticTest test2 = new StaticTest();
        test2.printVariables();
        
        
        // final int number = 100;
        // number = 1000; // The final local variable number cannot be assigned. It must be blank and not using a compound assignment.
        // final 지역 변수의 값은 변경할 수 없음.
        
        FinalTest ftest = new FinalTest(10000);
        System.out.println(ftest.getNumber());
        System.out.println(Math.E);
     
        
        
        
    }

}
