package javaclasses_fa;

/**
 *
 * @author KjG
 */
public class JavaClasses_Fa {

    private static Fa erdo[] = new Fa[50];

    private static void f1() {
        for (int ii = 0; ii < 14; ii++) {
            int year = (int) ((Math.random() * (50 - 10 + 1)) + 10);
            erdo[ii] = new Orokzold(year);
        }

        for (int ii = 14; ii < 30; ii++) {
            int year = (int) ((Math.random() * (35 - 10 + 1)) + 10);
            erdo[ii] = new Lombhullato(year);
        }
    }

    private static void f2(String label) {
        System.out.println(label);
        for (int ii = 0; erdo[ii] != null; ii++) {
            if (erdo[ii].getEletkor() > 29) {
                System.out.println("\t" + ii + ". "
                        + erdo[ii].getEletkor() + " év "
                        + erdo[ii].getLevele("tél"));
                System.out.println("\t" + ii + ". "
                        + erdo[ii] + erdo[ii].getLevele("tél"));
            }
        }
    }

    public static void main(String[] args) {
        f1();
        f2("Kiíratás 29 évesnél idősebb fák");
    }

}
