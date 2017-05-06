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
public class DatabaseFileEntry{
    
    private String Entry;
    
    public DatabaseFileEntry(String entry){
        Entry = entry;
    }
    
    public String GetEntry(){
        return Entry;
    }
    
    public String[] SplitEntry(String regex){
        if (Entry.matches(regex))
        {
            String replaceString = Entry.replace('<', ' ');
            replaceString = replaceString.replace('>', ' ');
            
            char[] stringAsCharArray = replaceString.toCharArray();

            String removedSpacesString = "";            
            for(int i = 1; i < stringAsCharArray.length-1; i++){
                removedSpacesString += stringAsCharArray[i];
            }
            
            String[] returnString = removedSpacesString.split(";");
            return returnString;
        }
        else
        {
            System.out.println("Entry does not match Regex");
            return null;
        }
    }
    
    public boolean MatchesEntry(String regex){
        return Entry.matches(regex);
    }
}
