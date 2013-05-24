package database;

import java.util.ArrayList;
import java.util.Collections;

import model.Quiz;

public class GegesorteerdeQuizzen {
	private QuizDatabase quizDB; 
	public GegesorteerdeQuizzen(String bestand, String bestandopdrachten){
		quizDB = new QuizDatabase(bestand, bestandopdrachten);
	}
	
	public void startsetup(){
		quizDB.leesQuizzen();
	}
	public void GenereerOverzicht(){
		ArrayList<Quiz> spilquizzen = quizDB.getQuizzenlijst();
		ArrayList<Quiz> spilgesorteerdequizzen = new ArrayList<Quiz>();
		int i = 0;
		for(i=0; i < spilquizzen.size();i++) {
			spilgesorteerdequizzen.add(spilquizzen.get(i));
		}
		Collections.sort(spilgesorteerdequizzen, new quizvergelijker());
		int h = 0;
		for(h=0; h < spilquizzen.size();h++) {
			System.out.println(spilgesorteerdequizzen.get(h).HaalOpdrachten().size() + "\t" + spilgesorteerdequizzen.get(h).getOnderwerp());
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
