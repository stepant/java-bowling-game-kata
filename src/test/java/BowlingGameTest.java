import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("JUnit5 - Test lifecycle adjustments")
class BowlingGameTest {
	private Game g;
		
	@BeforeAll
	void beforeAll() {
		g = new Game();
		System.out.println("Non static before all.");
	}
	
	private void rollMany(int n, int pins) {
		for(int i = 0; i < n; i++) {
			g.roll(pins);
		}
	}
	
	@Test
	void testGutterGame() {		
		rollMany(20, 0);
		assertEquals(0, g.score());
	}
	
	
	@Test
	void testAllOnes() {
		rollMany(20, 1);
		assertEquals(20, g.score());
	}

}
