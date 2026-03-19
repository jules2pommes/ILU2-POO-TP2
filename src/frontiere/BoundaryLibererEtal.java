package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		} else {
			String[] donneeEtal = controlLibererEtal.libererEtal(nomVendeur);
			if (donneeEtal[0] != null && donneeEtal[0].equals("true")) {  // Il faut que l'étal soit occupé ? on le libère quand alors ?
				System.out.println(
						String.format("Vous avez vendu %s sur %s %s.", donneeEtal[4], donneeEtal[3], donneeEtal[2]));
				System.out.println("En revoir %s, passez une bonne journée".formatted(nomVendeur));  // syntax plus commune avec JDK recent
			}
		}
	}

}
