package kr.hs.dgsw.java2.thread;

public class Stop extends Thread{

    @Override
    public void run() {
//        while (true) {
//
//        }
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Stop t1 = new Stop();
        t1.start();
        System.out.println("스레드 시작");

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        System.out.println("스레드 종료");
    }
}
