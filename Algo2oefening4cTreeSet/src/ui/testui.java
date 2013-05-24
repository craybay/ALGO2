
package ui;

import database.GegesorteerdeQuizzen;

public class testui {
	public static void main(String[] args) {
	String bestand = "Quiz";
	String bestandopdrachten = "Opdrachten";
	GegesorteerdeQuizzen eerstetest = new GegesorteerdeQuizzen(bestand, bestandopdrachten);
	eerstetest.startsetup();
	eerstetest.GenereerOverzicht();
	System.exit(0);
	}
}