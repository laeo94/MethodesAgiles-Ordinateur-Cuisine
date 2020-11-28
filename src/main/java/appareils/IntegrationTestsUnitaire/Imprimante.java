package appareils.IntegrationTestsUnitaire;

import java.util.ArrayList;

/**
 * Décrivez votre classe Imprimante ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Imprimante {
	// variables d'instance - remplacez l'exemple qui suit par le votre
	private String nom = "Nom inconnu";
	private String marque = "Marque inconnue";
	private ArrayList<Ordinateur> listOrdi;

	/**
	 * Constructeur d'objets de classe Imprimante
	 */
	public Imprimante(String nom, String marque) {
		// initialisation des variables d'instance
		this.nom = nom;
		this.marque = marque;
		this.listOrdi = new ArrayList<Ordinateur>();
	}

	public void addOrdinateur(Ordinateur ordinateur) {
		if (ordinateur.getImprimante().equals(this)) {
			listOrdi.add(ordinateur);
		}
	}

	public String afficherNomOrdinateurs() {
		String nomOrdinateurs;
		if (listOrdi.size() == 0) {
			nomOrdinateurs = "Aucun ordinateur connect�";
		} else {
			nomOrdinateurs = "";
			for (Ordinateur ordi : listOrdi) {
				nomOrdinateurs += " " + ordi.getNom();
			}
		}
		return nomOrdinateurs;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getNom() {
		return extracted();
	}

	private String extracted() {
		return this.nom;
	}

	public String getMarque() {
		return this.marque;
	}

}
