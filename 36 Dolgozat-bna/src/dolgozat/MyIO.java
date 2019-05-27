package dolgozat;

import java.io.*;

public class MyIO extends dolgozat {

    private static RandomAccessFile f;

    public static void inputFile(String fileName, String mode) {
        try {
            String line = "";
            f = new RandomAccessFile(fileName, mode);
            while ((line = f.readLine()) != null) {
                //------------------------

                lista.add(new Adat(line));

                //------------------------
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
            f.writeBytes(str + "\n");//kiír és ENTER
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
