package game;

public class GameLevel extends Hangman {
	
	public static int count = 0;

	public boolean playGameHard() {
		this.life = 5;

		randomWord();
		char charGuess = ' ';

		System.out.println("\nAlright! lets begin\n(Press '*' to stop guessing the word at any stage \nYou have " + life
				+ " guesses to find the secret word");

		while (this.life > 0) {
			System.out.println("Type your guess amongst: " + hiddenWord.length() + " characters" + "\n" + hiddenWord);
			charGuess = scan.next().charAt(0);
			boolean correct = false;

			for (int i = 0; i < this.secretWord.length(); i++) {
				if (charGuess == this.secretWord.charAt(i)) {
					correct = true;

				} else if (charGuess == this.secretWord.charAt(i) || charGuess == '*' ) {
					System.out.println("You stopped guessing.");
					return askForRestart();
				}

			}

			for (int i = 0; i < this.hiddenWord.length(); i++) {
				if (charGuess == hiddenWord.charAt(i))
					entered = true;

			}
			if (entered) {
				System.out.println("Already entered\n");
				entered = false;
			}

			if (correct == true) {
				int position = this.secretWord.indexOf(charGuess);
				while (position >= 0) {

					replaceChar(charGuess, position);
					position = this.secretWord.indexOf(charGuess, position + 1);
				}

				System.out.println("\nCorrect Guesses!");
			}

			else if (correct == false) {
				System.err
				.println("Sorry, the letter is not in the secret word." + "\nWrong character! Try again!\"  ");
				life--;

				if (life == 3) {
					System.out.println();
					System.out.println("==============="
							+"\n||          |"
							+"\n||          |"
							+"\n||          |"
							+"\n||         (_)"
							+"\n||          |");
				} else if (life == 2) {
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

					System.out.println("\nThe man died\n");

				}

			}

			System.out.println("You have " + life + " tries left\n");

			if (this.life == 0) {
				System.out.println("Out of tries!");
				System.out.println("The letter " + "\"" + secretWord + "\"" + " was the secret word");

			} else if (this.hiddenWord.contains("-") == false) {
				System.out.println(secretWord + "!!!! \nYou won!\nYou saved a man!!");
				count++;
				break;

			}

		}
		this.life = 5;
		this.menu = true;
		return askForRestart();
	}

	public boolean playGameEasy() {

		randomWord();
		char charGuess = ' ';

		System.out.println("\nAlright! lets begin\n(Press '*' to stop guessing the word at any stage \nYou have " + life
				+ " guesses to find the secret word");

		while (this.life > 0) {

			System.out.println("Type your guess amongst: " + hiddenWord.length() + " characters" + "\n" + hiddenWord);
			charGuess = scan.next().charAt(0);
			boolean correct = false;

			for (int i = 0; i < this.secretWord.length(); i++) {
				if (charGuess == this.secretWord.charAt(i)) {
					correct = true;

				} else if (charGuess == this.secretWord.charAt(i) || charGuess == '*') {
					System.out.println("You stopped guessing.");
					return askForRestart();
//					this.menu = true;

				}

			}

			for (int i = 0; i < this.hiddenWord.length(); i++) {
				if (charGuess == hiddenWord.charAt(i))
					entered = true;

			}
			if (entered) {
				System.out.println("Already entered\n");
				entered = false;
			}

			if (correct == true) {
				int position = this.secretWord.indexOf(charGuess);
				while (position >= 0) {

					replaceChar(charGuess, position);
					position = this.secretWord.indexOf(charGuess, position + 1);

				}

				System.out.println("\nCorrect Guesses!");
			}

			else if (correct == false) {
				// countCharacters++;
				System.err
						.println("Sorry, the letter is not in the secret word." + "\nWrong character! Try again!\"  ");
				life--;

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
					System.out.println("\nThe man died\n");


				}

			}

			System.out.println("You have " + life + " tries left\n");

			if (this.life == 0) {
				System.out.println("Out of tries!");
				System.out.println("The letter " + "\"" + secretWord + "\"" + " was the secret word");

			} else if (this.hiddenWord.contains("-") == false) {
				System.out.println(secretWord + "!!!! \nYou won!\nYou saved a man!!");
				count++;
				break;

			}

		}
		this.life = 7;
		this.menu = true;
		return askForRestart();
	}

}