package edu.java.contact.fileutil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import edu.java.contact.ver04.Contact;

// 도우미 클래스 - 다른 클래스에 파일 관련(read, write) 기능을 제공하기 위한 클래스.
public class FileUtil {
    // 상수 정의 - 데이터 폴더 이름, 데이터 파일 이름
    public static final String DATA_DIR = "data";
    public static final String DATA_FILE = "contacts.dat";
    
    // private 생성자 - 다른 클래스에서는 객체 생성이 안 되도록 하기 위해서.
    // 모든 메서드들은 public static으로 선언.
    // |__ 도우미 클래스들이 사용하는 방법으로 메서드만 이용할 수 있도록 함.
    private FileUtil() {} // The constructor is not visible. (예) Math.pi...
    
    // 메서드
    
    /**
     * 연락처 데이터 파일을 저장하는 폴더가 없으면 폴더를 생성하고 File 객체를 리턴.
     * 폴더가 생성되어져 있으면, 그 폴더의 File 객체를 리턴.
     * 
     * @return 데이터 파일을 저장할 폴더 객체
     */
    public static File initDataDir() {
        File dir = new File(DATA_DIR);
        
        // TODO: 폴더가 존재하지 않으면 폴더 생성.
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println("데이터 폴더 생성 성공...");
        } else {
            System.out.println("데이터 폴더가 이미 존재....");
        }
        
        return dir;
    }
    
    /**
     * 연락처 데이터 파일이 있으면, 파일의 내용을 읽어서 리스트를 만들고 리턴.
     * 연락처 데이터 파일이 없으면, 빈 리스트를 리턴.
     * 
     * @return Contact 타입을 저장하는 ArrayList.
     */
    public static List<Contact> initData() { // 프로그램 처음 실행 시, 파일을 만들어 주는 용도.
        List<Contact> list = null; // 리턴할 리스트 // 아직은 아무 것도 없는 null.
        
        File file = new File(DATA_DIR, DATA_FILE); // 데이터 파일 객체
        if (file.exists()) { // 데이터 파일이 존재하면
            list = readDataFromFile(file); // 또 다른 메서드를 파일에서 불러오기.
        } else { // 데이터 파일이 존재하지 않으면
            list = new ArrayList<>(); // 빈 리스트 생성
        }
        return list;
    }
    
    
    /**
     * argument로 전달된 File 객체를 사용해서, 파일에 저장된 연락처 정보를 읽고
     * 그 결과를 List 객체로 리턴.
     * 
     * @param file 연락처 정보가 저장된 파일 경로가 설정된 File 타입 객체.
     * @return Contact를 저장하는 ArrayList.
     */
    public static List<Contact> readDataFromFile(File file) { //list가 List<Contact>의 객체이므로
        List<Contact> list = null;
        
        FileInputStream in = null;
        BufferedInputStream bin = null;
        ObjectInputStream oin = null;
        
        try {
            in = new FileInputStream(file); // 위 initData()에서 호출된 file을 파라미터로 저장되어 있다.
            bin = new BufferedInputStream(in);
            oin = new ObjectInputStream(bin);
            
            list = (List<Contact>) oin.readObject();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oin.close(); // 닫을 때도 오류 발생하기 때문에 try-catch 구문 설정!
                // OIS close -> BIS close -> FIS close
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        return list;
    }
    
    
    /**
     * argument로 전달된 데이터를 파일에 write.
     * 
     * @param data data 파일에 쓸 데이터. Contact 타입을 저장하는 리스트
     * @param file 파일 정보를 가지고 있는 File 타입 객체.
     */
    public static void writeDataToFile(List<Contact> data, File file) {
        try (FileOutputStream out = new FileOutputStream(file);
             BufferedOutputStream bout = new BufferedOutputStream(out);
             ObjectOutputStream oout = new ObjectOutputStream(bout);
            ) {
        
        oout.writeObject(data);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

} // 클래스 닫음
