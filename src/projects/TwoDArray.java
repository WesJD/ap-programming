package projects;

import java.util.Scanner;

import static java.lang.System.out;
import utils.FormatUtils;
import utils.ReaderUtils;

public class TwoDArray {
	
	private TwoDArray() {
		try (Scanner scanner = new Scanner(System.in)) {
			final int n = ReaderUtils.readFromUser(scanner, "What is n?", Integer::parseInt);
			final boolean[][] values = new boolean[n][n];
			for(int row=0; row < values.length; row++) {
				for(int column=0; column < values[row].length; column++) {
					boolean value;
					if(row <= 1 || column <= 1) value = false;
					else if(gcd(row, column) <= 1) value = true;
					else value = false;
					
					values[row][column] = value;
				}
			}
			
			out.print(FormatUtils.repeat(" ", 2));
			for(int i=0; i < values[0].length; i++) out.print(i + FormatUtils.repeat(" ",  5));
			out.println();
			
			for(int row=0; row < values.length; row++) {
				out.print(row + " ");
				for(int column=0; column < values[row].length; column++) {
					final boolean value = values[row][column];
					out.print(value + (value ? "  " : " "));
				}
				out.println();
			}
		}
	}
	
	private int gcd(int a, int b) {
		if(a == 0 || b == 0) return a + b;
		return gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		new TwoDArray();
	}

}
