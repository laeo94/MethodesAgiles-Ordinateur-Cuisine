package cuisine.IntegrationTestsUnitaire;

import java.util.ArrayList;

public class AffichageDeuxChefs implements AffichageCuisineStrategie {

	@Override
	public String afficher(ArrayList<Chef> chefs) {
		String afficher = "";
		int c = 0;
		for (Chef chef : chefs) {
			afficher += chef.getNom();
			c++;
			if (c == 2) {
				afficher += "\n";
				c = 0;
			} else {
				afficher += " ";
			}
		}
		return afficher;
	}

}
