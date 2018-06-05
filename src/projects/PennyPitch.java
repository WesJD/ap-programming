package projects;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import utils.RandomComparator;
import utils.TwoDArrayUtils;
import static java.lang.System.out;

public class PennyPitch {
	
	private PennyPitch() {
		final Hole[][] board = new Hole[5][5];
		for(int i=0; i < board.length; i++) {
			for(int j=0; j < board[i].length; j++) {
				board[i][j] = new Hole();
			}
		}
		
		for(Prize prize : Prize.values()) {
			Arrays.stream(board)
				.flatMap(Arrays::stream)
				.filter(hole -> !hole.hasPrize())
				.sorted(new RandomComparator<>())
				.limit(3)
				.forEach(hole -> hole.setPrize(prize));
		}
		
		Arrays.stream(board)
			.flatMap(Arrays::stream)
			.sorted(new RandomComparator<>())
			.limit(10)
			.forEach(hole -> hole.setHasPenny(true));
		
		TwoDArrayUtils.print(board, (value) -> {
			return new StringBuilder()
				.append(value.hasPenny() ? "X" : "O")
				.append(" - ")
				.append(value.hasPrize() ? value.getPrize().toString().charAt(0) : "e")
				.toString();
		});
		out.println();
		out.println("Prizes won:");
		
		boolean any = false;
		for(Prize prize : Prize.values()) {
			int covered = 0;
			for(int i=0; i < board.length; i++) {
				for(int j=0; j < board[i].length; j++) {
					final Hole hole = board[i][j];
					if(hole.hasPenny() && hole.getPrize() == prize) covered++;
				}
			}
			
			if(covered == 3) {
				out.println(" - " + prize);
				any = true;
			}
		}
		
		if(!any) out.println(" - None");
		
		out.println();
		out.println("Thanks for playing!");
	}
	
	private static class Hole {
		
		private Prize prize;
		private boolean hasPenny;
		
		public Hole() {
			System.out.println("init " + prize);
		}
		
		public boolean hasPrize() {
			return prize != null;
		}
		
		public Prize getPrize() {
			return prize;
		}
		
		public void setPrize(Prize prize) {
			//System.out.println("set to " + prize);
			this.prize = prize;
		}
		
		public boolean hasPenny() {
			return hasPenny;
		}
		
		public void setHasPenny(boolean hasPenny) {
			this.hasPenny = hasPenny;
		}
		
		@Override
		public String toString() {
			return "Hole: hasPenny=" + hasPenny + ", prize=" + prize;
		}
		
	}
	
	private enum Prize {
		
		PUZZLE,
		GAME,
		BALL,
		POSTER,
		DOLL;
		
		@Override
		public String toString() {
			final String old = super.toString();
			final char first = old.charAt(0);
			return first + old.substring(1).toLowerCase();
		}
		
	}
	
	public static void main(String[] args) {
		new PennyPitch();
	}

}
