package model;
import model.Opdracht;

public class OpdrachtLijst {
	private Opdracht [] opdrachtenRij;
	private int aantalOpdrachten = 0; //hoeveel opdrachtobjecten zitten in opdrachtenRij
	private int capaciteit = 10; // huidige capciteit van de opdrachtenRij;
	
	public OpdrachtLijst(){
	}
	
	public OpdrachtLijst (int capaciteit) throws IllegalArgumentException{
		setCapaciteit(capaciteit);
		opdrachtenRij = new Opdracht[getCapaciteit()];
	}

	public int getCapaciteit() {
		return capaciteit;
	}

	public void setCapaciteit(int capaciteit) throws IllegalArgumentException{
		if (capaciteit <=0 ){
			throw new IllegalArgumentException ("capaciteit mag niet negatief of nul zijn");
			}
		this.capaciteit = capaciteit;
	}
	

	public void setAantalOpdrachten(int aantalOpdrachten) throws IllegalArgumentException{
		if (aantalOpdrachten < 0 ){
			throw new IllegalArgumentException ("aantalOpdrachten mag niet negatief zijn");
			}
		this.aantalOpdrachten = aantalOpdrachten;
	}
	
	// hoeveel opdrachtobjecten zitten er in de opdrachtenRij
	public int getAantalOpdrachten(){
		return aantalOpdrachten;
	}
	
	public int berekenAantalOpdrachten(){
		int aantOpdr=0;
		for (int k=0; k<getCapaciteit(); k++){
			if (this.getOpdracht(k)!=null){
				aantOpdr++;
				}
		}
		return aantOpdr;
	}
	
	public boolean isLeeg(){
		boolean leeg = false;
		if (this.getAantalOpdrachten() == 0){
		leeg = true;
		}
		return leeg;
	}
	
	//return opdrachtobject op plaats index in de opdrachtenRij
	public Opdracht getOpdracht(int index) throws IndexOutOfBoundsException{
		if (index < 0 || index >= getCapaciteit()){
			throw new IndexOutOfBoundsException ("index is verkeerd");
			}
		return opdrachtenRij[index];
	}
	
	// zet op de plaats index in de opdrachtenRij het opdrachtobject opdrachtNieuw
	// en returned de eventuele opdracht die op plaats index in de opdrachtenRij al aanwezig is
	public Opdracht setOpdracht(int index, Opdracht opdrachtNieuw)throws IndexOutOfBoundsException{
		if (index < 0 || index >= getCapaciteit()){
			throw new IndexOutOfBoundsException ("index is verkeerd");
			}
		if (getOpdracht(index)!=null){
		Opdracht tijdelijk=getOpdracht(index);
		voegOpdrachtToe(index, opdrachtNieuw);
	    return tijdelijk;
	    } else {
	    	voegOpdrachtToe(index, opdrachtNieuw);
	    	return null;
	    }
	}
	
	//voegt een nieuwe opdracht toe achteraan de opdrachtenRij
	//indien deze rij volledig gevuld is wordt de capaciteit van deze rij verdubbeld
    public boolean voegOpdrachtToe(Opdracht opdrachtNieuw){
		if (getAantalOpdrachten() == getCapaciteit()){
			setCapaciteit(2*getCapaciteit());
			Opdracht [] opdrachtrijtemp = new Opdracht [getCapaciteit()];
			for (int b=0; b < getAantalOpdrachten();b++){
				opdrachtrijtemp[b]=opdrachtenRij[b];
				}
			opdrachtrijtemp[getAantalOpdrachten()]=opdrachtNieuw;
			opdrachtenRij=opdrachtrijtemp;
			setAantalOpdrachten(getAantalOpdrachten()+1);
			return true;
			}	
		else {
			opdrachtenRij[getAantalOpdrachten()]=opdrachtNieuw;
			setAantalOpdrachten(getAantalOpdrachten()+1);
			return true;
		}
	}
	
	//voegt een nieuwe opdracht toe op de plaats index in de opdrachtenRij
	//alle elementen in de opdrachtenRij worden vanaf plaats index 1 positie opgeschoven
	//indien deze rij volledig gevuld is wordt de capaciteit van deze rij verdubbeld
	public boolean voegOpdrachtToe(int index, Opdracht opdrachtNieuw)throws IndexOutOfBoundsException{
		int g=0;
		int h=0;
		int i=0;
		int j=0;
		if (index < 0 || index >= getCapaciteit()){
			throw new IndexOutOfBoundsException ("index is verkeerd");
			}
		else if (this.getAantalOpdrachten()+1 < this.getCapaciteit()){
			Opdracht [] opdrachtrijtemp=new Opdracht [this.getCapaciteit()];
			for (g=0; g<index; g++){
				opdrachtrijtemp[g]=opdrachtenRij[g];
			}
	     	opdrachtrijtemp[index]=opdrachtNieuw;
			for (h=index; h<this.getAantalOpdrachten(); h++){
				opdrachtrijtemp[h+1]=opdrachtenRij[h];
			}
			opdrachtenRij=opdrachtrijtemp;
			setAantalOpdrachten(getAantalOpdrachten()+1);
			return true;
		} else {
			Opdracht [] opdrachtrijtemp=new Opdracht [2*this.getCapaciteit()];
			for (i=0; i<index; i++){
				opdrachtrijtemp[i]=opdrachtenRij[i];
			}
			opdrachtrijtemp[index]=opdrachtNieuw;
			for (j=index; j<this.getAantalOpdrachten(); j++){
				opdrachtrijtemp[j+1]=opdrachtenRij[j];
			}
			opdrachtenRij=opdrachtrijtemp;
			setAantalOpdrachten(getAantalOpdrachten()+1);
			return true;
		}
	}
			
	//verwijder de eventuele opdracht op plaats index in de opdrachtenRij
	//vanaf plaats index worden alle elementen 1 positie naar voren geschoven
	public Opdracht verwijderOpdracht(int index) throws IndexOutOfBoundsException{
		int g=0;
		int h=0;
		if (index < 0 || index >= getAantalOpdrachten()){
			throw new IndexOutOfBoundsException ("index is verkeerd");
			}
		Opdracht [] opdrachtrijtemp= new Opdracht [getCapaciteit()];
			for (g=0; g<index; g++){
				opdrachtrijtemp[g]=opdrachtenRij[g];
			}
			for (h=index; h<getCapaciteit(); h++){
				opdrachtrijtemp[h]=opdrachtenRij[h+1];
			}
			Opdracht tijdelijk = new Opdracht();
			tijdelijk=this.getOpdracht(index);
			opdrachtenRij=opdrachtrijtemp;
			setAantalOpdrachten(getAantalOpdrachten()-1);
		    return tijdelijk;
	}	
	
	//controleert of de opdracht aanwezig is in de opdrachtRij
	public boolean isOpdrachtAanwezig(Opdracht opdracht){
		boolean result=false;
		for (int i=0; i<getAantalOpdrachten() && !result; i++){
			if (this.getOpdracht(i).equals(opdracht)){
				result=true;
			}
		}
		return result;
	}
	
	public boolean equals(Object o){
		int t=0;
		int counter=0;
		boolean isZelfde = false;
		if (o != null && o instanceof OpdrachtLijst) {
			OpdrachtLijst OL = (OpdrachtLijst) o;
			if(OL.getCapaciteit() == this.getCapaciteit() && OL.getAantalOpdrachten() == this.getAantalOpdrachten()){
				for (t=0; t<this.getAantalOpdrachten(); t++){
					if (OL.getOpdracht(t).equals(this.getOpdracht(t))){
						counter++;
					}
				}
				if (counter==this.getAantalOpdrachten()){
					isZelfde = true;
				}
			}	
			}
		return isZelfde;
	}
	
	//elke opdracht uit de opdrachtenRij(volgens toString van Opdracht klasse), elke opdracht op een nieuwe lijn
	public String toString() {
		String uitvoerString = "";
		for(Opdracht opdr : opdrachtenRij){
			if (opdr != null){
			uitvoerString += opdr.toString() + "\n";
			}
		}
		return uitvoerString;
	}
}
