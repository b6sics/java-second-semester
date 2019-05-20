package cegesautok;

public class Car {
    int nap, id, km, ki_be;
    String idő, rendszám;
    
    public Car(String rekord){
        //5 07:30 CEG300 590 30580 0
        String[]t = rekord.split(" ");
        this.nap = Integer.parseInt(t[0]); //int(5)
        this.idő = t[1]; //07:30
        this.rendszám = t[2]; //CEG300
        this.id = Integer.parseInt(t[3]); //int(590)
        this.km = Integer.parseInt(t[4]); // int(30580)
        this.ki_be=Integer.parseInt(t[5]); // int(0)
        
    }


    public int getKi_be() {
        return ki_be;
    }
    
    public int getNap() {
        return nap;
    }

    public int getId() {
        return id;
    }

    public int getKm() {
        return km;
    }

    public String getIdő() {
        return idő;
    }

    public String getRendszám() {
        return rendszám;
    }


    @Override
    public String toString() {
        return  idő + " " + rendszám + " " +km+" km "+ ki_be;
    }
     
}
