package edu.java.class06;

public class ClassMain06 {

    public static void main(String[] args) {
        // Account 타입 변수 선언, Account 객체 생성
        Account account = new Account(468025, 0);
        account.printAccountInfo(); // 계좌 정보 출력.
        
        System.out.println();
        
        //account.deposit(5000);
        System.out.println(account.deposit(5000)); // 입금
        
        //double money = account.deposit(5000); // return 값을 변수에 지정한 뒤, 출력하기도 가능!
        //System.out.println(money);
        
        //account.withdraw(3000);
        System.out.println(account.withdraw(3000));
        
        //double money = account.withdraw(10000);
        //System.out.println(money);
        
        
        // 이체할 계좌 생성
        Account account2 = new Account(1572, 0);
        
        // account에서 account2으로 5,000원을 이체.
        //account.transfer(account2, 1000);
        System.out.println(account.transfer(account2, 500)); //account가 자신의 메서드를 호출
        
        System.out.println();
        account.printAccountInfo();
        account2.printAccountInfo();
    }

}
