package projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import utils.ReaderUtils;
import static java.lang.System.out;

public class Hangman {
	
	private final Random RANDOM = new Random();
	
	private char[] chars;
	private Character[] displayValues;
	private String choice;

	private Hangman() {
		final List<String> choices = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("words.txt"))) {
			while (scanner.hasNextLine())
				choices.add(scanner.nextLine());
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		int wins = 0;
		int losses = 0;

		try (Scanner scanner = new Scanner(System.in)) {
			do {
				choice(choices);
				out.println("choice was " + choice);

				chars = choice.toCharArray();
				displayValues = new Character[choice.split("").length];
				Arrays.fill(displayValues, '_');
				
				final List<Character> usedLetters = new ArrayList<>();
				final List<Character> incorrectLetters = new ArrayList<>();

				out.println();
				out.println("WELCOME TO HANGMAN!");
				out.println("Your goal is to guess:");
				display(displayValues);

				int chances = displayValues.length;
				
				boolean hasAnyLeft;
				while (hasAnyLeft =  Arrays.stream(displayValues).anyMatch(val -> val == '_')) {                                                              convert("");
					final char selection = ReaderUtils.readFromUser(scanner,
							"Enter a letter guess", (fromUser) -> {
								final String input = fromUser.trim();
								if (input.length() > 1)
									throw new ReaderUtils.InvalidInput(
											"Input must be a letter");
								else
									return input.charAt(0);
							});
					
					if(usedLetters.contains(selection)) out.println("You have already used this letter!");
					else {		
						final int uses = play(choice, selection);
						if (uses == 0) {
							incorrectLetters.add(selection);
							if (--chances == 0) break;
							else out.println("Incorrect guess!");
						} else out.println("Correct guess! Word has " + uses + " " + selection + "'s");
					}
					
					usedLetters.add(selection);
					display(displayValues);
					
					out.print("Incorrect letters: ");
					if(incorrectLetters.size() > 0) {
						incorrectLetters.stream().forEach(val -> out.print(val + " "));
						out.println();
					}
					else out.println("None");
					
					out.println("You have " + chances + " chances left!");
					out.println();
				}

				if(!hasAnyLeft) {
					out.println("You have won!");
					wins++;
				} else {
					out.println("You have lost!");
					losses++;
				}
				out.println();
			} while (ReaderUtils.readFromUser(scanner,
					"Do you want to play again? (y/n)", (input) -> {
						if (input.equalsIgnoreCase("y")) return true;
						else if (input.equalsIgnoreCase("n")) return false;
						else throw new ReaderUtils.InvalidInput("Must be y or n.");
					}));
		}
		
		out.println();
		out.println("Thanks for playing!");
		out.println("You played " + (wins + losses) + " games, with " + wins + " wins and " + losses + " losses.");
	}
	
	private int play(String current, char letter) {
		int uses = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (letter == c) {	
				displayValues[i] = c;
				uses++;
			}
		}
		return uses;
	}
	
	private String convert(String input) {
		return input.replaceAll("\b", "_");
	}
	
	private void choice(List<String> choices) {
		choice = choices.get(RANDOM.nextInt(choices.size()));
	}

	private void display(Character[] values) {
		Arrays.stream(values).forEach(val -> out.print(val + " "));
		out.println();
	}

	public static void main(String[] args) {
		new Hangman();
	}

}
