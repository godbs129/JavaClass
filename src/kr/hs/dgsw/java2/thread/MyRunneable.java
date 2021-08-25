package kr.hs.dgsw.java2.thread;


public class MyRunneable implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            System.out.println("Runneable : " + i);
        }
    }
}
