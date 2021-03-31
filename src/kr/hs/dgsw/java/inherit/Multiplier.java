package kr.hs.dgsw.java.inherit;

import java.util.Scanner;

public class Multiplier extends Adder{
    @Override
    public int calculate() {
        return getOperand1() * getOperand2();
    }

    @Override
    public void display() {
        String str = String.format("%d %s %d = %d", getOperand1(), getOperator(), getOperand2(), calculate());
        System.out.println(str);
    }

    @Override
    public String getOperator() {
        return "*";
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("두 수를 입력하세요");
            Scanner sc = new Scanner(System.in);
            int fir = sc.nextInt();
            int sec = sc.nextInt();

            if (fir == 0 && sec == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            Multiplier multiplier = new Multiplier();
            multiplier.setOperand1(fir);
            multiplier.setOperand2(sec);

            multiplier.display();
        }
    }
}
