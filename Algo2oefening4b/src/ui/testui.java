
package ui;

import database.GemeenschappelijkeQuizzenmetopdrachten;

public class testui {
	public static void main(String[] args) {
	String bestand = "Quiz";
	String bestandopdrachten = "Opdrachten";
	String onderwerp = "Blokken";
	String klascode = "5B";	
	String auteur = "Dorthea Mcduffy";
	GemeenschappelijkeQuizzenmetopdrachten eerstetest = new GemeenschappelijkeQuizzenmetopdrachten(bestand, bestandopdrachten);
	eerstetest.startsetup();
	eerstetest.GenereerOverzicht(onderwerp, klascode, auteur);
	System.exit(0);
	}
}