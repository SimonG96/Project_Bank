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
public class Kunde {
    
    private String Vorname;
    private String Nachname;
    private int Kundennummer;
    private Konto Konto;

    private Datenbank Datenbank;

    public Kunde(String vorname, String nachname, int kundennummer, Konto konto, Datenbank datenbank){
        Datenbank = datenbank;

        Vorname = vorname;
        Nachname = nachname;
        Kundennummer = kundennummer;
        Konto = konto;
    }

    public Kunde(String vorname, String nachname, Konto konto, Datenbank datenbank){
        Datenbank = datenbank;

        Vorname = vorname;
        Nachname = nachname;
        Kundennummer = datenbank.GetLastKontonummer()+1; //Kundennummer hochzählen (letzte vorhandene Kundennummer ++)
        Konto = konto;
    }
    
    public void SetVorname(String vorname){
        Vorname = vorname;
    }
    
    public String GetVorname(){
        return Vorname;
    }
    
    public void SetNachname(String nachname){
        Nachname = nachname;
    }
    
    public String GetNachname(){
        return Nachname;
    }
    
    public int GetKundennummer(){
        return Kundennummer;
    }
    
    public Konto GetKonto(){
        return Konto;
    }
    
    public void KundeAbspeichern(){
        Datenbank.AddCustomer(this);
    }
}
