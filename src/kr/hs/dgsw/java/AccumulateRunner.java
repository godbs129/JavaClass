package kr.hs.dgsw.java;

import java.util.Scanner;

public class AccumulateRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Accumulate accumulate = new Accumulate();

        while (true) {

            System.out.println("정수를 입력하세요.");
            int value = scanner.nextInt();

            // if (value == -9999) 상수를 앞에둬서 실수로 assign되지 않게 한다.
            if (-9999 == value) {
                break;
            }
            accumulate.add(value);
            accumulate.display();

        }

        System.out.println("종료");

        scanner.close();

    }
}
