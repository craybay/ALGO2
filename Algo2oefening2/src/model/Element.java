package model;

import model.Opdracht;

public class Element {
	private Opdracht opdracht;
	private Element volgend;

	public Element(Opdracht opdracht){
		this.setOpdracht(opdracht);
		this.setVolgend(null);
	}

	public Element(Opdracht opdracht, Element element){
		this.setOpdracht(opdracht);
		this.setVolgend(element);
	}

	public Opdracht getOpdracht() {
		return opdracht;
	}

	public void setOpdracht(Opdracht opdracht) {
		 this.opdracht = opdracht;
	}

	public Element getVolgend() {
		return volgend;
	}

	public void setVolgend(Element volgend) {
		this.volgend = volgend;
	}

}