package cuisine.IntegrationTestsUnitaire;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CuisineTest {

	private Cuisine c2;
	private Cuisine c1;
	private Chef toto;
	private Chef titi;
	private Chef coco;

	@Before
	public void setUp() {
		c1 = new Cuisine(30, "americaine");
		c2 = new Cuisine(20, "japonaise");
		toto = new Chef("toto", c1, 3);
		titi = new Chef("titi", c2, 5);
	}

	@Test
	public void testAjouterSurface() {
		c1.ajouterSurface(10);
		assertEquals(40, c1.getSurface());
	}

	@Test
	public void testGetType() {
		assertEquals("americaine", c1.getType());
	}

	@Test
	public void testGetSurface() {
		assertEquals(30, c1.getSurface());
	}

	@Test
	public void testSetType() {
		c1.setType("indienne");
		assertEquals("indienne", c1.getType());
	}

	@Test
	public void testSetSurface() {
		c1.setSurface(10);
		assertEquals(10, c1.getSurface());
	}

	@Test
	public void testAjouteMoiDansLaCuisine() {
		Chef tata = new Chef("tata", c1, 3);
		assertEquals(tata.getCuisine(), c1);
		assertTrue(c1.copyOfChefs().contains(tata));
		assertTrue(tata.isAvoir());
	}

	@Test
	public void testAjouterPersonne() {
		coco = new Chef("coco", c2, 3);
		c1.ajouterPersonne(coco);
		assertEquals(coco.getCuisine(), c1);
		assertTrue(c1.copyOfChefs().contains(coco));
		assertTrue(coco.isAvoir());
	}

	@Test
	public void testDeleteChef() {
		c1.deleteChef(toto);
		assertEquals(toto.getCuisine(), null);
		assertTrue(!c1.copyOfChefs().contains(toto));
		assertTrue(!toto.isAvoir());
	}

}
