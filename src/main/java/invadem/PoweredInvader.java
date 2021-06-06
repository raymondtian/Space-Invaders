package invadem;

public class PoweredInvader extends Invader {

	public PoweredInvader(int x, int y) {
		super(x, y);
	}

	/**
	 * Powered Invader shoots a big projectile that instant kills
	 */
	public Projectile shoot() {
		return new Projectile(this.getX() + 7, this.getY() + 16, 5, 2, this, 3);
	}
}
