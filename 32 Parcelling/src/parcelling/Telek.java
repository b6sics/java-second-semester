package parcelling;

/**
 *
 * @author x
 */
public class Telek {

    private static final String REGEX = " ";
    private int hsz, szelesseg, hossz, terulet, ado;
    private boolean paros;

    public int getHsz() {
        return hsz;
    }

    public int getSzelesseg() {
        return szelesseg;
    }

    public int getHossz() {
        return hossz;
    }

    public int getTerulet() {
        return terulet;
    }

    public boolean isParos() {
        return paros;
    }

    public int getAdo() {
        return ado;
    }

    public Telek(String sor) {
        String[] t = sor.split(REGEX);
        this.hsz = Integer.parseInt(t[0]);
        this.szelesseg = Integer.parseInt(t[1]);
        this.hossz = Integer.parseInt(t[2]);
        this.terulet = szelesseg * hossz;
        this.paros = hsz % 2 == 0;
        this.ado = adotSzamol();
    }

    private int adotSzamol() {
        int toReturn = 700 * 51 + 300 * 39;
        if (terulet > 1000) {
            return toReturn + 2000;
        } else if (terulet > 700) {
            return toReturn - (1000 - terulet) * 39;
        } else {
            return terulet * 51;
        }
    }

    @Override
    public String toString() {
        return "\tházszám: " + hsz
                + "\n\tszelesség: " + szelesseg + " m"
                + "\n\thossz: " + hossz + " m"
                + "\n\tterület: " + terulet + " m2\n";
    }
}
