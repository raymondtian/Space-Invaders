package invadem;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;

public class Projectile extends Character implements Action {

	private ProjectileOutput po;
	private int injure;

	public Projectile(int x, int y, int height, int width, ProjectileOutput po, int injure) {
		super(x, y, height, width);
		this.po = po;
		this.injure = injure;
	}

	public void draw(PApplet app) {
		app.image(selectCharacter(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
		move();
	}

	/**
	 * Getter method for ProjectileOutput
	 * @return ProjectileOutput
	 */
	public ProjectileOutput getPO() {
		return po;
	}

	/**
	 * Getter method for returning injury points
	 */
	public int getInjure() {
		return injure;
	}

	public PImage selectCharacter() {
		return this.getCharacters().get(0);
	}

	/**
	 * Projectile moves up by 1 pixel
	 */
	public void Up(Character c) {
		c.setY(c.getY() - 1);
	}

	/**
	 * Projectile moves down by 1 pixel
	 */
	public void Down(Character c) {
		c.setY(c.getY() + 1);
	}

	/**
	 * If the projectile is the Tank's projectile, it will move upwards
	 * else if the projectile is the Invader's projectile, it will move downwards
	 */
	public void move() {
		if (po instanceof Tank) {
			Up(this);
		} else if (po instanceof Invader) {
			Down(this);
		}
	}

	/**
	 * Checks if the character is an ally
	 * @return boolean value
	 */
	public boolean isAlly(Character chara) {
		if ((po instanceof PoweredInvader || po instanceof ArmouredInvader || po instanceof Invader) && !(chara instanceof Tank)) {
			return true;
		} return (chara.getClass().equals(po.getClass()));
	}

	/**
	 * Checks a barrier has been hit by a projectile
	 */
	public <B extends Barrier> boolean isBarrierHit(List<B> barriers) {
		for (B barr : barriers) {

			if (this.collision(this, barr) && !barr.isDeceased()) {
				barr.damage(this); //reduces hp
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if an invader or the tank has been hit
	 */
	public <P extends ProjectileOutput> boolean isEnemyHit(List<P> projectileoutput) {
		for (P projectileout : projectileoutput) {

			if (this.collision(this, projectileout) && !projectileout.isDeceased()) {

				if (!this.isAlly(projectileout)) {
					projectileout.damage(this); //reduces hp
					return true;
				}
			}
		}
		return false;
	}
}
