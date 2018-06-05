package projects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import utils.ReaderUtils;

import static java.lang.System.out;

public class Shorthand {
	
	private Shorthand() {
		final List<String> removals = Arrays.asList("a", "e", "i", "o", "u");
		final Map<String, String> replacements = new HashMap<>();
		replacements.put("and", "&");
		replacements.put("to", "2");
		replacements.put("you", "U");
		replacements.put("for", "4");
		
		final Scanner scanner = new Scanner(System.in);
		while(true) {
			final String input = ReaderUtils.readFromUser(scanner, "Enter a sentence.");
			if(input.equalsIgnoreCase("q")) break;
			
			final String[] parts = input.toLowerCase().split(" ");
			final StringBuilder sb = new StringBuilder();
			for(String part : parts) {
				String newValue = part;
				if(replacements.containsKey(part)) newValue = replacements.get(part);
				else for(String removal : removals)
					if(newValue.contains(removal)) newValue = newValue.replace(removal, "");
				sb.append(newValue);
				sb.append(" ");
			}
			out.println("Shorthand: " + sb.toString().trim());
		}
		out.println("Goodbye.");
		scanner.close();
	}
	
	public static void main(String[] args) {
		new Shorthand();
	}
	
}
