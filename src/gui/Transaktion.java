package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transaktion extends JFrame {
    JButton derButton1 = new JButton("Überweisen");
    JTextField dieEingabe1 = new JTextField(20);
    JTextField dieEingabe2 = new JTextField(20);
    JTextField dieEingabe3 = new JTextField(20);
    JTextField dieEingabe4 = new JTextField(20);
    JTextField dieEingabe5 = new JTextField(20);
    JTextField dieEingabe6 = new JTextField(20);
    JLabel dasLabelSender = new JLabel("Sender");
    JLabel dasLabel1 = new JLabel("Vorname");
    JLabel dasLabel2 = new JLabel("Nachname");
    JLabel dasLabel3 = new JLabel("Kontonummer");
    JLabel dasLabel4 = new JLabel("Vorname");
    JLabel dasLabel5 = new JLabel("Nachname");
    JLabel dasLabel6 = new JLabel("Kontonummer");
    JLabel dasLabelEmpfänger = new JLabel("Empfänger");
    public static void main(String[] args) {
        new Transaktion();
    }

    public Transaktion() {
        setBackground(new Color(200,100,100));
        this.setTitle("Transaktion");
        setLayout(null);
        this.pack();
        this.setVisible(true);
        this.setSize(400,400);
        add(derButton1);
        add(dieEingabe1);
        add(dieEingabe2);
        add(dieEingabe3);
        add(dieEingabe4);
        add(dieEingabe5);
        add(dieEingabe6);
        add(dasLabelSender);
        add(dasLabel1);
        add(dasLabel2);
        add(dasLabel3);
        add(dasLabel4);
        add(dasLabel5);
        add(dasLabel6);
        add(dasLabelEmpfänger);
        derButton1.setBounds(140,300,150,20);
        dieEingabe1.setBounds(10,40,150,20);
        dieEingabe2.setBounds(10,70,150,20);
        dieEingabe3.setBounds(10,100,150,20);
        dieEingabe4.setBounds(10,170,150,20);
        dieEingabe5.setBounds(10,200,150,20);
        dieEingabe6.setBounds(10,230,150,20);
        dasLabelSender.setBounds(75,10,150,20);
        dasLabel1.setBounds(170,40,150,20);
        dasLabel2.setBounds(170,70,150,20);
        dasLabel3.setBounds(170,100,150,20);
        dasLabelEmpfänger.setBounds(65,140,150,20);
        dasLabel4.setBounds(170,170,150,20);
        dasLabel5.setBounds(170,200,150,20);
        dasLabel6.setBounds(170,230,150,20);
    }
}
