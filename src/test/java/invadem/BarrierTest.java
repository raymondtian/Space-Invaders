package invadem;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import processing.core.*;

public class BarrierTest {

	private Barrier barrier;
	private Tank tank;
	private Projectile proj;

	@Before
	public void setup() {
		barrier = new Barrier(50, 50);
		tank = new Tank(0, 0);
		proj = new Projectile(50, 50, 3, 1, tank, 1);
	}

	/**
	 * Tests barrier construction by checking if barrier isn't null
	 */
	@Test
	public void barrierConstruction() {
		assertNotNull(barrier);
	}

	/**
	 * Tests barrier images
	 */
	@Test
	public void testBCharacters() {
		assertEquals(0, barrier.getCharacters().size());
	}

	/**
	 * Tests y location of barrier
	 */
	@Test
	public void testBGetY() {
		assertEquals(50, barrier.getY());
	}

	/**
	 * Tests x location of barrier
	 */
	@Test
	public void testBGetX() {
		assertEquals(50, barrier.getX());
	}

	/**
	 * Tests barrier height
	 */
	@Test
	public void testBHeight() {
		assertEquals(8, barrier.getHeight());
	}

	/**
	 * Tests barrier width
	 */
	@Test
	public void testBWidth() {
		assertEquals(8, barrier.getWidth());
	}

	/**
	 * Tests ability to set health of the barriers
	 */
	@Test
	public void testBSetHealth1() {
		barrier.setHealth(0);
		assertEquals(0, barrier.getHealth());
	}

	/**
	 * Tests ability to set health of the barriers
	 */
	@Test
	public void testBSetHealth2() {
		barrier.setHealth(1);
		assertEquals(1, barrier.getHealth());
	}

	/**
	 * Tests ability to set health of the barriers
	 */
	@Test
	public void testBSetHealth3() {
		barrier.setHealth(3);
		assertEquals(3, barrier.getHealth());
	}

	/**
	 * Tests ability to set health of the barriers
	 */
	@Test
	public void testBSetNegativeHealth() {
		barrier.setHealth(-5);
		assertEquals(-5, barrier.getHealth());
	}

	/**
	 * Tests if barriers are alive after 4 shots
	 */
	@Test
	public void testBNegativeHealthAlive() {
		barrier.damage(proj);
		barrier.damage(proj);
		barrier.damage(proj);
		barrier.damage(proj);
		assertEquals(true, barrier.isDeceased());
	}

	/**
	 * Tests if barriers are alive after 3 shots
	 */
	@Test
	public void testBAlive1() {
		barrier.damage(proj);
		barrier.damage(proj);
		barrier.damage(proj);
		assertEquals(true, barrier.isDeceased());
	}

	/**
	 * Tests if barriers are alive after 2 shots
	 */
	@Test
	public void testBAlive2() {
		barrier.damage(proj);
		barrier.damage(proj);
		assertEquals(false, barrier.isDeceased());
	}

	/**
	 * Tests if barriers are alive after 1 shot
	 */
	@Test
	public void testBAlive3() {
		barrier.damage(proj);
		assertEquals(false, barrier.isDeceased());
	}

	/**
	 * Tests if barriers are alive after 0 shots
	 */
	@Test
	public void testBAlive4() {
		assertEquals(false, barrier.isDeceased());
	}

	/**
	 * Tests barriers health after 4 shots
	 */
	@Test
	public void testBNegativeHealth() {
		barrier.damage(proj);
		barrier.damage(proj);
		barrier.damage(proj);
		barrier.damage(proj);
		assertEquals(-1, barrier.getHealth());
	}

	/**
	 * Tests barriers health after 3 shots
	 */
	@Test
	public void testBHealthMax1() {
		barrier.damage(proj);
		barrier.damage(proj);
		barrier.damage(proj);
		assertEquals(0, barrier.getHealth());
	}

	/**
	 * Tests barriers health after 2 shots
	 */
	@Test
	public void testBHealthMax2() {
		barrier.damage(proj);
		barrier.damage(proj);
		assertEquals(1, barrier.getHealth());
	}

	/**
	 * Tests barriers health after 1 shot
	 */
	@Test
	public void testBHealthMax3() {
		barrier.damage(proj);
		assertEquals(2, barrier.getHealth());
	}

	/**
	 * Tests barriers health after 0 shots
	 */
	@Test
	public void testBHealthMax4() {
		assertEquals(3, barrier.getHealth());
	}

}
