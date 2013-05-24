package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JOptionPane;


public class CategorienmetaantalOpdrachten {
	private OpdrachtenDatabase opdrDB; 
	private HashMap<String, Opdracht> invoerhashmap = new HashMap<String, Opdracht>();
	private String bestand;
	
	public CategorienmetaantalOpdrachten(String bestand){
		opdrDB = new OpdrachtenDatabase (bestand);
	}
	
	private void VulInvoerHashmap(){
		opdrDB.leesOpdrachten();
		for (int k=0; k < opdrDB.getAlleOpdrachten().size(); k++){
			invoerhashmap.put(opdrDB.getAlleOpdrachten().get(k).getCategorie(), opdrDB.getAlleOpdrachten().get(k));
		}
	}
		
	private ArrayList<String> GeefCategorien(){
		Set<String> Categorien = invoerhashmap.keySet();
		ArrayList<String> lijstvancat = new ArrayList<String>();
		for (String categorie : Categorien) {
			lijstvancat.add(categorie);
		    }
		Collections.sort(lijstvancat);
		return lijstvancat;
	}
	
	public void GenereerOverzicht(){
			this.VulInvoerHashmap();
			ArrayList<String> lijstvancatgesorteerd = this.GeefCategorien();
			for (String categorie : lijstvancatgesorteerd) {
				int aantal = 0;
				aantal = opdrDB.getOpdrachtenVanCategorie(categorie).size();
				System.out.println(categorie + "\t" + aantal);
			}
	}
	public void SchrijfOverzicht(){
		try {
			File uitvoer = new File("categorienmetaantallen.txt");
			PrintWriter schrijver = new PrintWriter(uitvoer);
			this.VulInvoerHashmap();
			ArrayList<String> lijstvancatgesorteerd = this.GeefCategorien();
			for (String categorie : lijstvancatgesorteerd) {
				int aantal = 0;
				aantal = opdrDB.getOpdrachtenVanCategorie(categorie).size();
				schrijver.println(categorie + "\t" + aantal);
			}
			schrijver.close();
		}
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		return "CategorienmetaantalOpdrachten [opdrDB=" + opdrDB
				+ ", invoerhashmap=" + invoerhashmap + ", bestand=" + bestand
				+ "]";
	}
}
