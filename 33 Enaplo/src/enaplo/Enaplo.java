package enaplo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author x
 */
public class Enaplo {

    protected static final ArrayList<Student> students = new ArrayList<>();  // protected legyen!

    private static void f1(String label, String fileName, String mode) {
        System.out.println(label);
        MyIO.inputFile(fileName, mode);
        System.out.println("\tA " + fileName + "... beolvasva");
    }

    private static void f2(String label) {
        System.out.println(label);
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    private static void updateTxt(String fileName, String mode) {
        MyIO.deleteFile(fileName);
        String str;
        for (int i = 0; i < students.size(); i++) {
            str = students.get(i).getName();
            for (int j = 0; j < students.get(i).getJegyek().size(); j++) {
                str += "\t" + students.get(i).getJegyek().get(j);
            }
            MyIO.appendFile(fileName, mode, str);
        }
    }

    private static void f3(String label, String fileName, String mode) {
        System.out.println(label);
        //órán
        Scanner sc = new Scanner((System.in), "ISO-8859-2");
        System.out.print("\tTanuló neve: ");
        String name = sc.nextLine();
        System.out.print("\tTanuló jegye: ");
        int jegy = sc.nextInt();

        int i = 0;
        while (!students.get(i).getName().equals(name)) {
            i++;
        }
        students.get(i).setJegyek(jegy);
        System.out.println("\t" + students.get(i));
        updateTxt(fileName, mode);
    }

    public static void main(String[] args) {
        f1(" 1. lista, osztály kialakítása, fájl beolvasása példányosítás", "src/txt/enaplo.txt", "r");
        f2(" \n2. napló kiírása ");
        f3(" \n3. új jegy adása ", "src/txt/enaplo.txt", "rw");
    }
}
