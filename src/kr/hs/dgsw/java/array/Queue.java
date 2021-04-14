package kr.hs.dgsw.java.array;

public class Queue {
    private String[] array = new String[5];

    private int head = 0;
    private int tail = 0;

    public void enqueue(String str) {
        array[head / 5] = str;
        head++;
    }

    public String dequeue() {
        if(tail>=head) {
            throw new ArrayIndexOutOfBoundsException();
        }

        String value = array[tail % 5];
        tail++;

        return value;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue("hi");
        queue.enqueue("yes");

        System.out.println(queue.dequeue());
    }
}
