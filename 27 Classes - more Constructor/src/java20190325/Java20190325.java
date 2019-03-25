package java20190325;

import java.util.*;

/**
 *
 * @author KjG
 */
public class Java20190325 {

    private static ArrayList<Quadrat> quadrats = new ArrayList<>();

    private static void f1(String label) {
        System.out.println(label);
        quadrats.add(new Quadrat("rectangle", 10, 22));
        quadrats.add(new Quadrat("square", 5));
        quadrats.add(new Quadrat("trapeze", 3, 5, 4, 10, 22));
        quadrats.add(new Quadrat("deltoid", 14, 6, 16, 14));
        quadrats.add(new Quadrat("trapeze", 6, 13, 6, 8, 8));
        quadrats.add(new Quadrat("deltoid", 7, 5, 9, 8));
        quadrats.add(new Quadrat("rectangle", 9, 8));
        System.out.println("Kész!");
    }

    private static void f2(String label, String name) {
        System.out.println(label);
        for (int ii = 0; ii < quadrats.size(); ii++) {
            if (quadrats.get(ii).getForm().equals(name)) {
                String str = "\t" + quadrats.get(ii).getForm();
                str += String.format(" %8.2f cm2", quadrats.get(ii).getArea());
                System.out.println(str);
            }
        }
        System.out.println("");
    }

    private static void f3(String label) {
        System.out.println(label);
        double sum = 0;
        int x = 0;
        for (int ii = 0; ii < quadrats.size(); ii++) {
            sum += quadrats.get(ii).getPerimeter();
            x++;
        }
        String str = String.format("\t %25.20f cm", sum / x);
        System.out.println(str);
        str = String.format("\t %25.20f cm", 100 * sum / x);
        System.out.println(str);
        str = String.format("\t %25.20f cm", 1.0 * ((int) (100 * sum / x)));
        System.out.println(str);
        str = String.format("\t %25.20f cm", ((int) (100 * sum / x)) / 100.0);
        System.out.println(str);
    }

    public static void main(String[] args) {
        f1("Lista feltöltése...");
        f2("Deltoid területek", "deltoid");
        f3("Négyszögek kerületének átlaga: ");
    }

}
