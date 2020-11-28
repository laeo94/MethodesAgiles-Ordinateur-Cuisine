package appareils.IntegrationTestsUnitaire;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParametrerOrdinateurTest {
	private Ordinateur ordinateur = new Ordinateur("ordiToto", "Dell", null);

	@Given("la modification d'un ordinateur comprenant le nouveau nom {string} du stagiaire")
	public void la_modification_d_un_ordinateur_comprenant_le_nouveau_nom_du_stagiaire(String string) {
		System.out.println("Le nouveau nom de l'ordinateur avec celui du nom du nouveau stagiaire : " + string);
	}

	@When("le responsable la valide")
	public void le_responsable_la_valide() {
		System.out.println("Le responsable valide ce nom pour l'attribution de l'ordinateur");
	}

	@Then("le nouveau de l'ordinateur {string} doit être modifier")
	public void le_nouveau_de_l_ordinateur_doit_être_modifier(String string) {
		assertEquals(string, ordinateur.changerNom(string));
		System.out.println("Modification effectuée! L'ordinateur est nommé :"+string);
	}

}
