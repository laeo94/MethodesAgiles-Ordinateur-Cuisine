package appareils.IntegrationTestsUnitaire;

import cuisine.IntegrationTestsUnitaire.Chef;

/**
 * Décrivez votre classe Ordinateur ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Ordinateur {
	private String nom = "Nom inconnu";
	private String marque = "Marque inconnu";
	private Imprimante imprimante;
	private Chef chef;
	private String menu = "";

	/**
	 * Constructeur d'objets de classe Ordinateur
	 */
	public Ordinateur(String nom, String marque, Imprimante imp) {
		// initialisation des variables d'instance
		this.nom = nom;
		this.marque = marque;
		this.imprimante = imp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Imprimante getImprimante() {
		return imprimante;
	}

	public void setImprimante(Imprimante imprimante) {
		this.imprimante = imprimante;
	}

	public String changerNom(String nom) {
		this.nom = nom;
		return this.nom;
	}

	public String nomComplet() {
		return this.nom + " " + this.imprimante.getNom();
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
}
