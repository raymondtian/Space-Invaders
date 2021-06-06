package invadem;

import org.junit.*;
import static org.junit.Assert.*;

public class LeftBarrierPartTest {

	private LeftBarrierPart lbp;

	@Before
	public void setup() {
		lbp = new LeftBarrierPart(10, 10);
	}

	/**
	 * Tests LeftBarrierPart construction by checking that it isn't null
	 */
	@Test
	public void LBPConstruction() {
		assertNotNull(lbp);
	}
}
