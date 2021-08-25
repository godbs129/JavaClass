package kr.hs.dgsw.java2.thread.PC;

public class Producer extends Thread{
    private static int id = 0;
    Table table;

    public Producer(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String packet = "No : " + nextId();
            table.put(packet);
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
