package kr.hs.dgsw.java.tr1;

import java.util.Scanner;

public class Triangle extends Polygon{
    private double bottom;
    private double height;

    @Override
    public double getArea() {
        return bottom * height / 2.0;
    }

    @Override
    public String getName() {
        return "삼각형";
    }

    public double getBottom() {
        return bottom;
    }

    public double getHeight() {
        return height;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Triangle triangle = new Triangle();

        System.out.println("밑면 길이를 입력하세요");
        int bot = sc.nextInt();
        System.out.println("높이 길이를 입력하세요");
        int hei = sc.nextInt();

        triangle.setBottom(bot);
        triangle.setHeight(hei);

        triangle.printArea();
    }
}
