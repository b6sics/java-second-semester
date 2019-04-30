package parcelling;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author x
 */
public class Parcelling {

    private static RandomAccessFile f;
    private static final ArrayList<Telek> telkek = new ArrayList<>();

    private static void inputFile(String label, String fileName, String mode) {
        try {
            f = new RandomAccessFile(fileName, mode);
            String sor;
            while ((sor = f.readLine()) != null) {
                telkek.add(new Telek(sor));
            }
            f.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println(label + fileName + "... beolvasva\n");
    }

    private static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    private static void appendFile(String fileName, String mode, String str) {
        try {
            f = new RandomAccessFile(fileName, mode);
            f.seek(f.length());//a fájlmutatót a fájl végére mozgatja
            f.writeBytes(str + "\n");
            f.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void f2(String label) {
        System.out.println(label);
        int hossz = 160;
        for (int ii = 0; ii < telkek.size(); ii++) {
            hossz += telkek.get(ii).getSzelesseg();
        }
        System.out.println("\ta futókör hossza: " + hossz + " m\n");
    }

    private static void f3(String label) {
        System.out.println(label);
        int maxIndex = 0;
        for (int ii = 1; ii < telkek.size(); ii++) {
            if (telkek.get(maxIndex).getTerulet() < telkek.get(ii).getTerulet()) {
                maxIndex = ii;
            }
        }
        System.out.println(telkek.get(maxIndex));
    }

    private static void f4(String label) {
        System.out.println(label);
        int count = 0;
        for (int ii = 1; ii < telkek.size(); ii++) {
            if (telkek.get(ii).isParos() && telkek.get(ii).getSzelesseg() < 21) {
                count++;
            }
        }
        System.out.println("A páros úton " + count + " telken kell teljes"
                + " utcafront beépítést alkalmazni.\n");
    }

    private static void f5(String label) {
        System.out.println(label);
        int maxIndex = 0, minIndex = 0; // de páratlan oldalon kell legyen
        for (int ii = 1; ii < telkek.size(); ii++) {
            if (!telkek.get(ii).isParos()) {
                if (telkek.get(minIndex).getTerulet()
                        > telkek.get(ii).getTerulet()) {
                    minIndex = ii;
                }
                if (telkek.get(maxIndex).getTerulet()
                        < telkek.get(ii).getTerulet()) {
                    maxIndex = ii;
                }
            }
        }
        System.out.println("A legnagyobb telek:\n" + telkek.get(maxIndex));
        System.out.println("A legkisebb telek:\n" + telkek.get(minIndex));
        System.out.print("A köztük lévő házszámok:");
        for (int ii = telkek.get(minIndex).getHsz() + 2;
                ii < telkek.get(maxIndex).getHsz(); ii++) {
            System.out.print(" " + ii++);
        }
        System.out.println("\n");
    }

    private static void f6(String label, String fileName, String mode) {
        System.out.print(label);
        deleteFile(fileName);
        Collections.sort(telkek, (o1, o2) -> {
            return o1.getHsz() - o2.getHsz();
        });
        String str;
        for (Telek telek : telkek) {
            if (!telek.isParos()) {
                str = telek.getHsz() + "; ";
                str += telek.getTerulet() + " m2; ";
                str += telek.getAdo() + " Ft";
                appendFile(fileName, mode, str);
            }
        }
        System.out.println(fileName + "... kiírva\n");
    }

    public static void main(String[] args) {
        inputFile("1. beolvasás: az ", "src/txt/adatok.txt", "r");
        f2("2. feladat:");
        f3("3. a legnagyobb telek adatai: ");
        f4("4. feladat:");
        f5("5. feladat:");
        f6("6. kiíratás: az ", "src/txt/paratlanut.txt", "rw");
    }
}
