package invadem;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;

public class Invader extends ProjectileOutput {

	private boolean goDown = false; //boolean value for moving down
	private boolean goRight = true; //boolean value for moving to the right
	private int side = 1; //holds how many pixels invader moves sideways
	private int down = 1; //holds how many pixels invader moves downwards
	private int frame = 1; //current frame the invader is in
	public List<PImage> characters;

	public Invader(int x, int y) {
		super(x, y, 16, 16, 1);
		characters = new ArrayList<PImage>();
	}

	public void draw(PApplet app) {
		app.image(selectCharacter(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
		frameMovement();
	}

	/**
	 * Getter method for the frame of the invader
	 * @return int
	 */
	public int getFrame() {
		return frame;
	}

	public PImage selectCharacter() {
		if (this.getHealth() <= 0) {
			return this.getCharacters().get(2);
		} else if (!goDown) {
			return this.getCharacters().get(0);
		} return this.getCharacters().get(1);
	}

	/**
	 * movement of invader
	 */
	public void move() {
		if (goRight) {
			if (goDown) {
				if (down == 8) {
					goDown = false;
					goRight = true;
					down = 1;
				} else {
					Down(this);
					down += 1;
				}
			} else {
				if (side == 30) {
					goDown = true;
					goRight = false;
				} else {
					Right(this);
					side += 1;
				}
			}
		} else {
			if (goDown) {
				if (down == 8) {
					goDown = false;
					down = 1;
				} else {
					Down(this);
					down += 1;
				}
			} else {
				if (side == 1) {
					goRight = true;
					goDown = true;
				} else {
					Left(this);
					side -= 1;
				}
			}
		}
	}

	public void frameMovement() {
		if (frame == 1) {
			frame = 2;
		} else {
			move();
			frame = 1;
		}
	}

	/**
	 * Check if invader has hit a barrier
	 */
	public boolean hitBarriers(ArrayList<Barrier> barriers) {
		for (int i = 0; i < barriers.size(); i++) {
			if (this.collision(this, barriers.get(i))) {
				return true;
			}
		} return false;
	}

	/**
	 * Invader moves left by 1 pixel
	 */
	public void Left(Character c) {
		c.setX(c.getX() - 1);
	}

	/**
	 * Invader moves right by 1 pixel
	 */
	public void Right(Character c) {
		c.setX(c.getX() + 1);
	}

	/**
	 * Invader moves down by 1 pixel
	 */
	public void Down(Character c) {
		c.setY(c.getY() + 1);
	}

	/**
	 * Invader shoots a projectile
	 */
	public Projectile shoot() {
		return new Projectile(this.getX() + 8, this.getY() + 16, 3, 1, this, 1);
	}
}
