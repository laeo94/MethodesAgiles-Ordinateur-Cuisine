package cuisine.IntegrationTestsUnitaire;

import java.util.ArrayList;

public class AffichageUnChef implements AffichageCuisineStrategie {

	@Override
	public String afficher(ArrayList<Chef> chefs) {
		String afficher = "";
		for (Chef chef : chefs) {
			afficher += chef.getNom() + "\n";
		}
		return afficher;
	}

}
