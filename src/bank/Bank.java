/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import gui.Oberflaeche;

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
        new Oberflaeche();
    }
    
}
