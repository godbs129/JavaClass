package kr.hs.dgsw.java.tr1;

import java.util.Scanner;


public class Circle extends Polygon{

    private double radius;

    @Override
    public double getArea() {
        return radius * 2.0 * 3.14;
    }

    @Override
    public String getName() {
        return "원";
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle circle = new Circle();

        int rad = sc.nextInt();

        System.out.println("반지름을 입력하세요");
        circle.setRadius(rad);

        circle.printArea();
    }
}
