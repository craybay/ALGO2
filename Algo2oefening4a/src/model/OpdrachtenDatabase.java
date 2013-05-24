package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Opdracht;

public class OpdrachtenDatabase {
	private ArrayList<Opdracht> opdrachten = new ArrayList<Opdracht>();
	private String bestand = new String();
	private int telleropdrachtID = 0;
	
	public OpdrachtenDatabase(String bestand){
		this.setBestand(bestand);
	}
	
	
	public String getBestand(){
		return this.bestand;
	}
	
	
	public void setBestand(String bestand){
		this.bestand = bestand;
	}
	
	
	public boolean voegOpdrachtToe(Opdracht opdracht){
		telleropdrachtID++;
		opdracht.setOpdrachtID(telleropdrachtID);
		opdrachten.add(opdracht);
		return true;
	}
	
	
	public boolean vervangOpdrachtToe(Opdracht opdrachtOud, Opdracht opdrachtNieuw){
	 	int index = opdrachten.indexOf(opdrachtOud);
	 	telleropdrachtID++;
	 	opdrachtNieuw.setOpdrachtID(telleropdrachtID);
		opdrachten.set(index, opdrachtNieuw);
		return true;
	}
	
	
	public boolean verwijderOpdracht(Opdracht opdracht){
		opdrachten.remove(opdracht);
		return true;
	}
	
	
	public ArrayList<Opdracht> getAlleOpdrachten(){
		return this.opdrachten;
	}
	
	
	public ArrayList<Opdracht> getOpdrachtenVanCategorie(String Categorie){
		ArrayList<Opdracht> OVanCat = new ArrayList<Opdracht>();
		for (int i=0; i < getAlleOpdrachten().size(); i++){
			if (getAlleOpdrachten().get(i).getCategorie().equals(Categorie)){
				OVanCat.add(getAlleOpdrachten().get(i));
			}
		}
		return OVanCat;
	}
	
	
	public Opdracht getOpdracht(String vraag){
		for (int k=0; k < getAlleOpdrachten().size(); k++){
			if (getAlleOpdrachten().get(k).getCategorie().equals(vraag)){
				return getAlleOpdrachten().get(k);
			}
		}
		return null;
	}
	
	
	public void leesOpdrachten(){
		try {
			Scanner scannerFile = new Scanner(new File(getBestand()+".txt"));
			scannerFile.useDelimiter("\n");
			while (scannerFile.hasNextLine()) {
				Scanner scannerLijn = new Scanner(scannerFile.nextLine());
				scannerLijn.useDelimiter("\t");
				String idnr = scannerLijn.next();
				int id= Integer.parseInt(idnr);
				String vraag = scannerLijn.next();
				String juisteAntwoord = scannerLijn.next();
				String BOOLEANhoofdLetterGevoelig = scannerLijn.next();
				boolean hoofdLetterGevoelig = false;
				if (BOOLEANhoofdLetterGevoelig.equals("true")){
					hoofdLetterGevoelig = true;
					}
				String antwoordHint = scannerLijn.next();
				String categorie = scannerLijn.next();
				String auteur = scannerLijn.next();
				Opdracht object = new Opdracht(id, vraag, juisteAntwoord, hoofdLetterGevoelig, antwoordHint, categorie, auteur);
				this.voegOpdrachtToe(object);
				scannerLijn.close();
				}
			scannerFile.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			}
	}
	
		
	public void schrijfOpdrachten(){
		try {
			File uitvoer = new File("uitvoervaninput.txt");
			PrintWriter schrijver = new PrintWriter(uitvoer);
			for (Opdracht opdracht : opdrachten) {
				schrijver.println(opdracht.toString());
			}
			schrijver.close();
		}
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}