package invadem;

import java.util.*;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import java.awt.event.KeyEvent;
import java.io.*;

import invadem.Tank;
import invadem.Projectile;
import invadem.Invader;
import invadem.Barrier;
import invadem.ArmouredInvader;
import invadem.PoweredInvader;

public class App extends PApplet {

	//will hold images
	private PImage tank1;
	private PImage invader1;
	private PImage invader2;
	private PImage armInvader1;
	private PImage armInvader2;
	private PImage powInvader1;
	private PImage powInvader2;
	private PImage projectile;
	private PImage lgProjectile;
	private PImage barrierSolid1;
	private PImage barrierSolid2;
	private PImage barrierSolid3;
	private PImage barrierTop1;
	private PImage barrierTop2;
	private PImage barrierTop3;
	private PImage barrierLeft1;
	private PImage barrierLeft2;
	private PImage barrierLeft3;
	private PImage barrierRight1;
	private PImage barrierRight2;
	private PImage barrierRight3;
	private PImage empty;
	private PImage gameover;
	private PImage nextLevel;
	private PImage health;
	private PImage extrahealth;
	private PImage play;
	private PImage instructions;
	private PImage high_score;
	private PImage instructionList;
	private PImage back;
	private PImage title;
	private PImage background;
	private PImage instructionsHeading;

	//boolean values to check if characters have been hit
	private boolean invHit;
	private boolean rbHit;
	private boolean lbHit;
	private boolean tbHit;
	private boolean sbHit;
	private boolean hitTank;

	//boolean value for item being used or not
	private boolean isItemUsed;

	//list for invader attributes
	private ArrayList<String[]> invaderAttributes;

	//list for tank attributes
	private ArrayList<String[]> tankAttributes;

	//random variable for random projectiles out of the invaders
	private Random r;

	//top margin of the screen
	private int topMargin;

	//bottom margin of the screen
	private int bottomMargin;

	//counter for levels
	private int level;

	//interval between invader shots
	private int shotInterval;

	//minimum rate of fire for invaders (1 proj per second)
	private int minShotInterval = 60;

	//current score
	private int currentScore = 0;

	//high score
	private int highScore = 0;

	//total score
	private int totalScore = 0;

	//timer
	private int timer = 0;

	//transition screen time
	private int transition = 0;

	//font
	private PFont font;

	//for opening config files
	private File f;
	private Scanner sc;

	//max & min items held
	private int maxItems = 1;
	private int minItems = 0;

	//current items held
	private int currentItems = 1;

	//ArrayLists of character objects
	private ArrayList<Tank> tankList;
	private ArrayList<Invader> invaderList;
	private ArrayList<ArmouredInvader> armInvaderList;
	private ArrayList<PoweredInvader> powInvaderList;
	private ArrayList<Projectile> projectileList;
	private ArrayList<RightBarrierPart> rBarrierList;
	private ArrayList<LeftBarrierPart> lBarrierList;
	private ArrayList<TopBarrierPart> tBarrierList;
	private ArrayList<SolidBarrierPart> sBarrierList;

	//ArrayLists of character photos
	private ArrayList<PImage> tankImages;
	private ArrayList<PImage> invadersImages;
	private ArrayList<PImage> armInvadersImages;
	private ArrayList<PImage> powInvadersImages;
	private ArrayList<PImage> projectileImages;
	private ArrayList<PImage> lgProjectileImages;
	private ArrayList<PImage> barrierLeftImages;
	private ArrayList<PImage> barrierRightImages;
	private ArrayList<PImage> barrierTopImages;
	private ArrayList<PImage> barrierSolidImages;

	/*
	 * Main method
	 */
	public static void main(String[] args) {
		PApplet.main("invadem.App");
	}

	public App() {
		currentScore = 0;
		highScore = 10000;
		totalScore = 0;
		shotInterval = 300;
		topMargin = 0;
		bottomMargin = 480;
		level = 0;
		invaderAttributes = new ArrayList<String[]>();
		tankAttributes = new ArrayList<String[]>();
		timer = 0;
		transition = 200;
		maxItems = 1;
		minItems = 0;
		currentItems = 1;
		isItemUsed = false;
		r = new Random();

		tankImages = new ArrayList<>();
		tankList = new ArrayList<>();
		projectileImages = new ArrayList<>();
		projectileList = new ArrayList<>();
		lgProjectileImages = new ArrayList<>();
		invadersImages = new ArrayList<>();
		armInvadersImages = new ArrayList<>();
		armInvaderList = new ArrayList<>();
		powInvadersImages = new ArrayList<>();
		powInvaderList = new ArrayList<>();
		invaderList = new ArrayList<>();
		barrierRightImages = new ArrayList<>();
		rBarrierList = new ArrayList<>();
		barrierLeftImages = new ArrayList<>();
		lBarrierList = new ArrayList<>();
		barrierSolidImages = new ArrayList<>();
		sBarrierList = new ArrayList<>();
		barrierTopImages = new ArrayList<>();
		tBarrierList = new ArrayList<>();
		invaderAttributes = new ArrayList<String[]>();
		tankAttributes = new ArrayList<String[]>();
	}

	/**
	 * Setting the size of the game
	 */
	public void settings() {
		size(640, 480);

	}

	public void setup() {
		frameRate(60); //setting framerate
		font = createFont("PressStart2P-Regular.ttf", 10);

		//loading images
		tank1 = loadImage("tank1.png");
		invader1 = loadImage("invader1.png");
		invader2 = loadImage("invader2.png");
		armInvader1 = loadImage("invader1_armoured.png");
		armInvader2 = loadImage("invader2_armoured.png");
		powInvader1 = loadImage("invader1_power.png");
		powInvader2 = loadImage("invader2_power.png");
		projectile = loadImage("projectile.png");
		lgProjectile = loadImage("projectile_lg.png");
		barrierSolid1 = loadImage("barrier_solid1.png");
		barrierSolid2 = loadImage("barrier_solid2.png");
		barrierSolid3 = loadImage("barrier_solid3.png");
		barrierTop1 = loadImage("barrier_top1.png");
		barrierTop2 = loadImage("barrier_top2.png");
		barrierTop3 = loadImage("barrier_top3.png");
		barrierLeft1 = loadImage("barrier_left1.png");
		barrierLeft2 = loadImage("barrier_left2.png");
		barrierLeft3 = loadImage("barrier_left3.png");
		barrierRight1 = loadImage("barrier_right1.png");
		barrierRight2 = loadImage("barrier_right2.png");
		barrierRight3 = loadImage("barrier_right3.png");
		empty = loadImage("empty.png");
		gameover = loadImage("gameover.png");
		nextLevel = loadImage("nextlevel.png");
		health = loadImage("heart.png");
		extrahealth = loadImage("extra_heart.png");
		play = loadImage("play.png");
		instructions = loadImage("instructions.png");
		high_score = loadImage("high_score.png");
		instructionList = loadImage("instructionList.png");
		back = loadImage("back.png");
		title = loadImage("title.png");
		background = loadImage("background.png");
		instructionsHeading = loadImage("instructions_heading.png");

		//adding images to respective PImage ArrayLists
		tankImages.add(tank1);
		invaderList.addAll(armInvaderList);
		invaderList.addAll(powInvaderList);
		projectileImages.add(projectile);
		lgProjectileImages.add(lgProjectile);
		invadersImages.add(invader1);
		invadersImages.add(invader2);
		armInvadersImages.add(armInvader1);
		armInvadersImages.add(armInvader2);
		powInvadersImages.add(powInvader1);
		powInvadersImages.add(powInvader2);
		barrierRightImages.add(barrierRight1);
		barrierRightImages.add(barrierRight2);
		barrierRightImages.add(barrierRight3);
		barrierLeftImages.add(barrierLeft1);
		barrierLeftImages.add(barrierLeft2);
		barrierLeftImages.add(barrierLeft3);
		barrierSolidImages.add(barrierSolid1);
		barrierSolidImages.add(barrierSolid2);
		barrierSolidImages.add(barrierSolid3);
		barrierTopImages.add(barrierTop1);
		barrierTopImages.add(barrierTop2);
		barrierTopImages.add(barrierTop3);
		barrierTopImages.add(empty);
		tankImages.add(empty);
		barrierRightImages.add(empty);
		barrierLeftImages.add(empty);
		barrierSolidImages.add(empty);
		invadersImages.add(empty);
		armInvadersImages.add(empty);
		powInvadersImages.add(empty);

		readInvaderCreationFile(); //reading invader config files
		readTankCreationFile(); //reading tank config files
		invaderCreation(); //creating invader objects
		tankCreation(); //creating tank objects
		barrierCreation(); //creating barrier objects
		images(); //drawing images on the screen
		healthpoints(); //drawing health bar on screen
	}

	/*
	 * Reading the invader configuration file
	 */
	public void readInvaderCreationFile() {
		try {
			f = new File("src/main/java/invadem/InvaderCreation.txt");
			sc = new Scanner(f);

			while (sc.hasNext()) {
				String[] invader_attributes = sc.nextLine().split(",");
				invaderAttributes.add(invader_attributes);
			}
		} catch (FileNotFoundException e) {
		}
	}

	/*
	 * Reading the tank configuration file
	 */
	public void readTankCreationFile() {
		try {
			f = new File("src/main/java/invadem/TankCreation.txt");
			sc = new Scanner(f);

			while (sc.hasNext()) {
				String[] tank_attributes = sc.nextLine().split(",");
				tankAttributes.add(tank_attributes);
			}
		} catch (FileNotFoundException e) {
		}
	}

	/*
	 * Drawing the health bar
	 */
	public void healthpoints() {
		textFont(font, 10);
		textAlign(LEFT);
		text("Lives", 298, 35);
		if (tankList.get(0).getHealth() == 3) {
			image(health, 295, 40);
			image(health, 315, 40);
			image(health, 335, 40);
		} if (tankList.get(0).getHealth() == 2) {
			image(health, 295, 40);
			image(health, 315, 40);
		} if (tankList.get(0).getHealth() == 1) {
			image(health, 295, 40);
		} if (tankList.get(0).getHealth() == 0) {
			image(empty, 315, 40);
		}
	}

	/*
	 * Function using item (extension)
	 */
	public void useItem() {
		if (tankList.get(0).getHealth() == 3) {
			image(empty, 640, 480);
		} if (isItemUsed == false) {
			if (currentItems <= maxItems && currentItems > minItems) {
				if (tankList.get(0).getHealth() == 2) {
					isItemUsed = true;
					currentItems--;
					image(health, 335, 40);
					tankList.get(0).increaseHealth();
				} if (tankList.get(0).getHealth() == 1) {
					isItemUsed = true;
					currentItems--;
					image(health, 315, 40);
					tankList.get(0).increaseHealth();
				}
			}
		}
	}

	/*
	 * Getter method for checking if item is used up (created for test cases)
	 * @return boolean value
	 */
	public boolean getIsItemUsed() {
		return isItemUsed;
	}

	/*
	 * Function for drawing tank and invader objects
	 */
	public void images() {
		for (Tank tank : tankList) {
			tank.addCharacters(tankImages);
		} for (Invader inv : invaderList) {
			if (inv instanceof PoweredInvader) {
				inv.addCharacters(powInvadersImages);
			} else if (inv instanceof ArmouredInvader) {
				inv.addCharacters(armInvadersImages);
			} else {
				inv.addCharacters(invadersImages);
			}
		}
	}

	/*
	 * Function for drawing game over level
	 */
	public void gameOverLevel() {
		image(gameover, 264, 232);
		isItemUsed = false;
		currentItems = 1;
		if (currentScore + totalScore > highScore) {
			highScore = currentScore + totalScore; //update high score
		}
		currentscoreboard(); //draw current score
		highscoreboard(); //draw high score
		if (timer >= transition) {
			shotInterval = 300;
			timer = 0;
			totalScore = 0;
			currentScore = 0;
			level = 1;
			killAll(); //removes all characters from screen
			readInvaderCreationFile(); //read invader config file
			readTankCreationFile(); //read tank config file
			invaderCreation(); //create invader objects
			tankCreation(); //create tank objects
			barrierCreation(); //creates barrier objects
			images(); //draws invaders and tanks on screen
			healthpoints(); //drawing health bar on screen
		} timer++; //add to timer for transition
	}

	/*
	 * Function for drawing next level transition
	 */
	public void nextLevelLevel() {
		image(nextLevel, 259, 232);
		if (timer >= transition) {
			if (shotInterval > 60) {
				shotInterval -= 60; //decrease shot interval by 60 each new leve up until invaders shoot 1 projectile per second
			}
			timer = 0;
			level = 1;
			totalScore = currentScore + totalScore;
			currentScore = 0;
			killAll(); //removes all characters from screen
			hitInvaderScore(); //adding to scoreboard
			readInvaderCreationFile(); //read invader config file
			readTankCreationFile(); //read tank config file
			invaderCreation(); //create invader objects
			tankCreation(); //create tank objects
			barrierCreation(); //create barrier objects
			images(); //draws invaders and tanks on screen
			healthpoints(); //drawing health bar on screen
		} timer++; //add to timer for transition
	}

	public void draw() {
		background(0, 0, 0);

		if (level == 0) { //start up menu
			image(background, 0, 0);
			image(title, 50, 25);
			image(play, 50, 90);
			image(instructions, 50, 160);
			image(high_score, 50, 230);
			image(invader1, 142, 168);
			image(invader1, 493, 168);
			image(invader1, 142, 379);
			image(invader1, 493, 379);
		}
		if (level == 1) { //if screen is on the invader gameplay
			if (invaderHitBarrier() || tankList.get(0).isDeceased()) {
				level = 2; //game over transition screen
			} else if (youWin()) {
				level = 3; //nextlevel transition screen
			} else {
				currentscoreboard(); //draw current score
				highscoreboard(); //draw high score

				//draw all barriers
				printBarrierParts(sBarrierList);
				printBarrierParts(tBarrierList);
				printBarrierParts(rBarrierList);
				printBarrierParts(lBarrierList);

				//draw tank and invaders
				printProjectileOutput(tankList);
				printProjectileOutput(invaderList);

				projectileOffScreen(); //check if projectiles are off screen
				outputProjectiles(); //draw projectiles
				invaderBlast(); //invaders randomly shooting
				isTankWithinMargins(); //prevents tank from going outside margins
				collisionWithCharacters(); //projectile colliding with invaders, tank or barriers
				invaderHitBarrier(); //user loses if invaders reach barriers
				hitInvaderScore(); //adding to scoreboard
				healthpoints(); //drawing health bar on screen
			}
		} if (level == 2) { //if screen is on the gameover screen
			gameOverLevel();
		} if (level == 3) { //if screen is on the next level transition screen
			nextLevelLevel();
		} if (level == 4) { //instructions screen
			image(instructionsHeading, 193, 5);
			image(background, 0, 0);
			image(instructionList, 95, 70); //list of instructions
			image(back, 10, 232);
		} if (level == 5) { //current high score screen
			image(background, 0, 0);
			textFont(font, 16);
			textAlign(CENTER);
			text("Current High Score: " + (highScore), 320, 240);
			image(back, 10, 232);
		}
	}

	/*
	 * Game menu
	 */
	public void setMenu() {
		level = 0;
	}

	/*
	 * begin the game at level of invaders
	 */
	public void begin() {
		level = 1;
	}

	/*
	 * level of game over screen
	 */
	public void setGameOverLevel() {
		level = 2;
	}

	/*
	 * level of next level screen
	 */
	public void setNextLevelLevel() {
		level = 3;
	}

	/*
	 * Changes level to the instruction screen
	 */
	public void instructionLevel() {
		level = 4;
	}

	/*
	 * Changes level to the high score screen
	 */
	public void highScoreLevel() {
		level = 5;
	}

	/*
	 * Function for creating tank objects
	 */
	public void tankCreation() {
		for (int i = 0; i < tankAttributes.size(); i++) {
			for (int n = 1; n < tankAttributes.get(i).length; n++) {
				String[] ls = tankAttributes.get(i)[n].split(" ");
				int y = Integer.parseInt(ls[1]);
				int x = Integer.parseInt(ls[0]);

				if (i == 0) {
					tankList.add(new Tank(x, y));
				}
			}
		}
	}

	/*
	 * Checking if the tank is within the margins specified
	 */
	public void isTankWithinMargins() {
		for (Tank tank : tankList) {

			if (tank.isWithinMarginsRight() && tank.isWithinMarginsLeft()) {
				tank.goRight();
				tank.goLeft();
			} else if (!tank.isWithinMarginsRight()) {
				tank.goLeft();
			} else if (!tank.isWithinMarginsLeft()) {
				tank.goRight();
			}
		}
	}

	/*
	 * Function for creating invader objects
	 */
	public void invaderCreation() {
		for (int i = 0; i < invaderAttributes.size(); i++) {
			for (int n = 1; n < invaderAttributes.get(i).length; n++) {
				String[] ls = invaderAttributes.get(i)[n].split(" ");
				int y = Integer.parseInt(ls[1]);
				int x = Integer.parseInt(ls[0]);

				if (i == 0 || i == 1) {
					invaderList.add(new Invader(x, y));
				} if (i == 2) {
					invaderList.add(new ArmouredInvader(x, y));
				} if (i == 3) {
					invaderList.add(new PoweredInvader(x, y));
				}
			}
		}
	}

	/*
	 * Invaders randomly shooting
	 */
	public void invaderBlast() {
		if (frameCount % shotInterval == 0)  { //if frameCount is even
			ArrayList<Invader> aliveInvaders = new ArrayList<Invader>();
			for (Invader inv : invaderList) {
				if (!inv.isDeceased()) {
					aliveInvaders.add(inv);
				}
			} if (aliveInvaders.size() > 0) {
				Invader invaderblaster = aliveInvaders.get(r.nextInt(aliveInvaders.size()));
				Projectile proj = invaderblaster.shoot();
				if (proj.getPO() instanceof PoweredInvader) {
					proj.addCharacters(lgProjectileImages);
				} else {
					proj.addCharacters(projectileImages);
				} projectileList.add(proj);
			}
		}
	}

	/*
	 * End game when an invader hits any barrier
	 */
	public boolean invaderHitBarrier() {
		for (Invader inv : invaderList) {

			if (inv.getY() == 410) { //if Y position of invaders are at the barriers
				return true;
			}
		} return false;
	}

	/*
	 * Draws projectiles
	 */
	public void outputProjectiles() {
		for (Projectile proj : projectileList) {
			proj.draw(this);
		}
	}

	/*
	 * Draws the characters that output projectiles
	 */
	public <P extends ProjectileOutput> void printProjectileOutput(List<P> projouts) {
		Iterator<P> i = projouts.iterator();

		while (i.hasNext()) {
			P projoutput = i.next();
			if (projoutput.isDeceased()) { //if an invader or tank is dead
				i.remove(); //remove them
			} else {
				projoutput.draw(this);
			}
		}
	}

	/*
	 * Projectile collision with tank, invader, and barriers
	 */
	public void collisionWithCharacters() {
		Iterator<Projectile> i = projectileList.iterator();

		while (i.hasNext()) {
			Projectile proj = i.next();
			boolean hitTank = proj.isEnemyHit(tankList);
			boolean invHit = proj.isEnemyHit(invaderList);
			boolean rbHit = proj.isBarrierHit(rBarrierList);
			boolean lbHit = proj.isBarrierHit(lBarrierList);
			boolean sbHit = proj.isBarrierHit(sBarrierList);
			boolean tbHit = proj.isBarrierHit(tBarrierList);

			if (hitTank || invHit || rbHit || lbHit || sbHit || tbHit) {
				i.remove();
			}
		}
	}

	/*
	 * Function for removing projectiles that are past the margins
	 */
	public void projectileOffScreen() {
		Iterator<Projectile> i = projectileList.iterator();

		while (i.hasNext()) {
			Projectile proj = i.next();

			if (proj.getY() >= bottomMargin || proj.getY() <= topMargin) {
				i.remove();
			}
		}
	}

	/*
	 * Function for adding points/score when an invader is killed
	 */
	public void hitInvaderScore() {
		for (Invader inv : invaderList) {

			if (inv.isDeceased()) {
				if (inv instanceof PoweredInvader || inv instanceof ArmouredInvader) {
					currentScore += 250;
				} else {
					currentScore += 100;
				}
			}
		}
	}

	/*
	 * Function for drawing the scoreboard for current score
	 */
	public void currentscoreboard() {
		textFont(font, 10);
		textAlign(LEFT);
		text("Current Score: " + (currentScore + totalScore), 40, 40);
	}

	/*
	 * Function for drawing the scoreboard for the high score
	 * high score only updates once user dies and a new game begins.
	 */
	public void highscoreboard() {
		textFont(font, 10);
		textAlign(RIGHT);
		text("High Score: " + (highScore), 600, 40);
	}

	/*
	 * When right or left arrow keys are pressed
	 * tank will move right or left respectively
	 */
	public void keyPressed() {
		if (keyCode == 39) { //right arrow key
			tankList.get(0).AbilityToMoveRight();
		} if (keyCode == 37) { //left arrow key
			tankList.get(0).AbilityToMoveLeft();
		} if (keyCode == 10) { //enter key
			if (level == 0) {
				begin();
			}
		} if (keyCode == 73) { //letter I key
			if (level == 0) {
				instructionLevel();
			}
		} if (keyCode == 8) { //backspace key
			if (level == 4 || level == 5) {
				level = 0;
			}
		} if (keyCode == 81) { //letter Q key
			useItem();
		} if (keyCode == 72) { //letter H key
			if (level == 0) {
				highScoreLevel();
			}
		}
	}

	/*
	 * When right or left arrow keys are released
	 * tank will stop its movement. When spacebar is
	 * released, tank will shoot a projectile
	 */
	public void keyReleased() {
		if (keyCode == 39) { //right arrow key
			tankList.get(0).InabilityToMoveRight();
		} if (keyCode == 37) { //left arrow key
			tankList.get(0).InabilityToMoveLeft();
		} if (keyCode == 32) { //spacebar key
			Projectile proj = tankList.get(0).shoot(); //tank shoots projectile
			proj.addCharacters(projectileImages);
			projectileList.add(proj);
		}
	}

	/*
	 * Function for creating barrier objects
	 */
	public void barrierCreation() {
		for (int i = 216; i <= 456; i += 120) {
			RightBarrierPart rb = new RightBarrierPart(i, 424);
			rBarrierList.add(rb);
		}
		for (RightBarrierPart rightbarrier : rBarrierList) {
			rightbarrier.addCharacters(barrierRightImages);
		}

		for (int i = 200; i <= 440; i += 120) {
			LeftBarrierPart lb = new LeftBarrierPart(i, 424);
			lBarrierList.add(lb);
		}
		for (LeftBarrierPart leftbarrier : lBarrierList) {
			leftbarrier.addCharacters(barrierLeftImages);
		}

		for (int i = 216; i <= 456; i += 120) {
			for (int n = 440; n >= 432; n -= 8) {
				SolidBarrierPart sb = new SolidBarrierPart(i, n);
				sBarrierList.add(sb);
			}
		}
		for (int i = 200; i <= 440; i += 120) {
			for (int n = 440; n >= 432; n -= 8) {
				SolidBarrierPart sb = new SolidBarrierPart(i, n);
				sBarrierList.add(sb);
			}
		}
		for (SolidBarrierPart solidbarrier : sBarrierList) {
			solidbarrier.addCharacters(barrierSolidImages);
		}

		for (int i = 208; i <= 448; i += 120) {
			TopBarrierPart tb = new TopBarrierPart(i, 424);
			tBarrierList.add(tb);
		}
		for (TopBarrierPart topbarrier : tBarrierList) {
			topbarrier.addCharacters(barrierTopImages);
		}
	}

	/*
	 * Draws the barriers
	 */
	public <B extends Barrier> void printBarrierParts(List<B> barr) {
		Iterator<B> i = barr.iterator();

		while (i.hasNext()) {
			B barrier = i.next();
			barrier.draw(this);
		}
	}

	/*
	 * User wins the game
	 */
	public boolean youWin() {
		for (Invader inv : invaderList) {

			if (!inv.isDeceased()) {
				return false;
			}
		} return true;
	}

	/*
	 * User loses the game
	 * removes all characters off screen
	 */
	public void killAll() {
		tankList.removeAll(tankList);
		projectileList.removeAll(projectileList);
		rBarrierList.removeAll(rBarrierList);
		lBarrierList.removeAll(lBarrierList);
		sBarrierList.removeAll(sBarrierList);
		tBarrierList.removeAll(tBarrierList);
		killInvaders();
	}

	/*
	 * Function for removing all invaders (created for test cases)
	 */
	public void killInvaders() {
		invaderList.removeAll(invaderList);
	}

	/*
	 * Getter method for shot interval (created for test cases)
	 * @return int value
	 */
	public int getShotInterval() {
		return shotInterval;
	}

	/*
	 * Getter method for score (created for test cases)
	 * @return int value
	 */
	public int getScore() {
		return currentScore;
	}

	/*
	 * Getter method for level (created for test cases)
	 * @return int value
	 */
	public int getLevel() {
		return level;
	}

	/*
	 * Getter method for tank object list (created for test cases)
	 */
	public ArrayList<Tank> getTankList() {
		return tankList;
	}

	/*
	 * Getter method for invader object list (created for test cases)
	 */
	public ArrayList<Invader> getInvaderList() {
		return invaderList;
	}

	/*
	 * Getter method for projectile object list (created for test cases)
	 */
	public ArrayList<Projectile> getProjList() {
		return projectileList;
	}

}
