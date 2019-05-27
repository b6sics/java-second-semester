/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dolgozat;

import java.util.ArrayList;

/**
 *
 * @author KjG
 */
public class dolgozat {

    protected static final ArrayList<Adat> lista = new ArrayList<>();

    private static void f1(String label, String fileName, String mode) {
        System.out.println(label);
        //------------------------

        MyIO.inputFile(fileName, mode);

        //------------------------
        System.out.println("\tA " + fileName + "... beolvasva");
    }

    private static void f2(String label) {
        System.out.println(label);
        //------------------------

        System.out.println(lista.get(lista.size() - 1));
        System.out.println(lista.get(lista.size() - 2));
        System.out.println(lista.get(lista.size() - 3));

        //------------------------
    }

    private static void f3(String label) {
        System.out.print(label);
        // 3. saját fejlesztés kiválogatás getKm szerint***
        String str = "";
        //------------------------

        String vesszö = "";
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getKm() == 172) {
                str += vesszö + lista.get(i).getÜlés();
                vesszö = ", ";
            }
        }

        //------------------------
        System.out.println(str + " ülésekben ültek.");
    }

    private static void f4(String label) {
        System.out.print(label);
        // 4. fejlesztés összegzés getFt-tal ***        
        int szumma = 0;
        //------------------------

        for (int i = 0; i < lista.size(); i++) {
            szumma += lista.get(i).getFt();
        }

        //------------------------
        System.out.println(szumma + " Ft");
    }

    public static void main(String[] args) {
        f1("1. Lista, osztály kialakítása, fájl beolvasása példányosítás", "txt\\eladott.txt", "r");
        f2("\n2. Az utolsó 3 jegyvásárló rekordja: ");
        f3("\n3. Akik végig utaztak a(z) ");
        f4("\n4. A társaság bevétele: ");

    }

}
