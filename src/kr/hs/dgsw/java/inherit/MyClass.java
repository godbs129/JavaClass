package kr.hs.dgsw.java.inherit;

public class MyClass {

    @Override
    public String toString() {
        return "내 클래스";
    }

    public static void main(String[] args) {

        String a = "hello";

        MyClass myClass = new MyClass();
        System.out.println(myClass.toString());
    }
}
