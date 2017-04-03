package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transaktion extends JFrame {
    JButton derButton1 = new JButton("Überweisung");
    JButton derButton2 = new JButton("Ein-/Auszahlung");
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
        add(derButton1);
        add(derButton2);
        derButton1.setBounds(75,10,150,20);
        derButton2.setBounds(75,40,150,20);
        derButton1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    verarbeiteButtonClick1();
                }
            });
                    derButton2.addMouseListener(new java.awt.event.MouseAdapter() {
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

