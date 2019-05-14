package tesztverseny;

import java.io.*;

public class MyIO extends Tesztverseny {

    private static RandomAccessFile f;

    public static void inputFile(String fileName, String mode) {
        try {
            String sor = "";
            f = new RandomAccessFile(fileName, mode);
            int i = 0;
            //1. az állomány 1. sorát a főmenübe küldjük
            while ((sor = f.readLine()) != null) {
                if (i == 0) {
                    goodReply = sor;
                    i++;
                } else {
                    players.add(new Player(sor));
                }
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
