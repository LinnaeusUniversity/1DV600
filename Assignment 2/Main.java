package game;

public class Main {

	private static boolean restart;

	public static void main(String[] args) {
		UserName user = new UserName();
		user.enterName();
		GameLevel gameLevel = new GameLevel();
		Hangman hangman = new Hangman();

		do {
			hangman = new Hangman();
			while (hangman.play()) {
				int input = hangman.gameMenu();

				switch (input) {
				case 1:
					restart = gameLevel.playGameEasy();
					break;
				case 2:
					restart = gameLevel.playGameHard();
					break;
				case 3:
					hangman.quitGame();
					System.out.println("You revealed " + GameLevel.count + " secret words");

					break;

				default:
					System.out.println("Incorrect number\n");
					break;
				}
			}
			

		} while (restart);
		
	
		
	}

}
