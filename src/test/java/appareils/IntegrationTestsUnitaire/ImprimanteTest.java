package appareils.IntegrationTestsUnitaire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		maisonImprimante = Imprimante.getInstance("impDauphine", "HP");
		maisonImprimante.cleanOrdis();
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
	public void testAfficherOrdis() {
		
		assertEquals(" ordiTiti ordiTata ordiToto", maisonImprimante.afficherNomOrdinateurs());
	}

	@Test
	public void testAfficher() {
		assertEquals("impDauphine/HP", maisonImprimante.nomComplet());
	}

	@Test
	public void testSuppOrdi() {
		assertTrue(maisonImprimante.suppOrdis(ordinateurPapa));
		assertEquals(" ordiTiti ordiTata", maisonImprimante.afficherNomOrdinateurs());
	}

	@Test
	public void testCleanOrdis() {
		assertTrue(maisonImprimante.cleanOrdis());
		assertEquals("Aucun ordinateur connecte", maisonImprimante.afficherNomOrdinateurs());
	}

	@Test
	public void testImprimer() {
		assertEquals("L'imprimante est eteint !", ordinateurSoeur.getImprimante().imprimer("Menu du jour"));
	}
}
