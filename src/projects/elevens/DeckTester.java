package projects.elevens;

public class DeckTester {

	public static void main(String[] args) {
		String[] ranks2 = new String[52];
		String[] suits2 = new String[52];
		int[] pointValues2 = new int[52];
		for (int i = 0; i < 52; i++) {
			String rank = "";
			String suit = "";
			if ((i + 1) % 13 == 11) {
				rank = "Jack";
			} else if ((i + 1) % 13 == 12) {
				rank = "Queen";
			} else if ((i + 1) % 13 == 0) {
				rank = "King";
			} else if ((i + 1) % 13 == 1) {
				rank = "Ace";
			} else {
				rank = Integer.toString((i + 1) % 13);
			}

			if (i < 13) {
				suit = "Hearts";
			} else if (i < 26) {
				suit = "Diamonds";
			} else if (i < 39) {
				suit = "Clubs";
			} else {
				suit = "Spades";
			}

			ranks2[i] = rank;
			suits2[i] = suit;
			pointValues2[i] = ((i + 1) % 13);
		}

		Deck e = new Deck(ranks2, suits2, pointValues2);
		System.out.println(e);
	}

}
