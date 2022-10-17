package edu.java.jdbc01;

import java.sql.Connection; // 데이터베이스와 연결(접속)을 관리하는 인터페이스.
import java.sql.DriverManager; // SQL 드라이버(라이브러리) 관리자
import java.sql.PreparedStatement; // SQL 문장을 작성, DB에 전송, 결과를 받는 객체.
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import edu.java.ojdbc.model.Blog;

import static edu.java.ojdbc.OracleJdbc.*; // static으로 선언된 변수/메서드 이름을 import. *: 모든 것을 다 가지고 옴.
import oracle.jdbc.OracleDriver; // ojdbc8.jar 라이브러리에 포함된 클래스. 가장 최신의 클래스...

import static edu.java.ojdbc.model.Blog.Entity.*;

/*
 * JDBC(Java Database Connectivity):
 * 자바 프로그램에서 데이터베이스를 연결하고 SQL 문장들을 실행하는 방법.
 * 1. Oracle JDBC 라이브러리(ojdbc8-.x.x.x.x.jar)를 다운로드하고 자바 프로젝트에 추가.
 *      (1) 라이브러리 다운로드.
 *      (2) 이클립스 자바 프로젝트에 lib 폴더 생성.
 *      (3) lib 폴더에 다운로드한 jar 파일을 복사.
 *      (4) jar 파일을 빌드 패스(build path)에 추가.
 * 
 * 2. 오라클 데이터베이스 시스템에 접속하기 위한 정보들(URL, USER, PASSWORD, ...)을 상수로 정의.
 * 
 * 3. 프로그램에서 오라클 JDBC 라이브러리를 사용할 수 있도록 메모리에 로드.
 * 
 * 4. 오라클 데이터베이스 시스템에 접속(connection).
 * 
 * 5. Statement 객체 생성 - 데이터베이스 서버에서 실행할 SQL 문장 작성, 실행
 * 
 * 6. Statement 객체의 메서드를 사용해서 SQL 문장을 데이터베이스 서버로 전송하고, 그 결과를 받음.
 *      (1) executeQuery() - DQL(select)
 *      (2) executeUpdate() - DML(insert, update, delete)
 *      
 * 7. 결과 처리 - 화면 출력.
 * 
 * 8. 사용했었던 모든 리소스 해제(close).
 */

public class JdbcMain01 {
    
    public static void main(String[] args) { //das
        Connection conn = null; // finally 구문에서 close를 해야 할 리소스 객체.
        PreparedStatement stmt = null; // finally 구문에서 close 해야 할 리소스 객체.
        ResultSet rs = null; // finally 구문에서 close 해야 할 리소스 객체.
        // resultset: SQL데이터 테이블을 가져오는 타입?
        try {
            // 3. Oracle JDBC 라이브러리 로드.
            DriverManager.registerDriver(new OracleDriver()); // 오라클 실행할 준비...
            System.out.println("Oracle Driver 등록 성공!");

            // 4. 오라클 DB에 접속.
            conn = DriverManager.getConnection(URL, USER, PASSWORD); // 오라클 접속!
            System.out.println("Oracle DB 접속 성공!");

            // 5. 전체 검색(select)할 수 있는 SQL 문장과 Statement 객체를 생성
            // JDBC에서는 SQL 문장 끝에 세미콜론(;)을 사용하지 않음!

            String sql = String.format("select * from %s order by %s desc", TBL_BLOGS, COL_BLOG_NO);

            System.out.println(sql);
            stmt = conn.prepareStatement(sql); // 통로(getConnection)를 통해서 SQL 데이터를 사용할 수 있게 하는 준비 단계.
            // 6. SQL 문장을 DB 서버로 전송, 결과 받음.
            rs = stmt.executeQuery(); // 쿼리 실행하시오.

            /*
             * 1. 통로 생성(getConnection) 2. 쿼리 사용 준비단계(prepareStatemnet) 3. 쿼리 실행(executeQuery)
             * -- select에서만 실행하는 클래스.
             */

            System.out.println(rs);

            // 7. SQL 실행 결과를 화면에 출력.
            while (rs.next()) { // ResultSet에 행(row)에 있는 경우
                
                // while (true)인 동안 반복문 돌려서 글 내용 출력.
                
                
                Integer blogNo = rs.getInt(COL_BLOG_NO); // BLOG_NO 컬럼의 값(number)을 읽음.
                // 파라미터: the label for the column specified with the SQL AS clause.
                // If the SQL AS clause was not specified, then the label is the name of the column.
                // --> 테이블 이름의 숫자를 불러와라.
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime createdDate = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                // SQL에서는 Date, Timestamp 타입
                // 자바에서는 LocalDateTime 타입을 가장 많이 사용. --> 변환 필요!
                LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();

                Blog blog = new Blog(blogNo, title, content, author, createdDate, modifiedDate);
                System.out.println(blog);

                // resultSet: 검색된 테이블의 첫번째 행에 처음에 위치.
                // resultSet.next(): 행에 데이터가 있는 지 유무 확인 후, 다음 행으로 옮겨 감.
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // 사용했었던 리소스들을 해제(close) - 객체들이 생성된 반대 순서로 close.
            // 나중에 생성된 객체부터 먼저 close.
            try {
                rs.close(); // ResultSet 해제
                stmt.close(); // PreparedStatement 해제
                conn.close(); // 오라클 DB와 연결 끊기.
                System.out.println("Oralc DB 연결 해제 성공!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
