package edu.java.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

import static edu.java.ojdbc.OracleJdbc.*;
import static edu.java.ojdbc.model.Blog.Entity.*;

public class JdbcMain02 {

    public static void main(String[] args) {
        // JDBC를 이용한 insert

        Scanner scanner = new Scanner(System.in); // 콘솔 입력을 위해서

        Connection conn = null;
        PreparedStatement stmt = null;
        // rs = stmt.executeQuery()는 select할 때만 작성.

        try {
            // 라이브러리 관리자에게 오라클 라이브러리를 등록 - 메모리 로딩
            DriverManager.registerDriver(new OracleDriver());

            // 라이브러리 관리자를 이용해서 데이터베이스와 연결
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = String.format("insert into %s (%s, %s, %s) values (?, ?, ?)", TBL_BLOGS, COL_TITLE,
                    COL_CONTENT, COL_AUTHOR);
            System.out.println(sql);

            // PreparedStatement 생성
            stmt = conn.prepareStatement(sql);

            // 콘솔 창에서 블로그 글 제목, 내용, 작성자를 입력
            System.out.print("제목 입력>> ");
            String title = scanner.nextLine();
            System.out.print("내용 입력>> ");
            String content = scanner.nextLine();
            System.out.print("작성자 입력 >> ");
            String author = scanner.nextLine();

            // PreparedStatement 객체에 입력받은 값들을 설정.
            stmt.setString(1, title); // stmt에서 첫 번째 ?를 변수 title 값으로 대체. // SQL에서 관련한 인덱스는 1로 시작!!
            stmt.setString(2, content); // stmt에서 두 번째 ?를 변수 content 값으로 대체.
            stmt.setString(3, author); // stmt에서 세 번째 ?를 변수 author 값으로 대체.

            // SQL 문장 실행
            int result = stmt.executeUpdate(); // 실행하시오.
            // DML을 실행했을 때 변경된 행의 갯수.
            
            // 실행 결과 출력
        
            System.out.println(result + "개 행이 삽입되었습니다.");
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // TODO:리소스 해제
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
