package edu.java.file08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileMain08 {

    public static void main(String[] args) {
        // Student를 저장하는 ArrayList를 선언, 생성.
        ArrayList<Student> students = new ArrayList<> ();
        
        // ArrayList에 Student 객체 5개를 저장.
//        students.add(new Student(20220920, "가가", new Score(50,50,50)));
//        students.add(new Student(20220921, "나나", new Score(10,20,30)));
//        students.add(new Student(20220922, "다다", new Score(40,32,17)));
//        students.add(new Student(20220923, "라라", new Score(0,12,11)));
//        students.add(new Student(20220924, "마마", new Score(30,22,90)));
        
        for (int i = 0 ; i < 5; i ++) {
            students.add(new Student(3232, "강낭콩", new Score(50,50,50)));
        }
        
        
//        for (Student x : students) {
//        System.out.println(x);
//        }
        
        // ArrayList를 파일에 write.
        String fileName = "data/student_list.txt";
        
        try(FileOutputStream out = new FileOutputStream(fileName);
            BufferedOutputStream bout = new BufferedOutputStream(out);
            ObjectOutputStream oout = new ObjectOutputStream(bout);
            ) {
            
            oout.writeObject(students);
            System.out.println("파일 작성 성공!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 파일에서 ArrayList 객체를 read.
        try(FileInputStream in = new FileInputStream(fileName);
            BufferedInputStream bin = new BufferedInputStream(in);
            ObjectInputStream oin = new ObjectInputStream(bin);
            ) {
            
            ArrayList<Student> list = (ArrayList<Student>) oin.readObject();
            for (Student s : list) {
                System.out.println(s);
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // ArrayList의 원소들을 한 줄씩 출력.

    } // 메인 닫음

} // 클래스 닫음
