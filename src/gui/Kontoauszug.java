import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Kontoauszug extends JFrame {
    JButton derButton1 = new JButton("Bestätigen");
    JTextField dieEingabe1 = new JTextField(20);
    JTextField dieEingabe2 = new JTextField(20);
    JTextField dieEingabe3 = new JTextField(20);
    JLabel dasLabel1 = new JLabel("Vorname");
    JLabel dasLabel2 = new JLabel("Nachname");
    JLabel dasLabel3 = new JLabel("Kontonummer");
    public static void main(String[] args) {
        new Kontoauszug();
    }

    public Kontoauszug() {
        setBackground(new Color(200,100,100));
        this.setTitle("Kontoauszug");
        setLayout(null);
        this.pack();
        this.setVisible(true);
        this.setSize(400,400);
        add(derButton1);
        add(dieEingabe1);
        add(dieEingabe2);
        add(dieEingabe3);
        add(dasLabel1);
        add(dasLabel2);
        add(dasLabel3);
        derButton1.setBounds(50,250,150,20);
        dieEingabe1.setBounds(10,10,150,20);
        dieEingabe2.setBounds(10,50,150,20);
        dieEingabe3.setBounds(10,90,150,20);
        dasLabel1.setBounds(170,10,150,20);
        dasLabel2.setBounds(170,50,150,20);
        dasLabel3.setBounds(170,90,150,20);
        derButton1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    verarbeiteButtonClick1();
                }
            });
    }
    void verarbeiteButtonClick1(){
        new Auszug();
    }
}
