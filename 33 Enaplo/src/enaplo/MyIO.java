package enaplo;

import java.io.*;

public class MyIO extends Enaplo { // ha Enaplo a projekt neve!

    private static RandomAccessFile f;

    public static void inputFile(String fileName, String mode) {
        try {
            String sor = "";
            f = new RandomAccessFile(fileName, mode);
            while ((sor = f.readLine()) != null) {
                students.add(new Student(sor));
            }
            f.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void appendFile(String fileName, String mode, String str) {
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

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}
