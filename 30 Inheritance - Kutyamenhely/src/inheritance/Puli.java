package inheritance;

/**
 *
 * @author x
 */
public class Puli extends Dog {

    private String pelage, property;

    public Puli(String név, int kora) {
        super(név, "Puli", kora);
        this.property = "terelek";
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
