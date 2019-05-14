package tesztverseny;
//e_170515

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Tesztverseny {

    protected static final ArrayList<Player> players = new ArrayList<>(); // protected a leszármazott láthatja
    static Scanner sc = new Scanner((System.in)); // input    
    public static String goodReply;// public a példányok láthatják
    // --- TAGVÁLTOZÓK VÉGE ---  

    private static void f1(String label, String fileName, String mode) {
        System.out.println(label);
        //1. a MyIO (kiterjesztett) osztály  metódusának elérése        
        MyIO.inputFile(fileName, mode);
        System.out.println("\tA " + fileName + "... beolvasva");
    }

    private static void f2(String label) {
        System.out.print(label);
        //2. a lista méretét kell kiírni
        System.out.println(players.size() + " fő");
    }

    private static void f3(String label) {
        System.out.println(label);
        Scanner sc = new Scanner((System.in), "ISO-8859-2");
        System.out.print("   Versenyző kódja (AB123 BF417 ZZ240): ");
        String id = sc.nextLine();
        int i = 0;
        //3. kiválasztás-tétele
        while (!players.get(i).getId().equals(id)) {
            i++;
        }
        System.out.println(players.get(i));
    }

    private static void f4(String label) {
        System.out.println(label);
        Scanner sc = new Scanner((System.in), "ISO-8859-2");
        System.out.print("   A feladat száma: ");
        int x = sc.nextInt();
        int count = 0;
        for (int i = 0; i < players.size(); i++) {
            String s = players.get(i).getFormula().substring(x - 1, x);
            if (s.equals("+")) {
                count++;
            }
        }
        DecimalFormat df = new DecimalFormat("#.00");
        String str = "\tJól válaszolt: " + count + " fő, ez a versenyzők "
                + df.format(count * 100.0 / players.size()) + " %-a";
        System.out.println(str);

    }

    private static void f5(String label, String fileName, String mode) {
        System.out.print(label);
        MyIO.deleteFile(fileName);
        players.forEach((player) -> {
            MyIO.appendFile(fileName, mode,
                    player.getId() + " " + player.getScore());
        });
        System.out.println("\tA " + fileName + "... kész");
    }

    private static void f6(String label) {
        System.out.println(label);
        int h[] = new int[3], dummy;
        for (Player player : players) {
            dummy = player.getScore();
            if (h[2] < dummy && h[1] > dummy) {
                h[2] = dummy;
            }
            if (h[1] < dummy && h[0] > dummy) {
                h[2] = h[1];
                h[1] = dummy;
            }
            if (h[0] < dummy) {
                h[2] = h[1];
                h[1] = h[0];
                h[0] = dummy;
            }
        }
        String format = "%d.díj (%d pont): %s\n";
        for (int j = 1; j <= 3; j++) {
            for (Player p : players) {
                if (p.getScore() == h[j - 1]) {
                    System.out.printf(format, j, p.getScore(), p.getId());
                }
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        f1("1. Lista, osztály kialakítása, fájl beolvasása példányosítás",
                "src/txt/valaszok.txt", "r");
        f2("\n2. Résztvevők létszáma: ");
        f3("\n3. Kérem a versenyző kódját: ");
        f4("\n4. Kérem a feladat sorszámát (1-14): ");
        f5("\n5. Pontszámok: ", "src/txt/pontok.txt", "rw");
        f6("\n6. A verseny legjobbjai: ");
    }
}
