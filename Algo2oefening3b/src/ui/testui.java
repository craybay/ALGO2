
package ui;

import database.QuizDatabase;

public class testui {
	public static void main(String[] args) {
	String bestand = "Quiz";
	String bestandopdrachten = "Opdrachten";
	QuizDatabase eerstetest = new QuizDatabase(bestand, bestandopdrachten);
	eerstetest.leesQuizzen();
	eerstetest.schrijfQuizzen();
	System.exit(0);
	}
}