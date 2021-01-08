package cuisine.IntegrationTestsUnitaire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ChefTest {

	private Chef toto;
	private Chef titi;
	private Chef tata;
	private Cuisine c1;
	private Cuisine c2;

	@Before
	public void setUp() throws Exception {
		c1 = new Cuisine(30, "japonnaise", new AffichageUnChef());
		c2 = new Cuisine(40, "americaine", new AffichageUnChef());
		toto = new Chef("toto", c1, 3);
		titi = new Chef("titi", c2, 5);
	}

	@Test
	public void testSetNom() {
		toto.setNom("TOTO");
		assertEquals("TOTO", toto.getNom());
	}

	@Test
	public void testSetNbEtoiles() {
		toto.setNbEtoiles(5);
		assertEquals(5, toto.getNbEtoiles());
	}

	@Test
	public void testSetCuisine() {
		titi.setCuisine(c1);
		assertEquals(titi.getCuisine(), c1);
		assertTrue(c1.copyOfChefs().contains(titi));
		assertTrue(titi.isAvoir());
	}

	@Test
	public void testQuitterCuisine() {
		titi.quitterCuisine();
		assertEquals(titi.getCuisine(), null);
		assertTrue(!titi.isAvoir());
	}

}
