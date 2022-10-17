package edu.java.class06;

/* 은행 계좌 정보 클래스.
 * 계좌번호, 잔액을 필드로 갖고, 입금, 출금, 이체, 정보 출력 기능을 메서드로 가짐.
 */

public class Account {
    // field
    int accountNo; // 계좌번호
    double balance; // 잔고
    
    // constructor - argument 2개를 갖는 생성자.
    // 매개변수 = 파라미터
    // .의 의미? 변수의 메서드, 필드 등을 참조(reference)한다는 의미.
    public Account(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }
    
    /**
     * 입금(deposit)
     * 
     * @param amount 입금액
     * @return 입금 후 잔액을 리턴.
     */
    public double deposit(double amount) {
        return this.balance += amount;
    }
    
    /**
     * 출금(withdraw)
     * 
     * @param amount 출금액
     * @return 출금 후 잔액을 리턴.
     */
    public double withdraw(double amount) {
        return this.balance -= amount;
    }
    
    /**
     * 이체(transfer)
     * 
     * @param to 이체할 계좌 객체(Account 타입)
     * @param amount 이체할 금액
     * @return true(이체 성공).
     */
    public boolean transfer(Account to, double amount) {
        // 이체: (1) 내 계좌 출금. (2) 상대방 계좌 입금.
        //this.balance -= amount;
        // 해당 객체의 필드값!! 파라미터 값에 추가하지 않아도 된다. (withdraw메서드의 파라미터 값이 amount 하나만 있고, 해당 객체의 balance 필드값을 파라미터 값으로 추가하지 않아도 된다.)
        // account가 자신의 메서드를 호출했기 때문에, 자신의 계좌에서 출금하기. 따라서 this.balance
        //to.balance += amount;
        // to는 변수명.......
        this.withdraw(amount); // 해당 객체의 메서드, this!!
        to.deposit(amount);
        
        return true;
    }
    
    /**
     * 계좌 정보 출력(printAccountInfo). 계좌 번호와 잔액을 출력.
     */
    public void printAccountInfo() {
        System.out.println("-----계좌 정보-----");
        System.out.println("고객님의 계좌번호는 " + this.accountNo + " 입니다.");
        System.out.println("고객님의 잔고는 " + this.balance +  "원 입니다.");
    }

}
