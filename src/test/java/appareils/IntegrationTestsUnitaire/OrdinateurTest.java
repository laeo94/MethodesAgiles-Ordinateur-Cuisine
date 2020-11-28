package appareils.IntegrationTestsUnitaire;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrdinateurTest {
	private Imprimante monImprimante;
	private Ordinateur monOrdinateur;

	@Before
	public void setUp() throws Exception {
		monImprimante = new Imprimante("imprimante123", "HP");
		monOrdinateur = new Ordinateur("ordiToto", "Dell", monImprimante);
		// monOrdinateur.nomComplet();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// assertEquals("Toto imprimante123", monOrdinateur.nomComplet());
		assertEquals("ordiTiti", monOrdinateur.changerNom("ordiTiti"));
	}

}
