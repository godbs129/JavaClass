package kr.hs.dgsw.java;

public class Accumulate {
    int sum = 0;

    public void add(int value) {
        sum += value;
    }

    public void display() {
        System.out.println("누적값 : " + sum);
    }
}