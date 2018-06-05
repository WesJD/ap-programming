package projects;

import java.util.Scanner;

import utils.ReaderUtils;
import static java.lang.System.out;

public class PigLatin {
	
	private PigLatin() {
		try(Scanner scanner = new Scanner(System.in)) {
			while(true) {
				final String input = ReaderUtils.readFromUser(scanner, "Enter a message to translate");
				if(input.equalsIgnoreCase("q")) break;
				
				final StringBuilder sb = new StringBuilder();
				for(String part : input.split(" ")) {
					String startingPuncuation = "";
					String endingPunctuation = "";
					final char[] chars = part.toCharArray();
					for(int i=0; i < chars.length; i++) {
						final char current = chars[i];
						final char next = (i + 1 == chars.length) ? Character.MIN_VALUE : chars[i + 1];
						if(startingPuncuation.isEmpty() && isPunctuation(current) && !isPunctuation(next)) {
							startingPuncuation = part.substring(0, i + 1);
						} else if(!isPunctuation(current) && isPunctuation(next)) {
							endingPunctuation = part.substring(i + 1);
							break;
						}
					}
					
					final int startingLength = startingPuncuation.length();
					final int endingLength = endingPunctuation.length();
					final String content = part.substring(startingLength, part.length() - endingLength);
					final String lower = content.toLowerCase();
					out.println("content is " + content);
					
					final boolean checkingY = content.charAt(0) != 'y';
					final char[] contentChars = lower.toCharArray();
					int firstVowel = -1;
					for(int i=0; i < contentChars.length; i++) {
						final char c = contentChars[i];
						if((checkingY && c == 'y') ||
								c == 'a' || 
								c == 'e' || 
								c == 'i' || 
								c == 'o' || 
								c == 'u') {
							firstVowel = i;
							break;
						}
					}
					
					if(firstVowel == -1) sb.append("INVALID");
					else {
						int index = firstVowel;
						if(lower.charAt(index) == 'u' && lower.charAt(index - 1) == 'q') index++;
						
						String beginning = lower.substring(index);
						if(Character.isUpperCase(content.charAt(0))) 
							beginning = Character.toUpperCase(beginning.charAt(0)) + beginning.substring(1);
						
						if(startingPuncuation != null) sb.append(startingPuncuation);
						sb.append(beginning);
						sb.append(lower.substring(0, index));
						sb.append(firstVowel == 0 ? "way" : "ay");
						if(endingPunctuation != null) sb.append(endingPunctuation);
					}
					sb.append(" ");
				}
				
				out.println("Pig latin: " + sb.toString().trim());
			}
			out.println("Goodbye.");
		}
	}
	
	private boolean isPunctuation(char c) {
		switch(c) {
			case '!':
			case '"':
			case '.':
			case '?':
				return true;
			default:
				return false;
		}
	}

	public static void main(String[] args) {
		new PigLatin();
	}
	
}
