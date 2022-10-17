package edu.java.inner03;

public class BuilderExample {

    public static void main(String[] args) {
        // Book 타입 변수 선언, 객체 생성
        
        
        // 생성자를 사용한 객체 생성
        Book book1 = new Book("혼공자", "가나다", "자기계발서");
        
        System.out.println(book1);
        
        Book book2 = new Book("김훈", "소설", "하얼빈");
        System.out.println(book2);
        
        
        // Builder/Factory 패턴을 사용한 객체 생성
         Book book3 = Book.builder() // 여기까는 BookBuilder 타입이어서 오류가 뜸..
                 .author("김훈")
                 .category("소설")
                 .title("하얼빈")
                 .build(); // static 메서드
         
         System.out.println(book3);
         
         Book book4 = Book.builder()
                 .title("하얼빈")
                 .author("김훈")
                 .category("소설")
                 .build(); 
         System.out.println(book4);
         
         // 생성자 패턴
         Book book5 = new Book("이상한 변호사 우영우", null, null);
         System.out.println(book5);
         
         Book book6 = Book.builder().title("이상한 변호사 우영우")
                 .author(null)
                 .build();
         System.out.println(book6);
         } // 메인 닫음

} // 클래스 닫음
