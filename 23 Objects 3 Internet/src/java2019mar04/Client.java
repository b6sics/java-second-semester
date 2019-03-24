package java2019mar04;

/**
 *
 * @KjG
 */
public class Client {

    public String getId() {
        return id;
    }

    public boolean isSok() {
        return sok;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public int getSzumma() {
        return szumma;
    }

    public int getMennyivel() {
        return mennyivel;
    }

    private final int NAPOK = 31;

    private String id;
    private boolean sok;
    private int bandwidth, szumma, mennyivel;
    private int[] napok = new int[NAPOK];

    private void setSzummaSokMennyivel(String[] t) {
        int s = 0;
        for (int ii = 2; ii < t.length; ii++) {
            s += Integer.parseInt(t[ii]);
        }
        this.szumma = s;
        this.sok = (szumma > 10240);
        if (sok) {
            this.mennyivel = szumma - 10240;
        }else{
            this.mennyivel = 0;
        }
    }

    public Client(String sor) {
        String[] t = sor.split("\\s*;\\s*");
        this.id = t[0];
        this.bandwidth = Integer.parseInt(t[1]);
        setSzummaSokMennyivel(t);
    }

}
