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
        // TODO code application logic here
        Datenbank = new Datenbank();
        
        new Oberflaeche();
    }
    
}
