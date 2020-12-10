package testRunners;

import static org.junit.Assert.assertEquals;

import appareils.IntegrationTestsUnitaire.Ordinateur;
import cuisine.IntegrationTestsUnitaire.Chef;
import cuisine.IntegrationTestsUnitaire.Cuisine;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuDuJour {
	private Cuisine cuisine = new Cuisine(150, "Dauphine");
	private Chef chef;
	private Ordinateur ordiChef;

	@Given("En tant que chef {string} de cuisine je veux pouvoir rédiger le menu du jour")
	public void en_tant_que_chef_de_cuisine_je_veux_pouvoir_rédiger_le_menu_du_jour(String string) {
		chef = new Chef(string, cuisine, 3);
		System.out.println(string + " souhaite rédiger son menu du jour");
	}

	@When("j écris sur l ordinateur le {string}")
	public void j_écris_sur_l_ordinateur_le(String string) {
		ordiChef = new Ordinateur(chef.getNom(), "Dell", null);
		ordiChef.setMenu(chef.getNom() + ": " + string);
		System.out.println("Le menu du jour :" + string);
	}

	@Then("le {string} est enregistré sur l'ordinateur du chef {string}")
	public void le_est_enregistré_sur_l_ordinateur_du_chef(String string, String string2) {
		assertEquals(string, ordiChef.getMenu());
		assertEquals(string2, chef.getNom());
	}

}
