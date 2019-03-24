package kissjgabor13ed;

/**
 *
 * KjG
 */
public class Tanulo {

    private String name, osztaly, napilap;
    private int szinhaz, mozi, oldalak, pontok;

    public Tanulo(String sor) {
        String[] t = sor.split("\\s*\t\\s*");
        this.name = t[0];
        this.osztaly = t[1];
        this.szinhaz = Integer.parseInt(t[2]);
        this.mozi = Integer.parseInt(t[3]);
        this.napilap = t[4];
        this.oldalak = Integer.parseInt(t[5]);
        this.pontok = this.szinhaz*10 + this.mozi*5 + this.oldalak/10;
    }

    public int getPontok() {
        return pontok;
    }

    public String getName() {
        return name;
    }

    public String getOsztaly() {
        return osztaly;
    }

    public String getNapilap() {
        return napilap;
    }

    public int getSzinhaz() {
        return szinhaz;
    }

    public int getMozi() {
        return mozi;
    }

    public int getOldalak() {
        return oldalak;
    }

}
