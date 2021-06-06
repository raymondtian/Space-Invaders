package invadem;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tank extends ProjectileOutput {

	private int rightMargin = 460; //right boundary - tank cannot move past this
	private int leftMargin = 180; //left boundary - tank cannot move past this
	private boolean abilityToMoveRight = false; //boolean value to see if tank can move right
	private boolean abilityToMoveLeft = false; //boolean value to see if tank can move left

	public Tank(int x, int y) {
		super(x, y, 14, 22, 3);
	}

	public void draw(PApplet app) {
		app.image(selectCharacter(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

	public PImage selectCharacter() {
		if (this.getHealth() <= 0) {
			return this.getCharacters().get(1);
		} return this.getCharacters().get(0);
	}

	/**
	 * Tank moves left by 1 pixel
	 */
	public void Left(Character c) {
		c.setX(c.getX() - 1);
	}

	/**
	 * Tank moves right by 1 pixel
	 */
	public void Right(Character c) {
		c.setX(c.getX() + 1);
	}

	/**
	 * Setter for moving left
	 * Tank has the ability to move left
	 */
	public void AbilityToMoveLeft() {
		this.abilityToMoveLeft = true;
	}

	/**
	 * Setter for moving left
	 * Tank does not have the ability to move left
	 */
	public void InabilityToMoveLeft() {
		this.abilityToMoveLeft = false;
	}

	/**
	 * Setter for moving right
	 * Tank has the ability to move right
	 */
	public void AbilityToMoveRight() {
		this.abilityToMoveRight = true;
	}

	/**
	 * Setter for moving right
	 * Tank does not have the ability to move right
	 */
	public void InabilityToMoveRight() {
		this.abilityToMoveRight = false;
	}

	/**
	 * Is the tank within the right margin of the game
	 * @return boolean value
	 */
	public boolean isWithinMarginsRight() {
		return (this.getX() < rightMargin);
	}

	/**
	 * Is the tank within the left margin of the game
	 * @return boolean value
	 */
	public boolean isWithinMarginsLeft() {
		return (this.getX() > leftMargin);
	}

	/**
	 * If the tank is within the right margin of the game
	 * tank moves right by 1 pixel
	 */
	public void goRight() {
		if (abilityToMoveRight) {
			Right(this);
		}
	}

	/**
	 * If the tank is within the left margin of the game
	 * tank moves left by 1 pixel
	 */
	public void goLeft() {
		if (abilityToMoveLeft) {
			Left(this);
		}
	}

	/**
	 * Getter method for tank's ability to move right
	 * @return boolean value
	 */
	public boolean getRight() {
		return abilityToMoveRight;
	}

	/**
	 * Getter method for tank's ability to move left
	 * @return boolean value
	 */
	public boolean getLeft() {
		return abilityToMoveLeft;
	}

	/**
	 * @return Projectile
	 */
	public Projectile shoot() {
		return new Projectile(this.getX() + 10, this.getY() - 5, 3, 1, this, 1);
	}

}
