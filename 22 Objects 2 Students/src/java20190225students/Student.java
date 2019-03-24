package java20190225students;

/**
 *
 * @KjG
 */
public class Student {

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public double getTti() {
        return tti;
    }

    public int getKg() {
        return kg;
    }

    private String name, gender;
    private double height, tti;
    private int kg;

    private static double tti(int kg, double m) {
        return Math.round(100 * (1.3 * kg / (Math.pow(m, 2.5)))) / 100.0;
    }

    public Student(String sor) {
        String[] t = sor.split("\\s*\t\\s*");
        this.name = t[0];
        this.gender = t[1];
        this.height = Integer.parseInt(t[2]) / 100.0;
        this.kg = Integer.parseInt(t[3]);
        this.tti = tti(this.kg, this.height);
    }

}
