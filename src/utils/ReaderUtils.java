package utils;

import java.util.Scanner;
import java.util.function.Function;

public class ReaderUtils {
	
	public static String readFromUser(Scanner scanner, String prompt) {
		return readFromUser(scanner, prompt, (s) -> {
			return s;
		});
	}
	
	public static <T> T readFromUser(Scanner scanner, String prompt, Function<String, T> converter) {
		if(prompt != null) System.out.println(prompt);
		System.out.print("> ");
		try {
			return converter.apply(scanner.nextLine());
		} catch (Exception ex) {
			String message = "Invalid Input";
			if(ex.getClass().isAssignableFrom(InvalidInput.class)) {
				final String invalidMessage = ex.getMessage();
				if(!invalidMessage.equals("")) message = invalidMessage;
			}
			System.out.println(message);
			
			return readFromUser(scanner, null, converter);
		}
	}
	
	public static class InvalidInput extends RuntimeException {
		
		public InvalidInput() {
			this("");
		}
		
		public InvalidInput(String message) {
			super(message);
		}
		
	}

}
