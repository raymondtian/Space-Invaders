package invadem;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class InvaderTest {

	private Invader inv;
	private PoweredInvader powInv;
	private ArmouredInvader armInv;
	private Tank tank;
	private Projectile proj;
	private Barrier barrier1 = new Barrier(10, 10);
	private Barrier barrier2 = new Barrier(50, 50);
	private ArrayList<Barrier> bLs;

	@Before
	public void setup() {
		inv = new Invader(10, 10);
		powInv = new PoweredInvader(20, 30);
		armInv = new ArmouredInvader(10, 10);
		tank = new Tank(0, 0);
		proj = new Projectile(20, 20, 3, 1, tank, 1);
		bLs = new ArrayList<Barrier>();
	}

	/**
	 * Tests Invader construction by checking that it isn't null
	 */
	@Test
	public void testInvaderConstruction() {
		assertNotNull(inv);
	}

	/**
	 * Tests Powered Invader construction by checking that it isn't null
	 */
	@Test
	public void testPowInvaderConstruction() {
		assertNotNull(powInv);
	}

	/**
	 * Tests Armoured Invader construction by checking that it isn't null
	 */
	@Test
	public void testArmInvaderConstruction() {
		assertNotNull(armInv);
	}

	/**
	 * Tests if invader is dead
	 */
	@Test
	public void testIAlive1() {
		assertEquals(false, inv.isDeceased());
	}

	/**
	 * Tests if invader is dead
	 */
	@Test
	public void testIAlive2() {
		inv.damage(proj);
		assertEquals(true, inv.isDeceased());
	}

	/**
	 * Tests y location of invader
	 */
	@Test
	public void testIGetY() {
		assertEquals(10, inv.getY());
	}

	/**
	 * Tests x location of invader
	 */
	@Test
	public void testIGetX() {
		assertEquals(10, inv.getX());
	}

	/**
	 * Tests x location of powered invader
	 */
	@Test
	public void testPowIGetX() {
		assertEquals(10, inv.getX());
	}

	/**
	 * Tests x location of powered invader
	 */
	@Test
	public void testPowIGetY() {
		assertEquals(10, inv.getY());
	}

	/**
	 * Tests x location of armoured invader
	 */
	@Test
	public void testArmIGetX() {
		assertEquals(10, inv.getX());
	}

	/**
	 * Tests x location of powered invader
	 */
	@Test
	public void testArmIGetY() {
		assertEquals(10, inv.getY());
	}

	/**
	 * Tests width of invader
	 */
	@Test
	public void testIGetWidth() {
		assertEquals(16, inv.getWidth());
	}

	/**
	 * Tests height of invader
	 */
	@Test
	public void testIGetHeight() {
		assertEquals(16, inv.getHeight());
	}

	/**
	 * Tests health of invader
	 */
	@Test
	public void testIHealth1() {
		assertEquals(1, inv.getHealth());
	}

	/**
	 * Tests health of invader
	 */
	@Test
	public void testIHealth2() {
		inv.damage(proj);
		inv.damage(proj);
		assertEquals(true, inv.isDeceased());
	}

	/**
	 * Tests health of invader
	 */
	@Test
	public void testIHealth3() {
		inv.damage(proj);
		inv.damage(proj);
		assertEquals(-1, inv.getHealth());
	}

	/**
	 * Tests health of invader
	 */
	@Test
	public void testIHealth4() {
		inv.damage(proj);
		assertEquals(true, inv.isDeceased());
	}

	/**
	 * Tests health of invader
	 */
	@Test
	public void testIHealth5() {
		inv.damage(proj);
		assertEquals(0, inv.getHealth());
	}

	/**
	 * Tests X movement of invader
	 */
	@Test
	public void testIMoveX1() {
		inv.frameMovement();
		inv.frameMovement();
		inv.move();
		assertEquals(12, inv.getX());
	}

	/**
	 * Tests X movement of invader
	 */
	@Test
	public void testIMoveX2() {
		inv.frameMovement();
		inv.move();
		assertEquals(11, inv.getX());
	}

	/**
	 * Tests X movement of invader
	 */
	@Test
	public void testIMoveX3() {
		inv.move();
		assertEquals(11, inv.getX());
	}

	/**
	 * Tests X movement of invader
	 */
	@Test
	public void testIMoveX4() {
		for (int i = 1; i <= 212; i++) {
			inv.frameMovement();
		} assertEquals(39, inv.getX());
	}

	/**
	 * Tests X movement of invader
	 */
	@Test
	public void testIMoveX5() {
		for (int i = 1; i <= 136; i++) {
			inv.frameMovement();
		} assertEquals(10, inv.getX());
	}

	/**
	 * Tests X movement of invader
	 */
	@Test
	public void testIMoveX6() {
		for (int i = 1; i <= 76; i++) {
			inv.frameMovement();
		} assertEquals(39, inv.getX());
	}

	/**
	 * Tests X movement of invader
	 */
	@Test
	public void testIMoveX7() {
		for (int i = 1; i <= 75; i++) {
			inv.frameMovement();
		} assertEquals(39, inv.getX());
	}

	/**
	 * Tests X movement of invader
	 */
	@Test
	public void testIMoveX8() {
		for (int i = 1; i <= 62; i++) {
			inv.frameMovement();
		} assertEquals(39, inv.getX());
	}

	/**
	 * Tests X movement of invader
	 */
	@Test
	public void testIMoveX9() {
		for (int i = 1; i <= 60; i++) {
			inv.frameMovement();
		} assertEquals(39, inv.getX());
	}

	/**
	 * Tests X movement of invader
	 */
	@Test
	public void testIMoveX10() {
		for (int i = 1; i <= 60; i++) {
			inv.frameMovement();
		} assertEquals(39, inv.getX());
	}

	/**
	 * Tests X movement of invader
	 */
	@Test
	public void testIMoveX11() {
		for (int i = 1; i <= 60; i++) {
			inv.frameMovement();
		} assertEquals(39, inv.getX());
	}

	/**
	 * Tests X movement of invader
	 */
	@Test
	public void testIMoveX12() {
		for (int i = 1; i <= 60; i++) {
			inv.frameMovement();
		} assertEquals(39, inv.getX());
	}

	/**
	 * Tests Y movement of invader
	 */
	@Test
	public void testIMoveY1() {
		for (int i = 1; i <= 154; i++) {
			inv.frameMovement();
		} assertEquals(24, inv.getY());
	}

	/**
	 * Tests Y movement of invader
	 */
	@Test
	public void testIMoveY2() {
		for (int i = 1; i <= 152; i++) {
			inv.frameMovement();
		} assertEquals(24, inv.getY());
	}

	/**
	 * Tests Y movement of invader
	 */
	@Test
	public void testIMoveY3() {
		for (int i = 1; i <= 138; i++) {
			inv.frameMovement();
		} assertEquals(18, inv.getY());
	}

	/**
	 * Tests Y movement of invader
	 */
	@Test
	public void testIMoveY4() {
		for (int i = 1; i <= 136; i++) {
			inv.frameMovement();
		} assertEquals(17, inv.getY());
	}

	/**
	 * Tests Y movement of invader
	 */
	@Test
	public void testIMoveY5() {
		for (int i = 1; i <= 78; i++) {
			inv.frameMovement();
		} assertEquals(17, inv.getY());
	}

	/**
	 * Tests Y movement of invader
	 */
	@Test
	public void testIMoveY6() {
		for (int i = 1; i <= 76; i++) {
			inv.frameMovement();
		} assertEquals(17, inv.getY());
	}

	/**
	 * Tests Y movement of invader
	 */
	@Test
	public void testIMoveY7() {
		for (int i = 1; i <= 62; i++) {
			inv.frameMovement();
		} assertEquals(11, inv.getY());
	}

	/**
	 * Tests Y movement of invader
	 */
	@Test
	public void testIMoveY8() {
		for (int i = 1; i <= 60; i++) {
			inv.frameMovement();
		} assertEquals(10, inv.getY());
	}

	/**
	 * Tests Y movement of invader
	 */
	@Test
	public void testIMoveY9() {
		for (int i = 1; i <= 1; i++) {
			inv.frameMovement();
		} assertEquals(10, inv.getY());
	}

	/**
	 * Tests invader shot
	 */
	@Test
	public void testIShoot() {
		assertNotNull(inv.shoot());
	}

	/**
	 * Tests powered invader shot
	 */
	@Test
	public void testPowIShoot() {
		assertNotNull(powInv.shoot());
	}

	/**
	 * Tests armoured invader shot
	 */
	@Test
	public void testArmIShoot() {
		assertNotNull(armInv.shoot());
	}

	/**
	 * Tests if invaders has hit barriers
	 */
	@Test
	public void testIHitBarriers() {
		bLs.add(barrier1);
		assertTrue(inv.hitBarriers(bLs));
	}

	/**
	 * Tests if invaders has hit barriers
	 */
	@Test
	public void testINotHitBarriers() {
		bLs.add(barrier2);
		assertFalse(inv.hitBarriers(bLs));
	}

	/**
	 * Tests frame that the invader is in
	 */
	@Test
	public void testGetFrame1() {
		inv.frameMovement();
		inv.frameMovement();
		assertEquals(1, inv.getFrame());
	}

	/**
	 * Tests frame that the invader is in
	 */
	@Test
	public void testGetFrame2() {
		inv.frameMovement();
		assertEquals(2, inv.getFrame());
	}

	/**
	 * Tests frame that the invader is in
	 */
	@Test
	public void testGetFrame3() {
		assertEquals(1, inv.getFrame());
	}
}
