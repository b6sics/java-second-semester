package java20190318;

/**
 *
 * @author KjG
 */
public class Worker {

    private String name, job;
    private int birthYear, payment;
    private boolean taxCredit;

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getPayment() {
        return payment;
    }

    public boolean isTaxCredit() {
        return taxCredit;
    }

    public Worker(String name, String job, int birthYear, int payment, boolean taxCredit) {
        this.name = name;
        this.job = job;
        this.birthYear = birthYear;
        this.payment = payment;
        this.taxCredit = taxCredit;
    }

}
