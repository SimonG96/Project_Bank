package gui; 

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Anlage extends JFrame {
    JButton derButton1 = new JButton("Kunden anlegen");
    JTextField dieEingabe1 = new JTextField(20);
    JTextField dieEingabe2 = new JTextField(20);
    JTextField dieEingabe3 = new JTextField(20);
    JTextField dieEingabe4 = new JTextField(20);
    JTextField dieEingabe5 = new JTextField(20);
    JLabel dasLabel1 = new JLabel("Vorname");
    JLabel dasLabel2 = new JLabel("Nachname");
    JLabel dasLabel3 = new JLabel("Straße");
    JLabel dasLabel4 = new JLabel("Ort");
    JLabel dasLabel5 = new JLabel("Kontonummer");
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
        add(derButton1);
        add(dieEingabe1);
        add(dieEingabe2);
        add(dieEingabe3);
        add(dieEingabe4);
        add(dieEingabe5);
        add(dasLabel1);
        add(dasLabel2);
        add(dasLabel3);
        add(dasLabel4);
        add(dasLabel5);
        derButton1.setBounds(50,225,150,20);
        dieEingabe1.setBounds(10,10,150,20);
        dieEingabe2.setBounds(10,50,150,20);
        dieEingabe3.setBounds(10,90,150,20);
        dieEingabe4.setBounds(10,130,150,20);
        dieEingabe5.setBounds(10,170,150,20);
        dasLabel1.setBounds(170,10,150,20);
        dasLabel2.setBounds(170,50,150,20);
        dasLabel3.setBounds(170,90,150,20);
        dasLabel4.setBounds(170,130,150,20);
        dasLabel5.setBounds(170,170,150,20);
     //   derButton1.addMouseListener(new java.awt.event.MouseAdapter() {
        //       public void mousePressed(MouseEvent e) {
        //            verarbeiteButtonClick1();
                }
          //  });
    //}
    //void verarbeiteButtonClick1(){
    //    Kunde kunde = new Kunde(dieEingabe1.getText,dieEingabe2.getText);
     //   kunde.KundeAbspeichern();
   // }
}
