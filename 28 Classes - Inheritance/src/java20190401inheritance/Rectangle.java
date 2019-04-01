package java20190401inheritance;

/**
 *
 * @author KjG
 */
public class Rectangle extends Quadrat {

    private int a;
    private int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int perimeter() {
        return 2 * (a + b);
    }

    @Override
    public int area() {
        return a * b;
    }
}
