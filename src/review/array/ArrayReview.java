package review.array;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayReview {
	
	private ArrayReview() {
		{
			final int[] values = new int[10];
			
			out.println("Default values:");
			for(int i : values) out.print(i + " ");
			out.println();
			
			for(int i=0; i < values.length; i++) 
				values[i] = ThreadLocalRandom.current().nextInt(values.length);
			
			out.println("Initialized values:");
			for(int i : values) out.print(i + " ");
			out.println();
			out.println("Sum: " + Arrays.stream(values).sum());
		}
		{
			final String[] values = new String[10];
			
			out.println("Default values:");
			for(String i : values) out.print(i + " ");
			out.println();
			
			for(int i=0; i < values.length; i++) 
				values[i] = "val: " + i;
			
			out.println("Initialized values:");
			for(String i : values) out.print(i + " ");
			out.println();
			out.println("Backwards:");
			for(int i=values.length-1; i > 0; i--) out.print(values[i] + " ");
			out.println();
		}
	}
	
	public static void main(String[] args) {
		new ArrayReview();
	}

}
