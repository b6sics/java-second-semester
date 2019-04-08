package javaclasses_fa;

/**
 *
 * @author x
 */
public abstract class Fa {

    private int eletkor;

    public int getEletkor() {
        return eletkor;
    }

    public Fa(int eletkor) {
        this.eletkor = eletkor;
    }

    public abstract String getLevele(String evszak);

    @Override
    public String toString() {
        return getEletkor() + " év ";
    }
}
