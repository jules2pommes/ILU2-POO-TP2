package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		return village.rechercherEtalVide();
	}
	
	public boolean estVendeur(String nomVendeur) {
		Gaulois g = village.trouverHabitant(nomVendeur);
		if (g != null) {
			return village.rechercherEtal(g) != null;
		}
		return false;
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		int numeroEtal = -1;
		numeroEtal = village.installerVendeur(village.trouverHabitant(nomVendeur), produit, nbProduit);
		return numeroEtal;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}
