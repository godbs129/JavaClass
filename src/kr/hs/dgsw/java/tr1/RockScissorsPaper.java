package kr.hs.dgsw.java.tr1;

import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(가위/바위/보) 중 입력");
        String str = scanner.next();
        int value = new Random().nextInt(3);

        System.out.println("나: " + str);
        if(value == 0) {
            System.out.println("상대: 주먹");
        } else if(value == 1) {
            System.out.println("상대: 가위");
        } else if(value == 2) {
            System.out.println("상대: 보");
        }

        int ROCK = 0;
        int SCISSORS = 1;
        int PAPER = 2;
        switch (str) {
            case "가위":
                if (value == ROCK) {
                    System.out.println("패배");
                } else if (value == SCISSORS) {
                    System.out.println("비김");
                } else {
                    System.out.println("승리");
                }
                break;
            case "바위":
                if (value == ROCK) {
                    System.out.println("비김");
                } else if (value == SCISSORS) {
                    System.out.println("승리");
                } else {
                    System.out.println("패배");
                }
                break;
            case "보":
                if (value == ROCK) {
                    System.out.println("승리");
                } else if (value == SCISSORS) {
                    System.out.println("패배");
                } else {
                    System.out.println("비김");
                }
                break;
            default:
                System.out.println("잘못 입력함");
                break;
        }
    }
}
