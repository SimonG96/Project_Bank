package gui; 

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
        new Auszug();
    }
}
