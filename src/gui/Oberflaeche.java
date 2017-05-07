package gui;

import bank.Bank;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Oberflaeche extends JFrame {
    JButton btUserAnlegen = new JButton("Neuen User anlegen");
    JButton btKontoauszug = new JButton("Kontoauszug");
    JButton btTransaktion = new JButton("Transaktion");
    public static void main(String[] args) {
        new Oberflaeche();
    }

    public Oberflaeche() {
        setBackground(new Color(200,100,100));
        this.setTitle("Die Bank");
        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();
        ImageIcon pic = new ImageIcon("bank-05.jpg");
        panel1.add(new JLabel(pic));
        this.pack();
        this.setSize(700,600);
        add(btUserAnlegen);
        add(btKontoauszug);
        add(btTransaktion);
        panel1.setBounds(30,30,600,500);
        btUserAnlegen.setBounds(50,500,150,20);

        btKontoauszug.setBounds(250,500,150,20);

        btTransaktion.setBounds(450,500,150,20);


        this.add(panel1);
        this.setVisible(true);

        btUserAnlegen.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    verarbeiteButtonClick1();
                }
            });
        btKontoauszug.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    verarbeiteButtonClick2();
                }
            });
        btTransaktion.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    verarbeiteButtonClick3();
                }
            });



    }

    void verarbeiteButtonClick1(){
        new Anlage();
    }

    void verarbeiteButtonClick2(){
        if (Bank.Datenbank.IsAnyCustomerAvailable())
        {
            new Kontoauszug();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Es ist kein Kunde angelegt. Bitte legen Sie zuerst einen Kunden an und versuchen Sie es dann erneut.", "Kein Kunde angelegt", JOptionPane.PLAIN_MESSAGE);
        }
    }

    void verarbeiteButtonClick3(){
        if (Bank.Datenbank.IsAnyCustomerAvailable())
        {
            new Transaktion();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Es ist kein Kunde angelegt. Bitte legen Sie zuerst einen Kunden an und versuchen Sie es dann erneut.", "Kein Kunde angelegt", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
