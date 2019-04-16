package kissjgabi;

/**
 *
 * @author KissJGabi
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

    abstract public String getKedvencTárgy();

    @Override
    public String toString() {
        return "\nnév: " + név
                + "\névfolyam: " + évfolyam
                + "\nkedvence: " + getKedvencTárgy();
    }
}
