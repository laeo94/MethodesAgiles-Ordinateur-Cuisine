package appareils.IntegrationTestsUnitaire;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParametrerImprimanteTest {
	private Imprimante imprimante;

	@Given("L'ajout d'une imprimante comprend le {string} et la {string} de l'imprimante")
	public void l_ajout_d_une_imprimante_comprend_le_et_la_de_l_imprimante(String string, String string2) {
		imprimante = new Imprimante(string, string2);

	}

	@When("le responsable valide le changement")
	public void le_responsable_valide_le_changement() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Le responsable valide le changement");
	}

	@Then("l'imprimante affiche son {string}")
	public void l_imprimante_affiche_son(String string) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(string, imprimante.nomComplet());
	}

	@Given("L'ajout de l'ordinateur de {string} et de la {string} à l'imprimante")
	public void l_ajout_de_l_ordinateur_de_et_de_la_à_l_imprimante(String string, String string2) {
		imprimante = new Imprimante("Imp1", "HP");
		Ordinateur ordiTata = new Ordinateur("ordiTata", "Asus", imprimante);
		imprimante.addOrdinateur(ordiTata);
		Ordinateur ordiToto = new Ordinateur(string, string2, imprimante);
		imprimante.addOrdinateur(ordiToto);

	}

	@When("le responsable valide l'ajout")
	public void le_responsable_valide_l_ajout() {
		System.out.println("Le responsable valide l'ajout");
	}

	@Then("l'imprimante affiche sa liste des ordinateurs connectés {string}")
	public void l_imprimante_affiche_sa_liste_des_ordinateurs_connectés_ordiconnectes(String string) {
		assertEquals(string, imprimante.afficherNomOrdinateurs());
	}
}