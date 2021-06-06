package invadem;

import org.junit.*;
import static org.junit.Assert.*;

public class SolidBarrierPartTest {

	private SolidBarrierPart sbp;

	@Before
	public void setup() {
		sbp = new SolidBarrierPart(10, 10);
	}

	/**
	 * Tests SolidBarrierPart construction by checking that it isn't null
	 */
	@Test
	public void SBPConstruction() {
		assertNotNull(sbp);
	}
}
