package game;

import java.util.Scanner;

public class UserName {
	public void enterName() {
		Scanner scan = new Scanner(System.in);
		String name;
		do {
			System.out.println("Enter a name to continue: (only English letters or integers)");
			name = scan.nextLine();

		} while (!enterValidName(name));
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
