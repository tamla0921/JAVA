package edu.java.ojdbc.controller;

import java.util.List;

import edu.java.ojdbc.model.Blog;

public interface BlogDao {
    
    // 전체 검색.
    List<Blog> select(); // SQL_SELECT_ALL
    Blog select(Integer blogNo); // SQL_SELECT_BY_NO
    
    // int insert(String title, String content, String author); // SQL_INSERT
    int insert(Blog blog); // SQL_INSERT
    
    //int update(int no, String title, String content); // SQL_UPDATE
    int update(Blog blog); //SQL_UPDATE
    
    int delete(Integer blogNo); // SQL_DELETE
    
    // SELECT_BY_TITLE, SELECT_BY_CONTENT, SELECT_BY_AUTHOR, SELECT_BY_TITLE_OR_CONTENT
    List<Blog> select(int type, String keyword);
    
    
}
