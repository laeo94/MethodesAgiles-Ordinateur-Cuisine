package menu;

import static org.junit.Assert.assertEquals;

import appareils.IntegrationTestsUnitaire.EtatImprimanteEteint;
import appareils.IntegrationTestsUnitaire.Imprimante;
import appareils.IntegrationTestsUnitaire.Ordinateur;
import cuisine.IntegrationTestsUnitaire.AffichageUnChef;
import cuisine.IntegrationTestsUnitaire.Chef;
import cuisine.IntegrationTestsUnitaire.Cuisine;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuDuJour {
	
	private Cuisine cuisine = new Cuisine(150, "Dauphine", new AffichageUnChef());
	private Chef chef;
	private Ordinateur ordiChef;
	private Imprimante imp = Imprimante.getInstance("impDauphine", "HP");

	/* 1er user storie */
	@Given("En tant que chef {string} de cuisine je veux pouvoir rédiger le menu du jour")
	public void en_tant_que_chef_de_cuisine_je_veux_pouvoir_rédiger_le_menu_du_jour(String string) {
		chef = new Chef(string, cuisine, 3);
		//System.out.println(string + " souhaite rédiger son menu du jour");
	}

	@When("j écris sur l ordinateur le {string}")
	public void j_écris_sur_l_ordinateur_le(String string) {
		ordiChef = new Ordinateur(chef.getNom(), "Dell", imp);
		ordiChef.setMenu(chef.getNom() + ": " + string);
		//System.out.println("Le menu du jour :" + string);
	}

	@Then("le {string} est enregistré sur l'ordinateur du chef {string}")
	public void le_est_enregistré_sur_l_ordinateur_du_chef(String string, String string2) {
		assertEquals(string, ordiChef.getMenu());
		assertEquals(string2, chef.getNom());
	}

	/* 2eme user storie */
	@Given("En tant que chef {string} je souhaite imprimer mon menu du jour établi sur mon ordinateur {string}")
	public void en_tant_que_chef_je_souhaite_imprimer_mon_menu_du_jour_établi_sur_mon_ordinateur_nom_ordi(String string,
			String string2) {
		chef = new Chef(string, cuisine, 3);
		ordiChef = new Ordinateur(string, "Dell", imp);
		chef.setOrdi(ordiChef);
		ordiChef.setChef(chef);
		assertEquals(string, string2);
		if (ordiChef.getImprimante().getEtat() instanceof EtatImprimanteEteint)
			ordiChef.getImprimante().changerEtat();
	}

	@When("je demande d imprimer le menu {string}")
	public void je_demande_d_imprimer_le_menu(String string) {
		ordiChef.setMenu(string);
		//System.out.println("Je souhaite imprimer le menu :" + string);
		assertEquals(string, ordiChef.getMenu());
		//System.out.println("Le menu dans ordinateur " + ordiChef.getMenu());
	}

	@Then("le {string} s imprime")
	public void le_s_imprime(String string) {
		assertEquals(string, ordiChef.getImprimante().imprimer(string));
		//System.out.println("Le menu : " + string + " a été imprimé");
	}
}
