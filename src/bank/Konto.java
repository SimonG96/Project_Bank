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
    private int Kontost;
    


public Konto (){

    this.Kontonr = Kontonr;
    this.Kontost = Kontost;

}

public int getKontost (){
    
    return Kontost;
}

public void Einzahlung (int mehrung){
    
    Kontost += mehrung;
}

public void Auszahlung (int minderung){
    
    Kontost -= minderung;
}

    

}

