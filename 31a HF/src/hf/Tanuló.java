package hf;

/**
 *
 * @author HF
 */
abstract public class Tanuló {

    private String név;
    private int évfolyam;

    public String getNév() {
        return név;
    }

    public int getÉvfolyam() {
        return évfolyam;
    }

    public Tanuló(String név, int évfolyam) {
        this.név = név;
        this.évfolyam = évfolyam;
    }

    abstract public String getkedvencTárgy();

    @Override
    public String toString() {
        return "név: " + név + "\n"
                + "évfolyam: " + évfolyam + "\n"
                + "kedvence: " + getkedvencTárgy() + "\n";
    }
}
