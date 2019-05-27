package sajátnév1;


import java.util.ArrayList;

public class SajátNév1 {

    protected static final ArrayList<Adat> lista = new ArrayList<>();

    private static void f1(String label, String fileName, String mode) {
        System.out.println(label);
        // 1.saját fejlesztés a MyIO-ban és itt ***
        //*
        
        //*
        System.out.println("\tA " + fileName + "... beolvasva");
    }

    private static void f2(String label) {
        System.out.println(label);
        // 2. saját fejlesztés az Adat-ban és itt ***
        //*        
        
        //*
    }

    private static void f3(String label) {
        System.out.print(label);
        // 3. saját fejlesztés kiválogatás getKm szerint***
        String str = "";
        //*
        
        //*
        System.out.println(str + " ülésekben ültek.");
    }
    private static void f4(String label) {
        System.out.print(label);
        // 4. fejlesztés összegzés getFt-tal ***        
        int szumma = 0;
        //*
        
        //*
        System.out.println(szumma + " Ft");
    }

    public static void main(String[] args) {
        f1("1. Lista, osztály kialakítása, fájl beolvasása példányosítás", "txt\\eladott.txt", "r");
        f2("\n2. Az utolsó 3 jegyvásárló rekordja: ");
        f3("\n3. Akik végig utaztak a(z) "); 
        f4("\n4. A társaság bevétele: ");
              
    }

}
