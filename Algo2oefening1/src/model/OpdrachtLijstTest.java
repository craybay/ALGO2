package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OpdrachtLijstTest {
	private Opdracht opdracht1;
	private Opdracht opdracht2; 
	private Opdracht opdracht3; 
	private Opdracht kopievano2;
	
	@Before
	public void setUp() throws Exception {
		opdracht1 = new Opdracht("dag van vandaag", "donderdag", false, "Do", "Dagen","J.Vgw");
		opdracht2 = new Opdracht("dag van gisteren", "woensdag", false, "Wo", "Dagen","J.Vgw");
		opdracht3 = new Opdracht("dag van morgen", "vrijdag", false, "Vr", "Dagen","J.Vgw");
		kopievano2 = new Opdracht("dag van gisteren", "woensdag", false, "Wo", "Dagen","J.Vgw");
	}
	
	@Test
	public void test_eerste_nieuw_object_geeft_2_0_true() {
		OpdrachtLijst OLijst1= new OpdrachtLijst(2);
		assertEquals(2, OLijst1.getCapaciteit());
		assertEquals(0, OLijst1.getAantalOpdrachten());
		assertTrue(OLijst1.isLeeg());	
	}
	
	@Test
	public void test_idem1_nieuw_object_geeft_2_true_true_1_2_false() {
		OpdrachtLijst OLijst1= new OpdrachtLijst(2);
		assertEquals(2, OLijst1.getCapaciteit());
		assertTrue(OLijst1.voegOpdrachtToe(opdracht1));
		assertEquals("Opdracht met nr0,met de vraag: dag van vandaag en antwoord: donderdag, is hoofdlettergevoelig:false een hint is: Do Deze opdracht zit in de Dagen categorie, gemaakt door J.Vgw" + "\n", OLijst1.toString());  
		assertEquals(1, OLijst1.getAantalOpdrachten());
		assertEquals(2, OLijst1.getCapaciteit());
		assertFalse(OLijst1.isLeeg());	
	}
	
	@Test
	public void test_idem2_twee_nieuwe_objecten_moet_werken() {
		OpdrachtLijst OLijst1= new OpdrachtLijst(2);
		assertTrue(OLijst1.voegOpdrachtToe(opdracht1));
		assertTrue(OLijst1.voegOpdrachtToe(opdracht2));
		assertEquals("Opdracht met nr0,met de vraag: dag van vandaag en antwoord: donderdag, is hoofdlettergevoelig:false een hint is: Do Deze opdracht zit in de Dagen categorie, gemaakt door J.Vgw" + "\n" +
				"Opdracht met nr0,met de vraag: dag van gisteren en antwoord: woensdag, is hoofdlettergevoelig:false een hint is: Wo Deze opdracht zit in de Dagen categorie, gemaakt door J.Vgw" + "\n", OLijst1.toString());  
		assertEquals(2, OLijst1.getCapaciteit());
		assertTrue(OLijst1.voegOpdrachtToe(opdracht3));
		System.out.println(OLijst1.toString());
		assertEquals(4, OLijst1.getCapaciteit());
		assertEquals(3, OLijst1.getAantalOpdrachten());
	}
	
	@Test
	public void test_setUp_geeft_juiste_resultaten() {
		assertEquals("Opdracht met nr0,met de vraag: dag van vandaag en antwoord: donderdag, is hoofdlettergevoelig:false een hint is: Do Deze opdracht zit in de Dagen categorie, gemaakt door J.Vgw", opdracht1.toString());  
		assertEquals("Opdracht met nr0,met de vraag: dag van gisteren en antwoord: woensdag, is hoofdlettergevoelig:false een hint is: Wo Deze opdracht zit in de Dagen categorie, gemaakt door J.Vgw", opdracht2.toString());
		assertEquals("Opdracht met nr0,met de vraag: dag van morgen en antwoord: vrijdag, is hoofdlettergevoelig:false een hint is: Vr Deze opdracht zit in de Dagen categorie, gemaakt door J.Vgw", opdracht3.toString());
		assertEquals("Opdracht met nr0,met de vraag: dag van gisteren en antwoord: woensdag, is hoofdlettergevoelig:false een hint is: Wo Deze opdracht zit in de Dagen categorie, gemaakt door J.Vgw", kopievano2.toString());
	}
	
	@Test
	public void test_equals_lijst_en_opdracht_geeft_false_en_true() {
		OpdrachtLijst OLijst1= new OpdrachtLijst(2);
		assertTrue(OLijst1.voegOpdrachtToe(opdracht1));
		assertFalse(OLijst1.getOpdracht(0).getVraag().equals(kopievano2.getVraag()));
	}
	
	@Test
	public void test_verwijderopdracht_van_lijst() {
		OpdrachtLijst OLijst1= new OpdrachtLijst(2);
		assertTrue(OLijst1.voegOpdrachtToe(opdracht1));
		assertEquals(opdracht1, OLijst1.verwijderOpdracht(0));
		assertEquals("", OLijst1.toString());
	}
	
	
	/*
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


}
