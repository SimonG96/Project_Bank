/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author s.gockner
 */
public class Datenbank {
    private final String FILENAME = "Kunden.txt";
    private final String DATENBANK_REGEX = "<.*\\|.*\\|.*\\|.*>";
    
    private static ArrayList<Kunde> Kunden;
        
    public Datenbank(){
        Kunden = new ArrayList<>();
        File file = new File(FILENAME);
        if (!file.exists()){
            CreateFile(file);
        }
        else {
            ReadFile(file);
        }
    }
    
    private void CreateFile(File file){
        try
        {
            file.createNewFile();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void ReadFile(File file){
        try 
        {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            do {
                line = bufferedReader.readLine();
                
                if (line.matches(DATENBANK_REGEX)){
                    String[] splittedLine = line.split(DATENBANK_REGEX);
                    String vorname = splittedLine[0];
                    String nachname = splittedLine[1];
                    int kundennummer = Integer.parseInt(splittedLine[2]);
                    int kontostand = Integer.parseInt(splittedLine[3]);
                    Konto konto = new Konto();
                    Kunde kunde = new Kunde(vorname, nachname, kundennummer, konto);
                    AddCustomer(kunde);
                }
                
            } while (null != line);           
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void AddCustomer(Kunde kunde){
        Kunden.add(kunde);
        
    }
    
    public void RemoveCustomer(Kunde kunde){
        Kunden.remove(kunde);
    }
}
