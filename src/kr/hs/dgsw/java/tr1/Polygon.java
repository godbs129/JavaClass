package kr.hs.dgsw.java.tr1;

public abstract class Polygon {
    public abstract double getArea();

    public String getName() {
        return "다각형";
    }

    public void printArea() {
        System.out.println(getName() + "의 면적: " + getArea());
    }
}
