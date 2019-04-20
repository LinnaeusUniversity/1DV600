package hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
@SuppressWarnings("static-access")
class ShowResult_Test {

	GameLevel game = new GameLevel();
	
	
	@Test
	void testShowResult_Success() {
		assertEquals(true, game.showResult(2));
	}
	
	@Test
	void testShowResult_Failed() {
		assertEquals(false, game.showResult(-4));
	}

}
