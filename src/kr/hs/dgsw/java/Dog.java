package kr.hs.dgsw.java;

public class Dog {
    String gender;
    String name;
    int age;
    int[] values = new int[10];

    public Dog() {
        System.out.println("생성자가 호출되었습니다");
    }
    public Dog(String name) {
        this.name = name;
    }

    public void bark() {

    }
    public void run() {

    }
    public void eat(String food) {
        System.out.println(name + "가" + food + "을 먹습니다");
    }

    public static void main(String[] args) {
        Dog messi = new Dog();
        Dog snoopy = new Dog();
        Dog naldo = new Dog("호날두");

        messi.name = "메시";
        messi.age = 3;
        messi.gender = "F";

        snoopy.name = "스누피";
        snoopy.age = 10;
        snoopy.gender = "M";
        System.out.println(snoopy.name);
    }

}
