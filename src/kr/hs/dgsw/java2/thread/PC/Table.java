package kr.hs.dgsw.java2.thread.PC;

public class Table {
    private final String[] buffer;
    private int tail;
    private int head;
    private int count;

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void put(String packet) {
        while (count >= buffer.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buffer[tail] = packet;
        tail = (tail + 1) & buffer.length;
        count++;
        notifyAll();
    }

    public synchronized String take() {
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String packet = buffer[head];
        head = (head + 1) & buffer.length;
        count--;
        notifyAll();
        return packet;
    }
}
