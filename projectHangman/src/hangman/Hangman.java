package hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
	GameLevel level;
	public Hangman() {

	}

	public int life = 7;

	public String secretWord = "";
	public String hiddenWord = "";
	Scanner scan = new Scanner(System.in);
	public boolean menu = true;

	public boolean validInput;

	public boolean entered;


	public boolean askForRestart() {
		int number;

		boolean restart;
		System.out.println(
				"\n\n----------------------------\nNew player?\nPress 1: restarts the game.\n----------------------------"
				+ "\nPress any  positive integer to quit the game session and\nto see the highScore board.");
		do {
			number = scan.nextInt();

		} while (restart = !validInputToQuit(number));
		if (number > 1)
			
			restart = true;
		if (restart == true) {
			System.out.println("Thank you and Goodbye ");
			System.out.println( GameLevel.count + " secret words have/has been revealed");
			
			System.out.println("Total number of game played is/are: "+GameLevel.numberOfGamePlayed);
			System.out.println("Player names|\t   |Win/lose\t|scores\n-----------------------------------");
			GameLevel.showResult(number);

			System.exit(0);
		}
		this.menu = false;

		return !restart;

	}

	public boolean validInputToQuit(int number) {
		while (number < 0) {
			System.err.println("provide positive integer");
			return false;
		}
		if (number == 1) {
			secretWord = "";
			hiddenWord = "";
			return true;

		}

		return true;
	}

	public void replaceChar(char str, int pos) {
		StringBuilder sb = new StringBuilder(this.hiddenWord);
		sb.setCharAt(pos, str);
		this.hiddenWord = sb.toString();
	}

	public void quitGame() {
		
		System.out.println("You quit the Game\nGoodbye!");
		

		
		System.exit(0);
	}

	public void randomWord() {
		System.out.println("\nSelect a category\n\n3: Name of the countries\n4: Car brands \n5: Quit");
		do {
			int category = scan.nextInt();

			switch (category) {
			case 3:
				String[] nameOfTheCountries = { "afghanistan", "england","norway","sweden","iran", "georgia","Holland", "germany", "greece", "india","Canada",	"tajikistan" };
				Random rand = new Random();
				int index = rand.nextInt(nameOfTheCountries.length);
				this.secretWord = nameOfTheCountries[index];

				for (int i = 0; i < this.secretWord.length(); i++) {
					this.hiddenWord += "-";
				}
				validInput = false;
				break;
			case 4:
				String[] carBrands = { "toyota", "volvo", "ford", "mitsubishi", "nissan", "bmw", "bugatti" + "ballot","audi" };
				Random rand1 = new Random();
				int index1 = rand1.nextInt(carBrands.length);
				this.secretWord = carBrands[index1];

				for (int i = 0; i < this.secretWord.length(); i++) {
					this.hiddenWord += "-";
				}
				validInput = false;
				break;
			case 5:
				quitGame();
				break;
			default:
				System.out.println(
						"Wrong entery.\nPlease enter again!\nSelect a category\n\n3: Name of the countries\n4: Car brands \n5: Quit\"");
				validInput = true;

			}
			
		} while (validInput);

	}

	public boolean play() {
		return this.menu;
	}

	public int gameMenu() {
		System.out.println("To contintue please Select a number:\n-----------\n" + "| 1: |Play Easy|\n"
				+ "| 2: |Play Hard|\n" + "| 3: |Quit |"+"\n-----------");
		System.out.print("Select a number: ");
		return scan.nextInt();
	}


	
	

}