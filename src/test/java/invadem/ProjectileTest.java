package invadem;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ProjectileTest {

	private Projectile projInv;
	private Projectile projPowInv;
	private Projectile projArmInv;
	private Projectile projTank;
	private Projectile testProjTank1;
	private Projectile testProjTank2;
	private Projectile testProjTank3;
	private Projectile testProjTank4;
	private Projectile testProjInv;
	private Invader inv;
	private PoweredInvader powInv;
	private ArmouredInvader armInv;
	private Tank tank;
	private Barrier barr;
	private ArrayList<Tank> tankLs;
	private ArrayList<Invader> invLs;
	private ArrayList<PoweredInvader> powInvLs;
	private ArrayList<ArmouredInvader> armInvLs;
	private ArrayList<Barrier> barrLs;


	@Before
	public void setup() {
		projInv = new Projectile(50, 50, 3, 1, inv, 1);
		projPowInv = new Projectile(50, 50, 3, 1, powInv, 3);
		projArmInv = new Projectile(50, 50, 3, 1, armInv, 1);
		projTank = new Projectile(50, 50, 3, 1, tank, 1);
		testProjTank1 = new Projectile(0, 0, 3, 1, tank, 1);
		testProjTank2 = new Projectile(50, 50, 3, 1, tank, 1);
		testProjTank3 = new Projectile(50, 60, 3, 1, tank, 1);
		testProjTank4 = new Projectile(-10, 50, 3, 1, tank, 1);
		testProjInv = new Projectile(0, 0, 3, 1, inv, 1);
		inv = new Invader(5, 5);
		tank = new Tank(0, 0);
		barr = new Barrier(0, 0);
		tankLs = new ArrayList<Tank>();
		invLs = new ArrayList<Invader>();
		powInvLs = new ArrayList<PoweredInvader>();
		barrLs = new ArrayList<Barrier>();
	}

	/**
	 * Tests Invader projectile construction by checking that it isn't null
	 */
	@Test
	public void testProjectileConstruction1() {
		assertNotNull(projInv);
	}

	/**
	 * Tests Powered Invader projectile construction by checking that it isn't null
	 */
	@Test
	public void testProjectileConstruction2() {
		assertNotNull(projPowInv);
	}

	/**
	 * Tests Armoured Invader projectile construction by checking that it isn't null
	 */
	@Test
	public void testProjectileConstruction3() {
		assertNotNull(projArmInv);
	}

	/**
	 * Tests Tank projectile construction by checking that it isn't null
	 */
	@Test
	public void testProjectileConstruction4() {
		assertNotNull(projTank);
	}

	/**
	 * Tests ability to get powered invader
	 */
	@Test
	public void testPGetPowInvader() {
		assertEquals(powInv, projPowInv.getPO());
	}

	/**
	 * Tests ability to get armoured invader
	 */
	@Test
	public void testPGetArmInvader() {
		assertEquals(armInv, projArmInv.getPO());
	}

	/**
	 * Tests tank projectile damage
	 */
	@Test
	public void testGetProjInjure1() {
		assertEquals(1, projTank.getInjure());
	}

	/**
	 * Tests invader projectile damage
	 */
	@Test
	public void testGetProjInjure2() {
		assertEquals(1, projInv.getInjure());
	}

	/**
	 * Tests armoured invader projectile damage
	 */
	@Test
	public void testGetProjInjure3() {
		assertEquals(1, projArmInv.getInjure());
	}

	/**
	 * Tests powered invader projectile damage
	 */
	@Test
	public void testGetLargeProjInjure() {
		assertEquals(3, projPowInv.getInjure());
	}

	/**
	 * Tests the armoured invader's projectile movement
	 */
	@Test
	public void testPArmInvMoveY() {
		for (int i = 1; i <= 10; i++) {
			projArmInv.move();
		} assertEquals(50, projArmInv.getY());
	}

	/**
	 * Tests the armoured invader's projectile movement
	 */
	@Test
	public void testPArmInvMoveX() {
		projTank.move();
		assertEquals(50, projArmInv.getX());
	}

	/**
	 * Tests powered invader's projectile movement
	 */
	@Test
	public void testPPowInvMoveY() {
		for (int i = 1; i <= 10; i++) {
			projPowInv.move();
		} assertEquals(50, projPowInv.getY());
	}

	/**
	 * Tests powered invader's projectile movement
	 */
	@Test
	public void testPPowInvMoveX() {
		projTank.move();
		assertEquals(50, projPowInv.getX());
	}

	/**
	 * Tests tank's projectile movement
	 */
	@Test
	public void testPTankMoveX() {
		projTank.move();
		assertEquals(50, projTank.getX());
	}

	/**
	 * Tests tank's projectile movement
	 */
	@Test
	public void testPTankMoveY1() {
		projTank.move();
		assertEquals(50, projTank.getY());
	}

	/**
	 * Tests tank's projectile movement
	 */
	@Test
	public void testPTankMoveY2() {
		for (int i = 1; i <= 10; i++) {
			projTank.move();
		} assertEquals(50, projTank.getY());
	}

	/**
	 * Tests invader projectile movement
	 */
	@Test
	public void testPInvMoveY1() {
		for (int i = 1; i <= 10; i++) {
			projInv.move();
		} assertEquals(50, projInv.getY());
	}

	/**
	 * Tests invader projectile movement
	 */
	@Test
	public void testPInvMoveY2() {
		for (int i = 1; i <= 1; i++) {
			projInv.move();
		} assertEquals(50, projInv.getY());
	}

	/**
	 * Tests invader projectile movement
	 */
	@Test
	public void testPInvMoveX() {
		for (int i = 1; i <= 1; i++) {
			projInv.move();
		} assertEquals(50, projInv.getX());
	}

	/**
	 * Tests projectile hitting tank
	 */
	@Test
	public void testPIntersectTank1() {
		tankLs.add(tank);
		assertFalse(projTank.isEnemyHit(tankLs));
	}

	/**
	 * Tests projectile hitting tank
	 */
	@Test
	public void testPIntersectTank2() {
		tank.setHealth(0);
		tankLs.add(tank);
		assertFalse(testProjInv.isEnemyHit(tankLs));
	}

	/**
	 * Tests projectile hitting barrier
	 */
	@Test
	public void testPIntersectBarrier1() {
		barrLs.add(barr);
		assertFalse(testProjTank2.isBarrierHit(barrLs));
	}

	/**
	 * Tests projectile hitting barrier
	 */
	@Test
	public void testPIntersectBarrier2() {
		barrLs.add(barr);
		assertTrue(testProjTank1.isBarrierHit(barrLs));
	}

	/**
	 * Tests projectile hitting barrier
	 */
	@Test
	public void testPIntersectBarrier3() {
		barr.setHealth(-5);
		barrLs.add(barr);
		assertFalse(testProjTank1.isBarrierHit(barrLs));
	}

	/**
	 * Tests projectile hitting invader
	 */
	@Test
	public void testPIntersectInvader1() {
		invLs.add(inv);
		assertFalse(testProjTank4.isEnemyHit(invLs));
	}

	/**
	 * Tests projectile hitting invader
	 */
	@Test
	public void testPIntersectInvader2() {
		invLs.add(inv);
		assertFalse(testProjTank2.isEnemyHit(invLs));
	}

}
