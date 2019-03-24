package kissjgabor13ed;

import java.io.*;
import java.util.*;

/**
 *
 * @KjG
 */
public class KissJGabor13ED {

    private static RandomAccessFile f;
    private static final ArrayList<Tanulo> TANULO = new ArrayList<>();

    private static void inputFile(String label, String fileName, String mode) {
        try {
            f = new RandomAccessFile(fileName, mode);
            String sor;
            while ((sor = f.readLine()) != null) {
                TANULO.add(new Tanulo(sor));
            }
            f.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println(label + fileName + "... beolvasva\n");
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

    private static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    private static void f2(String label, String fileName, String mode) {
        deleteFile(fileName);
        for (int ii = 0; ii < TANULO.size(); ii++) {
            if (TANULO.get(ii).getOsztaly().equals("B")) {
                String str = TANULO.get(ii).getName();
                System.out.println(str);
                appendFile(fileName, mode, str);
            }
        }

        System.out.println(label + fileName + "... kiírva");
        System.out.println("");
    }

    private static void f3(String label) {
        int szumma = 0;
        for (int ii = 0; ii < TANULO.size(); ii++) {
            if (TANULO.get(ii).getNapilap().equals("Igen")) {
                szumma++;
            }
        }

        String str = label + szumma + " tanuló\n";

        System.out.println(str);
    }

    private static void f4(String label) {
        String name = "";
        int oldalak = 0;
        for (int ii = 0; ii < TANULO.size(); ii++) {
            if (TANULO.get(ii).getOldalak() > oldalak) {
                oldalak = TANULO.get(ii).getOldalak();
                name = TANULO.get(ii).getName();
            }
        }

        String str;

        for (int ii = 0; ii < TANULO.size(); ii++) {
            if (TANULO.get(ii).getOldalak() == oldalak) {
                str = label + TANULO.get(ii).getName();
                System.out.println(str);
            }
        }
        System.out.println("");
    }

    private static void f5(String label) {
        System.out.println(label);
        int pontok = 0;
        for (int ii = 0; ii < TANULO.size(); ii++) {
            if (TANULO.get(ii).getPontok() >= 120) {
                String str = TANULO.get(ii).getName();
                System.out.println(str);
            }
        }
    }

    public static void main(String[] args) {

        inputFile("1. A ", "txt/forras.txt", "r");
        f2("2. A ", "txt/B.txt", "rw");
        f3("3. napilap olvasók száma: ");
        System.out.println("extra1");
        f4("A legtöbb könyvet olvasott: ");
        System.out.println("extra2");
        f5("Könyvjutalmat kaptak: ");
        System.out.println("");
    }

}
