package enaplo; // ha kell, cserélni a Main package-ére!

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Student {

    private String name;
    private ArrayList<Integer> jegyek = new ArrayList<>();

    public Student(String sor) {
        String t[] = sor.split("\t");
        this.name = t[0];
        fillJegyek(t);
    }

    private void fillJegyek(String[] t) {
        for (int i = 1; i < t.length; i++) {
            jegyek.add(Integer.parseInt(t[i]));
        }
    }

    public void setJegyek(int x) {
        jegyek.add(x);
    }

    private String avg() {
        double x = 0;
        for (int i = 0; i < jegyek.size(); i++) {
            x += jegyek.get(i);
        }
        DecimalFormat df1 = new DecimalFormat("#.0");
        return df1.format(x / jegyek.size());
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getJegyek() {
        return jegyek;
    }

    @Override
    public String toString() {
        return name + " " + jegyek + " " + avg();
    }
}
