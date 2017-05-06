package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;

public class EinAuszahlung extends JFrame {
    JButton btEinzahlen = new JButton("Einzahlen");
    JButton btAuszahlen = new JButton("Auszahlen");
    JTextField tfVorname = new JTextField(20);
    JTextField tfNachname = new JTextField(20);
    JTextField tfKontonummer = new JTextField(20);
    JLabel lbVorname = new JLabel("Vorname");
    JLabel lbNachname = new JLabel("Nachname");
    JLabel lbKontonummer = new JLabel("Kontonummer");
    public static void main(String[] args) {
        new EinAuszahlung();
    }

    public EinAuszahlung() {
        setBackground(new Color(200,100,100));
        this.setTitle("Transaktion");
        setLayout(null);
        this.pack();
        this.setVisible(true);
        this.setSize(300,250);
        add(btEinzahlen);
        add(btAuszahlen);
        add(tfVorname);
        add(tfNachname);
        add(tfKontonummer);
        add(lbVorname);
        add(lbNachname);
        add(lbKontonummer);
        btEinzahlen.setBounds(75,150,150,20);
        btAuszahlen.setBounds(75,175,150,20);
        tfVorname.setBounds(10,40,150,20);
        tfNachname.setBounds(10,70,150,20);
        tfKontonummer.setBounds(10,100,150,20);
        lbVorname.setBounds(170,40,150,20);
        lbNachname.setBounds(170,70,150,20);
        lbKontonummer.setBounds(170,100,150,20);
    }
}
