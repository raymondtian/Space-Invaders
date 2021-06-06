package invadem;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class TankTest {

	private Invader inv;
	private Invader inv2;
	private ArmouredInvader armInv;
	private PoweredInvader powInv;
	private Tank tank;
	private Projectile proj;

	@Before
	public void setup() {
		inv = new Invader(5, 5);
		inv2 = new Invader(20, 20);
		armInv = new ArmouredInvader(-30, 30);
		powInv = new PoweredInvader(10, 20);
		tank = new Tank(0, 0);
		proj = new Projectile(30, 30, 3, 1, inv2, 1);
	}

	/**
	 * Tests tank construction by checking tank isn't null
	 */
	@Test
	public void testTankConstruction() {
		assertNotNull(tank);
	}

	 /**
	 * Tests tank height
	 */
	@Test
	public void testTHeight() {
		assertEquals(14, tank.getHeight());
	}

	 /**
	 * Tests tank width
	 */
	@Test
	public void testTWidth() {
		assertEquals(22, tank.getWidth());
	}

	 /**
	 * Tests y location of tank
	 */
	@Test
	public void testTGetY() {
		assertEquals(0, tank.getY());
	}

	 /**
	 * Tests x location of tank
	 */
	@Test
	public void testTGetX() {
		assertEquals(0, tank.getX());
	}

	 /**
	 * Tests if tank is alive
	 */
	@Test
	public void testTAlive1() {
		assertEquals(false, tank.isDeceased());
	}

	 /**
	 * Tests if tank is alive
	 */
	@Test
	public void testTAlive2() {
		assertEquals(false, tank.isDeceased());
	}

	 /**
	 * Tests if tank is alive
	 */
	@Test
	public void testTAlive3() {
		assertEquals(false, (tank.getHealth() == 0));
	}

	/**
	 * Tests if tank is alive after 3 hits from invader
	 */
	@Test
	public void testTAlive4() {
		tank.damage(proj);
		tank.damage(proj);
		tank.damage(proj);
		assertEquals(true, tank.isDeceased());
	}

	/**
	 * Tests if tank is alive after 2 hits from invader
	 */
	@Test
	public void testTAlive5() {
		tank.damage(proj);
		tank.damage(proj);
		assertEquals(false, tank.isDeceased());
	}

	/**
	 * Tests if tank is alive after 1 hit from invader
	 */
	@Test
	public void testTAlive6() {
		tank.damage(proj);
		assertEquals(false, tank.isDeceased());
	}

	 /**
	 * Tests tank health
	 */
	@Test
	public void testTHealth() {
		assertEquals(3, tank.getHealth());
	}

	/**
	 * Tests tank's projectile
	 */
	@Test
	public void testTProjectile() {
		assertNotNull(tank.shoot());
	}

	/**
	 * Tests tank's ability to move right
	 */
	@Test
	public void testTCanMoveRight() {
		tank.AbilityToMoveRight();
		assertEquals(true, tank.getRight());
	}

	/**
	 * Tests tank's ability to move right
	 */
	@Test
	public void testTCannotMoveRight() {
		tank.InabilityToMoveRight();
		assertEquals(false, tank.getRight());
	}

	/**
	 * Tests tank's ability to move left
	 */
	@Test
	public void testTCanMoveLeft() {
		tank.AbilityToMoveLeft();
		assertEquals(true, tank.getLeft());
	}

	/**
	 * Tests tank's ability to move left
	 */
	@Test
	public void testTCannotMoveLeft() {
		tank.InabilityToMoveLeft();
		assertEquals(false, tank.getLeft());
	}

	/**
	 * Tests tank while moving right
	 */
	@Test
	public void testTRight1() {
		tank.InabilityToMoveRight();
		tank.goRight();
		assertEquals(0, tank.getX());
	}

	/**
	 * Tests tank while moving right
	 */
	@Test
	public void testTRight2() {
		tank.AbilityToMoveRight();
		tank.goRight();
		assertEquals(1, tank.getX());
	}

	/**
	 * Tests tank while moving left
	 */
	@Test
	public void testTLeft1() {
		tank.InabilityToMoveLeft();
		tank.goLeft();
		assertEquals(0, tank.getX());
	}

	/**
	 * Tests tank while moving left
	 */
	@Test
	public void testTLeft2() {
		tank.AbilityToMoveLeft();
		tank.goLeft();
		assertEquals(-1, tank.getX());
	}

	/**
	 * Tests tank health after 3 hits from invader
	 */
	@Test
	public void testTInvader1() {
		tank.damage(proj);
		tank.damage(proj);
		tank.damage(proj);
		assertEquals(0, tank.getHealth());
	}

	/**
	 * Tests tank health after 2 hits from invader
	 */
	@Test
	public void testTInvader2() {
		tank.damage(proj);
		tank.damage(proj);
		assertEquals(1, tank.getHealth());
	}
	/**
	 * Tests tank health after 1 hits from invader
	 */
	@Test
	public void testTInvader3() {
		tank.damage(proj);
		assertEquals(2, tank.getHealth());
	}

	/**
	 * Tests if tank inside right margin
	 */
	@Test
	public void testTOutOfBoundsRightMargin1() {
		tank.setX(550);
		assertEquals(false, tank.isWithinMarginsRight());
	}

	/**
	 * Tests if tank inside right margin
	 */
	@Test
	public void testTOutOfBoundsRightMargin2() {
		tank.setX(460);
		assertEquals(false, tank.isWithinMarginsRight());
	}

	/**
	 * Tests if tank inside right margin
	 */
	@Test
	public void testTOutOfBoundsRightMargin3() {
		tank.setX(300);
		assertEquals(true, tank.isWithinMarginsRight());
	}

	/**
	 * Tests if tank inside left margin
	 */
	@Test
	public void testTOutOfBoundsLeftMargin1() {
		tank.setX(100);
		assertEquals(false, tank.isWithinMarginsLeft());
	}

	/**
	 * Tests if tank inside left margin
	 */
	@Test
	public void testTOutOfBoundsLeftMargin2() {
		tank.setX(180);
		assertEquals(false, tank.isWithinMarginsLeft());
	}

	/**
	 * Tests if tank inside left margin
	 */
	@Test
	public void testTOutOfBoundsLeftMargin3() {
		tank.setX(182);
		assertEquals(true, tank.isWithinMarginsLeft());
	}

	/**
	 * Tests tank's ability to increase health (extension task)
	 */
	@Test
	public void testTHealthIncrease1() {
		tank.damage(proj);
		tank.increaseHealth();
		assertEquals(3, tank.getHealth());
	}

	/**
	 * Tests tank's ability to increase health (extension task)
	 */
	@Test
	public void testHealthIncrease2() {
		tank.damage(proj);
		tank.damage(proj);
		tank.increaseHealth();
		assertEquals(2, tank.getHealth());
	}

	/**
	 * Tests tank's ability to increase health (extension task)
	 */
	@Test
	public void testHealthIncrease3() {
		tank.setHealth(1);
		tank.increaseHealth();
		assertEquals(2, tank.getHealth());
	}

	/**
	 * Tests tank's ability to increase health (extension task)
	 */
	@Test
	public void testHealthIncrease4() {
		tank.setHealth(1);
		tank.increaseHealth();
		tank.increaseHealth();
		assertEquals(3, tank.getHealth());
	}
}
