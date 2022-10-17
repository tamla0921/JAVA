package edu.java.swing05;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class AppMain05 {
    // field
    // 이미지 파일들의 경로를 저장한 (문자열) 배열.
    
    
    
    
    private static final String[] IMAGES = {
        "images/flower1.jpg",
        "images/flower2.jpg",
        "images/flower3.jpg",
        "images/flower4.jpg",
        "images/flower5.jpg",
    };
        
    private JFrame frame;
    private int i; // 현재 화면에 보여지는 이미지의 인덱스.
    
    private JLabel lblImage;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain05 window = new AppMain05();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain05() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 493, 405);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        
        
        
            
        lblImage = new JLabel(new ImageIcon(IMAGES[i]));
    
        lblImage.setOpaque(true);
        lblImage.setBounds(10, 10, 455, 313);
        frame.getContentPane().add(lblImage);
        
        JButton btnNext = new JButton("next");
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // 자바가상머신(JVM)이 실행.
                showNextImage(); // 빨간 줄 (1) 익명 클래스 내, (2) 외부 클래스중 선택.
                // 내부 클레스에서는 외부 클래스의 메서드도 사용 가능.
                
//                    try {
//                    i += 1;
//                    ImageIcon test  = new ImageIcon(IMAGES[i]);
//                    lblImage.setIcon(test);
//                    } catch (IndexOutOfBoundsException e1) {
//                        i = 0;
//                        ImageIcon test  = new ImageIcon(IMAGES[i]);
//                        lblImage.setIcon(test);
//                    }
                
//                    
//                    public ImageIcon (String filename) {
//                        this(filename, filename);
//                    } 누르면 생성자도 볼 수 있음!! 
                

            }
        });
        btnNext.setBounds(368, 333, 97, 23);
        frame.getContentPane().add(btnNext);
        
        JButton btnPrev = new JButton("previous");
        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                try {
//                    i -= 1;
//                    ImageIcon test  = new ImageIcon(IMAGES[i]);
//                    lblImage.setIcon(test);
//                    } catch (IndexOutOfBoundsException e1) {
//                        i = IMAGES.length-1;
//                        ImageIcon test  = new ImageIcon(IMAGES[i]);
//                        lblImage.setIcon(test);
//                    }
                
                showPrevImage();
           }
        });
        btnPrev.setBounds(10, 333, 97, 23);
        frame.getContentPane().add(btnPrev);
    }

    private void showPrevImage() {
        // 현재 보여지는 이미지가 첫 번째 이미지가 아니면 인덱스 1 감 소 -> 새로운 이미지를 보여줌.
        // 현재 보여지는 이미지가 첫 번째 이미지이면 마지막 이미지(index = length - 1를 보여줌.
        if (i > 0) {
           i--;  
        } else {
            i = IMAGES.length - 1;
        }
        lblImage.setIcon(new ImageIcon(IMAGES[i]));
        
    }

    private void showNextImage() {
        // 현재 보여지는 이미지의 인덱스를 1 증가 -> 새로운 이미지를 보여줌.
        // 현재 보여지는 이미지가 가장 마지막 이미지이면 첫 번째 이미지(index = 0)를 보여줌.
        if (i < IMAGES.length - 1) {
            i++;
        } else {
            i = 0;
        }
        lblImage.setIcon(new ImageIcon(IMAGES[i]));
        }
        
    

    
    
} // 클래스 닫음
