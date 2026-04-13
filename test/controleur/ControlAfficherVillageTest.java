package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Chef abraracourcix;
	Village village;
	ControlAfficherVillage controlAfficherVillage;
	ControlEmmenager controlEmmenager;

	@BeforeEach
	void setUp() throws Exception {
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village = new Village("le village des irréductibles", 10, 5);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
		controlEmmenager = new ControlEmmenager(village);
		
	}

	@Test
	public void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage);
	}

	@Test
	public void testDonnerNomsVillageois() {
		assertArrayEquals(new String[]{"Abraracourcix"}, controlAfficherVillage.donnerNomsVillageois());
		controlEmmenager.ajouterGaulois("Asterix", 5);
		controlEmmenager.ajouterDruide("Panoramix", 2, 5, 15);
		assertArrayEquals(new String[]{"Abraracourcix", "Asterix", "le druide Panoramix"}, controlAfficherVillage.donnerNomsVillageois());
	}
	
	@Test
	public void testDonnerNomVillage() {
		assertEquals("le village des irréductibles", controlAfficherVillage.donnerNomVillage());
	}
	
	@Test
	public void testDonnerNbEtals() {
		assertEquals(5, controlAfficherVillage.donnerNbEtals());
	}

}
