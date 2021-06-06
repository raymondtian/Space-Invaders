package invadem;

import java.util.*;
import processing.core.PImage;

public abstract class Character implements Impact {

	protected int x, y; //x and y coordinates of character
	protected int width, height; //dimensions of character
	protected List<PImage> characters = new ArrayList<PImage>();

	public Character(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Getter for height of character
	 * @return int height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Getter for width of character
	 * @return int height
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Getter for x coordinate of character
	 * @return int x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter for y coordinate of character
	 * @return int y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter for x coordinate of character
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Setter for y coordinate of character
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Getter for list of characters
	 */
	public List<PImage> getCharacters() {
		return characters;
	}

	/**
	 * Adding characters to list of characters
	 */
	public void addCharacters(List<PImage> characters) {
		this.characters.addAll(characters);
	}
}
