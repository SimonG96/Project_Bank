/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author s.gockner
 */
public class Kontenbewegung {
    private int Kundennummer;
    private int Kontonummer;
    private double Kontostand;
    private double Bewegung;
    
    public Kontenbewegung(int kundennummer, int kontonummer, double kontostand, double bewegung){
        Kundennummer = kundennummer;
        Kontonummer = kontonummer;
        Kontostand = kontostand;
        Bewegung = bewegung;
    }
    
    public int GetKundennummer(){
        return Kundennummer;
    }
    
    public int GetKontonummer(){
        return Kontonummer;
    }
    
    public double GetKontostand(){
        return Kontostand;
    }
    
    public double GetBewegung(){
        return Bewegung;
    }
}
