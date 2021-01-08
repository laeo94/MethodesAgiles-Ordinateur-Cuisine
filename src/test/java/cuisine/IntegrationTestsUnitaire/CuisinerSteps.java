package cuisine.IntegrationTestsUnitaire;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CuisinerSteps {

	Cuisine c1;
	Chef chef1;
	Chef chef2;

	@Given("je suis une cuisine")
	public void je_suis_une_cuisine() {
		c1 = new Cuisine(30, "americaine", new AffichageUnChef());
		System.out.print(c1);
	}

	@When("je recrute un chef libre")
	public void je_recrute_un_chef_libre() {
		chef1 = new Chef();
		chef1.setNom("Paul");
		chef1.setNbEtoiles(2);
		if (!chef1.isAvoir())
			c1.ajouteMoiDansLaCuisine(chef1);
	}

	@Then("le chef devra apparaitre dans ma liste de chefs")
	public void le_chef_devra_apparaitre_dans_ma_liste_de_chefs() {

		if (c1.verifierPresence(chef1)) {
			System.out.println("test passe");
		} else {
			System.out.println("test ne passe pas ");
		}
	}

	@When("le nom {string} du chef est valide")
	public void le_nom_du_chef_est_valide(String string) {
		c1 = new Cuisine(30, "americaine", new AffichageUnChef());
		chef2 = new Chef();
		chef2.setNom("Paul");
		chef2.setCuisine(c1);
		if (chef2.verifierNom(string)) {
			System.out.println("Le nom du chef est valide");
		} else {
			System.out.println("Le nom du chef n'est pas valide");
		}
	}

	@When("j expulse un chef portant le nom {string}")
	public void j_expulse_un_chef_portant_le_nom(String string) {
		if (c1.deleteChefWithNom(string)) {
			System.out.println("Le chef avec le nom " + string + " a bien été expulsé");
		} else {
			System.out.println("Le chef avec le nom " + string + " , n'a pas été expulsé");
		}
	}

	@Then("le chef portant ce nom ne devrait pas apparaitre dans la liste de chefs")
	public void le_chef_portant_ce_nom_ne_devrait_pas_apparaitre_dans_la_liste_de_chefs() {
		if (!c1.verifierPresence(chef2)) {
			System.out.println("test passe");
		} else {
			System.out.println("test ne passe pas ");
		}
	}

	@Given("je suis un Chef")
	public void je_suis_un_Chef() {
		c1 = new Cuisine(30, "americaine", new AffichageUnChef());
		chef2 = new Chef();
		chef2.setNom("titi");
		chef2.setCuisine(c1);
		System.out.println(chef2);
	}

	@Given("j appartiens a une cuisine")
	public void j_appartiens_a_une_cuisine() {

		if (c1.verifierPresence(chef2)) {
			System.out.println("le chef " + chef2);
		} else if (chef2.isAvoir()) {
			System.out.println(" et ma cuisine est " + c1);
		} else {
			System.out.println("Oupsi, je n'ai pas de cuisine !");
		}
	}

	@When("je quitte cuisine")
	public void je_quitte_cuisine() {
		chef2.quitterCuisine();
		if (!chef2.isAvoir() && (chef2.getCuisine() == null)) {
			System.out.println("J'ai quitté ma cuisine ");
		} else {
			System.out.println("Je n'ai pas quitté ma cuisine ");
		}
	}

	@Then("je n apparais plus dans la liste chefs de la cuisine que j ai quitte")
	public void je_n_apparais_plus_dans_la_liste_chefs_de_la_cuisine_que_j_ai_quitte() {

	}

	@Then("je n appartiens plus a aucune cuisine")
	public void je_n_appartiens_plus_a_aucune_cuisine() {
	}

	// Test Pattern
	@Given("Je suis un responsable d une cuisine")
	public void je_suis_un_responsable_d_une_cuisine() {
		c1 = new Cuisine(20, "americaine", new AffichageUnChef());
		chef1 = new Chef();
		chef1.setNom("Paul");
		chef1.setNbEtoiles(2);
		chef1.setCuisine(c1);
		chef2 = new Chef();
		chef2.setNom("titi");
		chef2.setCuisine(c1);
	}

	@When("je recupere la liste")
	public void je_recupere_la_liste() {
		System.out.println("Je souhaite récuperer la liste");
	}

	@Then("la liste des chefs s affiche")
	public void la_liste_des_chefs_s_affiche() {
		assertEquals("Paul\ntiti\n", c1.afficher());
		System.out.println(c1.afficher());
	}
}
