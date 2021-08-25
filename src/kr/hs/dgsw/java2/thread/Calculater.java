package kr.hs.dgsw.java2.thread;

public class Calculater {
    private int sum = 0;

    public void add(int value) {
        synchronized (this) {
            sum += value;
        }
    }

    public int getSum() {
        return sum;
    }
}