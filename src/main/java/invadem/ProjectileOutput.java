package invadem;

import java.util.*;
import processing.core.PImage;

public abstract class ProjectileOutput extends Health implements Action {

	public ProjectileOutput(int x, int y, int height, int width, int health) {
		super(x, y, height, width, health);
		characters = new ArrayList<PImage>();
	}

	/**
	 * Character shoots a projectile
	 */
	public abstract Projectile shoot();

}
