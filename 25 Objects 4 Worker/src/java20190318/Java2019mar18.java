package java20190318;

import java.io.*;
import java.util.*;

/**
 *
 * @author KjG
 */
public class Java2019mar18 {

    private static Worker GipszJakab;
    private static Worker SoosEeva;

    private static void f00(int hossz, char jel, String name) {
        int start = 0;
        if (name.length() != 0) {
            start = name.length() + 5;
            System.out.print(jel + "| ");
            System.out.print(name + " |");
        }
        for (int ii = start; ii < hossz; ii++) {
            System.out.print(jel);
        }
        System.out.println("");
    }
    // --- textdekoráció metódus vége

    private static void f1(String label) {
        f00(60, '-', label);
        GipszJakab = new Worker("Gipsz Jakab", "könyvelő", 1963, 150000, true);
        SoosEeva = new Worker("Soós Éva", "gyakornok", 1960, 130000, true);
        System.out.println("");
    }

    private static void f2(String label) {
        f00(60, '-', label);
        String str = SoosEeva.getJob();
        System.out.println("");
    }

    private static void f3(String label) {
        f00(60, '-', label);
        String str = GipszJakab.getName();
        if (SoosEeva.getPayment() > GipszJakab.getPayment()) {
            str = SoosEeva.getName();
        }
        System.out.println(str);
    }

    private static void f4(String label) {
        f00(60, '-', label);

        System.out.println("");
    }

    private static void f5(String label) {
        f00(60, '-', label);

        System.out.println("");
    }

    public static void main(String[] args) {
        f00(60, '*', "STARTofJAVA 2019mar18");
        f00(60, '-', "");

        f1("1. Gipsz Jakab és Soós Éva: ");
        f2("2. Soós Éva munkaköre: ");
        f3("3. Kinek nagyobb a fizetése: ");

        f00(60, '-', "");
        f00(60, '*', "ENDofJAVA   2019mar18");
    }

}
