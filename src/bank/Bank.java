/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import gui.*;

/**
 *
 * @author s.gockner
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    
    public static Datenbank Datenbank;
    
    public static void main(String[] args) {
        Datenbank = new Datenbank();

        //TODO: write new Kontostand after Transaction or at the end etc. ...
        //TODO: check for Kunden before allowing any action except adding a new one
        //TODO: create method "Auszahlung" in EinAuszahlung
        //TODO: Add Betrag to Überweisung, add checks, call Einzahlug and Auszahlung for the two Konten
        //TODO: create Kontoauszug


        new Oberflaeche();
    }
    
}
