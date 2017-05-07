package gui;

/**
*
* @author d.ferber
*/

import bank.Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int retValue = JOptionPane.showConfirmDialog(Oberflaeche.this ,"Wollen Sie die Anwendung wirklich schließen?", "Anwendung schließen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (retValue == JOptionPane.NO_OPTION){
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
                else if (retValue == JOptionPane.YES_OPTION){
                    Bank.Datenbank.OnClosing();
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
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

    void verarbeiteButtonClick3() {
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
