package java2019mar04;

import java.io.*;
import java.util.*;

/**
 *
 * @KjG
 */
public class Java2019mar04 {

    private static RandomAccessFile f;
    private static final ArrayList<Client> CLIENTS = new ArrayList<>();

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

    private static void inputFile(String fileName, String mode) {
        try {
            f = new RandomAccessFile(fileName, mode);
            String sor;
            while ((sor = f.readLine()) != null) {
                CLIENTS.add(new Client(sor));
            }
            f.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("A " + fileName + "... beolvasva");
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

    private static void f1(String label, String fileName, String mode) {
        f00(60, '-', label);
        inputFile(fileName, mode);
        System.out.println("");
    }

    private static void f2(String label, String fileName, String mode) {
        f00(60, '-', label);
        deleteFile(fileName);
        for (int ii = 0; ii < CLIENTS.size(); ii++) {
            if (CLIENTS.get(ii).isSok()) {
                String str = String.format("%10s", CLIENTS.get(ii).getId()) + " ";
                str += String.format("%8s", CLIENTS.get(ii).getSzumma()) + " ";
                str += String.format("%6s", CLIENTS.get(ii).getMennyivel()) + " MB";
                System.out.println(str);
                appendFile(fileName, mode, str);
            }
        }

        System.out.println("");
    }

    private static void f3(String label) {
        f00(60, '-', label);
        int bound256 = 0, bound512 = 0, bound1000 = 0;
        for (int ii = 0; ii < CLIENTS.size(); ii++) {
            int x = CLIENTS.get(ii).getBandwidth();
            switch (x) {
                case 256:
                    bound256++;
                    break;
                case 512:
                    bound512++;
                    break;
                case 1000:
                    bound1000++;
                    break;
                default:
                    break;
            }
        }

        String str = "\t 256 MB: " + bound256 + "\n";
        str += "\t 512 MB: " + bound512 + "\n";
        str += "\t1000 MB: " + bound1000 + "\n";

        System.out.println(str);
    }

    public static void main(String[] args) {
        f00(60, '*', "STARTofJAVA 2019mar04 Internet");
        f00(60, '-', "");

        f1("1. ", "csv/adatforgalom.csv", "r");
        f2("2. ", "csv/tullepte.txt", "rw");
        f3("3. előfizetők száma sávszélességenként:");

        f00(60, '-', "");
        f00(60, '*', "ENDofJAVA   2019mar04");

    }

}
