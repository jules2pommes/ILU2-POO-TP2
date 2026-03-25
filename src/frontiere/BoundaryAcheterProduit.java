package frontiere;

import java.util.Iterator;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println(
					"Je suis désolée %s, mais il faut être un habitant de notre village pour commercer ici.".formatted(nomAcheteur));
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			String[] vendeurs = controlAcheterProduit.listeVendeurs(produit);
			
			if (vendeurs != null) {
				choisirVendeur(nomAcheteur, produit, vendeurs);
			} else {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
		}
	}
	
	private void choisirVendeur(String nomAcheteur, String produit, String[] vendeurs) {
		StringBuilder question = new StringBuilder();
		question.append("Chez quel commerçant voulez-vous acheter des %s ?%n".formatted(produit));
		for (int i = 0; i < vendeurs.length; i++) {
			question.append("%d - %s%n".formatted(i+1, vendeurs[i]));
		}
		
		int choixVendeur = -1;
		while ((choixVendeur = Clavier.entrerEntier(question.toString())-1) >= vendeurs.length) {
			System.out.println("Veuillez saisir un entier entre 1 et %d".formatted(vendeurs.length));
		}
		String nomVendeur = vendeurs[choixVendeur];
		System.out.println("%s se déplace jusqu'à l'étal du vendeur %s".formatted(nomAcheteur, nomVendeur));
		System.out.println("Bonjour " + nomAcheteur);
		
		int quantite = Clavier.entrerEntier("Combien de %s voulez-vous acheter ?".formatted(produit));
		int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeur, quantite);
		
		if (quantite == quantiteAchetee) {
			System.out.println("%s achète %d fleurs à %s".formatted(nomAcheteur, quantite, nomVendeur));
		} else if (quantiteAchetee == 0) {
			System.out.println("%s veut acheter %d fleurs, malheureusement il n’y en a plus !".formatted(nomAcheteur, quantite));
		} else {
			System.out.print("%s veut acheter %d fleurs, malheureusement %s n’en a plus que %d.".formatted(nomAcheteur, quantite, nomVendeur, quantiteAchetee));
			System.out.println("%s achète tout le stock de %s.".formatted(nomAcheteur, nomVendeur));
		}
	}
}
