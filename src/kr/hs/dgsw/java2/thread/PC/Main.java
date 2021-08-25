package kr.hs.dgsw.java2.thread.PC;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(20);

        new Producer(table).start();
        new Consumer(table).start();
    }
}
