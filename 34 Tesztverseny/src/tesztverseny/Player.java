package tesztverseny;

public class Player {

    private String id, reply, formula;
    private int score;

    // konstruktor
    public Player(String sor) {
        String t[] = sor.split(" ");
        this.id = t[0];
        this.reply = t[1];
        this.score = 0;
        this.formula = setFormula();
    }

    public String getId() {
        return id;
    }

    public String getReply() {
        return reply;
    }

    public String getFormula() {
        return formula;
    }

    public int getScore() {
        return score;
    }

    private String setFormula() {
        //1. sorozatszámítás-tétele        
        String str = "";
        for (int i = 0; i < reply.length(); i++) {
            String s1 = reply.substring(i, i + 1);
            String s2 = Tesztverseny.goodReply.substring(i, i + 1);
            if (s1.equals(s2)) {
                str += "+";
                score += setScore(i+1);
            } else {
                str += " ";
            }
        }
        return str;
    }

    private int setScore(int i) {
        int s = 3;
        if (i == 14) {
            s = 6;
        } else if (i > 10) {
            s = 5;
        } else if (i > 5) {
            s = 4;
        }
        return s;
    }

    @Override
    public String toString() {
        String str = "";
        str += "\t" + Tesztverseny.goodReply + " : jó válasz\n"
                + "\t" + reply + " : saját válasz\n"
                + "\t" + formula + " : találati minta";
        return str;
    }
}
