package MVC;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    //JFrame window = new JFrame();
    private JTextField firstPolynomial = new JTextField(20);
    private JTextField secondPolynomial = new JTextField(20);
    private JTextField result = new JTextField(20);
    private JLabel firstPText = new JLabel("Primul polinom: ");
    private JLabel secondPText = new JLabel("   Al doilea polinom: ");
    private JLabel opText = new JLabel("Operatii: ");
    private JLabel resText = new JLabel("Rezultat: ");
    private JButton addition = new JButton("+");
    private JButton substraction = new JButton("-");
    private JButton multiplication = new JButton("*");
    private JButton division = new JButton("/");
    private JButton integration = new JButton("\u222B");
    private JButton derivative = new JButton("'");


    public View() {
        this.setSize(700, 180);

        JPanel polynomialPanel = new JPanel();
        polynomialPanel.add(firstPText);
        polynomialPanel.add(firstPolynomial);
        polynomialPanel.add(secondPText);
        polynomialPanel.add(secondPolynomial);
        this.add(polynomialPanel, BorderLayout.PAGE_START);

        JPanel buttonPanel = new JPanel();
        /*Container cont = new Container();
        Dimension d = new Dimension(100, 100);
        cont.add(Box.createRigidArea(d));
        this.add(cont);*/
        buttonPanel.add(opText);
        buttonPanel.add(addition);
        buttonPanel.add(substraction);
        buttonPanel.add(multiplication);
        buttonPanel.add(division);
        buttonPanel.add(integration);
        buttonPanel.add(derivative);
        this.add(buttonPanel, BorderLayout.CENTER);

        JPanel resultPanel = new JPanel();
        resultPanel.add(resText);
        resultPanel.add(result);
        this.add(resultPanel, BorderLayout.PAGE_END);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //this.pack();

        this.setVisible(true);
    }

    String getUserFirstInput() {
        return firstPolynomial.getText();
    }

    String getUserSecondInput() {
        return secondPolynomial.getText();
    }

    void setResult(String newTotal) {
        result.setText(newTotal);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    void addAdditionListener(ActionListener a) {
        addition.addActionListener(a);
    }

    void addSubstractionListener(ActionListener b) {
        substraction.addActionListener(b);
    }

    void addMultiplicationListener(ActionListener c) {
        multiplication.addActionListener(c);
    }

    void addDivisionListener(ActionListener d) {
        division.addActionListener(d);
    }

    void addIntegrationListener(ActionListener e) {
        integration.addActionListener(e);
    }

    void addDerivativeListener(ActionListener f) {
        derivative.addActionListener(f);
    }
}
