package gui;

/**
*
* @author d.ferber
*/

import bank.Bank;
import bank.Konto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class EinAuszahlung extends JFrame {
    JButton btEinzahlen = new JButton("Einzahlen");
    JButton btAuszahlen = new JButton("Auszahlen");
    JTextField tfVorname = new JTextField(20);
    JTextField tfNachname = new JTextField(20);
    JTextField tfKontonummer = new JTextField(20);
    JTextField tfBetrag = new JTextField(20);
    JLabel lbVorname = new JLabel("Vorname");
    JLabel lbNachname = new JLabel("Nachname");
    JLabel lbKontonummer = new JLabel("Kontonummer");
    JLabel lbBetrag = new JLabel("Betrag");
    public static void main(String[] args) {
        new EinAuszahlung();
    }

    public EinAuszahlung() {
        setBackground(new Color(200,100,100));
        this.setTitle("Transaktion");
        setLayout(null);
        this.pack();
        this.setVisible(true);
        this.setSize(300,300);
        add(btEinzahlen);
        add(btAuszahlen);
        add(tfVorname);
        add(tfNachname);
        add(tfKontonummer);
        add(tfBetrag);
        add(lbVorname);
        add(lbNachname);
        add(lbKontonummer);
        add(lbBetrag);
        btEinzahlen.setBounds(75,180,150,20);
        btAuszahlen.setBounds(75,205,150,20);
        tfVorname.setBounds(10,40,150,20);
        tfNachname.setBounds(10,70,150,20);
        tfKontonummer.setBounds(10,100,150,20);
        tfBetrag.setBounds(10, 130, 150, 20);
        lbVorname.setBounds(170,40,150,20);
        lbNachname.setBounds(170,70,150,20);
        lbKontonummer.setBounds(170,100,150,20);
        lbBetrag.setBounds(170, 130, 150, 20);

        btEinzahlen.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    Einzahlen();
                }
        });

        btAuszahlen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Auszahlen();
            }
        });
    }

    void Einzahlen(){
        int kontonummer = 0;
        double betrag = 0.0;
        String vorname = tfVorname.getText();
        String nachname = tfNachname.getText();

        try{
             kontonummer = Integer.parseInt(tfKontonummer.getText());
        }
        catch (NumberFormatException ex){
            String message = "Geben Sie eine Zahl als Kontonummer ein. \n\n" +
            "Drücken Sie Abbrechen um den Vorgang abzubrechen.";

            int dialogResult = JOptionPane.showConfirmDialog(this, message, "Falsches Format", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (dialogResult == JOptionPane.CANCEL_OPTION){
                this.dispose();
                return;
            }
            else if (dialogResult == JOptionPane.OK_OPTION){
                return;
            }
        }

        try{
            betrag = Double.parseDouble(tfBetrag.getText());
        }
        catch (NumberFormatException ex){
            String message = "Geben Sie eine Zahl als Betrag ein. \n\n" +
                    "Drücken Sie Abbrechen um den Vorgang abzubrechen.";

            int dialogResult = JOptionPane.showConfirmDialog(this, message, "Falsches Format", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (dialogResult == JOptionPane.CANCEL_OPTION){
                this.dispose();
                return;
            }
            else if (dialogResult == JOptionPane.OK_OPTION){
                return;
            }
        }

        if (vorname.isEmpty() || nachname.isEmpty())
        {
            String message = "Bitte füllen Sie folgende Felder aus: \n";

            if (vorname.isEmpty()){
                message += "\t - Vorname \n";
            }

            if (nachname.isEmpty()){
                message += "\t - Nachname \n";
            }

            message += "\n Drücken Sie Abbrechen um den Vorgang abzubrechen.";

            int dialogResult = JOptionPane.showConfirmDialog(this, message, "Unvollständige Transaktion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (dialogResult == JOptionPane.CANCEL_OPTION){
                this.dispose();
                return;
            }
            else if (dialogResult == JOptionPane.OK_OPTION){
                return;
            }
        }

        Konto konto = Bank.Datenbank.GetKontoByKontonummer(kontonummer);

        if (!konto.getKunde().GetVorname().equals(vorname)){
            String message = "Der Vorname stimmt nicht mit der angegebenen Kontonummer überein. \n" +
                    "Ändern sie entweder den Vornamen oder die Kontonummer.\n\n" +
                    "Drücken Sie Abbrechen um den Vorgang abzubrechen.";

            int dialogResult = JOptionPane.showConfirmDialog(this, message, "Ungültige Benutzerdaten", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (dialogResult == JOptionPane.CANCEL_OPTION){
                this.dispose();
                return;
            }
            else if (dialogResult == JOptionPane.OK_OPTION){
                return;
            }
        }

        if (!konto.getKunde().GetNachname().equals(nachname)){
            String message = "Der Nachname stimmt nicht mit der angegebenen Kontonummer überein. \n" +
                    "Ändern sie entweder den Nachnamen oder die Kontonummer.\n\n" +
                    "Drücken Sie Abbrechen um den Vorgang abzubrechen.";

            int dialogResult = JOptionPane.showConfirmDialog(this, message, "Ungültige Benutzerdaten", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (dialogResult == JOptionPane.CANCEL_OPTION){
                this.dispose();
                return;
            }
            else if (dialogResult == JOptionPane.OK_OPTION){
                return;
            }
        }

        konto.Einzahlung(betrag);
        JOptionPane.showMessageDialog(this, "Einzahlung von " + betrag + " war erfolgreich.\n Ihr Kontostand beträgt " + konto.getKontost() + ".", "Einzahlung erfolgreich", JOptionPane.PLAIN_MESSAGE);
        this.dispose();
    }

    void Auszahlen(){
        int kontonummer = 0;
        double betrag = 0.0;
        String vorname = tfVorname.getText();
        String nachname = tfNachname.getText();

        try{
            kontonummer = Integer.parseInt(tfKontonummer.getText());
        }
        catch (NumberFormatException ex){
            String message = "Geben Sie eine Zahl als Kontonummer ein. \n\n" +
                    "Drücken Sie Abbrechen um den Vorgang abzubrechen.";

            int dialogResult = JOptionPane.showConfirmDialog(this, message, "Falsches Format", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (dialogResult == JOptionPane.CANCEL_OPTION){
                this.dispose();
                return;
            }
            else if (dialogResult == JOptionPane.OK_OPTION){
                return;
            }
        }

        try{
            betrag = Double.parseDouble(tfBetrag.getText());
        }
        catch (NumberFormatException ex){
            String message = "Geben Sie eine Zahl als Betrag ein. \n\n" +
                    "Drücken Sie Abbrechen um den Vorgang abzubrechen.";

            int dialogResult = JOptionPane.showConfirmDialog(this, message, "Falsches Format", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (dialogResult == JOptionPane.CANCEL_OPTION){
                this.dispose();
                return;
            }
            else if (dialogResult == JOptionPane.OK_OPTION){
                return;
            }
        }

        if (vorname.isEmpty() || nachname.isEmpty())
        {
            String message = "Bitte füllen Sie folgende Felder aus: \n";

            if (vorname.isEmpty()){
                message += "\t - Vorname \n";
            }

            if (nachname.isEmpty()){
                message += "\t - Nachname \n";
            }

            message += "\n Drücken Sie Abbrechen um den Vorgang abzubrechen.";

            int dialogResult = JOptionPane.showConfirmDialog(this, message, "Unvollständige Transaktion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (dialogResult == JOptionPane.CANCEL_OPTION){
                this.dispose();
                return;
            }
            else if (dialogResult == JOptionPane.OK_OPTION){
                return;
            }
        }

        Konto konto = Bank.Datenbank.GetKontoByKontonummer(kontonummer);

        if (!konto.getKunde().GetVorname().equals(vorname)){
            String message = "Der Vorname stimmt nicht mit der angegebenen Kontonummer überein. \n" +
                    "Ändern sie entweder den Vornamen oder die Kontonummer.\n\n" +
                    "Drücken Sie Abbrechen um den Vorgang abzubrechen.";

            int dialogResult = JOptionPane.showConfirmDialog(this, message, "Ungültige Benutzerdaten", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (dialogResult == JOptionPane.CANCEL_OPTION){
                this.dispose();
                return;
            }
            else if (dialogResult == JOptionPane.OK_OPTION){
                return;
            }
        }

        if (!konto.getKunde().GetNachname().equals(nachname)){
            String message = "Der Nachname stimmt nicht mit der angegebenen Kontonummer überein. \n" +
                    "Ändern sie entweder den Nachnamen oder die Kontonummer.\n\n" +
                    "Drücken Sie Abbrechen um den Vorgang abzubrechen.";

            int dialogResult = JOptionPane.showConfirmDialog(this, message, "Ungültige Benutzerdaten", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (dialogResult == JOptionPane.CANCEL_OPTION){
                this.dispose();
                return;
            }
            else if (dialogResult == JOptionPane.OK_OPTION){
                return;
            }
        }

        if ((konto.getKontost() - betrag) < 0){
            int dialogResult = JOptionPane.showConfirmDialog(this, "Diese Auszahlung überschreitet Ihren aktuellen Kontostand.\n Wollen Sie dennoch fortfahren?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (dialogResult == JOptionPane.NO_OPTION){
                return;
            }
        }

        konto.Auszahlung(betrag);
        JOptionPane.showMessageDialog(this, "Auszahlung von " + betrag + " war erfolgreich.\n Ihr Kontostand beträgt " + konto.getKontost() + ".", "Einzahlung erfolgreich", JOptionPane.PLAIN_MESSAGE);
        this.dispose();
    }
}
