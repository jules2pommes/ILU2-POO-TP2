package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}

	public String[] listeVendeurs(String produit) {
		String[] vendeurs = null;
		Gaulois[] vendeursG = village.rechercherVendeursProduit(produit);
		
		if (vendeursG != null) {
			 vendeurs = new String[vendeursG.length];
			for (int i = 0; i < vendeursG.length; i++) {
				vendeurs[i] = vendeursG[i].getNom();
			}
		}
		return vendeurs;
	}
	
	public int acheterProduit(String nomVendeur, int quantite) {
		Gaulois g = village.trouverHabitant(nomVendeur);
		if (g != null) {
			Etal etal = village.rechercherEtal(g);
			return etal.acheterProduit(quantite);
		}
		return -1;
	}
}
