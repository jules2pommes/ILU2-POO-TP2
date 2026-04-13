package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village; 
	private ControlPrendreEtal controlPrendreEtal;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlEmmenager controlEmenager;
	

	@BeforeEach
	void setUp() throws Exception {
		Chef abraracourcix;
		ControlVerifierIdentite controlVerifierIdentite;
		
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlEmenager = new ControlEmmenager(village);
	}

	@Test
	void testTrouverEtalVendeur() {
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Existe pas"));
		controlEmenager.ajouterGaulois("Asterix", 5);
		controlPrendreEtal.prendreEtal("Asterix", "Choux", 10);
		assertEquals("Asterix", controlTrouverEtalVendeur.trouverEtalVendeur("Asterix").getVendeur().getNom());
		
	}

}
