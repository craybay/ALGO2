package model;

	public class Opdracht {
		private int opdrachtID;
		private String vraag;
		private String juisteAntwoord;
		private boolean hoofdLetterGevoelig;
		private String antwoordHint;
		private String categorie;
		private String auteur;
		
		public Opdracht(String vraag, String juisteAntwoord,
				boolean hoofdLetterGevoelig, String antwoordHint, String categorie,
				String auteur) {
			setVraag(vraag);
			setJuisteAntwoord(juisteAntwoord);
			setHoofdLetterGevoelig(hoofdLetterGevoelig);
			setAntwoordHint(antwoordHint);
			setCategorie(categorie);
			setAuteur(auteur);
		}	
		
		public Opdracht(int opdrachtID, String vraag, String juisteAntwoord,
				boolean hoofdLetterGevoelig, String antwoordHint, String categorie,
				String auteur) {
			setOpdrachtID(opdrachtID);
			setVraag(vraag);
			setJuisteAntwoord(juisteAntwoord);
			setHoofdLetterGevoelig(hoofdLetterGevoelig);
			setAntwoordHint(antwoordHint);
			setCategorie(categorie);
			setAuteur(auteur);
		}	
		
		public int getOpdrachtID() {
			return opdrachtID;
		}

		public void setOpdrachtID(int opdrachtID) {
			this.opdrachtID = opdrachtID;
		}

		public String getVraag() {
			return vraag;
		}

		public void setVraag(String vraag) {
			this.vraag = vraag;
		}

		public String getJuisteAntwoord() {
			return juisteAntwoord;
		}

		public void setJuisteAntwoord(String juisteAntwoord) {
			this.juisteAntwoord = juisteAntwoord;
		}

		public boolean isHoofdLetterGevoelig() {
			return hoofdLetterGevoelig;
		}

		public void setHoofdLetterGevoelig(boolean hoofdLetterGevoelig) {
			this.hoofdLetterGevoelig = hoofdLetterGevoelig;
		}

		public String getAntwoordHint() {
			return antwoordHint;
		}

		public void setAntwoordHint(String antwoordHint) {
			this.antwoordHint = antwoordHint;
		}

		public String getCategorie() {
			return categorie;
		}

		public void setCategorie(String categorie) {
			this.categorie = categorie;
		}

		public String getAuteur() {
			return auteur;
		}

		public void setAuteur(String auteur) {
			this.auteur = auteur;
		}

		@Override
		public int hashCode() {
			int result = 0;
			result += opdrachtID + vraag.hashCode() + categorie.hashCode() + auteur.hashCode();
			result /= 2;
			return result;
		}
		
		public boolean equals(Object o){
			boolean isZelfde = false;
			if(o != null && o instanceof Opdracht) {
				Opdracht opdracht = (Opdracht) o;
				if(opdracht.getOpdrachtID() == this.getOpdrachtID()
						&& opdracht.getVraag() == this.getVraag() 
						&& opdracht.getJuisteAntwoord() == this.getJuisteAntwoord()
								&& opdracht.isHoofdLetterGevoelig() == this.isHoofdLetterGevoelig()
										&& opdracht.getAntwoordHint() == this.getAntwoordHint()
												&& opdracht.getCategorie() == this.getCategorie()
														&& opdracht.getAuteur() == this.getAuteur()
						){
					isZelfde= true;
				}
			}
			return isZelfde;
		}
		
		@Override 
		public String toString() {
			return  getOpdrachtID() + "\t" + getVraag() + "\t" + getJuisteAntwoord() 
					 + "\t" + isHoofdLetterGevoelig() + "\t" + getAntwoordHint() 
					 + "\t" + getCategorie() + "\t" + getAuteur();
			}
}