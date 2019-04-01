package java20190401inheritance;

import java.text.DecimalFormat;

/**
 *
 * @author KjG
 */
public class Printer {

    DecimalFormat df = new DecimalFormat("#.0");

    public String PrintPerimeterArea(Quadrat quadrat) {
        String str = "kerűlet: " + quadrat.perimeter() + " cm"
                + "\nterület: " + quadrat.area() + " cm²\n";

        System.out.println("kerület: " + quadrat.perimeter() + " cm"
                + "\nterület: " + quadrat.area() + " cm²");
        if (quadrat.getClass() == Square.class) {
            str += "beírhetó kör területe: "
                    + df.format(((Square) quadrat).getCircle()) + " cm²\n\n";

            System.out.println("beírhetó kör területe: "
                    + df.format(((Square) quadrat).getCircle()) + " cm²\n");
        } else {
            str += "\n";
            System.out.println("");
        }
        return str;
    }
}
