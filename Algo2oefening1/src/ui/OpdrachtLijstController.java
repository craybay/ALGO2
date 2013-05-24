package ui;

import model.Opdracht;
import model.OpdrachtLijst;

public class OpdrachtLijstController {
	
	public static void main(String[] args) {
		OpdrachtLijst OLijst1= new OpdrachtLijst(2);
		System.out.println(OLijst1.getCapaciteit());         // moet 2 zijn 
		System.out.println(OLijst1.getAantalOpdrachten());   // moet 0 zijn 
		System.out.println(OLijst1.isLeeg());                // moet true zijn 
		
		
		Opdracht opdracht1 = new Opdracht("dag van vandaag", "donderdag", false, "Do", "Dagen","J.Vgw");
		System.out.println(opdracht1.toString());  
		Opdracht opdracht2 = new Opdracht("dag van gisteren", "woensdag", false, "Wo", "Dagen","J.Vgw");
		System.out.println(opdracht2.toString());
		Opdracht opdracht3 = new Opdracht("dag van morgen", "vrijdag", false, "Vr", "Dagen","J.Vgw");
		System.out.println(opdracht3.toString());
		Opdracht kopievano2 = new Opdracht("dag van gisteren", "woensdag", false, "Wo", "Dagen","J.Vgw");
		System.out.println(kopievano2.toString());
		
		
		System.out.println(OLijst1.getCapaciteit());           // moet 2 zijn 
		OLijst1.voegOpdrachtToe(opdracht1);
		// bovenstaande regel of deze: OLijst1.setOpdracht(0, opdracht1);
		
		System.out.println(OLijst1.toString());
		System.out.println(OLijst1.getAantalOpdrachten());     // moet 1 zijn
		System.out.println(OLijst1.getCapaciteit());           // moet 2 zijn 

	
		OLijst1.voegOpdrachtToe(opdracht2);
		System.out.println(OLijst1.toString());
		
		System.out.println(OLijst1.getCapaciteit());           // moet 2 zijn 
       
		
		OLijst1.voegOpdrachtToe(2, opdracht3);
		System.out.println(OLijst1.getCapaciteit());           // moet 4 zijn 
		
        //na correctie textcase hier verder gaan:
		if (OLijst1.getOpdracht(1).getVraag().equals(kopievano2.getVraag())){
			System.out.println("o&kzijngelijk=juist");
		} else {System.out.println("o&kzijngelijk=fout");
		}
		
		
		OLijst1.verwijderOpdracht(0);
		System.out.println(OLijst1.toString());
		
		if (OLijst1.getOpdracht(0).getVraag()==kopievano2.getVraag()){
			System.out.println("o&kzijngelijk=juist");
		} else {System.out.println("o&kzijngelijk=fout");
		}
		
		OLijst1.verwijderOpdracht(0);
		System.out.println(OLijst1.toString());
		
		if (OLijst1.getOpdracht(1)==null){
			System.out.println("n&nzijngelijk=juist");
		} else {System.out.println("n&nzijngelijk=fout");
		}
		
		System.out.println(OLijst1.isOpdrachtAanwezig(opdracht3));  // moet true zijn, opdracht 3 is het laatste element in de array
        

		System.out.println(OLijst1.toString());          // moet 1 objecten zijn, nl opdracht3
		
	
		System.out.println(OLijst1.getCapaciteit());
		
		/*
		OpdrachtLijst OLijst1kopie= new OpdrachtLijst(4);
		
		System.arraycopy (OLijst1,0,OLijst1kopie,0,OLijst1.getCapaciteit());

		
		
		System.out.println(OLijst1kopie.toString());
		System.out.println(OLijst1kopie.getCapaciteit());
		*/

		System.exit(0);
		}
	
}
