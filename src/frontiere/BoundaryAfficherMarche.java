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
			for (int i = 0; i < infosMarche.length/3; i++) {
				s.append(" - ");
				s.append(infosMarche[i]);
				i++;
				s.append(" qui vend ");
				s.append(infosMarche[i]);
				i++;
				s.append(" ");
				s.append(infosMarche[i]);
				i++;
				s.append("\n");
			}
			System.out.println(s.toString());
		}
	}
}
