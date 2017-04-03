package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EinAuszahlung extends JFrame {
    JButton derButton1 = new JButton("Einzahlen");
    JButton derButton2 = new JButton("Auszahlen");
    JTextField dieEingabe1 = new JTextField(20);
    JTextField dieEingabe2 = new JTextField(20);
    JTextField dieEingabe3 = new JTextField(20);
    JLabel dasLabel1 = new JLabel("Vorname");
    JLabel dasLabel2 = new JLabel("Nachname");
    JLabel dasLabel3 = new JLabel("Kontonummer");
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
        add(derButton1);
        add(derButton2);
        add(dieEingabe1);
        add(dieEingabe2);
        add(dieEingabe3);
        add(dasLabel1);
        add(dasLabel2);
        add(dasLabel3);
        derButton1.setBounds(75,150,150,20);
        derButton2.setBounds(75,175,150,20);
        dieEingabe1.setBounds(10,40,150,20);
        dieEingabe2.setBounds(10,70,150,20);
        dieEingabe3.setBounds(10,100,150,20);
        dasLabel1.setBounds(170,40,150,20);
        dasLabel2.setBounds(170,70,150,20);
        dasLabel3.setBounds(170,100,150,20);
    }
}
