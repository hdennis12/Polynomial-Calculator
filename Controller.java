package MVC;

import Core.*;
import jdk.jfr.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class Controller {
    private Model m_model;
    private View m_view;

    public Controller(Model model, View view) {
        this.m_model = model;
        this.m_view = view;

        m_view.addAdditionListener(new AdditionListener());
        m_view.addSubstractionListener(new SubstractionListener());
        m_view.addMultiplicationListener(new MultiplicationListener());
        m_view.addDivisionListener(new DivisionListener());
        m_view.addIntegrationListener(new IntegrationListener());
        m_view.addDerivativeListener(new DerivativeListener());
    }

    class AdditionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String firstInput = "";
            String secondInput = "";
            try {
                firstInput = m_view.getUserFirstInput();
                secondInput = m_view.getUserSecondInput();
                m_model.polynomialAddition(new Polinom(firstInput), new Polinom(secondInput));
                m_view.setResult(m_model.getRezultat());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + firstInput + "' or '" + secondInput + "'");
            }
        }
    }

    class SubstractionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String firstInput = "";
            String secondInput = "";
            try {
                firstInput = m_view.getUserFirstInput();
                secondInput = m_view.getUserSecondInput();
                m_model.polynomialSubstraction(new Polinom(firstInput), new Polinom(secondInput));
                m_view.setResult(m_model.getRezultat());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + firstInput + "' or '" + secondInput + "'");
            }
        }
    }

    class MultiplicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String firstInput = "";
            String secondInput = "";
            try {
                firstInput = m_view.getUserFirstInput();
                secondInput = m_view.getUserSecondInput();
                m_model.polynomialMultiplication(new Polinom(firstInput), new Polinom(secondInput));
                m_view.setResult(m_model.getRezultat());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + firstInput + "' or '" + secondInput + "'");
            }
        }
    }

    class DivisionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String firstInput = "";
            String secondInput = "";
            try {
                firstInput = m_view.getUserFirstInput();
                secondInput = m_view.getUserSecondInput();
                m_model.polynomialDivision(new Polinom(firstInput), new Polinom(secondInput));
                m_view.setResult(m_model.getRezultatDiv());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + firstInput + "' or '" + secondInput + "'");
            }
        }
    }

    class IntegrationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String firstInput = "";
           // try {
                firstInput = m_view.getUserFirstInput();
                m_model.polynomialIntegration(new Polinom(firstInput));
                m_view.setResult(m_model.getRezultat());

            //} catch (NumberFormatException nfex) {
             //   m_view.showError("Bad input: '" + firstInput + "'");
            //}
        }
    }

    class DerivativeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String firstInput = "";
            try {
                firstInput = m_view.getUserFirstInput();
                m_model.polynomialDerivative(new Polinom(firstInput));
                m_view.setResult(m_model.getRezultat());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + firstInput + "'");
            }
        }
    }

}
