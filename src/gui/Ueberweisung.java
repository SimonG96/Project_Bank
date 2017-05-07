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

public class Ueberweisung extends JFrame {
    JButton btUeberweisen = new JButton("Überweisen");
    JTextField tfVornameAbs = new JTextField(20);
    JTextField tfNachnameAbs = new JTextField(20);
    JTextField tfKontonummerAbs = new JTextField(20);
    JTextField tfBetrag = new JTextField(20);
    JTextField tfVornameEmpf = new JTextField(20);
    JTextField tfNachnameEmpf = new JTextField(20);
    JTextField tfKontonummerEmpf = new JTextField(20);
    JLabel lbAbsender = new JLabel("Sender");
    JLabel lbVornameAbs = new JLabel("Vorname");
    JLabel lbNachnameAbs = new JLabel("Nachname");
    JLabel lbKontonummerAbs = new JLabel("Kontonummer");
    JLabel lbBetrag = new JLabel("Betrag");
    JLabel lbVornameEmpf = new JLabel("Vorname");
    JLabel lbNachnameEmpf = new JLabel("Nachname");
    JLabel lbKontonummerEmpf = new JLabel("Kontonummer");
    JLabel lbEmpfaenger = new JLabel("Empfänger");
    public static void main(String[] args) {
        new Ueberweisung();
    }

    public Ueberweisung() {
        setBackground(new Color(200,100,100));
        this.setTitle("Transaktion");
        setLayout(null);
        this.pack();
        this.setVisible(true);
        this.setSize(300,400);
        add(btUeberweisen);
        add(tfVornameAbs);
        add(tfNachnameAbs);
        add(tfKontonummerAbs);
        add(tfVornameEmpf);
        add(tfNachnameEmpf);
        add(tfKontonummerEmpf);
        add(tfBetrag);
        add(lbAbsender);
        add(lbVornameAbs);
        add(lbNachnameAbs);
        add(lbKontonummerAbs);
        add(lbVornameEmpf);
        add(lbNachnameEmpf);
        add(lbKontonummerEmpf);
        add(lbEmpfaenger);
        add(lbBetrag);
        btUeberweisen.setBounds(75,300,150,20);
        tfVornameAbs.setBounds(10,40,150,20);
        tfNachnameAbs.setBounds(10,70,150,20);
        tfKontonummerAbs.setBounds(10,100,150,20);
        tfVornameEmpf.setBounds(10,170,150,20);
        tfNachnameEmpf.setBounds(10,200,150,20);
        tfKontonummerEmpf.setBounds(10,230,150,20);
        tfBetrag.setBounds(10,260,150,20);
        lbAbsender.setBounds(75,10,150,20);
        lbVornameAbs.setBounds(170,40,150,20);
        lbNachnameAbs.setBounds(170,70,150,20);
        lbKontonummerAbs.setBounds(170,100,150,20);
        lbEmpfaenger.setBounds(65,140,150,20);
        lbVornameEmpf.setBounds(170,170,150,20);
        lbNachnameEmpf.setBounds(170,200,150,20);
        lbKontonummerEmpf.setBounds(170,230,150,20);
        lbBetrag.setBounds(170,260,150,20);

        btUeberweisen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Ueberweisen();
            }
        });
    }

    void Ueberweisen(){
        int kontonummerAbs = 0;
        int kontonummerEmpf = 0;
        double betrag = 0.0;
        String vornameAbs = tfVornameAbs.getText();
        String nachnameAbs = tfNachnameAbs.getText();
        String vornameEmpf = tfVornameEmpf.getText();
        String nachnameEmpf = tfNachnameEmpf.getText();

        try{
            kontonummerAbs = Integer.parseInt(tfKontonummerAbs.getText());
        }
        catch (NumberFormatException ex){
            String message = "Geben Sie eine Zahl als Kontonummer für den Absender ein. \n\n" +
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
            kontonummerEmpf = Integer.parseInt(tfKontonummerEmpf.getText());
        }
        catch (NumberFormatException ex){
            String message = "Geben Sie eine Zahl als Kontonummer für den Empfänger ein. \n\n" +
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

        if (vornameAbs.isEmpty() || nachnameAbs.isEmpty() || vornameEmpf.isEmpty() || nachnameEmpf.isEmpty())
        {
            String message = "Bitte füllen Sie folgende Felder aus: \n";

            if (vornameAbs.isEmpty()){
                message += "\t - Vorname Absender \n";
            }

            if (nachnameAbs.isEmpty()){
                message += "\t - Nachname Absender \n";
            }

            if (vornameEmpf.isEmpty()){
                message += "\t - Vorname Empfänger \n";
            }

            if (nachnameEmpf.isEmpty()){
                message += "\t - Nachname Empfänger \n";
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

        Konto kontoAbs = Bank.Datenbank.GetKontoByKontonummer(kontonummerAbs);

        if (!kontoAbs.getKunde().GetVorname().equals(vornameAbs)){
            String message = "Der Vorname des Absenders stimmt nicht mit der angegebenen Kontonummer überein. \n" +
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

        if (!kontoAbs.getKunde().GetNachname().equals(nachnameAbs)){
            String message = "Der Nachname des Absenders stimmt nicht mit der angegebenen Kontonummer überein. \n" +
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

        Konto kontoEmpf = Bank.Datenbank.GetKontoByKontonummer(kontonummerEmpf);

        if (!kontoEmpf.getKunde().GetVorname().equals(vornameEmpf)){
            String message = "Der Vorname des Empfängers stimmt nicht mit der angegebenen Kontonummer überein. \n" +
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

        if (!kontoEmpf.getKunde().GetNachname().equals(nachnameEmpf)){
            String message = "Der Nachname des Empfängers stimmt nicht mit der angegebenen Kontonummer überein. \n" +
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


        kontoEmpf.Einzahlung(betrag);
        kontoAbs.Auszahlung(betrag);

        JOptionPane.showMessageDialog(this, "Überweisung von " + betrag + " war erfolgreich.", "Überweisung erfolgreich", JOptionPane.PLAIN_MESSAGE);
        this.dispose();
    }
}
