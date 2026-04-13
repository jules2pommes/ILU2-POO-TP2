package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Chef abraracourcix;
	Village village;
	ControlLibererEtal controlLibererEtal;
	ControlVerifierIdentite controlVerifierIdentite;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	ControlEmmenager controlEmmenager;
	ControlPrendreEtal controlPrendreEtal;
	ControlAcheterProduit controlAcheterProduit;


	@BeforeEach
	void setUp() throws Exception {
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village = new Village("le village des irréductibles", 10, 5);
		village.setChef(abraracourcix);

		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur, village);
		controlEmmenager = new ControlEmmenager(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		
		controlEmmenager.ajouterGaulois("Asterix", 5);
		controlPrendreEtal.prendreEtal("Asterix", "choux", 10);
	}
	@Test
	void testIsVendeur() {
		assertFalse(controlLibererEtal.isVendeur(null));
		assertTrue(controlLibererEtal.isVendeur("Asterix"));
	}
	
	@Test
	void testLibererEtal() {
		assertArrayEquals(new String[]{"true", "Asterix", "choux", "10", "0"}, controlLibererEtal.libererEtal("Asterix"));
		assertNull(controlLibererEtal.libererEtal("Asterix"));

		controlPrendreEtal.prendreEtal("Asterix", "livres", 3);
		controlAcheterProduit.acheterProduit("Asterix", 2);
		assertArrayEquals(new String[]{"true", "Asterix", "livres", "3", "2"}, controlLibererEtal.libererEtal("Asterix"));
		
	
	}

}
