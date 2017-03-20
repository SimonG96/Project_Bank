package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Oberflaeche extends JFrame {
    JButton derButton1 = new JButton("Neuen User anlegen");
    JButton derButton2 = new JButton("Kontoauszug");
    JButton derButton3 = new JButton("Transaktion");
    public static void main(String[] args) {
        new Oberflaeche();
    }

    public Oberflaeche() {
        setBackground(new Color(200,100,100));
        this.setTitle("Die Bank");
        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();
        ImageIcon pic = new ImageIcon("H:/SAE/Neuer Ordner/2017.03.20 - Projekt (Bank)/bank-05.jpg");
        panel1.add(new JLabel(pic));
        this.add(panel1);
        this.pack();
        this.setVisible(true);
        this.setSize(700,600);
        add(derButton1);
        add(derButton2);
        add(derButton3);
        panel1.setBounds(30,30,600,500);
        derButton1.setBounds(50,500,150,20);
        derButton2.setBounds(250,500,150,20);
        derButton3.setBounds(450,500,150,20);
        derButton1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                   
                }
                //    });
                //derButton2.addMouseListener(new java.awt.event.MouseAdapter() {
                //        public void mousePressed(MouseEvent e) {
                //            vearbeiteButtonClick2();
                //        }
                //    });
                //derButton3.addMouseListener(new java.awt.event.MouseAdapter() {
                //        public void mousePressed(MouseEvent e) {
                //            vearbeiteButtonClick3();
                //        }
                 });


               
        
    
            
        }
    }