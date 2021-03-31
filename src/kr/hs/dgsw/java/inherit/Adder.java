package kr.hs.dgsw.java.inherit;

import java.util.Scanner;

public class Adder {
    private int operand1;
    private int operand2;

    public int calculate() {
        return operand1 + operand2;
    }

    public void display() {
        String str = String.format("%d %s %d = %d", operand1, getOperator(), operand2, calculate());
        System.out.println(str);
    }

    public String getOperator() {
        return "+";
    }

    public int getOperand1() {
        return operand1;
    }
    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("두 수를 입력하세요");
            Scanner sc = new Scanner(System.in);
            int fir = sc.nextInt();
            int sec = sc.nextInt();

            if (fir == 0 && sec == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            Adder adder = new Adder();
            adder.setOperand1(fir);
            adder.setOperand2(sec);
            adder.display();
        }
    }
}
