package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village; 
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlEmmenager controlEmenager;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlEmenager = new ControlEmmenager(village);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testPrendreEtals() {
		assertEquals(controlPrendreEtal.prendreEtal("Existe pas", "Choux", 10), -1);
		assertNotEquals(controlPrendreEtal.prendreEtal("Abraracourcix", "Choux", 10), -1);
	}
	
	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("Existe pas", "Choux", 10);
		assertTrue(controlPrendreEtal.resteEtals());
		controlEmenager.ajouterGaulois("Asterix", 5);
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("Asterix", "Choux", 10);
		assertFalse(controlPrendreEtal.resteEtals());
		
	}
	
	@Test
	void testEstVendeur() {
		assertFalse(controlPrendreEtal.estVendeur("Existe pas"));
		controlEmenager.ajouterGaulois("Asterix", 5);
		assertFalse(controlPrendreEtal.estVendeur("Asterix"));
		controlPrendreEtal.prendreEtal("Asterix", "Choux", 10);
		assertTrue(controlPrendreEtal.estVendeur("Asterix"));
	}
	
	@Test
	void testverifierIdentite() {
		assertEquals(controlPrendreEtal.verifierIdentite(null), controlVerifierIdentite.verifierIdentite(null));
		assertEquals(controlPrendreEtal.verifierIdentite("Existe pas"), controlVerifierIdentite.verifierIdentite("Existe pas"));
		new Gaulois("Asterix", 5);
		assertEquals(controlPrendreEtal.verifierIdentite("Asterix"), controlVerifierIdentite.verifierIdentite("Asterix"));
	}


}
