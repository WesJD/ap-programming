package projects;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

import static java.lang.System.out;

public class RockPaperScissors {
	
	private final Scanner SCANNER = new Scanner(System.in);
	private final Comparator<PlayType> COMPARATOR = new Comparator<PlayType>() {
		@Override
		public int compare(PlayType o1, PlayType o2) {
			switch(o1) {
				case ROCK:
					switch(o2) {
						case PAPER:
							return -1;
						case SCISSORS:
							return 1;
						default:
							return 0;
					}
				case PAPER:
					switch(o2) {
						case SCISSORS:
							return -1;
						case ROCK:
							return 1;
						default:
							return 0;
					}
				case SCISSORS:
					switch(o2) {
						case ROCK:
							return -1;
						case PAPER:
							return 1;
						default:
							return 0;
					}
			}
			return 0;
		}
	};
	
	private RockPaperScissors() {
		do {
			final int games = requestTypeSafely("Best of how many? Must be an odd number!", this::parseGames);
			int playerWins = 0;
			int computerWins = 0;
			for(int i=1; i<=games; i++) {
				out.println("-----[ ROUND " + i + " ]-----");
				int result = 0;
				while(result == 0) {
					final PlayType play = requestTypeSafely("What play do you want to make? " 
							+ Arrays.toString(PlayType.values()), (input) -> PlayType.valueOf(input.toUpperCase()));
					final PlayType computer = PlayType.values()[ThreadLocalRandom.current()
					                                            .nextInt(PlayType.values().length)];
					result = COMPARATOR.compare(play, computer);
					out.println("The computer plays " + computer + "!");
				}
				switch(result) {
					case -1:
						out.println("You lose!");
						computerWins++;
						break;
					case 1:
						out.println("You win!");
						playerWins++;
						break;
				}
			}
			out.println("---------------------");
			out.println("The computer had " + computerWins + " wins.");
			out.println("You had " + playerWins + " wins.");
			out.println("Overall, " + (computerWins > playerWins ? "the computer wins" : "you win") + ".");
		} while(requestTypeSafely("Do you want to play again? (y/n)", (input) -> {
			if(input.equalsIgnoreCase("y")) {
				out.println("---------------------");
				return true;
			} else if(input.equalsIgnoreCase("n")) return false;
			else throw new RuntimeException("Not a valid input.");
		}));
		out.println("Goodbye.");
		System.exit(0);
	}
	
	private int parseGames(String input) {
		final int parsed = Integer.parseInt(input);
		if(parsed % 2 == 0) throw new RuntimeException("The number must be odd!");
		return parsed;
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion) {
		return requestTypeSafely(prompt, conversion, false);
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion, boolean wasInvalid) {
		try {
			out.println(prompt);
			out.print("> ");
			return conversion.apply(SCANNER.nextLine());
		} catch (Exception ex) {
			return requestTypeSafely((wasInvalid ? "" : "Invalid answer. ") + prompt, conversion, true);
		}
	}
	
	private enum PlayType {		
		ROCK, SCISSORS, PAPER
	}
	
	public static void main(String[] args) {
		new RockPaperScissors();
	}

}