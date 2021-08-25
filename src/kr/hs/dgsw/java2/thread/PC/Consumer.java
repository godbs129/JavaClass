package kr.hs.dgsw.java2.thread.PC;

public class Consumer extends Thread {
    private final Table table;

    public Consumer(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            String packet = table.take();
            System.out.println("consumer : " + packet);
        }
    }
}
