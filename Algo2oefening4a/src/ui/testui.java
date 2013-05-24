
package ui;

import model.CategorienmetaantalOpdrachten;


public class testui {
	public static void main(String[] args) {
	String bestand = "Opdrachten";
	CategorienmetaantalOpdrachten CataantOpdr = new CategorienmetaantalOpdrachten(bestand);
	CataantOpdr.GenereerOverzicht();
	System.exit(0);
	}
}