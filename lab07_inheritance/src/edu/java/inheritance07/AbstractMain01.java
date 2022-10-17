package edu.java.inheritance07;

// 추상 메서드(abstract method)
//  메서드의 signature(수식어, 리턴 타입, 파라미터 선언)만 선언되어 있고, 본체({...})가 정의되지 않은 메서드.
//  추상 메서드는 반드시 abstract 수식어를 사용해야 함.
//  추상 메서드의 반드시 선언은 반드시 세미콜론(;)으로 끝나야 함. 호출할 수 없다.

// 추상 클래스(abstract class)
//  abstract 수식어가 사용된 클래스.
//  대부분의 경우, 추상 클래스는 1개 이상의 추상 메서드를 가지고 있음.
//  추상 메서드를 가지고 있는 경우는 클래스 선언에서 반드시 abstract를 사용해야 함.
//  추상 클래스는 객체를 생성할 수 없음.

// 추상 메서드와 추상 클래스는 상속하는 하위 클래스에서 구현을 목적으로 함.

abstract class Animal {
    public abstract void move(); // {} 블록 없이 ()후에 ; 사용!
}

class Dog extends Animal {
    @Override // 추상 메서드를 재정의해서 메서드 본체를 작성 -> 구현(implement)
    public void move() {
        System.out.println("강아지가 총총총...");
    }
}

class Fish extends Animal {
    @Override
    public void move() {
        System.out.println("물고기 스윔스윔...");
    }
}

class Bird extends Animal {
    @Override
    public void move() {
        System.out.println("새는 훨훨~~~"); 
    }
}

    


public class AbstractMain01 {

    public static void main(String[] args) {
        Animal dog = new Dog(); // 다형성!
        dog.move(); // 창에서만 Animal의 메서드로만 보여질 뿐, 실제로 작동은 된다.
        
        Fish fish = new Fish();
        fish.move();
        
        Animal bird = new Bird();
        bird.move();
        
        // Animal c = new Animal(); // cannot instantiate the type Animal
        
        Animal[] animals = {dog, fish, bird};
        for (Animal a : animals) {
            a.move();
        }

    }

}
