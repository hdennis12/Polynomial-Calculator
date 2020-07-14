package MVC;

import java.util.*;

import Core.*;

public class Model {
    private Polinom rezultat;
    private Polinom rezultatDiv;
    private Polinom rest;

    public void polynomialAddition(Polinom p, Polinom q) {

        /*for (Monom m : p.getMon_list())
            System.out.print(m.getCoef() + "x^" + m.getPutere() + " ");
        System.out.println();
        for (Monom m : q.getMon_list())
            System.out.print(m.getCoef() + "x^" + m.getPutere() + " ");
        System.out.println();
        */

        Collections.sort(p.getMon_list(), Collections.reverseOrder());
        Collections.sort(q.getMon_list(), Collections.reverseOrder());
        if (p.isGreaterThan(q) == 1) {
            rezultat = new Polinom(p);
            for (Monom m : q.getMon_list())
                rezultat.getMon_list().get(q.getMon_list().indexOf(m)).setCoef(rezultat.getMon_list().get(q.getMon_list().indexOf(m)).getCoef() + m.getCoef());
        } else if (q.isGreaterThan(p) == 1) {
            rezultat = new Polinom(q);
            for (Monom m : p.getMon_list())
                rezultat.getMon_list().get(p.getMon_list().indexOf(m)).setCoef(rezultat.getMon_list().get(p.getMon_list().indexOf(m)).getCoef() + m.getCoef());
        }
    }

    public void polynomialSubstraction(Polinom p, Polinom q) {

        Collections.sort(p.getMon_list(), Collections.reverseOrder());
        Collections.sort(q.getMon_list(), Collections.reverseOrder());

        for (Monom m : q.getMon_list())
            m.setCoef(-m.getCoef());

        if (p.isGreaterThan(q) == 1) {
            rezultat = new Polinom(p);
            for (Monom m : q.getMon_list())
                rezultat.getMon_list().get(q.getMon_list().indexOf(m)).setCoef(rezultat.getMon_list().get(q.getMon_list().indexOf(m)).getCoef() + m.getCoef());
        } else if (q.isGreaterThan(p) == 1) {
            rezultat = new Polinom(q);
            for (Monom m : p.getMon_list())
                rezultat.getMon_list().get(p.getMon_list().indexOf(m)).setCoef(rezultat.getMon_list().get(p.getMon_list().indexOf(m)).getCoef() + m.getCoef());
        }
    }

    public void polynomialMultiplication(Polinom p, Polinom q) {
        Polinom polinom_aux = new Polinom();
        for (Monom m : p.getMon_list())
            for (Monom n : q.getMon_list()) {
                Monom monom_aux = new Monom();
                monom_aux.setCoef(m.getCoef() * n.getCoef());
                monom_aux.setPutere(m.getPutere() + n.getPutere());
                if (!polinom_aux.getMon_list().isEmpty()) {
                    boolean ok = false;
                    for (Monom vip : polinom_aux.getMon_list())
                        if (monom_aux.getPutere() == vip.getPutere()) {
                            vip.setCoef(vip.getCoef() + monom_aux.getCoef());
                            ok = true;
                        }
                    if (!ok)
                        polinom_aux.getMon_list().add(monom_aux);
                } else
                    polinom_aux.getMon_list().add(monom_aux);
            }
        rezultat = new Polinom(polinom_aux);
    }

    public void polynomialDivision(Polinom p, Polinom q) {

        Collections.sort(p.getMon_list());
        Collections.sort(q.getMon_list());

        //adaugam monoame pentru ca polinoamele sa aiba acelasi numar de elemente
        //while(b.getMon_list().size() != a.getMon_list().size())
        //b.getMon_list().add(new Monom(0, b.getMon_list().size()));

        //p.printList();
        //q.printList();
        //System.out.println(p.grade()-q.grade());

        /*if (q.grade() < 0)
            System.err.println("Impartirea la zero nu este permisa");
        rezultat = new Polinom();
        Polinom d;
        while (p.grade() >= q.grade()) {
            d = new Polinom(q);
            for (int i = 1; i <= p.grade() - q.grade(); i++)
                d.shiftRight();
            rezultat.getMon_list().get(p.grade() - q.grade()).setCoef(p.getMon_list().get(p.grade()).getCoef()/d.getMon_list().get(d.grade()).getCoef());
            for (Monom x : d.getMon_list())
                x.setCoef(x.getCoef() * rezultat.getMon_list().get(p.grade() - q.grade()).getCoef());
            p = new Polinom(polynomialSubstractionForDivision(p, d));
            p.printList();
        }
        rest = new Polinom(p);
        rezultat = q;*/

       /* if (b.degree() < 0)
            System.err.println("Impartirea la zero nu este permisa");

        Polinom q = new Polinom( 0, 0 );
        Polinom r = new Polinom( a );
        while( !r.isZero() && r.degree() >= b.degree() ){
            double coef = r.coeff() / b.coeff();
            int deg = r.degree() - b.degree();
            Polinom t = new Polinom( coef, deg );
            q = q.plus( t );
            r = r.minus( t.times( b ) );
        }//end while

        rezultat = new Polinom(q);*/

        if (q.degree() < 0) {
            System.err.println("Impartirea la zero nu este permisa");
            System.exit(1);
        }
        if (q.degree() > p.degree()) {
            System.err.println("Gradul lui q este mai mare decat gradul lui p");
            System.exit(1);
        }

        rezultat = new Polinom();
        rezultatDiv = new Polinom();

        while (q.degree() <= p.degree()) {
            double a = p.getMon_list().get(0).getCoef() / q.getMon_list().get(0).getCoef();
            int b = p.getMon_list().get(0).getPutere() - q.getMon_list().get(0).getPutere();
            Monom m = new Monom(a, b);
            Polinom n = new Polinom();
            n.getMon_list().add(m);
            rezultatDiv.getMon_list().add(m);
            n.polAdjust(n);
            polynomialMultiplication(n, q);
            Collections.sort(rezultat.getMon_list());
            Polinom d = new Polinom(rezultat);
            Polinom auxiliar = new Polinom();
            for (Monom x : p.getMon_list())
                for (Monom y : d.getMon_list())
                    if (x.getPutere() == y.getPutere())
                        auxiliar.getMon_list().add(new Monom(x.getCoef() - y.getCoef(), x.getPutere()));
            Collections.sort(rezultat.getMon_list());
            p = new Polinom(auxiliar);          //      1x^2-1x^0     1x^1-1x^0
            p.getMon_list().remove(0);
        }
        rest = p;
        rezultatDiv.printList();

    }

    public void polynomialIntegration(Polinom p) {

        Collections.sort(p.getMon_list());

        rezultat = new Polinom(p);
        for (Monom m : rezultat.getMon_list()) {
            m.setCoef(m.getCoef() / (m.getPutere() + 1));
            m.setPutere(m.getPutere() + 1);
        }
    }

    public void polynomialDerivative(Polinom p) {

        Collections.sort(p.getMon_list(), Collections.reverseOrder());

        rezultat = new Polinom(p);

        for (Monom m : rezultat.getMon_list()) {
            m.setCoef(m.getCoef() * m.getPutere());
            m.setPutere(m.getPutere() - 1);
        }
    }

    public String getRezultat() {
        String s = "";
        Collections.sort(rezultat.getMon_list());
        rezultat.getMon_list().removeIf(Monom -> Monom.getCoef() == 0);
        for (Monom m : rezultat.getMon_list()) {
            s += m.getCoef() + "x^" + m.getPutere();
            if (rezultat.getMon_list().indexOf(m) != rezultat.getMon_list().size() - 1)
                if (rezultat.getMon_list().get(rezultat.getMon_list().indexOf(m) + 1).getCoef() > 0)
                    s += "+";
        }
        if (s == "")
            s += "0";
        return s;
    }

    public String getRezultatDiv() {
        String s = "";
        Collections.sort(rezultatDiv.getMon_list());
        rezultatDiv.getMon_list().removeIf(Monom -> Monom.getCoef() == 0);
        for (Monom m : rezultatDiv.getMon_list()) {
            s += m.getCoef() + "x^" + m.getPutere();
            if (rezultatDiv.getMon_list().indexOf(m) != rezultatDiv.getMon_list().size() - 1)
                if (rezultatDiv.getMon_list().get(rezultatDiv.getMon_list().indexOf(m) + 1).getCoef() > 0)
                    s += "+";
        }
        s += ", rest: ";
        Collections.sort(rest.getMon_list());
        rest.getMon_list().removeIf(Monom -> Monom.getCoef() == 0);
        for (Monom m : rest.getMon_list()) {
            s += m.getCoef() + "x^" + m.getPutere();
            if (rest.getMon_list().indexOf(m) != rest.getMon_list().size() - 1)
                if (rest.getMon_list().get(rest.getMon_list().indexOf(m) + 1).getCoef() > 0)
                    s += "+";
        }

        if (s == "")
            s += "0";
        return s;
    }


}
