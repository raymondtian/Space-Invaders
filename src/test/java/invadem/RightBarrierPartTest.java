package invadem;

import org.junit.*;
import static org.junit.Assert.*;

public class RightBarrierPartTest {

	private RightBarrierPart rbp;

	@Before
	public void setup() {
		rbp = new RightBarrierPart(10, 10);
	}

	/**
	 * Tests RightBarrierPart construction by checking that it isn't null
	 */
	@Test
	public void RBPConstruction() {
		assertNotNull(rbp);
	}
}
