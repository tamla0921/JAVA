package edu.java.ojdbc;

// 인터페이스의 변수들은 모두 public static final!!

public interface OracleJdbc {
    
    // Oracle DB에 접속하는 주소(, 포트번호, SID)
     String URL = "jdbc:oracle:thin:@localhost:1521:xe";
                                // ip주소:포트번호:sid
    
    // String URL = "jdbc:oracle:thin:@192.168.20.31:1521:xe";

    // Oracle DB에 접속하는 사용자 계정
    String USER = "scott";
    
    // Oracle DB에 접속하는 사용자 비밀번호
    String PASSWORD = "tiger";
    
}
