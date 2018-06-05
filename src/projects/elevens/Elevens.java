package projects.elevens;

import static java.lang.System.out;

public class Elevens {

	private Elevens() {
		final String[] ranks = new String[] { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king" };
		final String[] suits = new String[] { "spades", "hearts", "diamonds", "clubs" };
		final int[] pointValues = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0 };
		final Deck deck = new Deck(ranks, suits, pointValues);
		out.println(deck);
	}

	public static void main(String[] args) {
		new Elevens();
	}

}
