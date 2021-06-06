package invadem;

public interface Impact {

	public default boolean collision(Character c1, Character c2) {
		if ((c1.getX() + c1.getWidth()) > c2.getX() && (c1.getHeight() + c1.getY()) > c2.getY() && c1.getY() < (c2.getY() + c2.getHeight())
		&& c1.getX() < (c2.getX() + c2.getWidth())) {
			return true;
		}
		return false;
	}
}
