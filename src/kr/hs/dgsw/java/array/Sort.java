package kr.hs.dgsw.java.array;

import java.util.Random;

public abstract class Sort {
    private static final int SIZE = 100;

    protected int[] array = new int[SIZE];

    public void fillValues() {
        Random random = new Random();
        for(int i = 0;i<array.length;i++) {
            array[i] = random.nextInt(100000);
        }
    }

    public void printArray() {
        for(int i = 0;i<array.length;i++) {
            System.out.println(i + " : " + array[i]);
        }
    }

    public abstract void sort();


}
