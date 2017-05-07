package gui;

/**
*
* @author d.ferber
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Transaktion extends JFrame {
    JButton btUeberweisung = new JButton("Überweisung");
    JButton btZahlung = new JButton("Ein-/Auszahlung");
    public static void main(String[] args) {
        new Transaktion();
    }

    public Transaktion() {
        setBackground(new Color(200,100,100));
        this.setTitle("Transaktion");
        setLayout(null);
        this.pack();
        this.setVisible(true);
        this.setSize(300,150);
        add(btUeberweisung);
        add(btZahlung);
        btUeberweisung.setBounds(75,10,150,20);
        btZahlung.setBounds(75,40,150,20);
        btUeberweisung.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    verarbeiteButtonClick1();
                }
            });
                    btZahlung.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    verarbeiteButtonClick2();
                }
            });
    }

    void verarbeiteButtonClick1(){
        new Ueberweisung();
    }
        void verarbeiteButtonClick2(){
        new EinAuszahlung();
    }
}

