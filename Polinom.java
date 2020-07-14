package Core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    private ArrayList<Monom> mon_list;

    public Polinom() {
        mon_list = new ArrayList<Monom>();
    }

    public Polinom(String s) {
        mon_list = new ArrayList<Monom>();
        Pattern pattern = Pattern.compile("([-]?[^+-]+)");
        Matcher matcher = pattern.matcher(s);
        int x = 0;
        while (matcher.find()) {
            x = x + 1;
            //System.out.println("Group "+x+": " + matcher.group());
            Monom m = new Monom(matcher.group());
            if (!mon_list.isEmpty() && mon_list.get(mon_list.size() - 1).getPutere() - 1 != m.getPutere()) {
                int nr = mon_list.get(mon_list.size() - 1).getPutere() - m.getPutere() - 1;
                while (nr != 0) {
                    mon_list.add(new Monom(0, mon_list.get(mon_list.size() - 1).getPutere() - 1));
                    nr--;
                }
            }
            mon_list.add(m);
        }
        while (mon_list.get(mon_list.size() - 1).getPutere() != 0)
            mon_list.add(new Monom(0, mon_list.get(mon_list.size() - 1).getPutere() - 1));

    }

    public Polinom(Polinom p) {
        this.mon_list = p.getMon_list();
    }

    public ArrayList<Monom> getMon_list() {
        return mon_list;
    }

    public void setMon_list(ArrayList<Monom> mon_list) {
        this.mon_list = mon_list;
    }

    public void polAdjust(Polinom p)
    {
        int nr = p.getMon_list().get(p.getMon_list().size()- 1).getPutere();
        while(nr > 0)
        {
            p.getMon_list().add(new Monom(0, nr-1));
            nr--;
        }
    }

    public void printList() {
        for (Monom i : mon_list)
            System.out.println(i.getCoef() + " " + i.getPutere());

        String s = "";
        for (Monom m : mon_list) {
            s += m.getCoef() + "x^" + m.getPutere();
            if (mon_list.indexOf(m) != mon_list.size() - 1)
                if (mon_list.get(mon_list.indexOf(m) + 1).getCoef() > 0)
                    s += "+";
        }
        System.out.println(s);
    }

    public int degree() {
        int grad = -1;
        for (Monom x : mon_list)
            if (x.getCoef() != 0 && x.getPutere() > grad)
                grad = x.getPutere();
        return grad;
    }

    public int isGreaterThan(Polinom q) {
        if (this.getMon_list().get(mon_list.size() - 1).getPutere() > q.getMon_list().get(q.getMon_list().size() - 1).getPutere())
            return 1;
        else
            return -1;
    }
}
