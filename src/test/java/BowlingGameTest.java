import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("JUnit5 - Test lifecycle adjustments")
class BowlingGameTest {
	private Game g;
		
	@BeforeEach
	void beforeAll() {
		g = new Game();
		System.out.println("Non static before beforeEach.");
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
		System.out.println("Check score:" + g.score());
		rollMany(20, 1);
		assertEquals(20, g.score());
	}

	@Test
	void testOneSpare() {
		rollSpare();
		g.roll(3);
		rollMany(17, 0);
		assertEquals(16, g.score());
	}
	
	private void rollSpare(){
		g.roll(5);
		g.roll(5);
	}

}
