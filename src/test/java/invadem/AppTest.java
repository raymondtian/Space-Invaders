package invadem;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import processing.core.*;
import java.io.*;

public class AppTest extends App {

	private App app;

	@Before
	public void start() {
		app = new App();
		PApplet.runSketch(new String[]{"--location=0,0", ""}, app);
		delay(2000);
	}

	/**
	 * Tests app construction
	 */
	@Test
	public void testAppConstruction() {
		assertNotNull(app);
	}

	/**
	 * Tests user pressing left arrow key to move tank
	 */
	@Test
	public void testTankMoveLeft1() {
		app.readTankCreationFile();
		app.tankCreation();
		app.begin();
		app.keyCode = 37;
		app.keyPressed();
		assertTrue(app.getTankList().get(0).getLeft());
		assertFalse(app.getTankList().get(0).getRight());
		app.killAll();
	}

	/**
	 * Tests user releasing left arrow key to stop moving tank
	 */
	@Test
	public void testTankMoveLeft2() {
		app.readTankCreationFile();
		app.tankCreation();
		app.begin();
		app.keyCode = 37;
		app.keyReleased();
		assertFalse(app.getTankList().get(0).getLeft());
		assertFalse(app.getTankList().get(0).getRight());
		app.killAll();
	}

	/**
	 * Tests user pressing right arrow key to move tank
	 */
	@Test
	public void testTankMoveRight1() {
		app.readTankCreationFile();
		app.tankCreation();
		app.begin();
		app.keyCode = 39;
		app.keyPressed();
		assertTrue(app.getTankList().get(0).getRight());
		assertFalse(app.getTankList().get(0).getLeft());
		app.killAll();
	}

	/**
	 * Tests user pressing right arrow key to stop moving tank
	 */
	@Test
	public void testTankMoveRight2() {
		app.readTankCreationFile();
		app.tankCreation();
		app.begin();
		app.keyCode = 39;
		app.keyReleased();
		assertFalse(app.getTankList().get(0).getRight());
		assertFalse(app.getTankList().get(0).getLeft());
		app.killAll();
	}

	/**
	 * Tests user pressing I key to go to instruction level
	 */
	@Test
	public void testInstructions() {
		app.setMenu();
		app.keyCode = 73;
		app.keyPressed();
		assertEquals(4, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests user pressing H key to go to high score level
	 */
	@Test
	public void testHighScores() {
		app.setMenu();
		app.keyCode = 72;
		app.keyPressed();
		assertEquals(5, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests user pressing backspace key to go back to game menu
	 */
	@Test
	public void testBackspace1() {
		app.setMenu();
		app.keyCode = 73;
		app.keyPressed();
		app.keyCode = 8;
		app.keyPressed();
		assertEquals(0, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests user pressing backspace key to go back to game menu
	 */
	@Test
	public void testBackspace2() {
		app.setMenu();
		app.keyCode = 72;
		app.keyPressed();
		app.keyCode = 8;
		app.keyPressed();
		assertEquals(0, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests user pressing enter key to start game
	 */
	@Test
	public void testStart() {
		app.setMenu();
		app.keyCode = 10;
		app.keyPressed();
		assertEquals(1, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests user releasing spacebar to shoot projectile
	 */
	@Test
	public void testSpacebar() {
		app.readTankCreationFile();
		app.tankCreation();
		app.begin();
		app.keyCode = 32;
		app.keyReleased();
		assertEquals(true, app.getProjList().get(0).getPO() instanceof Tank);
		app.killAll();
	}

	/**
	 * Tests user pressing Q
	 */
	@Test
	public void testQ() {
		app.readTankCreationFile();
		app.tankCreation();
		app.begin();
		app.keyCode = 81;
		app.keyPressed();
		assertEquals(false, app.getIsItemUsed());
		app.killAll();
	}

	/**
	 * Tests the game
	 */
	@Test
	public void testGameLevel() {
		app.begin();
		assertEquals(1, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests going to next level screen after tank wins
	 */
	@Test
	public void testNextLevelFromTankWin() {
		app.begin();
		app.killInvaders();
		app.setNextLevelLevel();
		delay(100);
		assertEquals(3, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests the instruction level
	 */
	@Test
	public void testInstructionLevel() {
		app.instructionLevel();
		assertEquals(4, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests the game menu
	 */
	@Test
	public void testStartMenu1() {
		app.setMenu();
		assertEquals(0, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests the game menu
	 */
	@Test
	public void testStartMenu2() {
		app.begin();
		app.setMenu();
		assertEquals(0, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests the game menu
	 */
	@Test
	public void testStartMenu3() {
		app.instructionLevel();
		app.setMenu();
		assertEquals(0, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests the game menu
	 */
	@Test
	public void testStartMenu4() {
		app.setNextLevelLevel();
		app.setMenu();
		assertEquals(0, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests the game menu
	 */
	@Test
	public void testStartMenu5() {
		app.highScoreLevel();
		app.setMenu();
		assertEquals(0, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests the game over level after tank loses
	 */
	@Test
	public void testGameOverLevelFromInvaderHittingBarriers() {
		app.readInvaderCreationFile(); //reading invader config file
		app.invaderCreation(); //creating invader objects
		app.begin();
		ArrayList<Invader> listInvader = app.getInvaderList();
		Invader inv = listInvader.get(0);
		inv.setY(411); //invaders hit barriers
		app.setGameOverLevel();
		delay(100);
		assertEquals(2, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests the game over level after tank loses
	 */
	@Test
	public void testGameOverLevelFromTankDeath() {
		app.readTankCreationFile(); //reading tank config file
		app.tankCreation(); //creating tank objects
		app.begin();
		ArrayList<Tank> listTank = app.getTankList();
		Tank tank = listTank.get(0);
		tank.setHealth(0); //tank is destroyed
		app.setGameOverLevel();
		delay(100);
		assertEquals(2, app.getLevel());
		app.killAll();
	}

	/**
	 * Tests the scoring system
	 */
	@Test
	public void testScore() {
		app.readInvaderCreationFile(); //reading invader config file
		app.invaderCreation(); //creating invader objects
		app.readTankCreationFile(); //reading tank config file
		app.tankCreation(); //creating tank objects
		app.begin();
		app.hitInvaderScore();
		delay(100);
		assertEquals(0, app.getScore());
		app.killAll();
	}

	/**
	 * Tests the invader shooting projectiles
	 */
	@Test
	public void testInvShooting() {
		app.readInvaderCreationFile(); //reading invader config file
		app.invaderCreation(); //creating invader objects
		app.begin();
		invaderBlast();
		delay(100);
		assertEquals(0, app.getProjList().size());
		app.killAll();
	}

	/**
	 * Tests when tank is out of bounds
	 */
	@Test
	public void testTankOutOfBoundsLeft() {
		app.readTankCreationFile(); //reading tank config file
		app.tankCreation(); //creating tank objects
		app.begin();
		ArrayList<Tank> listTank = app.getTankList();
		Tank tank = listTank.get(0);
		tank.setX(180);
		app.isTankWithinMargins();
		delay(100);
		assertEquals(180, tank.getX());
		app.killAll();
	}

	/**
	 * Tests when tank is out of bounds
	 */
	@Test
	public void testTankOutOfBoundsRight() {
		app.readTankCreationFile(); //reading tank config file
		app.tankCreation(); //creating tank objects
		app.begin();
		ArrayList<Tank> listTank = app.getTankList();
		Tank tank = listTank.get(0);
		tank.setX(460);
		app.isTankWithinMargins();
		delay(100);
		assertEquals(460, tank.getX());
		app.killAll();
	}

	/**
	 * Tests invader's shot interval
	 */
	@Test
	public void testShotInterval() {
		app.readInvaderCreationFile(); //reading invader config file
		app.invaderCreation(); //creating invader objets
		app.begin();
		assertEquals(300, app.getShotInterval());
		app.killAll();
	}

	/**
	 * Tests user's ability to use item (extension)
	 */
	@Test
	public void testFullHealthUseItem() {
		//delete this test case if it gives a NullPointerException as it is glitchy,
		//so you can see the rest of the code coverage
		app.readTankCreationFile(); //reading tank config file
		app.tankCreation(); //creating tank objects
		app.begin();
		app.useItem();
		assertEquals(false, app.getIsItemUsed());
		app.killAll();
	}

	/**
	 * Tests user's ability to use item (extension)
	 */
	@Test
	public void test2HealthUseItem() {
		//delete this test case if it gives a NullPointerException as it is glitchy,
		//so you can see the rest of the code coverage
		app.readTankCreationFile(); //reading tank config file
		app.tankCreation(); //creating tank objects
		app.begin();
		ArrayList<Tank> listTank = app.getTankList();
		Tank tank = listTank.get(0);
		tank.setHealth(2);
		app.useItem();
		assertEquals(true, app.getIsItemUsed());
		app.killAll();
	}

}
