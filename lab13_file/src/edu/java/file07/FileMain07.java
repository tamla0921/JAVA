package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import edu.java.file06.Product;

public class FileMain07 {

    public static void main(String[] args) {
        // edu.java.file06.Product 타입의 객체를 1,000,000개 생성하고 ArrayList에 저장.
        // ArrayList의 내용을 product_list.dat 파일에 write -  시간 측정.
        // product_list.dat 파일에서 데이터를 읽어서 ArrayList 타입으로 변환 - 시간 측정.
        
        ArrayList<Product> products = new ArrayList<> ();
        
        for (int i = 0 ; i < 1_000_000 ; i++) {
            products.add(new Product(i, "NONAME#" + i, i));
        }
        
        System.out.println(products.size()); // 리스트 길이 아는 법.
        System.out.println(products.get(5));
        
        String fileName = "data/product_list.dat";
        
        FileOutputStream out = null;
        BufferedOutputStream bout = null;
        ObjectOutputStream oout = null;
    
        try {
            out = new FileOutputStream(fileName);
            bout = new BufferedOutputStream(out);
            oout = new ObjectOutputStream(bout);
            
            long startTime = System.currentTimeMillis();
            
            oout.writeObject(products); // 100만 개 원소를 가지는 리스트를 파일에 write
            
            long endTime = System.currentTimeMillis();
            long elapsed = endTime - startTime;
            
            System.out.println("파일 작성 성공: " + elapsed + "ms");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {;    
            try {
                oout.close(); // 가장 마지막에 연 것만 닫으면 됨/
            } catch (Exception e) {
            e.printStackTrace();
        }
        }
        
        try(FileInputStream in = new FileInputStream(fileName);
            BufferedInputStream bin = new BufferedInputStream(in);
            ObjectInputStream oin = new ObjectInputStream(bin);
                ) {
            long start = System.currentTimeMillis();
            
            ArrayList<Product> list = (ArrayList<Product>) oin.readObject();
            
            long end = System.currentTimeMillis(); // 일기 종료 시간
            long elapsed = end - start;
            System.out.println("파일 읽기 성공: " + elapsed + "ms");
            
            System.out.println(list.size());
            System.out.println(list.get(999));
            
        } catch(Exception e) {
            e.printStackTrace();
        }

//        try (FileOutputStream out = new FileOutputStream(fileName);
//             ObjectOutputStream oout = new ObjectOutputStream(out);
//        ) {
//            oout.writeObject(products);
//            
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        long endTime = System.currentTimeMillis();
//        
//        long elapsedTime = endTime - startTime;
//        System.out.println("파일 생성 성공! = " + elapsedTime);
//        
//        
//        startTime = System.currentTimeMillis();
//        try(FileInputStream in = new FileInputStream(fileName);
//            ObjectInputStream oin = new ObjectInputStream(in);
//            ) {
//            Object obj = oin.readObject();
//            if (obj instanceof ArrayList) {
//                ArrayList project2 = (ArrayList) obj;
////                for (int i = 0 ; i < project2.size() ; i++) {
////                System.out.println(project2.get(i));
////                }
//            }
//             
//           } catch(Exception e) {
//            e.printStackTrace();
//        }
//        
//        endTime = System.currentTimeMillis();
//        elapsedTime = endTime - startTime;
//        
//        System.out.println("파일 불러오기 성공! = " + elapsedTime);
//        
//        //System.out.println(products2);
                

    } // 메서드 닫음

} // 클래스 닫음
