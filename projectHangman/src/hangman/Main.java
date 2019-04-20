package hangman;

public class Main {

	private static boolean restart;
	static GameLevel level;
	GameLevel l;
	public static void main(String[] args) {
		
		do {

			Hangman hangman = new Hangman();
			hangman = new Hangman();
			while (hangman.play()) {
				UserName user = new UserName();
				user.enterName();
				GameLevel.setUser(user);
				GameLevel gameLevel = new GameLevel();
				
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
			
				default:
					System.out.println("Incorrect number\n");
					break;
				}
			}
			

		} while (restart);
		
	}

}
