package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Quiz;

public class QuizDatabase {
	String bestand;
	String bestandopdrachten;
	OpdrachtenDatabase opdrachtenDB;
	private ArrayList<Quiz> quizzen = new ArrayList<Quiz>();
	
	
	public QuizDatabase(String bestand, String bestandopdrachten){
		setBestand(bestand);
		opdrachtenDB = new OpdrachtenDatabase(bestandopdrachten);
	}
	
	public String getBestand(){
		return this.bestand;
	}
	
	
	public void setBestand(String bestand){
		this.bestand = bestand;
	}
	
	public boolean voegQuizToe(Quiz quiz){
		boolean res = false;
		if (!quizzen.contains(quiz)){ // naar methode om te checken of uniek is 
			quizzen.add(quiz);
			res = true;
		}
		return res;
	}
	
	public boolean verwijderQuiz(Quiz quiz){
		quizzen.remove(quiz);
		return true;
	}

	public void leesQuizzen(){ 
		try {
			opdrachtenDB.leesOpdrachten();
			Scanner scannerFile = new Scanner(new File(getBestand()+".txt"));
			scannerFile.useDelimiter("\n");
			while (scannerFile.hasNextLine()) {
				Scanner scannerLijn = new Scanner(scannerFile.nextLine());
				scannerLijn.useDelimiter("\t");
				String onderwerp = scannerLijn.next();
				String klascode = scannerLijn.next();
				String auteur = scannerLijn.next();
				int opdrachtID1 = Integer.parseInt(scannerLijn.next());
				int opdrachtID2 = Integer.parseInt(scannerLijn.next());
				int opdrachtID3 = Integer.parseInt(scannerLijn.next());
				int opdrachtID4 = Integer.parseInt(scannerLijn.next());
				//ID's verwijzen naar de eigenlijke opdrachten
				Quiz quiztemp = new Quiz(onderwerp, klascode, auteur, opdrachtenDB.getOpdrachtByID(opdrachtID1), opdrachtenDB.getOpdrachtByID(opdrachtID2), opdrachtenDB.getOpdrachtByID(opdrachtID3), opdrachtenDB.getOpdrachtByID(opdrachtID4));
					while (scannerLijn.hasNextLine()){  //of hasNextInt();
						int opdrachtIDlater = Integer.parseInt(scannerLijn.next());
						quiztemp.VoegOpdrachtToe(opdrachtenDB.getOpdrachtByID(opdrachtIDlater));
						//herhaal invoeren van opdrachtobjecten in quiz
						}
					this.voegQuizToe(quiztemp);
				scannerLijn.close();
				}
				/*quizzen.VoegQuizToe(quiztemp);  --> methode schrijven die eerst kijkt of quiz uniek is 
				alvorens dit toe te passen !!!*/
			scannerFile.close();
		} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
	}
	
	
	public void schrijfQuizzen(){
		try {
			File uitvoer = new File("uitvoervaninputquizDB.txt");
			PrintWriter schrijver = new PrintWriter(uitvoer);
			for (Quiz quiz : quizzen) {
				schrijver.println(quiz.toString());
			}
			schrijver.close();
		}
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}
