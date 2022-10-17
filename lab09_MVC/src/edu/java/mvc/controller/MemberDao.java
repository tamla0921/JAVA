package edu.java.mvc.controller;

import edu.java.mvc.model.Member;

//인터페이스!!
public interface MemberDao {
    
    /**
     * 신규 회원 정보 등록. Argument로 전달된 Member 객체를 배열에 저장.
     * 
     * @param m 신규 등록할 회원 정보.
     * @return 배열에 새로운 회원 저장이 성공하면 1, 그렇지 않으면 0을 리턴.
     */
    int create(Member m);

    
    /**
     * 전체 회원 목록 검색 기능. 모든 회원 정보가 저장된 배열을 리턴.
     * 
     * @return 회원 정보가 저장된 배열.
     */
    Member[] read();
    
    /**
     * 
     * 인덱스를 사용한 회원 정보 검색 기능. 배열에서 해당 인덱스의 Member 객체를 찾아서 리턴.
     * @param index 회원 정보를 검색할 인덱스. 0 이상의 정수.
     * @return 배열의 index 위치에 null이 아닌 Member 객체가 있으면 그 객체를 리턴.
     * index가 배열의 범위 밖에 있거나, 해당 인덱스의 배열 원소가 null이면 null을 리턴.
     */
    Member read(int index); // 파라미터가 다르면 같은 이름의 메서드를 작성할 수 있다. (메서도 오버로드)
    
    /**
     * 회원 정보 업데이트 기능. 해당 인덱스의 회원 비밀번호를 업데이트.
     * 
     * @param index 수정할 회원의 배열 인덱스. 0 이상의 정수.
     * @param password 업데이트할 새로운 비밀번호.
     * @return 비밀번호 수정 성공하면 1, 그렇지 않으면 0을 리턴.
     */
    int update(int index, String password);
}
