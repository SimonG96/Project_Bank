package gui; 

/**
*
* @author d.ferber
*/

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import bank.*;

public class Anlage extends JFrame {
    JButton btKundeAnlegen = new JButton("Kunden anlegen");
    JTextField tfVorname = new JTextField(20);
    JTextField tfNachname = new JTextField(20);
    JTextField tfStraße = new JTextField(20);
    JTextField tfOrt = new JTextField(20);
    //JTextField tfKontonummer = new JTextField(20);
    JLabel lbVorname = new JLabel("Vorname");
    JLabel lbNachname = new JLabel("Nachname");
    JLabel lbStraße = new JLabel("Straße");
    JLabel lbOrt = new JLabel("Ort");
    //JLabel lbKontonummer = new JLabel("Kontonummer");
    public static void main(String[] args) {
        new Anlage();
    }

    public Anlage() {
        setBackground(new Color(200,100,100));
        this.setTitle("Die Bank");
        setLayout(null);
        this.pack();
        this.setVisible(true);
        this.setSize(300,300);
        add(btKundeAnlegen);
        add(tfVorname);
        add(tfNachname);
        add(tfStraße);
        add(tfOrt);
        //add(tfKontonummer);
        add(lbVorname);
        add(lbNachname);
        add(lbStraße);
        add(lbOrt);
        //add(lbKontonummer);
        btKundeAnlegen.setBounds(50,225,150,20);
        tfVorname.setBounds(10,10,150,20);
        tfNachname.setBounds(10,50,150,20);
        tfStraße.setBounds(10,90,150,20);
        tfOrt.setBounds(10,130,150,20);
        //tfKontonummer.setBounds(10,170,150,20);
        lbVorname.setBounds(170,10,150,20);
        lbNachname.setBounds(170,50,150,20);
        lbStraße.setBounds(170,90,150,20);
        lbOrt.setBounds(170,130,150,20);
        //lbKontonummer.setBounds(170,170,150,20);
        btKundeAnlegen.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mousePressed(MouseEvent e) {
                    verarbeiteButtonClick1();
                }
            });
    }
    void verarbeiteButtonClick1(){
        String vorname = tfVorname.getText();
        String nachname = tfNachname.getText();
        String ort = tfOrt.getText();
        String straße =tfStraße.getText();

        if (vorname.isEmpty() || nachname.isEmpty() || ort.isEmpty() || straße.isEmpty())
        {
            String message = "Bitte füllen Sie folgende Felder aus: \n";

            if (vorname.isEmpty()){
                message += "\t - Vorname \n";
            }

            if (nachname.isEmpty()){
                message += "\t - Nachname \n";
            }

            if (ort.isEmpty()){
                message += "\t - Ort \n";
            }

            if (straße.isEmpty()){
                message += "\t - Straße \n";
            }

            message += "\n Drücken Sie Abbrechen um den Vorgang abzubrechen.";

            int dialogResult = JOptionPane.showConfirmDialog(this, message, "Unvollständige Kunden Anlage", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (dialogResult == JOptionPane.CANCEL_OPTION){
                this.dispose();
                return;
            }
        }
        else
        {
            Kunde kunde = new Kunde(vorname, nachname, ort, straße, Bank.Datenbank);
            kunde.KundeAbspeichern();
            System.out.println(kunde.GetVorname() + "; " + kunde.GetNachname());
            JOptionPane.showMessageDialog(this, "Kunde erfolgreich angelegt.", "Anlage erfolgreich", JOptionPane.PLAIN_MESSAGE);
            this.dispose();
        }
    }
}
