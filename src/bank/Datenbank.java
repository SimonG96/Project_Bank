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
    private final String KUNDEN_FILENAME = "Kunden.txt";
    private final String KUNDEN_DATENBANK_REGEX = "<.*\\;.*\\;.*\\;.*\\;.*\\;.*\\;.*>";

    private final String KONTENBEWEGUNG_FILENAME = "Kontenbewegung.txt";
    private final String KONTENBEWEGUNG_DATENBANK_REGEX = "<.*\\;.*\\;.*\\;.*>";

    private File KundenFile;
    private ArrayList<Kunde> Kunden;
    
    private File KontenbewegungenFile;
    private ArrayList<Kontenbewegung> Kontenbewegungen;

    public Datenbank(){
        Kunden = new ArrayList<>();
        KundenFile = new File(KUNDEN_FILENAME);

        if (!KundenFile.exists()){
            CreateFile(KundenFile);
        }
        else {
            try {
                ReadKundenFile(KundenFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        Kontenbewegungen = new ArrayList<>();
        KontenbewegungenFile = new File(KONTENBEWEGUNG_FILENAME);
        
        if (!KontenbewegungenFile.exists()){
            CreateFile(KontenbewegungenFile);            
        }
        else {
            try {
                ReadKontenbewegungenFile(KontenbewegungenFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void CreateFile(File file){
        try
        {
            file.createNewFile();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void ReadKundenFile(File file) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try
        {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            do {
                line = bufferedReader.readLine();
                DatabaseFileEntry entry = new DatabaseFileEntry(line);
                //null check
                if (entry.MatchesEntry(KUNDEN_DATENBANK_REGEX)){
                    String[] splittedLine = entry.SplitEntry(KUNDEN_DATENBANK_REGEX);
                    String vorname = splittedLine[0];
                    String nachname = splittedLine[1];
                    String ort = splittedLine[2];
                    String straße = splittedLine[3];
                    int kundennummer = Integer.parseInt(splittedLine[4]);
                    int kontonummer = Integer.parseInt(splittedLine[5]);
                    
                    double kontostand = 0;
                    if (!splittedLine[6].equals("0"))
                    {
                        kontostand = Double.parseDouble(splittedLine[6]);
                    }
                    
                    //Konto konto = new Konto(kontonummer, kontostand, this);
                    Kunde kunde = new Kunde(vorname, nachname, ort, straße, kundennummer, /*konto,*/kontonummer, kontostand, this);
                    Kunden.add(kunde);
                }

            } while (null != line);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            if (bufferedReader != null)
            {
                bufferedReader.close();
            }
            if (fileReader != null)
            {
                fileReader.close();
            }
        }
    }
    
    private void ReadKontenbewegungenFile(File file) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try
        {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            do {
                line = bufferedReader.readLine();
                DatabaseFileEntry entry = new DatabaseFileEntry(line);
                //null check
                if (entry.MatchesEntry(KONTENBEWEGUNG_DATENBANK_REGEX)){
                    String[] splittedLine = entry.SplitEntry(KONTENBEWEGUNG_DATENBANK_REGEX);
                    int kundennummer = Integer.parseInt(splittedLine[0]);
                    int kontonummer = Integer.parseInt(splittedLine[1]);
                    double kontostand = Double.parseDouble(splittedLine[2]);
                    double bewegung = Double.parseDouble(splittedLine[3]);
                    Kontenbewegung kontenbewegung = new Kontenbewegung(kundennummer, kontonummer, kontostand, bewegung);
                    Kontenbewegungen.add(kontenbewegung);
                }

            } while (null != line);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            if (bufferedReader != null)
            {
                bufferedReader.close();
            }
            if (fileReader != null)
            {
                fileReader.close();
            }
        }
    }

    private void WriteToFile(File file, String string) throws IOException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try{
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(string);
            bufferedWriter.newLine();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            if (bufferedWriter != null)
            {
                bufferedWriter.close();
            }
            if ( fileWriter != null)
            {
                fileWriter.close();
            }
        }
    }

    private void WriteCustomerToFile(File file, Kunde kunde){
        String customer = "<" + kunde.GetVorname()+ ";" + kunde.GetNachname() + ";" + kunde.GetOrt() + ";" + kunde.GetStraße() + ";" + kunde.GetKundennummer() + ";" + kunde.GetKonto().getKontonr()+ ";" + kunde.GetKonto().getKontost() + ">";

        try {
            WriteToFile(file, customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void WriteKontenbewegungToFile(File file, Kontenbewegung kontenbewegung){
        String bewegung = "<" + kontenbewegung.GetKundennummer() + ";" + kontenbewegung.GetKontonummer() + ";" + kontenbewegung.GetKontostand() + ";" + kontenbewegung.GetBewegung() + ">";

        try {
            WriteToFile(file, bewegung);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AddCustomer(Kunde kunde){
        Kunden.add(kunde);
        WriteCustomerToFile(KundenFile, kunde);
    }
    
    public void AddKontenbewegung(Kontenbewegung kontenbewegung){
        Kontenbewegungen.add(kontenbewegung);
        WriteKontenbewegungToFile(KontenbewegungenFile, kontenbewegung);
    }

    public int GetLastKundennummer(){
        if (Kunden.size()>=1)
        {
            return Kunden.get(Kunden.size()-1).GetKundennummer();
        }
        else
        {
            return 0;
        }
    }
    
    public int GetLastKontonummer(){
        if (Kunden.size()>=1)
        {
            return Kunden.get(Kunden.size()-1).GetKonto().getKontonr();
        }
        else
        {
            return 0;
        }
    }

    public Konto GetKontoByKontonummer(int kontonummer){
        for (int i = 0; i < Kunden.size(); i++){
            Konto konto = Kunden.get(i).GetKonto();
            if (konto.getKontonr() == kontonummer){
                return konto;
            }
        }

        return null;
    }

    public boolean IsAnyCustomerAvailable(){
        if (Kunden.size() == 0){
            return false;
        }
        else{
            return true;
        }
    }

    public void OnClosing(){
        KundenFile.delete();
        CreateFile(KundenFile);

        for (int i = 0; i < Kunden.size(); i++){
            WriteCustomerToFile(KundenFile, Kunden.get(i));
        }
    }

    /*public void RemoveCustomer(Kunde kunde){
        Kunden.remove(kunde);
    }*/
}
