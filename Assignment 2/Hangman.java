package game;

import java.util.*;

public class Hangman {

	public Hangman() {

	}

	public int life = 7;

	public String secretWord = "";
	public String hiddenWord = "";
	Scanner scan = new Scanner(System.in);
	public boolean menu = true;

	public boolean validInput;

	public boolean entered;
	public String name = "";

	public boolean askForRestart() {
		int number;

		boolean restart;
		System.out.println(
				"\n\nDo you want to play again?\nPress 1: restarts the game.\nPress any positive integer to quit the game.");
		do {
			number = scan.nextInt();

		} while (restart = !validInputToQuit(number));
		if (number > 1)
			
			restart = true;
		if (restart == true) {
			System.out.println("Thank you and Goodbye ");
			System.out.println("You revealed " + GameLevel.count + " secret words");
			
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
				String[] nameOfTheCountries = { "afghanistan", "sweden", "georgia", "germany", "greece", "india",
						"tajikistan" };
				Random rand = new Random();
				int index = rand.nextInt(nameOfTheCountries.length);
				this.secretWord = nameOfTheCountries[index];

				for (int i = 0; i < this.secretWord.length(); i++) {
					this.hiddenWord += "-";
				}
				validInput = false;
				break;
			case 4:
				String[] carBrands = { "toyota", "volvo", "ford", "mitsubishi", "Nissan", "bmw", "bugatti" + "ballot",
						"audi" };
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
				+ "| 2: |Play Hard|\n" + "| 3: |Quit |\n" + "-----------");
		System.out.print("Select a number: ");
		return scan.nextInt();
	}

}