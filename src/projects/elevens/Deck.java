package projects.elevens;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	
	private final List<Card> cards = new ArrayList<>();
	private int dealIndex;

	public Deck(String[] ranks, String[] suits, int[] values) {
		for(int i=0; i < ranks.length; i++) {
			final String rank = ranks[i];
			final int pointValue = values[i];
			for(String suit : suits) cards.add(new Card(rank, suit, pointValue));
		}
		shuffle();
	}
	
	public Card deal() {
		if(dealIndex == -1) return null;
		else return cards.get(dealIndex--);
	}
	
	public void shuffle() {
		for(int i=cards.size()-1; i > 0; i--) {
			final Card current = cards.get(i);
			final int index = (int) (Math.random() * i);
			cards.set(i, cards.get(index));
			cards.set(index, current);
		}
		dealIndex = cards.size() - 1;
	}
	
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	
	public int size() {
		return cards.size();
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Cards: \n");
		cards.forEach((card) -> {
			sb.append(card);
			sb.append("\n");
		});
		return sb.toString();
	}
	
}
