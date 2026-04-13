package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Chef abraracourcix;
	Village village;
	ControlVerifierIdentite controlVerifierIdentite;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	ControlAcheterProduit controlAcheterProduit;
	ControlAfficherVillage controlAfficherVillage;
	ControlEmmenager controlEmmenager;
	ControlPrendreEtal controlPrendreEtal;


	@BeforeEach
	void setUp() throws Exception {
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village = new Village("le village des irréductibles", 10, 5);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		controlEmmenager = new ControlEmmenager(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}

	@Test
	void testListeVendeurs() {
		controlEmmenager.ajouterDruide("Panoramix", 10, 5, 15);
		assertNull(controlAcheterProduit.listeVendeurs("Choux"));
		controlPrendreEtal.prendreEtal("Panoramix", "Choux", 10);
		assertArrayEquals(new String[]{"Panoramix"}, controlAcheterProduit.listeVendeurs("Choux"));
	}
	
	@Test
	void testAcheterProduit() {
		controlEmmenager.ajouterDruide("Panoramix", 10, 5, 15);
		controlPrendreEtal.prendreEtal("Panoramix", "Choux", 10);
		assertEquals(10, controlAcheterProduit.acheterProduit("Panoramix", 15));
		assertEquals(0, controlAcheterProduit.acheterProduit("Panoramix", 10));
		assertEquals(-1, controlAcheterProduit.acheterProduit("Obelix", 10));
	}
	
	@Test
	void testverifierIdentite() {
		assertEquals(controlAcheterProduit.verifierIdentite(null), controlVerifierIdentite.verifierIdentite(null));
		assertEquals(controlAcheterProduit.verifierIdentite("Existe pas"), controlVerifierIdentite.verifierIdentite("Existe pas"));
		new Gaulois("Asterix", 5);
		assertEquals(controlAcheterProduit.verifierIdentite("Asterix"), controlVerifierIdentite.verifierIdentite("Asterix"));
	}


}
