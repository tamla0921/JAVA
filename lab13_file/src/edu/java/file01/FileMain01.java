package edu.java.file01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 입/출력 스트림(Input/Output Stream): 프로그램이 값(데이터)을 입력받거나 출력하는 통로.
 * 프로그램 <== InputStream <== 입력 장치(키보드, 마우스, 터치스크린, 펜, 파일, ...)
 * 프로그램 ==> OutputStream ==> 출력 장치(모니터, 프린터, 스크린, 파일, ...)
 * 
 * 프로그램 <== FileInputStream <== 파일
 * 프로그램 ==> FileOutputStream ==> 파일
 * 
 * java.io.InputStream: 데이터를 읽어오는 통로
 * |__ FileInputStream: 파일에서 데이터를 읽어오는 통로(read)
 *  (1) FileInputStream 생성
 *  (2) FIS 객체의 read 관련 메서드 호출
 *  (3) FIS 객체를 close!
 * 
 * 
 * java.io.OutputStream: 데이터를 쓰는(write) 통로
 * |__ FileOutputStram: 파일에 데이터를 쓰는 통로(write)
 *  (1) FileOutputStream 생성
 *  (2) FOS 객체의 write 관련 메서드 호출
 *  (3) FOS 객체를 close!
 */

public class FileMain01 {

    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        
        try {
            // data 폴더에 있는 test.txt 파일을 읽기 위한 스트림 객체 생성.
            in = new FileInputStream("data/test.txt");
            // FileInputStream in = new FileImputStream("data/test.txt")로 적는다면, try의 지역 변수가 된다.(블록이 끝날 때까지만 존재)
            // 따라서 그 후 finally 에서는 지역 변수가 사라져서 오류가 생긴다.
            
            // data 폴더에 test_copy.txt 파일을 쓰기 위한 스트림 객체 생성.
            out = new FileOutputStream("data/test_copy.txt");
            // FOS의 경우에는 파일을 새로 만들어주지만, 폴더는 이미 있어야 함.
            
            // 파일 복사 시작 시간 측정.
            long startTime = System.currentTimeMillis();
        
            while (true) {
                int read = in.read(); // 읽기 - 파일에서 1 바이트씩 읽음.
                System.out.println(read + ":" + (char) read);
                // read() 메서드는 파일 끝(EOF: End Of File)에 도달했을 때 -1을 리턴
                if (read == -1) { 
                    break; // 무한 루프 종료
                }
                
                out.write(read); // 쓰기 - 파일에 1 바이트씩 쓰기(write)  // 마지막 -1은 작성이 되지 않음!
            }
            
            // 파일 복사 종료 시간 측정
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime; // 복사하는 데 걸린 시간.
            
            System.out.println("파일 복사 성공! - " + elapsedTime + "ms");
            
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 예외가 발생하지 않아도(try 블록이 정상적으로 끝났을 때),
            // 예외가 발생하더라도(catch 블록이 실행됐을 때)
            // 열려져 있는 FIS, FOS 객체는 닫아야 함!
            try {
                in.close(); // FileInputStream 객체 close
                out.close(); // FileOutputStream 객체 close
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        

                 
    } // 메인 메서드 닫음

} // 클래스 닫음
