package inheritance;

/**
 *
 * @author x
 */
public class GreyHund extends Dog {

    private String[] properties = {"erős", "kitartó", "félénk",
        "elegáns", "gyors"};
    private String property, pelage;

    public GreyHund(String name, int age) {
        super(name, "Agár", age);
        this.property = properties[rnd(0, properties.length - 1)];
        this.pelage = "homokszínű és rövid";
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
