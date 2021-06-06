package invadem;

public abstract class Health extends Character {

	protected int hp; //health of characters

	public Health(int x, int y, int height, int width, int hp) {
		super(x, y, height, width);
		this.hp = hp;
	}

	/**
	 * Setter for health of a character
	 */
	public void setHealth(int health) {
		this.hp = health;
	}

	/**
	 * Getter for health of a character
	 * @return boolean health
	 */
	public int getHealth() {
		return hp;
	}

	/**
	 * Increases health of character (extension)
	 */
	public void increaseHealth() {
		this.hp += 1;
	}

	/**
	 * When a character gets hit
	 * health is decreased by 1 point
	 */
	public void damage(Projectile proj) {
		this.hp = this.hp - proj.getInjure();
	}

	/**
	 * Checks if a character is deceased
	 * @return boolean value
	 */
	public boolean isDeceased() {
		return (this.hp <= 0);
	}

}
