package kr.hs.dgsw.java.if1;

public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("사료를 먹습니다");
    }

    @Override
    public void makeSound() {
        System.out.println("ㅁㄴㅇㄹ");
    }
}
