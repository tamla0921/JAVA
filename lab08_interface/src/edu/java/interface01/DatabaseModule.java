package edu.java.interface01;

public interface DatabaseModule {
    // public static final 필드 (--> 생략할 수 있음)
    /*( public static final )*/ int DB_VERSION = 1; 
    
    // public abstract 메서드
    
    /**
     * 데이터베이스의 테이블에서 자료를 읽어오는(검색하는) 기능.
     * 
     * @return 검색된 자료의 갯수(int).
     */
    
    int /*( abstract )*/ read(); // 바디가 없는 abstract여도 메서드와는 달리 인터페이스 메서드에서는 abstract 생략 가능.
    
    /**
     * 데이터베이스의 테이블에 정수와 문자열을 저장하는 기능
     * 
     *  @param intVal 저장할 정수 값.
     *  @param strVal 저장할 문자열.
     *  
     *  @return 저장된 자료의 갯수(int).
     */
    
    int create(int intVal, String strVal);

}
