package Core;

public class Monom implements Comparable<Monom>{
    private double coef;
    private int putere;

    public Monom()
    {

    }

    public Monom(double coef, int putere)
    {
        this.coef = coef;
        this.putere = putere;
    }

    public Monom(String s) {
        int nr = 0;
        for (String val: s.split( "x\\^")) {
            //System.out.println("valoare coef + putere: " + val);
            if(nr % 2 == 0)
                this.coef = Double.parseDouble(val);
            else if(nr % 2 == 1)
                this.putere = Integer.parseInt(val);
            nr++;
        }
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public int compareTo(Monom m)
    {
        return m.getPutere() - this.getPutere();
    }
}
