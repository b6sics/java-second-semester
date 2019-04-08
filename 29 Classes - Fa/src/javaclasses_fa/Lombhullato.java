package javaclasses_fa;

/**
 *
 * @author x
 */
public class Lombhullato extends Fa {

    public Lombhullato(int eletkor) {
        // Az ős konstruktorát hívjuk a megadott paraméterekkel
        super(eletkor);
    }

    @Override
    public String getLevele(String evszak) {
        if (evszak.equals("tavasz")) {
            return "A lombhullató fák tavasszal hozzák leveleiket.";
        } else if (evszak.equals("nyár")) {
            return "A lombhullatók nyáron dúsan zöldellnek.";
        } else if (evszak.equals("ősz")) {
            return "A lombhullató fák levelei lehullanak.";
        } else if (evszak.equals("tél")) {
            return "A lombhullató fák ágai télen üresek.";
        } else {
            return "Ilyen évszakot nem ismerek!";
        }
    }
}
