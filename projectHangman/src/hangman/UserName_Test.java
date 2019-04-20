package hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserName_Test {

	UserName hangman = new UserName();

	@Test
	void testEnterValidName_Valid() {
		assertEquals(true, hangman.enterValidName("Rashid"));
//		assertEquals(true, hangman.enterValidName("Topias"));
//		assertEquals(true, hangman.enterValidName("John"));
//		assertEquals(true, hangman.enterValidName("Bond007"));


	}
	
	@Test
	void testEnterValidName_NotValid() {
		assertEquals(false, hangman.enterValidName("+/*!%/&"));
//		assertEquals(false, hangman.enterValidName(" "));
//		assertEquals(false, hangman.enterValidName("-Ahmad"));

	}

}
