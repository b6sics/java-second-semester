package inheritance;

/**
 *
 * @author x
 */
public class Spaniel extends Dog {

    private static String properties[] = {"szeretetteljes",
        "embercentrikus", "vidám", "társaságkedvelő", "hűséges"};
    private String property, pelage;

    public Spaniel(String név, int kora) {
        super(név, "Spániel", kora);
        this.property = properties[rnd(0, properties.length - 1)];
        this.pelage = "hosszú selymes";
    }

    @Override
    public String getPelage() {
        return pelage;
    }

    @Override
    public String getProperty() {
        return property;
    }
}
