package game;

import java.util.*;

public class Hangman {


	public Hangman() {

	}

	public void enterName() {
		Scanner scan = new Scanner(System.in);
		String name;
		do {
			System.out.println("\nEnter a name: (only English letters or integers)");
			name= scan.nextLine();
		}while(!enterValidName(name));

	}

	public boolean enterValidName(String name) {
		if (!name.matches("[a-zA-Z0-9]+")){
			System.err.println("English Letters Or positive integers!");
			return false;
		}
		else {
			System.out.println(name+"! Welcome to the Hangman game");
			return true;
		}

	}
	private int life = 7;

	private String secretWord = "";
	private String hiddenWord = "";
	Scanner scan = new Scanner(System.in);
	private boolean menu = true;

	private boolean validInput;

	private boolean entered;
	public String name="";
	public boolean playGame() {

		randomWord();
		char charGuess = ' ';

		System.out.println("\nAlright! lets begin \nYou have "+life+" guesses to find the secret word");


		while (this.life > 0) {


			System.out.println("Type your guess amongst: "+hiddenWord.length() + " characters" + "\n" + hiddenWord);
			charGuess = scan.next().charAt(0);
			boolean correct = false;

			for (int i = 0; i < this.secretWord.length(); i++) {
				if (charGuess == this.secretWord.charAt(i)) {
					correct = true;

				}

			}




			// ****************************

			for (int i = 0; i < this.hiddenWord.length(); i++) {
				if (charGuess == hiddenWord.charAt(i))
					entered = true;

			}
			if (entered) {
				System.out.println("Already entered\n");
				entered = false;
			}

			// *****************************

			if (correct == true) {
				int position = this.secretWord.indexOf(charGuess);
				while (position >= 0) {

					replaceChar(charGuess, position);
					position = this.secretWord.indexOf(charGuess, position + 1);

				}

				System.out.println("\nCorrect Guesses!");
			}

			else if (correct == false) {
				//countCharacters++;
				System.err
				.println("Sorry, the letter is not in the secret word." + "\nWrong character! Try again!\"  ");
				life--;
				// *****

				if (life == 5) {
					System.out.println();
					System.out.println("==============="
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |");
				} else if (life == 3) {
					System.out.println();
					System.out.println("==============="
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |"
							+"\n||         / \\"
							+"\n||          "
							+"\n||         "
							+"\n||"
							+"\n||____"
							+"\n|_____]");
					System.out.println("\nThe man died\n");





				} else if (life == 0) {
					System.out.println();
					System.out.println("==============="
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |"
							+"\n||         / \\"
							+"\n||          |"
							+"\n||         / \\"
							+"\n||"
							+"\n||____"
							+"\n|_____]");



				}

				// **

			}

			System.out.println("You have " + life + " tries left\n");



			if (this.life == 0) {
				System.out.println("Out of tries!");
				System.out.println("The letter "+"\"" + secretWord +"\"" + " was the secret word");

			} else if (this.hiddenWord.contains("-") == false) {
				System.out.println(secretWord+"!!!! \nYou won!\nYou saved a man!!");
				break;


			}

		}
		this.life = 7;
		this.menu = true;
		return askForRestart();
	}

	private boolean askForRestart() {
		int number;
		boolean restart;
		System.out.println(
				"\n\nDo you want to play again?\nPress 1: restarts the game.\nPress any positive integer to quit the game.");
		do {
			number = scan.nextInt();

		}while(restart = !validInputToQuit(number));
		if(number>1)
			restart = true;
		this.menu = false;
		return !restart;		
	}

	public boolean validInputToQuit(int number) {
		while(number<0) {
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
				String[] nameOfTheCountries = { "Afghanistan", "sweden","georgia"
						+ "germany" ,"greece","india","tajikistan"};
				Random rand = new Random();
				int index = rand.nextInt(nameOfTheCountries.length);
				this.secretWord = nameOfTheCountries[index];

				for (int i = 0; i < this.secretWord.length(); i++) {
					this.hiddenWord += "-";
				}
				validInput = false;
				break;
			case 4:
				String[] carBrands = { "toyota", "volvo","ford","mitsubishi","Nissan","bmw","bugatti"
						+ "ballot","audi" };
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
		System.out.println("To contintue please Select a number:\n-----------\n" + "| 1: |Play |\n" + "| 2: |Quit |\n" + "-----------");
		System.out.print("Select a number: ");
		return scan.nextInt();
	}

}