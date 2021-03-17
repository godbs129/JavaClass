package kr.hs.dgsw.java;

public class AccumulateRunner {
    public static void main(String[] args) {
        Accumulate accumulate = new Accumulate();

        accumulate.add(3);
        accumulate.display();

        accumulate.add(8);
        accumulate.display();

        accumulate.add(-5);
        accumulate.display();
    }
}
