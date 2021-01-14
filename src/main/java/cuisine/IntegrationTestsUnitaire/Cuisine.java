package cuisine.IntegrationTestsUnitaire;

import java.util.ArrayList;

public class Cuisine {
	private int surface;
	private String type;
	private ArrayList<Chef> chefs = new ArrayList<Chef>();
	private AffichageCuisineStrategie cuisine;

	public Cuisine(int s, String t, AffichageCuisineStrategie cuisine) {
		this.surface = s;
		this.type = t;
		this.cuisine = cuisine;
	}

	public String afficher() {
		return cuisine.afficher(chefs);
	}

	public int getSurface() {
		return this.surface;
	}

	public String getType() {
		return this.type;
	}

	public void setSurface(int surface) {
		if (surface > 0)
			this.surface = surface;
		else
			this.surface = 0;
	}

	public void setType(String t) {
		this.type = t;
	}

	public void ajouterSurface(int supplementaire) {
		this.surface = this.surface + supplementaire;
	}

	public boolean ajouteMoiDansLaCuisine(Chef c) {
		if (!this.chefs.contains(c)) {
			ajouterPersonne(c);
			return true;
		}
		return false;
	}

	public ArrayList<Chef> copyOfChefs() {
		return copyChefs();
	}

	private ArrayList<Chef> copyChefs() {
		ArrayList<Chef> c = new ArrayList<Chef>();
		for (int i = 0; i < this.chefs.size(); i++) {
			c.add(this.chefs.get(i));
		}
		return c;
	}

	public void ajouterPersonne(Chef p) {
		if (!this.chefs.contains(p)) {
			if (!p.isAvoir()) {
				this.chefs.add(p);
				p.setCuisine(this);
				p.setAvoir(true);

			} else {
				p.quitterCuisine();
				this.chefs.add(p);
				p.setCuisine(this);
				p.setAvoir(true);
			}
		}
	}

	public void deleteChef(Chef p) {
		if (this.chefs.contains(p)) {
			int index = this.chefs.indexOf(p);
			this.chefs.remove(index);
			p.quitterCuisine();

		}
	}

	public Boolean deleteChefWithNom(String nom) {
		for (Chef c : this.copyOfChefs()) {
			if (c.getNom().equals(nom)) {
				deleteChef(c);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return ("Je suis une cuisine et ma surface = " + this.getSurface() + " et mon type : " + this.getType());
	}

	public Boolean verifierPresence(Chef c) {
		if (this.copyOfChefs().contains(c))
			return true;
		return false;
	}

	public Boolean demandeExistanceChefAvecNbEtoiles(int nbetoiles) {

		for (Chef c : chefs) {
			if (c.getNbEtoiles() < nbetoiles) {
				return true;
			}
		}
		return false;
	}
}
