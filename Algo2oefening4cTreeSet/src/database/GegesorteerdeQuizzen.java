package database;

import java.util.ArrayList;
import java.util.TreeSet;

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
		TreeSet<Quiz> spilgesorteerdequizzen = new TreeSet<Quiz>(new quizvergelijker());
		//deactiveer bovenstaande lijn code en activeer deze lijn code om te zien wat de ordering is zonder de comparator: TreeSet<Quiz> spilgesorteerdequizzen = new TreeSet<Quiz>();
		spilgesorteerdequizzen.addAll(spilquizzen);
		for(Quiz quiz : spilgesorteerdequizzen) {
			System.out.println(quiz.HaalOpdrachten().size() + "\t" + quiz.getOnderwerp());
		}
	}
}