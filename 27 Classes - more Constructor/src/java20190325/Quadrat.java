package java20190325;

/**
 *
 * @author KjG
 */
public class Quadrat {

    private String form;
    private double area, perimeter;

    public String getForm() {
        return form;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public Quadrat(String form, int a, int b) {
        this.form = form;
        this.area = a * b;
        this.perimeter = 2 * (a + b);
    }

    public Quadrat(String form, int a) {
        this.form = form;
        this.area = a * a;
        this.perimeter = 4 * a;
    }

    public Quadrat(String form, int a, int b, int c, int d, int m) {
        this.form = form;
        this.area = ((a + c) / 2) * m;
        this.perimeter = a + b + c + d;
    }

    public Quadrat(String form, int a, int b, int e, int f) {
        this.form = form;
        this.area = (e * f) / 2;
        this.perimeter = 2 * (a + b);
    }

}
