package gui;

/**
*
* @author d.ferber
*/

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;

public class Ueberweisung extends JFrame {
    JButton btUeberweisen = new JButton("Überweisen");
    JTextField tfVornameAbs = new JTextField(20);
    JTextField tfNachnameAbs = new JTextField(20);
    JTextField tfKontonummerAbs = new JTextField(20);
    JTextField tfBetragAbs = new JTextField(20);
    JTextField tfVornameEmpf = new JTextField(20);
    JTextField tfNachnameEmpf = new JTextField(20);
    JTextField tfKontonummerEmpf = new JTextField(20);
    JLabel lbAbsender = new JLabel("Sender");
    JLabel lbVornameAbs = new JLabel("Vorname");
    JLabel lbNachnameAbs = new JLabel("Nachname");
    JLabel lbKontonummerAbs = new JLabel("Kontonummer");
    JLabel lbBetragAbs = new JLabel("Betrag");
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
        add(tfBetragAbs);
        add(lbAbsender);
        add(lbVornameAbs);
        add(lbNachnameAbs);
        add(lbKontonummerAbs);
        add(lbVornameEmpf);
        add(lbNachnameEmpf);
        add(lbKontonummerEmpf);
        add(lbEmpfaenger);
        add(lbBetragAbs);
        btUeberweisen.setBounds(75,300,150,20);
        tfVornameAbs.setBounds(10,40,150,20);
        tfNachnameAbs.setBounds(10,70,150,20);
        tfKontonummerAbs.setBounds(10,100,150,20);
        tfVornameEmpf.setBounds(10,170,150,20);
        tfNachnameEmpf.setBounds(10,200,150,20);
        tfKontonummerEmpf.setBounds(10,230,150,20);
        tfBetragAbs.setBounds(10,260,150,20);
        lbAbsender.setBounds(75,10,150,20);
        lbVornameAbs.setBounds(170,40,150,20);
        lbNachnameAbs.setBounds(170,70,150,20);
        lbKontonummerAbs.setBounds(170,100,150,20);
        lbEmpfaenger.setBounds(65,140,150,20);
        lbVornameEmpf.setBounds(170,170,150,20);
        lbNachnameEmpf.setBounds(170,200,150,20);
        lbKontonummerEmpf.setBounds(170,230,150,20);
        lbBetragAbs.setBounds(170,260,150,20);
    }
}
