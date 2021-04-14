package kr.hs.dgsw.java.tr1;

public class Dog extends Animal {

    @Override
    public String getName() {
        return "개";
    }

    @Override
    public int getCountOfLegs() {
        return 4;
    }
}