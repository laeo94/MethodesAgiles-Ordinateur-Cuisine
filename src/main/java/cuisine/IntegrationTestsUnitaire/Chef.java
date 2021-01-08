package cuisine.IntegrationTestsUnitaire;

import appareils.IntegrationTestsUnitaire.Ordinateur;

public class Chef {
	private String nom;
	private int nbEtoiles;
	private Cuisine maCuisine;
	private boolean avoir = false;
	private Ordinateur ordi;

	public Chef(String n, Cuisine c, int nbEts) {
		this.nom = n;
		setAvoir(demandeInvitation(c));
		this.setNbEtoiles(nbEts);
	}

	public Chef() {
	}

	private boolean demandeInvitation(Cuisine c) {
		return c.ajouteMoiDansLaCuisine(this);
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String name) {
		this.nom = name;
	}

	public void setCuisine(Cuisine c) {
		if (!this.isAvoir()) {
			this.maCuisine = c;
			setAvoir(c.ajouteMoiDansLaCuisine(this));
		}
		this.quitterCuisine();
		this.maCuisine = c;
		setAvoir(c.ajouteMoiDansLaCuisine(this));
	}

	public Cuisine getCuisine() {
		return this.maCuisine;
	}

	public void quitterCuisine() {
		this.maCuisine = null;
		this.setAvoir(false);
	}

	public int getNbEtoiles() {
		return nbEtoiles;
	}

	public void setNbEtoiles(int nbetoiles) {
		this.nbEtoiles = nbetoiles;
	}

	public boolean isAvoir() {
		return avoir;
	}

	public void setAvoir(boolean avoir) {
		this.avoir = avoir;
	}

	public String affichageChef() {
		return ("Je suis le Chef " + this.getNom());
	}

	public void reduireSurface(int surface) {
		this.maCuisine.setSurface(surface);
	}

	public Boolean verifierNom(String nom) {
		if (nom instanceof String)
			return true;
		return false;
	}

	public Ordinateur getOrdi() {
		return ordi;
	}

	public void setOrdi(Ordinateur ordi) {
		this.ordi = ordi;
	}
}