package inheritance;

/**
 *
 * @author x
 */
public class Main {

    private static Dog dogs[] = new Dog[70];
    private static String names[] = {"Argosz", "Bodri", "Csutak", "Dugó",
        "Elek", "Fickó", "Gyilkos", "Hurka", "Idétlen", "Jómadár", "Kántor",
        "Lajka", "Morzsi", "Nyakas", "Ordas", "Picúr", "Q", "Rex", "Sátán",
        "Tomtom", "Uborka", "Vendetta", "Xavier", "Yukon", "Zorró"};

    private static int rnd(int lowerLim, int upperLim) {
        return (int) (Math.random() * (upperLim - lowerLim + 1)) + lowerLim;
    }

    private static void f0(String label) {
        System.out.println("" + label);
        for (int ii = 0; ii < dogs.length; ii++) {
            int year = rnd(1, 10);
            String name = names[rnd(0, names.length - 1)];
            switch (rnd(0, 2)) {
                case 0:
                    dogs[ii] = new Puli(name, year);
                    break;
                case 1:
                    dogs[ii] = new Spaniel(name, year);
                    break;
                case 2:
                    dogs[ii] = new GreyHund(name, year);
                    break;
            }
            System.out.println(" " + dogs[ii]);
        }
        System.out.println("");
    }

    private static void f1(String label) {
        System.out.println("" + label);
        for (int ii = 0; ii < dogs.length; ii++) {
            if (dogs[ii].getAge() == 1) {
                System.out.println("" + dogs[ii]);
            }
        }
        System.out.println("");
    }

    private static void f2(String label) {
        System.out.println("" + label);
        for (int ii = 0; ii < dogs.length; ii++) {
            if (dogs[ii].getAge() < 5
                    && dogs[ii].getProperty().equals("vidám")) {
                System.out.println("" + dogs[ii]);
            }
        }
        System.out.println("");
    }

    private static void f3(String label) {
        System.out.println("" + label);
        for (int ii = 0; ii < dogs.length; ii++) {
            if (dogs[ii].getAge() > 6
                    && dogs[ii].getSpecies().equals("Puli")) {
                System.out.println("" + dogs[ii]);
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        f0("Adatok betöltése ...");
        f1("Az 1 éves kutyák listája");
        f2("Az 5 évnél fiatalabb vidám kutyák listája");
        f3("Az 6 évnél idősebb pulik listája");
    }
}
