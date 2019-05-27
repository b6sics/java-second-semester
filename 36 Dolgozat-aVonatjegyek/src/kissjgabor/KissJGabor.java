/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kissjgabor;

import java.util.ArrayList;

/**
 *
 * @author KjG
 */
public class KissJGabor {

    protected static final ArrayList<Adat> lista = new ArrayList<>();

    private static void f1(String label, String fileName, String mode) {
        System.out.println(label);
        MyIO.inputFile(fileName, mode);
        System.out.println("\tA " + fileName + "... beolvasva");
    }

    private static void f2(String label) {
        System.out.println(label);
        for (int ii = lista.size() - 1; ii >= lista.size() - 3; ii--) {
            System.out.println(lista.get(ii));
        }
    }

    private static void f3(String label) {
        System.out.print(label);
        // 3. saját fejlesztés kiválogatás getKm szerint***
        String str = "";
        boolean first = true;
        for (Adat adat : lista) {
            if (adat.getKm() == 172) {
                if (first) {
                    first = false;
                } else {
                    System.out.print(", ");
                }
                System.out.print(adat.getÜlés());
            }
        }
        System.out.println(str + " ülésekben ültek.");
    }

    private static void f4(String label) {
        System.out.print(label);
        // 4. fejlesztés összegzés getFt-tal ***        
        int szumma = 0;
        for (Adat adat : lista) {
            szumma += adat.getFt();
        }
        System.out.println(szumma + " Ft");
    }

    public static void main(String[] args) {
        f1("1. Lista, osztály kialakítása, fájl beolvasása példányosítás", "src/txt/eladott.txt", "r");
        f2("\n2. Az utolsó 3 jegyvásárló rekordja: ");
        f3("\n3. Akik végig utaztak a(z) ");
        f4("\n4. A társaság bevétele: ");

    }

}
