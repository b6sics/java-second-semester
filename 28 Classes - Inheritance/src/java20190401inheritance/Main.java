package java20190401inheritance;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author KjG
 */
public class Main {

    private static Square square;
    private static Rectangle rectangle;

    private static RandomAccessFile f;
    private static final String MODE_RW = "rw";
    private static final String DATARESULTS = "results/results.txt";

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
            str = str.replace("ő", String.valueOf((char) 245));
            str = str.replace("Ő", String.valueOf((char) 213));
            str = str.replace("ű", String.valueOf((char) 251));
            str = str.replace("Ű", String.valueOf((char) 219));
            str = str.replace("²", "2");
            f.writeBytes(str + "\n");
            f.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void f1() {
        square = new Square(5);
        rectangle = new Rectangle(5, 10);
    }

    private static void f2() {
        deleteFile(DATARESULTS);
        Printer printer = new Printer();
        appendFile(DATARESULTS, MODE_RW,
                printer.PrintPerimeterArea(square));
        appendFile(DATARESULTS, MODE_RW,
                printer.PrintPerimeterArea(rectangle));
    }

    public static void main(String[] args) {
        f1();
        f2();
    }

}
