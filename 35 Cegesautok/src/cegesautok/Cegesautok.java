package cegesautok;

import java.util.*;

public class Cegesautok {// alosztálya van: MyIO.class

    //protected az alosztály láthatja
    protected static final ArrayList<Car> cars = new ArrayList<>();

    private static void f1(String label, String fileName, String mode) {
        System.out.println(label);
        MyIO.inputFile(fileName, mode);
        System.out.println("\tA " + fileName + "... beolvasva");
    }

    private static void f2(String label) {
        System.out.println(label);
        String str = "";
        int ii = cars.size() - 1;
        while (cars.get(ii).getKi_be() != 0) {
            ii--;
        }
        str = "\t" + cars.get(ii).getNap() + ". nap renszám: " + cars.get(ii);

        System.out.println(str);
    }

    private static void f3(String label) {
        System.out.print(label);
        Scanner sc = new Scanner((System.in));
        String str = "";
        int nap = sc.nextInt();
        sc.nextLine();
        for (int ii = 0; ii < cars.size(); ii++) {
            if (cars.get(ii).getNap() == nap) {
                System.out.println("\t" + cars.get(ii));
            }
        }
    }

    private static void f4(String label) {
        System.out.println(label);
        String str = "";
        //4. kiválogatás-tétele: T=rendszám utolsó karaktere szerint
        int[] rsz = new int[10];
        for (int ii = 0; ii < cars.size(); ii++) {
            int dummy = Integer.
                    parseInt(cars.get(ii).getRendszám().substring(5));
            rsz[dummy] = cars.get(ii).getKi_be();
        }
        //5. megszámlálás-tétele
        System.out.println(str);
        int count = 0;
        for (int jj = 0; jj < rsz.length; jj++) {
            if (rsz[jj] == 0) {
                count++;
            }
        }
        str = "\t a hónap végén " + count + " autót nem hoztak vissza.";
        System.out.println(str);
    }

    private static void f5(String label) {
        System.out.println(label);
        int[] indul = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int[] befejez = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int hanyadik = 0;
        for (int ii = 0; ii < cars.size(); ii++) {
            int dummy = Integer.
                    parseInt(cars.get(ii).getRendszám().substring(5));
            if (indul[dummy] == -1) {
                indul[dummy] = cars.get(ii).getKm();
                hanyadik++;
            }
            if (hanyadik == 10) {
                break;
            }
        }
        hanyadik = 0;
        for (int ii = cars.size() - 1; ii > -1; ii--) {
            int dummy = Integer.
                    parseInt(cars.get(ii).getRendszám().substring(5));
            if (befejez[dummy] == -1) {
                befejez[dummy] = cars.get(ii).getKm();
                hanyadik++;
            }
            if (hanyadik == 10) {
                break;
            }
        }
        for (int ii = 0; ii < indul.length; ii++) {
            String s = "\tCEG30" + ii;
            s += " " + (befejez[ii] - indul[ii]);
            System.out.println(s + " km");
        }
    }

    private static void f6(String label) {
        System.out.println(label);
        String str;
        int[] indul = new int[10];
        int leghosszabb = 0;
        int id = 0;
        for (int ii = 0; ii < cars.size(); ii++) {
            int dummy = Integer.
                    parseInt(cars.get(ii).getRendszám().substring(5));
            if (cars.get(ii).getKi_be() == 0) {
                indul[dummy] = cars.get(ii).getKm();
            } else {
                if ((cars.get(ii).getKm() - indul[dummy]) > leghosszabb) {
                    leghosszabb = cars.get(ii).getKm() - indul[dummy];
                    id = cars.get(ii).getId();
                }
            }
        }

        for (int ii = 0; ii < cars.size(); ii++) {
            int dummy = Integer.
                    parseInt(cars.get(ii).getRendszám().substring(5));
            if (cars.get(ii).getKi_be() == 0) {
                indul[dummy] = cars.get(ii).getKm();
            } else {
                if ((cars.get(ii).getKm() - indul[dummy]) == leghosszabb) {
                    str = "\t" + (cars.get(ii).getKm() - indul[dummy])
                            + " km, személyID: " + cars.get(ii).getId();
                    System.out.println(str);
                }
            }
        }
    }

    private static void f7(String label, String fileName, String mode) {
        System.out.print(label);
        String str = "";
        int indul;
        Scanner sc = new Scanner((System.in));
        String rsz = sc.nextLine();
        MyIO.deleteFile("src/txt/" + rsz + fileName);
        String format = "%d %2d. %s %5d km";
        for (int ii = 0; ii < cars.size(); ii++) {
            if (cars.get(ii).getRendszám().equals(rsz)) {
                indul = cars.get(ii).getKm();
                if (cars.get(ii).getKi_be() == 0) {
                    str = String.format(format, cars.get(ii).getId(),
                            cars.get(ii).getNap(), cars.get(ii).getIdő(),
                            indul) + " - ";
                } else {
                    str += String.format(format, cars.get(ii).getId(),
                            cars.get(ii).getNap(), cars.get(ii).getIdő(),
                            cars.get(ii).getKm());
                    System.out.println("" + str);
                    MyIO.appendFile("src/txt/" + rsz + fileName, mode, str);
                    str = "";
                }
            }
        }
        if (!str.equals("")) {
            System.out.println(str);
            MyIO.appendFile("src/txt/" + rsz + fileName, mode, str);
        }
        System.out.println("\tAz src/txt/" + rsz + fileName + "... kész");
    }

    public static void main(String[] args) {
        f1("1. Lista, osztály kialakítása, fájl beolvasása példányosítás",
                "src/txt/adatok.txt", "r");
        f2("\n2. Feladat: ");
        f3("\n3. Melyik napi forgalom legyen? (1-30): ");
        f4("\n4. Feladat ");
        f5("\n5. Feladat ");
        f6("\n6. A leghosszabb út:");
        f7("\n7. Kérem a rendszámot (CEG300-CEG309): ", "_menetlevel.txt", "rw");
    }
}
