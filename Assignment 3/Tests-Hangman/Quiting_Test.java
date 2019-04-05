package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Quiting_Test {
	Hangman hangman = new Hangman();
	@Test
	void testvalidInputToQuit_Valid() {		
		// Quit the game while you input a positive number other than number 1
		assertEquals(true, hangman.validInputToQuit(2));
		assertEquals(true, hangman.validInputToQuit(10));
		assertEquals(true, hangman.validInputToQuit(400));

	}
	
	@Test
	void testvalidInputToQuit_NotValid() {
		assertEquals(false, hangman.validInputToQuit(-2));
		assertEquals(false, hangman.validInputToQuit(-5));
		assertEquals(false, hangman.validInputToQuit(-20));

	}

}
