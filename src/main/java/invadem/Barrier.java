package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class Barrier extends Health implements Action {

	public Barrier(int x, int y) {
		super(x, y, 8, 8, 3);
	}

	public void draw(PApplet app) {
		app.image(selectCharacter(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

	/**
	 * When barrier is hit, it changes images
	 */
	public PImage selectCharacter() {
		if (this.getHealth() == 2) {
			return this.getCharacters().get(1);
		} else if (this.getHealth() <= 0) {
			return this.getCharacters().get(3);
		} else if (this.getHealth() == 3) {
			return this.getCharacters().get(0);
		} return this.getCharacters().get(2);
	}
}
