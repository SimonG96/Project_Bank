package gui; 

/**
*
* @author d.ferber
*/

import bank.Bank;
import bank.Kontenbewegung;
import bank.Konto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

public class Kontoauszug extends JFrame {
    JButton btBestaetigen = new JButton("Bestätigen");
    JTextField tfVorname = new JTextField(20);
    JTextField tfNachname = new JTextField(20);
    JTextField tfKontonummer = new JTextField(20);
    JLabel lbVorname = new JLabel("Vorname");
    JLabel lbNachname = new JLabel("Nachname");
    JLabel lbKontonummer = new JLabel("Kontonummer");
    public static void main(String[] args) {
        new Kontoauszug();
    }

    public Kontoauszug() {
        setBackground(new Color(200,100,100));
        this.setTitle("Kontoauszug");
        setLayout(null);
        this.pack();
        this.setVisible(true);
        this.setSize(300,225);
        add(btBestaetigen);
        add(tfVorname);
        add(tfNachname);
        add(tfKontonummer);
        add(lbVorname);
        add(lbNachname);
        add(lbKontonummer);
        btBestaetigen.setBounds(50,150,150,20);
        tfVorname.setBounds(10,10,150,20);
        tfNachname.setBounds(10,50,150,20);
        tfKontonummer.setBounds(10,90,150,20);
        lbVorname.setBounds(170,10,150,20);
        lbNachname.setBounds(170,50,150,20);
        lbKontonummer.setBounds(170,90,150,20);
        btBestaetigen.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    verarbeiteButtonClick1();
                }
            });
    }
    void verarbeiteButtonClick1(){
        int kontonummer = 0;
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

            int dialogResult = JOptionPane.showConfirmDialog(this, message, "Unvollständige Eingabe", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (dialogResult == JOptionPane.CANCEL_OPTION){
                this.dispose();
                return;
            }
            else if (dialogResult == JOptionPane.OK_OPTION){
                return;
            }
        }

        Konto konto = Bank.Datenbank.GetKontoByKontonummer(kontonummer);

        if (konto == null){
            String message = "Ungültige Kontonummer. \n\n" +
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

        List<Kontenbewegung> listOfKontenbewegungen = Bank.Datenbank.GetAllKontenbewegungenForOneKontoByKontonummer(kontonummer);

        if (listOfKontenbewegungen == null){
            String message = "Ungültige Kontonummer. \n\n" +
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

        new Auszug(listOfKontenbewegungen);
    }
}
