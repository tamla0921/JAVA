package edu.java.ojdbc.model;

import java.time.LocalDateTime;

// 데이터베이스에 생성된 테이블(BLOGS)의 각 칼럼들을 필드(멤버 변수)로 선언한 모델 클래스.
public class Blog {
    
    public interface Entity {
        String TBL_BLOGS = "BLOGS"; // 테이블 이름.
        String COL_BLOG_NO = "BLOG_NO"; // 컬럼 이름 - 블로그 글 번호
        String COL_TITLE = "TITLE"; // 블로그 글 제목
        String COL_CONTENT = "CONTENT"; // 블로그 글 내용(본문)
        String COL_AUTHOR = "AUTHOR"; // 블로그 글 작성자
        String COL_CREATED_DATE = "CREATED_DATE"; // 블로그 글 작성 시간
        String COL_MODIFIED_DATE = "MODIFIED_DATE"; // 블로그 글 수정 시간
    }
    
    private Integer blogNo;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    
    // 생성자
    public Blog() {}

    public Blog(Integer blogNo, String title, String content, String author, LocalDateTime createdDate,
            LocalDateTime modifiedDate) {
        this.blogNo = blogNo;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        
    }
    
    // getters/ setters
    public Integer getBlogNo() {
        return blogNo;
    }

    public void setBlogNo(Integer blogNo) {
        this.blogNo = blogNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

     public String getAuthor() {
         return author;
     }

     public void setAuthor(String author) {
         this.author = author;
     }

     public LocalDateTime getCreatedDate() {
         return createdDate;
     }

     public void setCreatedDate(LocalDateTime createdDate) {
         this.createdDate = createdDate;
      }

     public LocalDateTime getModifiedDate() {
         return modifiedDate;
     }

      public void setModifiedDate(LocalDateTime modifiedDate) {
          this.modifiedDate = modifiedDate;
      }
      
    public String toString() {
        return String.format(
                "Blog(No=%d, title=%s, content=%s, author=%s, created=%s, modified=%s)",
                blogNo, title, content, author, createdDate, modifiedDate);
    
    }

    
    
} // 클래스 닫음
