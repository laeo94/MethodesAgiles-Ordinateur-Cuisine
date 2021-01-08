package appareils.IntegrationTestsUnitaire;

import java.util.ArrayList;

/**
 * Décrivez votre classe Imprimante ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Imprimante {
	private static Imprimante instanceImp = null;
	// variables d'instance - remplacez l'exemple qui suit par le votre
	private String nom = "Nom inconnu";
	private String marque = "Marque inconnue";
	private ArrayList<Ordinateur> listOrdi;
	private EtatImprimante etat;

	/**
	 * Constructeur d'objets de classe Imprimante
	 */
	private Imprimante(String nom, String marque) {
		// initialisation des variables d'instance
		this.nom = nom;
		this.marque = marque;
		this.listOrdi = new ArrayList<Ordinateur>();
		this.etat = new EtatImprimanteEteint(this);
	}

	public static Imprimante getInstance(String nom, String marque) {
		if (instanceImp == null)
			instanceImp = new Imprimante(nom, marque);
		return instanceImp;
	}

	public String imprimer(String menu) {
		if (this.etat instanceof EtatImprimanteAllume)
			return menu;
		return "L'imprimante est eteint !";
	}

	public void changerEtat() {
		etat = etat.etatsuivant();
	}

	public EtatImprimante getEtat() {
		return etat;
	}

	public void addOrdinateur(Ordinateur ordinateur) {
		if (ordinateur.getImprimante().equals(this)) {
			listOrdi.add(ordinateur);
		}
	}

	public String nomComplet() {
		return this.nom + "/" + this.marque;
	}

	public String afficherNomOrdinateurs() {
		String nomOrdinateurs;
		if (listOrdi.size() == 0) {
			nomOrdinateurs = "Aucun ordinateur connecte";
		} else {
			nomOrdinateurs = "";
			for (Ordinateur ordi : listOrdi) {
				nomOrdinateurs += " " + ordi.getNom();
			}
		}
		return nomOrdinateurs;
	}

	/*
	 * public void setNom(String nom) { this.nom = nom; }
	 * 
	 * public void setMarque(String marque) { this.marque = marque; }
	 */
	public String getNom() {
		return extracted();
	}

	private String extracted() {
		return this.nom;
	}

	public String getMarque() {
		return this.marque;
	}

	public ArrayList<Ordinateur> copyOrdi() {
		ArrayList<Ordinateur> c = new ArrayList<Ordinateur>();
		for (int i = 0; i < this.listOrdi.size(); i++) {
			c.add(this.listOrdi.get(i));
		}
		return c;
	}

}
