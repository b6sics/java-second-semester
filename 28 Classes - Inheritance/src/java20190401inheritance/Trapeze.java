package java20190401inheritance;

/**
 *
 * @author Kjg
 */
public class Trapeze extends Quadrat {

    private int a;
    private int b;
    private int c;
    private int d;
    private int m;

    public Trapeze(int a, int b, int c, int d, int m) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.m = m;
    }

    @Override
    public int perimeter() {
        return a + b + c + d;
    }

    @Override
    public int area() {
        return m * (a + c) / 2;
    }
}
