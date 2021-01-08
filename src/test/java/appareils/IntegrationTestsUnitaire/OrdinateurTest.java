package appareils.IntegrationTestsUnitaire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrdinateurTest {
	private Imprimante monImprimante;
	private Ordinateur monOrdinateur;

	@Before
	public void setUp() throws Exception {
		monImprimante = Imprimante.getInstance("impDauphine", "HP");
		monOrdinateur = new Ordinateur("ordiToto", "Dell", monImprimante);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("ordiTiti", monOrdinateur.changerNom("ordiTiti"));
		monImprimante.addOrdinateur(monOrdinateur);
		assertTrue(monImprimante.copyOrdi().contains(monOrdinateur));
		assertEquals("impDauphine", monOrdinateur.getImprimante().getNom());
	}

}
