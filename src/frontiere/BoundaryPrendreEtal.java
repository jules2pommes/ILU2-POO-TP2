package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println(String.format("Je suis désolé %s, mais il faut un habitant de notre village pour commercer ici.", nomVendeur));
		} else if (controlPrendreEtal.estVendeur(nomVendeur)) {
			System.out.println(String.format("Vous possedez déjà un étal."));
		} else {
			System.out.println(String.format("Bonjour %s, je vais regarder si je peux vous trouver un étal.", nomVendeur));
			if (!controlPrendreEtal.resteEtals()) 
				System.out.println(String.format("Désolé %s, je n'ai plus d'étal qui ne soit pas déjà occupé.", nomVendeur));
			else
				installerVendeur(nomVendeur);
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignements :");
		String produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		
		if (numeroEtal != -1) {
			System.out.println(String.format("Le vendeur %s s'est installé à l'étal n°%d", nomVendeur, numeroEtal+1));
		}
	}
}
