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
    private String Ort;
    private String Straße;
    private int Kundennummer;
    private Konto Konto;

    private Datenbank Datenbank;

    public Kunde(String vorname, String nachname, String ort, String straße, int kundennummer, /*Konto konto,*/int kontonummer, int kontostand, Datenbank datenbank){
        Datenbank = datenbank;

        Vorname = vorname;
        Nachname = nachname;
        Ort = ort;
        Straße = straße;
        Kundennummer = kundennummer;
        //Konto = konto;
        Konto = new Konto(kontonummer, kontostand, Datenbank, this);
    }

    public Kunde(String vorname, String nachname, String ort, String straße, /*Konto konto,*/ Datenbank datenbank){
        Datenbank = datenbank;

        Vorname = vorname;
        Nachname = nachname;
        Ort = ort;
        Straße = straße;
        Kundennummer = datenbank.GetLastKundennummer()+1; //Kundennummer hochzählen (letzte vorhandene Kundennummer ++)
        //Konto = konto;
        int kontonr = datenbank.GetLastKontonummer() + 1; //Kontonummer hochzählen (letzte vorhandene Kontonummer ++)
        Konto = new Konto(kontonr, 0, datenbank, this);
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

    public String GetOrt() {
        return Ort;
    }

    public String GetStraße() {
        return Straße;
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
