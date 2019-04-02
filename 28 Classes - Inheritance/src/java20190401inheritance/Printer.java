package java20190401inheritance;

import java.text.DecimalFormat;

/**
 *
 * @author KjG
 */
public class Printer {

    DecimalFormat df = new DecimalFormat("#.0");

    public String PrintPerimeterArea(Quadrat quadrat) {
        String str = quadrat.getName() + ": \n"
                + "kerület: " + quadrat.perimeter() + " cm"
                + "\nterület: " + quadrat.area() + " cm²\n";
        if (quadrat.getClass() == Square.class) {
            str += "a beírhetó kör területe: "
                    + df.format(((Square) quadrat).getCircle()) + " cm²\n\n";
        } else {
            str += "\n";
        }
        System.out.println(str);
        return str;
    }
}
