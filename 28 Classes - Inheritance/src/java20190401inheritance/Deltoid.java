package java20190401inheritance;

/**
 *
 * @author KjG
 */
public class Deltoid extends Quadrat {

    private int a;
    private int b;
    private int e;
    private int f;

    public Deltoid(int a, int b, int e, int f) {
        this.a = a;
        this.b = b;
        this.e = e;
        this.f = f;
    }

    @Override
    public int perimeter() {
        return 2 * (a + b);
    }

    @Override
    public int area() {
        return (e * f) / 2;
    }
}
