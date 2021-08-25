package kr.hs.dgsw.java2.thread;

import java.util.Scanner;

public class WaitThread extends Thread {
    private Object object;

    public WaitThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            System.out.println(getId() + " 나를 깨워줘");
            synchronized (object) {
                object.wait();
            }
            System.out.println(getId() + " 아 잘잤다");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Object ob = new Object();

        WaitThread t1 = new WaitThread(ob);
        t1.start();

        Scanner sc = new Scanner(System.in);

        sc.nextLine();
        synchronized (ob) {
            ob.notifyAll();
        }

        sc.close();
    }
}
