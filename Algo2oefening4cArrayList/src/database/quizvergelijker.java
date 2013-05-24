package database;

import java.util.Comparator;

import model.Quiz;

public class quizvergelijker implements Comparator<Quiz> {
	public int compare (Quiz q1, Quiz q2) {
		return q2.compareTo(q1);
	}
}