package edu.java.variable05;

import java.io.IOException;

public class VariableMain05 {

    public static void main(String[] args) {

        int bt;
        int cnt = 0;

        try {
            // 표준 입력을 받는다.
            while ((bt = System.in.read()) != -1) {
                cnt++;

                // 입력받은 내용을 표준 출력한다.
                System.out.write(bt);
            }
        } catch (IOException e) {
            // 에러 발생 시 에러를 출력한다.
            System.out.println(e);
        }

        System.out.println();
        System.out.println("total bytes: " + cnt);

    }

}
