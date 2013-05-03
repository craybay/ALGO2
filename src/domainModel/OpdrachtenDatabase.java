/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domainModel;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author 543237
 */
public class OpdrachtenDatabase {
    private String bestand;
    private ArrayList<Opdracht>opdrachten = new ArrayList<Opdracht>();

    public OpdrachtenDatabase(String bestand)throws NullPointerException , IllegalArgumentException {
        setBestand(bestand);
    }

    public void setBestand(String bestand)throws NullPointerException, IllegalArgumentException {
     if(bestand == null)throw new NullPointerException("Er is geen bestand opgegeven");
     if("".equals(bestand)) throw new IllegalArgumentException("Er is niets opgeven in bestand");
     
    }
    
    public String getBestand(){
        return this.bestand;
    }
    
    public boolean voegOpdrachtToe(Opdracht element) throws NullPointerException{
        boolean uit = false;
        if(element == null){
            throw new NullPointerException("Er is geen element opgegeven");
            
            
        }
       uit = true;
        this.opdrachten.add(element);
         return uit;
        
    }
    
}
    
    
    
    
    
    
    
