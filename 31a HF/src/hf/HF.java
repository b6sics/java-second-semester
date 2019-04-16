package hf;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KissJGabi
 */
public class HF {

    private static String[] nevek = {"Kiss János", "Nagy Fanni",
        "Tóth Elek", "Végh Pál", "Kovács Lajos"};
    private static String[] tantárgyak = {"Matematika", "Fizika"};
    private static List<Tanuló> faktorCsoport = new ArrayList<>();

    private static int rnd(int aH, int fH) {
        return (int) (Math.random() * (fH - aH + 1)) + aH;
    }

    private static void f1(String label) {
        System.out.println(label);
        for (int i = 0; i < nevek.length; i++) {
            String név = HF.nevek[i];
            int évfolyam = rnd(9, 12);
            String kedvencTantárgy = tantárgyak[rnd(0, 1)];
            faktorCsoport.add(new Faktos(név, évfolyam, kedvencTantárgy));
        }
        System.out.println("");
    }

    private static void f2(String label) {
        System.out.println(label);
        for (int i = 0; i < faktorCsoport.size(); i++) {
            System.out.println(faktorCsoport.get(i).toString());
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        f1("f1");
        f2("f2");
    }

}
