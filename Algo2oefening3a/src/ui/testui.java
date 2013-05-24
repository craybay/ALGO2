
package ui;

import database.OpdrachtenDatabase;

public class testui {
	public static void main(String[] args) {
	String bestand = "Opdrachten";
	OpdrachtenDatabase eerstetest = new OpdrachtenDatabase(bestand);
	eerstetest.leesOpdrachten();
	eerstetest.schrijfOpdrachten();
	System.exit(0);
	}
}