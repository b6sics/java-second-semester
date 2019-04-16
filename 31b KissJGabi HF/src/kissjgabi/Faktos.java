package kissjgabi;

/**
 *
 * @author KissJGabi
 */
public class Faktos extends Tanuló {

    private String kedvencTantárgy;

    public Faktos(String név, int évfolyam, String kedvencTantárgy) {
        super(név, évfolyam);
        this.kedvencTantárgy = kedvencTantárgy;
    }

    @Override
    public String getKedvencTárgy() {
        return kedvencTantárgy;
    }

}
