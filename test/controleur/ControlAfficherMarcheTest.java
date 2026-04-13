package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village; 
	private Chef abraracourcix;
	private ControlAfficherMarche controlAfficherMarche;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlEmmenager controlEmenager;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherMarche = new ControlAfficherMarche(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlEmenager = new ControlEmmenager(village);
	}

	@Test
	void testDonnerInfosMarche() {
		// nomvendeur, le nombre de produit, le produit
		controlEmenager.ajouterGaulois("Asterix", 5);
		controlEmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Asterix", "Choux", 5);
		assertArrayEquals(new String[]{"Asterix", "5", "Choux"}, controlAfficherMarche.donnerInfosMarche());
		controlPrendreEtal.prendreEtal("Bonemine", "Fleurs", 10);
		assertArrayEquals(new String[]{"Asterix", "5", "Choux", "Bonemine", "10", "Fleurs"}, controlAfficherMarche.donnerInfosMarche());
	}

}
