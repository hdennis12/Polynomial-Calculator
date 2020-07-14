package MVC;
import java.util.*;
import Core.*;

public class Main {
    public static void main(String[] args) {
        View v_view = new View();
        Model m_model = new Model();
        Controller Calculator = new Controller(m_model, v_view);
        //String exp1 = "-2.5x^7-4x^4+5x^1-42x^0";
        //String exp2 = "4x^5-2.7x^4+3x^2-2x^1+30x^0";
        //String exp1 = "3x^2+1x^0";
        //String exp2 = "2x^3+7x^0";
        //String exp1 = "1x^2-1x^0";
        //String exp2 = "1x^1-1x^0";
        //Polinom p = new Polinom(exp1);
        //Polinom q = new Polinom(exp2);
        //m_model.polynomialDivision(p, q);
        //p.printList();
        //q.printList();
        //Model m_model = new Model();
        //m_model.polynomialAddition(p, q);
        //m_model.polynomialMultiplication(p, q);
        //System.out.println(m_model.getRezultat());
        //p.printList();

        //System.out.println("dedwef");
        //String polinom ="3x^3+4x^2+15x^3+2x^2+20x+1";
        //String delimitatori = "\\+";
        //String[] monoame = polinom.split(delimitatori);
        //for (int i = 0; i < monoame.length; i++)
        //System.out.println(monoame[i]);

        //P.add(5.2);
        //System.out.println(P.get(0));
    }
}
