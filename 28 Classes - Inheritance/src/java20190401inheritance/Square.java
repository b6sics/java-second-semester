package java20190401inheritance;

/**
 *
 * @author KjG
 */
public class Square extends Quadrat {

    private int a;
    private double circle;

    public Square(int a) {
        this.a = a;
        this.circle = (a / 2) * (a / 2) * 3.14;
    }

    public double getCircle() {
        return circle;
    }

    @Override
    public int perimeter() {
        return 4 * a;
    }

    @Override
    public int area() {
        return a * a;
    }
}
