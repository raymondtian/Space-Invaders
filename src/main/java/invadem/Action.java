package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public interface Action {

	public void draw(PApplet app);

	public PImage selectCharacter(); //selecting a character
}
