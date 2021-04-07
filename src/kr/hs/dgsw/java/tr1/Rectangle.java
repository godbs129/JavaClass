package kr.hs.dgsw.java.tr1;

public class Rectangle extends Polygon{

    private double bottom;
    private double height;

    @Override
    public double getArea() {
        return bottom * height;
    }

    @Override
    public String getName() {
        return "직각사각형";
    }

    public double getHeight() {
        return height;
    }

    public double getBottom() {
        return bottom;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();

        rectangle.setBottom(8);
        rectangle.setHeight(5);

        rectangle.printArea();
    }
}
