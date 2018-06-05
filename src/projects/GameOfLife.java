package projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import utils.TwoDArrayUtils;

import static java.lang.System.out;

public class GameOfLife {
	
	private final int[] DIFFS = new int[] { -1, 0, 1 };
	
	private GameOfLife() {
		boolean[][] matrix = new boolean[20][20];
		
		try(Scanner scanner = new Scanner(new File("life100.txt"))) {
			final int pairs = Integer.parseInt(scanner.nextLine());
			for(int i=0; i < pairs; i++) {
				final int row = scanner.nextInt();
				final int column = scanner.nextInt();
				matrix[row - 1][column - 1] = true;
			}
		} catch (FileNotFoundException ex) {
			throw new RuntimeException("Unable to read", ex);
		}
		
		for(int cur=0; cur < 5; cur++) {
			final boolean[][] next = new boolean[matrix.length][matrix[0].length];
			for(int i=0; i < matrix.length; i++) {
				for(int j=0; j < matrix[i].length; j++) {
					next[i][j] = matrix[i][j];
				}
			}
			
			for(int i=0; i < matrix.length; i++) {
				final boolean[] row = matrix[i];
				for(int j=0; j < row.length; j++) {
					int aliveNeighbors = 0;
					
					for(int first=0; first < DIFFS.length; first++) {
						for(int second=0; second < DIFFS.length; second++) {
							final int horiz = DIFFS[first];
							final int vert = DIFFS[second];
							if(!(horiz == 0 && vert == 0)) {
								final int checkingHoriz = j + horiz;
								if(checkingHoriz >= 0 && checkingHoriz < row.length) {
									final int checkingVert = i + vert;
									if(checkingVert >= 0 && 
										checkingVert < matrix.length &&
										matrix[checkingVert][checkingHoriz]) {
										aliveNeighbors++;
									}
								}
							}
						}
					}
					
					if(aliveNeighbors <= 1 || aliveNeighbors >= 4) next[i][j] = false;
					else if(aliveNeighbors == 3) next[i][j] = true;
				}
			}
			
			matrix = next;
		}

		TwoDArrayUtils.print(matrix, value -> value ? "*" : " ");
		
		final boolean[] row10 = matrix[9];
		final long alive = IntStream.range(0, row10.length)
			.mapToObj(index -> row10[index])
			.filter(value -> value)
			.count();
		out.println("Number in row 10 ---> " + alive);
		
		int column10Count = 0;
		int totalAlive = 0;
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[i].length; j++) {
				if(matrix[i][j]) {
					totalAlive++;
					if(j == 9) column10Count++;
				}
			}
		}
		out.println("Number in column 10 ---> " + column10Count);
		out.println("Number of living organisms ---> " + totalAlive);
	}
	
	public static void main(String[] args) {
		new GameOfLife();
	}

}
