package projects.magpie;

/**
 * A program to carry on conversations with a human user. This version:
 * <ul>
 * <li>
 * Uses advanced search for keywords</li>
 * <li>
 * Will transform statements as well as react to keywords</li>
 * </ul>
 * 
 * @author Laurie White
 * @version April 2012
 *
 */
public class Magpie {
	/**
	 * Get a default greeting
	 * 
	 * @return a greeting
	 */
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement) {
		String response = "";

		final int youIndex = findKeyword(statement, "you", 0);
		final int iIndex = findKeyword(statement, "I", 0);

		if (statement.length() == 0) {
			response = "Say something, please.";
		} else if (findKeyword(statement, "no") >= 0) {
			response = "Why so negative?";
		} else if (findKeyword(statement, "mother") >= 0 ||
				findKeyword(statement, "father") >= 0 ||
				findKeyword(statement, "sister") >= 0 ||
				findKeyword(statement, "brother") >= 0) {
			response = "Tell me more about your family.";
		} else if(findKeyword(statement, "cat") >= 0 ||
				findKeyword(statement, "dog") >= 0) {
			response = "Tell me more about your pets!";
		} else if(findKeyword(statement, "running") >= 0 ||
				findKeyword(statement, "jogging") >= 0 ||
				findKeyword(statement, "sports") >= 0) {
			response = "Why do you excersize?";
		} else if(findKeyword(statement, "baby") >= 0) {
			response = "Babies are so cute!";
		} else if (youIndex >= 0 && findKeyword(statement, "me", youIndex) >= 0) {
			response = handleYouMe(statement);
		} else if (iIndex >= 0 && findKeyword(statement, "you", iIndex) >= 0) {
			response = handleIYou(statement);
		} else if (findKeyword(statement, "I want to", 0) >= 0) {
			response = handleIWantToStatement(statement);
		} else if (findKeyword(statement, "I want", 0) >= 0) {
			response = handleIWant(statement);
		} else {
			response = getRandomResponse();
		}

		return response;
	}

	private String handleIWantToStatement(String statement) {
		statement = prepare(statement);
		final int index = findKeyword(statement, "I want to", 0);
		return "What would it mean to " + statement.substring(index + 9) + "?";
	}

	private String handleIWant(String statement) {
		statement = prepare(statement);
		final int index = findKeyword(statement, "I want", 0);
		return "Would you really be happy if you had " + statement.substring(index + 6) + "?";
	}

	private String handleYouMe(String statement) {
		statement = prepare(statement);
		final int youIndex = findKeyword(statement, "you", 0);
		final int meIndex = findKeyword(statement, "me", youIndex + 3);
		return "What makes you think that I " + statement.substring(youIndex + 3, meIndex) + " you?";
	}

	private String handleIYou(String statement) {
		statement = prepare(statement);
		final int iIndex = findKeyword(statement, "I", 0);
		final int youIndex = findKeyword(statement, "you", iIndex + 1);
		return "Why do you " + statement.substring(iIndex + 1, youIndex) + " me?";
	}
	
	private String prepare(String pre) {
		String ret = pre.trim();
		final String lastChar = pre.substring(pre.length() - 1);
		if (lastChar.equals(".") || lastChar.equals("!"))
			ret = ret.substring(0, ret.length() - 1);
		return ret;
	}

	private int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim();
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		while (psn >= 0) {
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}

			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
					&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
				return psn;
			}

			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
		}

		return -1;
	}

	private int findKeyword(String statement, String goal) {
		return findKeyword(statement, goal, 0);
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * 
	 * @return a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 7;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";
		
		switch(whichResponse) {
			case 0:
				response = "Interesting, tell me more.";
				break;
			case 1:
				response = "Hmmm.";
				break;
			case 2:
				response = "Do you really think so?";
				break;
			case 3:
				response = "You don't say.";
				break;
			case 4:
				response = "Why?";
				break;
			case 5:
				response = "That's interesting.";
				break;
			case 6:
				response = "And?";
				break;
		}

		return response;
	}

}