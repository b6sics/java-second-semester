package kissjgabi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KissJGabi
 */
public class KissJGabi {

    private static final int EVOLYAM_MIN = 9;
    private static final int EVOLYAM_MAX = 12;

    private static final String NEVEK[] = {"Kiss János", "Nagy Fanni",
        "Tóth Elek", "Végh Pál", "Kovács Lajos"};

    private static final String TANTARGYAK[] = {"Matematika", "Fizika"};

    private static final List<Tanuló> FAKTORCSOPORT = new ArrayList<>();

    private static int rnd(int max, int min) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    private static void f1(String label) {
        System.out.println(label);
        for (String név : NEVEK) {
            int évfolyam = rnd(EVOLYAM_MAX, EVOLYAM_MIN);
            String kedvencTantárgy = TANTARGYAK[rnd(TANTARGYAK.length - 1, 0)];
            FAKTORCSOPORT.add(new Faktos(név, évfolyam, kedvencTantárgy));
        }
        System.out.println("");
    }

    private static void f2(String label) {
        System.out.println(label);
        FAKTORCSOPORT.forEach((f) -> {
            System.out.println(f.toString());
        });
        System.out.println("");
    }

    public static void main(String[] args) {
        f1("Adatbevitel... ...kész!");
        f2("A faktorcsoport névsora:");
    }

}
