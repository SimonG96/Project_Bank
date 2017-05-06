/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author mike.lauber
 */
public class Konto {
    
    private int Kontonr;
    private double Kontost;
    
    private Datenbank Datenbank;
    private Kunde Kunde;

    public Konto (int kontonr, double kontost, Datenbank datenbank, Kunde kunde){
        Datenbank = datenbank;
        Kunde = kunde;
    
        this.Kontonr = kontonr;
        this.Kontost = kontost;
    }

    public int getKontonr(){
        return Kontonr;
    }

    public double getKontost (){
        return Kontost;
    }

    public Kunde getKunde() {
        return Kunde;
    }

    public void Einzahlung(double mehrung) {

        Kontost += mehrung;
        Kontenbewegung kontenbewegung = new Kontenbewegung(Kunde.GetKundennummer(), Kontonr, Kontost, mehrung);
        Datenbank.AddKontenbewegung(kontenbewegung);
    }

    public void Auszahlung (double minderung){
    
        Kontost -= minderung;
        Kontenbewegung kontenbewegung = new Kontenbewegung(Kunde.GetKundennummer(), Kontonr, Kontost, minderung);
        Datenbank.AddKontenbewegung(kontenbewegung);
    }
}

