package kr.hs.dgsw.java.exam;

import java.util.Random;
import java.util.Scanner;

public class NumberBaseball {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int[] me = new int[3];
        int[] rand = new int[3];

        for (int i = 0; i < 3; i++) {
            rand[i] = random.nextInt(9);
            for (int j = 0; j < i; j++) {
                if (rand[i] == rand[j]) {
                    i--;
                }
            }
        }

        int strike = 0;
        int ball = 0;
        while (true) {
            for (int i = 0; i < 3; i++) {
                System.out.print(i + 1 + "번째 숫자를 입력하세요 > ");
                me[i] = sc.nextInt();

                if (me[i] > 9) {
                    System.out.println("다시 입력하세요");
                    i--;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (me[i] == rand[i]) {
                    strike++;
                    continue;
                }
                for (int j = 0; j < 3; j++) {
                    if(me[i] == rand[j]) {
                        ball++;
                    }
                }
            }

            if (strike == 3) {
                System.out.println("축하합니다. 숫자를 맞췄습니다.");
                return;
            }

            if(strike + ball == 0) {
                System.out.println("아웃\n");
            } else {
                System.out.println(strike + "S" + ball + "B입니다");
            }

            strike = 0;
            ball = 0;
        }
    }
}
