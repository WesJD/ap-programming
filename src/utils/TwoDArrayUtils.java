package utils;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class TwoDArrayUtils {
	
	public static <T> void forEach(T[][] values, BiConsumer<T, Pair<Integer, Integer>> consumer) {
		for(int row=0; row < values.length; row++) {
			for(int column=0; column < values[row].length; column++) {
				consumer.accept(values[row][column], Pair.of(row, column));
			}
		}
	}
	
	public static void print(boolean[][] values) {
		print(values, Object::toString);
	}
	
	public static void print(boolean[][] values, Function<Boolean, String> valuer) {
		final Boolean[][] supply = new Boolean[values.length][values[0].length];
		for(int i=0; i < values.length; i++) {
			for(int j=0; j < values[i].length; j++) {
				supply[i][j] = values[i][j];
			}
		}
		print(supply, valuer);
	}
	
	public static <T> void print(T[][] values) {
		print(values, Object::toString);
	}
	
	public static <T> void print(T[][] values, Function<T, String> valuer) {
		final int leftNumbersWidth = Integer.toString(values.length).length();
		
		final int maxWidth = Arrays.stream(values)
			.flatMap(Arrays::stream)
			.mapToInt(value -> valuer.apply(value).length())
			.max().orElseThrow(() -> new RuntimeException("Unable to calculate max width"));
		
		out.print(FormatUtils.repeat(" ", leftNumbersWidth + 1));
		IntStream.range(0, values[0].length)
			.forEach(index -> {
				out.print(index);
				out.print(FormatUtils.repeat(" ", maxWidth - Integer.toString(index).length() + 1));
			});
		out.println();
		
		for(int i=0; i < values.length; i++) {
			final int rowIndexWidth = Integer.toString(i).length();
			out.print(FormatUtils.repeat(" ", leftNumbersWidth - rowIndexWidth));
			out.print(i);
			out.print(" ");
			for(int j=0; j < values[i].length; j++) {
				final String output = valuer.apply(values[i][j]);
				final int valueWidth = output.length();
				out.print(FormatUtils.repeat(" ", maxWidth - valueWidth));
				out.print(output);
				out.print(" ");
			}
			out.println();
		}
	}
	
}
