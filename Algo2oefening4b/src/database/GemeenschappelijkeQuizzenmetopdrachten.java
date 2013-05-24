package database;

import java.util.ArrayList;
import java.util.HashSet;

import model.Opdracht;
import model.Quiz;

public class GemeenschappelijkeQuizzenmetopdrachten {
	private QuizDatabase quizDB; 
	public GemeenschappelijkeQuizzenmetopdrachten(String bestand, String bestandopdrachten){
		quizDB = new QuizDatabase(bestand, bestandopdrachten);
	}
	
	public void startsetup(){
		quizDB.leesQuizzen();
	}
	public void GenereerOverzicht(String onderwerp, String klascode, String auteur){
		Quiz spil = quizDB.getQuiz(onderwerp, klascode, auteur);
		ArrayList<Opdracht> rijlijstspilopdrachten = spil.HaalOpdrachten();
		HashSet<Opdracht> spilhashset = new HashSet<Opdracht>();
		for(Opdracht opdracht : rijlijstspilopdrachten) {
			spilhashset.add(opdracht);
		}
		System.out.println("Geselecteerde quiz: " + spil.getOnderwerp() + "\n" + "Quizen met gemeenschappelijke opdrachten:");
		for(Quiz quiz : quizDB.getQuizzenlijst()) {
			if (!quiz.equals(spil)){
				ArrayList<Opdracht> rijlijstvergelekenopdrachten = quiz.HaalOpdrachten();
				HashSet<Opdracht> vergelijkendehashset = new HashSet<Opdracht>();
				for(Opdracht opdracht :rijlijstvergelekenopdrachten) {
					vergelijkendehashset.add(opdracht);
				}
			HashSet<Opdracht> doorsnede = new HashSet<Opdracht>(spilhashset);
			doorsnede.retainAll(vergelijkendehashset);
			if (!doorsnede.isEmpty()){
				System.out.println(quiz.getOnderwerp());
				for(Opdracht opdracht :doorsnede) {
					System.out.println("\n" + opdracht.getVraag() + " =");
				}
			}
		    }
		}
		
	}
}
	/*
	 * Geselecteerde quiz: Rekenen niveau 1 ((NAAMQUIZ))  
       Quizen met gemeenschappelijke opdrachten:
	Leren rekenen                          ((NAAMQUIZ))
		9³ =                               ((NAAMOPDRACHTVRAAG))
		(4 +3) x 11 =
	Rekenen met machten                    ((NAAMOPDRACHTVRAAG))
		9³ =
		8 * 2³ =
   
   *quizdb zie inputfile, als opdrachtid = Geselecteerde quiz.lijstvan opdrachtid, 
   *
   *bij die ((NAAMQUIZ)) genereer lijst van ((NAAMOPDRACHTVRAAG)) die gelijk zijn.
   *
   *Toon voor die quizen tevens de gemeenschappelijke opdachten (vragen). 
   *
   *Los dit op door gebruik te maken van de klasse HashSet.
   */
