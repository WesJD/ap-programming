package projects;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class PermutationGenerator {

	private PermutationGenerator() {
		final List<Integer> numbers = IntStream.range(1, 10)
				.boxed()
				.collect(Collectors.toList());
		for (int i = 0; i < 10; i++) {
			Collections.shuffle(numbers);
			out.println("List " + (i + 1) + ": " + numbers);
		}
	}

	public static void main(String[] args) {
		new PermutationGenerator();
	}
	
}
