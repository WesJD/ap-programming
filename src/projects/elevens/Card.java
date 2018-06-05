package projects.elevens;

public class Card {
	
	private final String rank;
	private final String suit;
	private final int pointValue;
	
	public Card(String rank, String suit, int pointValue) {
		this.rank = rank;
		this.suit = suit;
		this.pointValue = pointValue;
	}
	
	public String getRank() {
		return rank;
	}
	public String getSuit() {
		return suit;
	}
	public int getPointValue() {
		return pointValue;
	}
	
	public boolean matches(Card otherCard) {
		return otherCard.getRank().equals(rank)
				&& otherCard.getSuit().equals(suit)
				&& otherCard.getPointValue() == pointValue;
	}
	
	@Override
	public String toString() {
		return rank + " of " + suit + " (" + pointValue + " = pointValue)";
	}

}
