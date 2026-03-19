package frontiere;

import java.util.Iterator;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard");
		} else {
			System.out.println(nomAcheteur + ", vous trouverez au marché :");
			StringBuilder s = new StringBuilder();
			
			int end = infosMarche.length; // sonarQube veut une borne invariante
			for (int i = 0; i < end; i = i+3) {
				s.append(" - %s qui vend %d %s%n".formatted(infosMarche[i], infosMarche[i+1], infosMarche[i+2]));
			}
			System.out.print(s.toString());
		}
	}
}