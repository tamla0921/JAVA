package edu.java.datetime;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeMain {

    public static void main(String[] args) {
        // Java 8 버전에서 새로 생긴 날짜/시간 관련 클래스
        
        LocalDate today = LocalDate.now();
        
        System.out.println("=------===");
        System.out.println(LocalDate.now());
        System.out.println("==========");
        
        System.out.println(today); // toString 메서드 오버로딩 되어 있어서 시간이 표시가 됨.
        System.out.println(today.getYear());
        
        System.out.println(today.getMonth()); // return Month enum.
        System.out.println(today.getMonthValue());
        
        System.out.println(today.getDayOfMonth());
        
        System.out.println(today.getDayOfWeek());
        
        System.out.println(today.plusDays(1));
        System.out.println(today.minusDays(1));
        
        LocalDate date = LocalDate.of(1993,1,31);
        //LocalDate date2 = LocalDate.of(1993,new Month("JANUARY"),31);
        System.out.println(date);
        System.out.println(date.plusDays(1));
        
        
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        
        // Timestmap: 1970-01-01 00:00:00를 기준으로 1/1000 (1 milli-second)마다 1씩 증가하는
        // 정수(long 타입)를 기반으로 날짜/시간 전보를 저장하는 클래스.
        // (1) LocalDateTime --> Timestamp 변환
        Timestamp ts = Timestamp.valueOf(now);
        System.out.println(ts);
        
        System.out.println(ts.getTime());
        
        // (2) Timestamp --> LocalDateTme 변환
        LocalDateTime dt = ts.toLocalDateTime();
        System.out.println(dt);

    }

}
