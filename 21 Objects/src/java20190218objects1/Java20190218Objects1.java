package java20190218objects1;

import java.io.*;
import java.util.*;

/**
 *
 * @KjG
 */
public class Java20190218Objects1 {

    private static RandomAccessFile f;
    private static final ArrayList<Diak> DIAKOK = new ArrayList<>();
    private static int letszam = 0;

    private static double tti(int kg, int m) {
        return 1.3 * (double) kg / (Math.pow((double) m / 100, 2.5));
    }

    public static final class Diak {

        int index;
        String nev;
        int magas;
        int suly;
        double tti;

        public Diak(String sor, int index) {
            setIndex(index);
            List<String> items = Arrays.asList(sor.split("\\s*\t\\s*"));
            setNev(items.get(0));
            setMagas(Integer.valueOf(items.get(1)));
            setSuly(Integer.valueOf(items.get(2)));
            setTti(tti(this.suly, this.magas));
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getNev() {
            return nev;
        }

        public void setNev(String nev) {
            this.nev = nev;
        }

        public int getMagas() {
            return magas;
        }

        public void setMagas(int magas) {
            this.magas = magas;
        }

        public int getSuly() {
            return suly;
        }

        public void setSuly(int suly) {
            this.suly = suly;
        }

        public double getTti() {
            return tti;
        }

        public void setTti(double tti) {
            this.tti = tti;
        }

        public void kiir() {
            String str = String.format("Név: %16s ", this.nev);
            System.out.println(str);
            str = "magasság: " + this.magas;
            str += ", testsúly " + this.suly;
            str += String.format(", tti:%6.2f ", this.tti);
            System.out.println(str);
        }
    }

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

    private static void f01(String label, String sor) {
        f00(60, '-', label);
        DIAKOK.add(new Diak(sor, letszam));
        letszam++;
        DIAKOK.get(DIAKOK.size() - 1).kiir();
        System.out.println("");
    }

    private static void f02(String label, String sor) {
        f00(60, '-', label);
        List<String> items = Arrays.asList(sor.split("\\s*\t\\s*"));
        int index = -1;
        for (Diak diak : DIAKOK) {
            if (diak.nev.equals(items.get(0))) {
                index = diak.index;
            }
        }
        DIAKOK.get(index).suly = Integer.valueOf(items.get(1));
        DIAKOK.get(index).setTti(tti(DIAKOK.get(index).suly, DIAKOK.get(index).magas));
        DIAKOK.get(index).kiir();
        System.out.println("");
    }

    private static void f03(String label, String sor) {
        f00(60, '-', label);
        List<String> items = Arrays.asList(sor.split("\\s*\t\\s*"));
        int index = -1;
        for (Diak diak : DIAKOK) {
            if (diak.nev.equals(items.get(0))) {
                index = diak.index;
            }
        }
        DIAKOK.get(index).magas = Integer.valueOf(items.get(1));
        DIAKOK.get(index).setTti(tti(DIAKOK.get(index).suly, DIAKOK.get(index).magas));
        DIAKOK.get(index).kiir();
        System.out.println("");
    }

    private static void f04(String label, String sor) {
        f00(60, '-', label);
        List<String> items = Arrays.asList(sor.split("\\s*\t\\s*"));
        int index = -1;
        for (Diak diak : DIAKOK) {
            if (diak.nev.equals(items.get(0))) {
                index = diak.index;
            }
        }
        DIAKOK.get(index).magas = Integer.valueOf(items.get(1));
        DIAKOK.get(index).suly = Integer.valueOf(items.get(2));
        DIAKOK.get(index).setTti(tti(DIAKOK.get(index).suly, DIAKOK.get(index).magas));
        DIAKOK.get(index).kiir();
        System.out.println("");
    }

    public static void main(String[] args) {
        f00(60, '*', "STARTofJAVA 2019feb18 Obektumok");
        f00(60, '-', "");

        f01("Új tanulo hozzáadása", "Kovács Éva \t  168 \t 60");
        f01("Új tanulo hozzáadása", "Kerekes Kati \t  162 \t 62");
        f02("Adat változtatása - testsúly", "Kerekes Kati \t64");
        f03("Adat változtatása - magasság", "Kovács Éva \t164");
        f01("Adatok változtatása", "Kerekes Kati \t162 \t 59");

        f00(60, '-', "");
        f00(60, '*', "ENDofJAVA   2019feb18");
    }

}
