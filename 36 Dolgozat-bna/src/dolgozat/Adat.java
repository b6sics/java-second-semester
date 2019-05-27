package dolgozat;

public class Adat {

    int ülés, mettől, meddig;
    int ft, km;

    public Adat(String line) {
        String[] t = line.split(" ");
        this.ülés = Integer.parseInt(t[0]);
        this.mettől = Integer.parseInt(t[1]);
        this.meddig = Integer.parseInt(t[2]);
        this.km = meddig - mettől; // megtett út
        this.ft = setFt();
    }

    private int setFt() {
        int x = km / 10;
        //1. fejlesztés: az f2(), f4()-s feladathoz kell
        //------------------------

        if (x * 10 != km) {
            x++;
        }

        //------------------------
        return x * 70;
    }

    public int getFt() {
        return ft;
    }

    public int getKm() {
        return km;
    }

    public int getÜlés() {
        return ülés;
    }

    public int getMettől() {
        return mettől;
    }

    public int getMeddig() {
        return meddig;
    }

    @Override
    public String toString() {
        // 2. fejlesztés: az f2()-s feladathoz kell
        String str = "";
        //------------------------

        str = "ülés: " + ülés + "   távolság: " + km + "km   jegyár: " + ft;

        //------------------------
        return str;
    }

}
