package model;

import model.Opdracht;
import model.Element;

public class OpdrachtLinkedLijst {
	private Element elementStart;
	private Element element;
	private int aantalElementen; //hoeveel opdrachtobjecten zitten in gelinkte lijst	
	
	public OpdrachtLinkedLijst(){		
	}	
	
	public OpdrachtLinkedLijst(Element starter, Element el, int aantalel){
		setAantalOpdrachten(aantalel);
	}
	
	// hoeveel opdrachtobjecten zitten er in de gelinkte lijst
	public int getAantalOpdrachten(){
		return aantalElementen;
	}
	
	public void setAantalOpdrachten(int aantal){
		if (aantal>=1){
			this.aantalElementen = aantal;
					}
	}
	
	public boolean isLeeg(){
		return (aantalElementen == 0);
	}
	
	//return opdrachtobject op plaats index in de gelinkte lijst
	public Opdracht getOpdracht(int index) throws IndexOutOfBoundsException{
		int i=0;
		if (index < 0 && index > getAantalOpdrachten()){
			throw new IndexOutOfBoundsException();
		} else {
				Element o= elementStart;
				for (i=0; i<=index-1; i++){
				o = o.getVolgend();
				}
			return o.getOpdracht();
		}
	}
	
	//zet op de plaats index in de gelinkte lijst het opdrachtobject opdrachtNieuw
	//en returned de eventuele opdracht die op plaats index in de gelinkte lijst al aanwezig is
	public Opdracht setOpdracht(int index,Opdracht opdrachtNieuw)throws IndexOutOfBoundsException{
		int i=0;
		if (index < 0 && index > getAantalOpdrachten()){
			throw new IndexOutOfBoundsException();
		} else {Element o= elementStart;
				for (i=0; i<=index-2; i++){
				o = o.getVolgend();
				}
				Opdracht geefterug=o.getVolgend().getOpdracht();
				element.setOpdracht(opdrachtNieuw);
				element.setVolgend(o.getVolgend());
				o.setVolgend(element);
				setAantalOpdrachten(getAantalOpdrachten()+1);
				return geefterug;
		}
	}
	
	//voegt een nieuwe opdracht toe achteraan de gelinkte lijst
	public boolean voegOpdrachtToe(Opdracht opdrachtNieuw){
		voegOpdrachtToe(this.getAantalOpdrachten(), opdrachtNieuw);
		setAantalOpdrachten(getAantalOpdrachten()+1);
		return true;
	}
	
	//voegt een nieuwe opdracht toe op de plaats index in de gelinkte lijst
	public boolean voegOpdrachtToe(int index,Opdracht opdrachtNieuw)throws IndexOutOfBoundsException{
		int i=0;
		if (index < 0 && index > getAantalOpdrachten()){
			throw new IndexOutOfBoundsException();
		} else {Element o= elementStart;
				for (i=0; i<=index-2; i++){
				o = o.getVolgend();
				}
				element.setOpdracht(opdrachtNieuw);
				element.setVolgend(o.getVolgend());
				o.setVolgend(element);
				setAantalOpdrachten(getAantalOpdrachten()+1);
		}
		return true;
	}
	
	//verwijder de eventuele opdracht op plaats index in de gelinkte lijst
	public Opdracht verwijderOpdracht(int index) throws IndexOutOfBoundsException{
		int i=0;
		if (index < 0 && index > getAantalOpdrachten()){
			throw new IndexOutOfBoundsException();
		} else {Element o= elementStart;
				for (i=0; i<=index-2; i++){
				o = o.getVolgend();
				}
				Opdracht X=o.getVolgend().getOpdracht();
				o.setVolgend(o.getVolgend().getVolgend());
				setAantalOpdrachten(getAantalOpdrachten()-1);
				return X;
		}
	}	
	
	//controleert of de opdracht aanwezig is in de gelinkte lijst
	public boolean isOpdrachtAanwezig(Opdracht opdracht){
		int i=0;
		boolean status = false;
		Element o= elementStart;
		for (i=0; status == false && i <= getAantalOpdrachten()-1; i++){
			if ((o.getOpdracht()).equals(opdracht)) {
				status = true;
			} else {o = o.getVolgend();
			}
		}
		return status;
	}
	

/*public boolean equals(Object o){
		int t=0;
		int counter=0;
		boolean isZelfde = false;
		if (o != null && o instanceof OpdrachtLijst) {
			OpdrachtLijst OL = (OpdrachtLijst)o;
			if(OL.getCapaciteit() == this.getCapaciteit() && OL.getAantalOpdrachten() == this.getAantalOpdrachten()){
				for (t=0; t < this.getAantalOpdrachten(); t++){
					if (OL[t]==this[t]){
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
*/	
	//elke opdracht uit de gelinkte lijst(volgens toString van Opdracht klasse), elke opdracht
    //op een nieuwe lijn
	public String toString(){
		String uitvoer = new String("");
		if (this.isLeeg()==false){
			int i=0;
			Element o= elementStart;
			for (i=0; i <= getAantalOpdrachten()-1; i++){
				uitvoer += o.getOpdracht().toString();
				uitvoer += "\n";
						o = o.getVolgend();
			}
		}
		return uitvoer;
	}	
}