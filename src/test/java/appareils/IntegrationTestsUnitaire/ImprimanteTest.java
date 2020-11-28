package appareils.IntegrationTestsUnitaire;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ImprimanteTest {
	private Imprimante maisonImprimante;
	private Ordinateur monOrdinateur;
	private Ordinateur ordinateurSoeur;
	private Ordinateur ordinateurPapa;

	@Before
	public void setUp() throws Exception {
		maisonImprimante = new Imprimante("imprimante123", "HP");
		monOrdinateur = new Ordinateur("ordiTiti", "Dell", maisonImprimante);
		ordinateurSoeur = new Ordinateur("ordiTata", "Apple", maisonImprimante);
		ordinateurPapa = new Ordinateur("ordiToto", "Asus", maisonImprimante);
		maisonImprimante.addOrdinateur(monOrdinateur);
		maisonImprimante.addOrdinateur(ordinateurSoeur);
		maisonImprimante.addOrdinateur(ordinateurPapa);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(" ordiTiti ordiTata ordiToto", maisonImprimante.afficherNomOrdinateurs());
	}

	private void main() {
		Imprimante maisonImprimante;
		Ordinateur monOrdinateur;
		Ordinateur ordinateurSoeur;
		Ordinateur ordinateurPapa;
		maisonImprimante = new Imprimante("imprimante123", "HP");
		monOrdinateur = new Ordinateur("ordiTiti", "Dell", maisonImprimante);
		ordinateurSoeur = new Ordinateur("ordiTata", "Apple", maisonImprimante);
		ordinateurPapa = new Ordinateur("ordiToto", "Asus", maisonImprimante);
		maisonImprimante.addOrdinateur(monOrdinateur);
		maisonImprimante.addOrdinateur(ordinateurSoeur);
		maisonImprimante.addOrdinateur(ordinateurPapa);
		maisonImprimante.afficherNomOrdinateurs();
	}
}
