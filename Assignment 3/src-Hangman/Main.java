package game;

public class Main {

	private static boolean restart;
	public static void main(String[] args) {
	
		//alreday exist
		//restart
	
		Hangman hangman = new Hangman();
		hangman.enterName();

		do {
			hangman = new Hangman();
//			
			while(hangman.play()) {
				int input = hangman.gameMenu();

				switch(input) {
				case 1:restart = hangman.playGame(); 
				break;

				case 2: hangman.quitGame(); 
				break;

				default: System.out.println("Incorrect number\n"); 
				break;
				}
			}
			
			System.out.println("Thank you and GoodBye");
		}while(restart);
	}

}
