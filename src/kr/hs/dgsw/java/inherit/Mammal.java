package kr.hs.dgsw.java.inherit;

public class Mammal extends Animal {

    public void birthBaby() {
        System.out.println(getName() + "이(가) 새끼를 놓는다.");
    }

    public void eat() {
        System.out.println(getName() + "이(가) 아기 때에는 젖을 먹습니다.");
//        System.out.println(name + "이(가)" + getFood() + "을(를) 먹는다.");
        super.eat();
    }

    public static void main(String[] args) {
        Mammal hippo = new Mammal();
        hippo.setName("하마");
        hippo.setFood("물");

        hippo.eat();
        hippo.birthBaby();

        Animal dog = new Mammal();
        dog.eat();
    }
}
