package kr.hs.dgsw.java;

import java.util.Scanner;

public class ScannerStudy {
    public static void main(String[] args) {

        System.out.println("step 1");
        Scanner sc = new Scanner(System.in);
        System.out.println("step 2");

        int i = sc.nextInt();
        float f = sc.nextFloat();
        double d = sc.nextDouble();

        System.out.println("step3");
        System.out.println("input : " + i);
        System.out.println(f);
        System.out.println(d);
    }
}
