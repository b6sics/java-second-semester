package javaclasses_fa;

/**
 *
 * @author x
 */
public class Orokzold extends Fa {

    public Orokzold(int eletkor) {
        super(eletkor);
    }

    @Override
    public String getLevele(String evszak) {
        return "Az örökzöldeknek minden évszakban vannak lévelei";
    }
}
