package projects.elevens;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		final Card card = new Card("big", "man", 5);
		System.out.println("matches itself? " + (card.matches(new Card("asd", "man", 5))));
		System.out.println("suit: " + card.getSuit());
		System.out.println("rank: " + card.getRank());
		System.out.println("value: " + card.getPointValue());
		System.out.println(card);
	}
}
