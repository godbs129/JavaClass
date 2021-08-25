package kr.hs.dgsw.java2.thread;

public class MainClass {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("쓰레드 1");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        System.out.println(t1.isAlive());
        System.out.println("getId() : " + t1.getId());
        System.out.println("getName() : " + t1.getName());

        MyRunneable r1 = new MyRunneable();
        Thread t2 = new Thread(r1);
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
        System.out.println("getId() : " + t2.getId());

        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }

//        for (int i = 0; i < 100; i++) {
//            System.out.println("Main : " + i);
//        }


//        MyThread t2 = new MyThread();
//        t2.start();

    }
}
