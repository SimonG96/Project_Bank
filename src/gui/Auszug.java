package gui;

/**
*
* @author d.ferber
*/

import bank.Kontenbewegung;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Auszug extends JFrame {
    public static void main(String[] args) { new Auszug(null); }

    public Auszug(List<Kontenbewegung> listOfKontenbewegungen) {
        setBackground(new Color(200,100,100));
        this.setTitle("Kontoauszug");
        setLayout(null);
        this.pack();
        this.setVisible(true);
        this.setSize(500,500);

        PrintKontoauszug(listOfKontenbewegungen);
    }

    void PrintKontoauszug(List<Kontenbewegung> listOfKontenbewegungen){
        if (listOfKontenbewegungen.size() > 0){
            JLabel lbNumberOfBewegungHead = new JLabel("Nr");
            JLabel lbPrevKontostandHead = new JLabel("Alter Kontostand");
            JLabel lbBewegungHead = new JLabel("Bewegung");
            JLabel lbNewKontostandHead = new JLabel("Neuer Kontostand");
            JSeparator sep = new JSeparator();

            add(lbNumberOfBewegungHead);
            add(lbPrevKontostandHead);
            add(lbBewegungHead);
            add(lbNewKontostandHead);
            add(sep);

            lbNumberOfBewegungHead.setBounds(10,0,150,20);
            lbPrevKontostandHead.setBounds(50,0,150,20);
            lbBewegungHead.setBounds(170,0,150,20);
            lbNewKontostandHead.setBounds(290,0,150,20);
            sep.setBounds(5, 20, 450, 2);
        }
        else{
            JLabel lbNoKontenbewegung = new JLabel("Keine Kontenbewegung verfügbar!");
            add(lbNoKontenbewegung);
            lbNoKontenbewegung.setBounds(100,30,150,20);
        }

        for (int i = 0; i < listOfKontenbewegungen.size(); i++){
            Kontenbewegung currentKontenbewegung = listOfKontenbewegungen.get(i);

            JLabel lbNumberOfBewegung = new JLabel(Integer.toString(i+1));
            JLabel lbPrevKontostand = new JLabel(Double.toString(currentKontenbewegung.GetKontostand()-currentKontenbewegung.GetBewegung()));
            JLabel lbBewegung = new JLabel(Double.toString(currentKontenbewegung.GetBewegung()));
            JLabel lbNewKontostand = new JLabel(Double.toString(currentKontenbewegung.GetKontostand()));

            add(lbNumberOfBewegung);
            add(lbPrevKontostand);
            add(lbBewegung);
            add(lbNewKontostand);

            int y = (i+1)*30;

            lbNumberOfBewegung.setBounds(10,y,150,20);
            lbPrevKontostand.setBounds(50,y,150,20);
            lbBewegung.setBounds(170,y,150,20);
            lbNewKontostand.setBounds(290,y,150,20);
        }
    }
}
