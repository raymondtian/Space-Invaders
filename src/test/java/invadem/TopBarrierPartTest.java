package invadem;

import org.junit.*;
import static org.junit.Assert.*;

public class TopBarrierPartTest {

	private TopBarrierPart tbp;

	@Before
	public void setup() {
		tbp = new TopBarrierPart(10, 10);
	}

	/**
	 * Tests TopBarrierPart construction by checking that it isn't null
	 */
	@Test
	public void TBPConstruction() {
		assertNotNull(tbp);
	}
}
