package inheritance;

/**
 *
 * @author x
 */
abstract public class Dog {

    private String name, species;
    private int age;

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public Dog(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    protected int rnd(int lowerLim, int upperLim) {
        return (int) (Math.random() * (upperLim - lowerLim + 1)) + lowerLim;
    }

    public abstract String getPelage();

    public abstract String getProperty();

    @Override
    public String toString() {
        String str = species + " vagyok a nevem "
                + name + ", " + getProperty() + " "
                + age + " éves vagyok, szőrzetem: " + getPelage();
        return str;
    }
}
