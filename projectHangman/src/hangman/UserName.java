package hangman;

import java.util.Scanner;

public class UserName {
	
	
	public String name="";
	public String score;
	public int highScore;
	
	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void enterName() {
		Scanner scan = new Scanner(System.in);
//		String name;
		do {
			System.out.println("Enter a name to continue: (only English letters or integers)");
			this.name = scan.nextLine();

		} while (!enterValidName(name));
		setName(name);
	}

	public boolean enterValidName(String name) {
		if (!name.matches("[a-zA-Z0-9]+")) {
			System.err.println("English Letters Or positive integers!");
			
			return false;
		} else {
			System.out.println(name + "! Welcome to the Hangman game");
			return true;
		}

	}

}
