package model;

import java.util.ArrayList;

public class Quiz implements Comparable<Quiz>{
	private String onderwerp, klascode, auteur;
	private ArrayList<Opdracht> opdrachten = new ArrayList<Opdracht>();
	
	public Quiz(String onderwerp, String klascode, String auteur, 
			Opdracht opdracht1, Opdracht opdracht2, Opdracht opdracht3, Opdracht opdracht4){
		setOnderwerp(onderwerp);
		setKlascode(klascode);
		setAuteur(auteur);
		VoegOpdrachtToe(opdracht1);
		VoegOpdrachtToe(opdracht2);
		VoegOpdrachtToe(opdracht3);
		VoegOpdrachtToe(opdracht4);
	}
	
	public int compareTo (Quiz o) {
		int gelijk = 0;
		if(this.HaalOpdrachten().size() > o.HaalOpdrachten().size()){
			gelijk = -1;
		}
		else if(this.HaalOpdrachten().size() < o.HaalOpdrachten().size()){
        	gelijk = 1;
		}
		else{
			gelijk=this.getOnderwerp().compareTo(o.getOnderwerp());
		}
		return gelijk;
	}
	
	public void VoegOpdrachtToe(Opdracht opdracht){
		if (!opdrachten.contains(opdracht)){
			opdrachten.add(opdracht);
		}
	}
	
	public void VerwijderOpdracht(Opdracht opdracht){
		if (opdrachten.size() > 4){
			opdrachten.remove(opdracht);
		}
	}
	
	public ArrayList<Opdracht> HaalOpdrachten(){
		return this.opdrachten;
	}
	
	public void VerwisselOpdracht(Opdracht opdrachta, Opdracht opdrachtb){
		int a = opdrachten.indexOf(opdrachta);
		int b = opdrachten.indexOf(opdrachtb);
		ArrayList<Opdracht> newopdrachtenlijst = new ArrayList<Opdracht>();
		int i=0;
		for (i=0; i<a; i++){
			newopdrachtenlijst.add(opdrachten.get(i));
		}
		newopdrachtenlijst.add(opdrachten.get(b));
		
		int h=0;
		for (h=a+1; h<b; h++){
			newopdrachtenlijst.add(opdrachten.get(h));
		}
		newopdrachtenlijst.add(opdrachten.get(a));
		
		int g=0;
		for (g=b+1; g<opdrachten.size()-1; g++){
			newopdrachtenlijst.add(opdrachten.get(g));
		}
		opdrachten = newopdrachtenlijst;
	}
	
	public String getOnderwerp() {
		return onderwerp;
	}

	private void setOnderwerp(String onderwerp) throws IllegalArgumentException {
		if (onderwerp == null || onderwerp == ""){
			throw new IllegalArgumentException("");
		}
		this.onderwerp = onderwerp;
	}

	public String getKlascode() {
		return klascode;
	}

	private void setKlascode(String klascode) throws IllegalArgumentException {
		if (klascode == null || klascode == ""){
			throw new IllegalArgumentException("");
		}
		this.klascode = klascode;
	}

	public String getAuteur() {
		return auteur;
	}

	private void setAuteur(String auteur) throws IllegalArgumentException {
		if (klascode == null || klascode == ""){
			throw new IllegalArgumentException("");
		}
		this.auteur = auteur;
	}

	@Override
	public boolean equals(Object o) {
		boolean isZelfde=false;
		if (o instanceof Quiz){
			Quiz kwis = (Quiz)o;
					if (kwis.getAuteur().equals(this.getAuteur())
							&& kwis.getKlascode().equals(this.getKlascode()) 
							&& kwis.getOnderwerp().equals(this.getOnderwerp()))
						isZelfde=true;
		}
		return isZelfde;
	}
	
	public String getAlleOpdrachtIDs(){
		String teruggeefstring = "";
		for (int r=0; r < HaalOpdrachten().size(); r++){
			teruggeefstring += "\t" + HaalOpdrachten().get(r).getOpdrachtID();
			}
		return teruggeefstring;
	}
	

	@Override
	public String toString() {
		String naarstring = this.getOnderwerp() + "\t" + this.getKlascode() + "\t" + this.getAuteur();
		naarstring += this.getAlleOpdrachtIDs();
		return naarstring;
	}

}
