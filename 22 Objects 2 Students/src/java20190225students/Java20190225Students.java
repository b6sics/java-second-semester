package java20190225students;

import java.io.*;
import java.util.*;

/**
 *
 * @KjG
 */
public class Java20190225Students {

    private static RandomAccessFile f;
    private static final ArrayList<Student> STUDENTS = new ArrayList<>();

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
                STUDENTS.add(new Student(sor));
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
        for (int ii = 0; ii < STUDENTS.size(); ii++) {
            if (STUDENTS.get(ii).getGender().equals("L")) {
                String str = String.format("%20s", STUDENTS.get(ii).getName());
                System.out.println(str);
                appendFile(fileName, mode, str);
            }
        }

        System.out.println("");
    }

    private static void f3(String label) {
        f00(60, '-', label);
        for (int ii = 0; ii < STUDENTS.size(); ii++) {
            if (STUDENTS.get(ii).getHeight() > 1.7) {
                String str = String.format("%20s", STUDENTS.get(ii).getName());
                str += String.format(": %5.2f m", STUDENTS.get(ii).getHeight());
                System.out.println(str);
            }
        }

        System.out.print("");
    }

    private static void f4(String label) {
        f00(60, '-', label);
        double szum = 0;
        for (int ii = 0; ii < STUDENTS.size(); ii++) {
            szum += STUDENTS.get(ii).getHeight();
        }
        String str = String.format("%5.2f", szum / STUDENTS.size());

        System.out.print(str + " m.\n");
    }

    public static void main(String[] args) {
        f00(60, '*', "STARTofJAVA 2019feb25 StudentsTTI");
        f00(60, '-', "");

        f1("1. ", "txt/adatok.txt", "r"); //közösen;
        f2("2. ", "txt/girls.txt", "rw"); //közösen;
        f3("3. A 1,70 m-nél magasabbak"); //egyéni;
        f4("4. Az osztály átlagmagassága"); //egyéni;

        f00(60, '-', "");
        f00(60, '*', "ENDofJAVA   2019feb25");
    }

}
